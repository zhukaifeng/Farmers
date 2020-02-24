package com.osiris.farmers.marketcheck;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.marketcheck.adapter.MarketCxAdapter;
import com.osiris.farmers.model.MarketCheck;
import com.osiris.farmers.model.SerachGoodData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.AddSampleDataActivity;
import com.osiris.farmers.view.adapter.GridImageAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.widget.FullyGridLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

public class MarketCheckFragment extends BaseFragment {


    @BindView(R.id.rv_data)
    RecyclerView recyclerView;
    @BindView(R.id.tv_add)
    TextView tv_add;

    @OnClick({R.id.tv_add})
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_add:
                Intent intent = new Intent(getActivity(),MarketCheckActivity.class);
                startActivity(intent);
                break;
        }
    }

    private List<MarketCheck.DataBean> selectList = new ArrayList<>();
    private MarketCxAdapter dataAdapter = new MarketCxAdapter(selectList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_marketcheck;
    }

    @Override
    protected void initView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(dataAdapter);
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), CheckDetailActivity.class);
                intent.putExtra("data",selectList.get(position).getId());
                startActivity(intent);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        getData();

    }




    private void getData() {

        String url = ApiParams.API_HOST + "/app/richangxcPageList.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
        paramMap.put("pageNo", String.valueOf(1));
        paramMap.put("pageSize", String.valueOf(10));
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){
                    MarketCheck.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"),MarketCheck.DataBean[].class);
                    if (selectList.size()>0)selectList.clear();
                    selectList.addAll(Arrays.asList(dataBeans));

                    dataAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }


    @Override
    protected void initData() {

    }
}
