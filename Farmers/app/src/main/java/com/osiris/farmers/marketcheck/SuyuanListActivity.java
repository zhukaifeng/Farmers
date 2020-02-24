package com.osiris.farmers.marketcheck;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.marketcheck.adapter.SuyuanJinAdapter;
import com.osiris.farmers.model.SuyuanJinData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class SuyuanListActivity extends BaseActivity {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;


    private String type;
    private String date;
    private List<SuyuanJinData.DataBean> dataBeanList = new ArrayList<>();
    private SuyuanJinAdapter dataAdapter = new SuyuanJinAdapter(dataBeanList);


    @Override
    public int getLayoutResId() {
        return R.layout.activity_suyuan_list;
    }

    @Override
    public void init() {

        type = getIntent().getStringExtra("data");
        date = getIntent().getStringExtra("date");
        getListData();


        rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SuyuanListActivity.this, SuyuanJinDetailActivity.class);
                intent.putExtra("data", dataBeanList.get(position).getId());
                intent.putExtra("isChu", true);

                startActivity(intent);
            }
        });

    }

    private void getListData() {
        String url = ApiParams.API_HOST + "/app/getJYHSprkByUserId.action";


        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
//        paramMap.put("marketId", String.valueOf(GlobalParams
//                .currentMarketId));
        paramMap.put("marketId", String.valueOf(18));
        Log.d("zkf", "marketid:" + GlobalParams.currentMarketId);
        // paramMap.put("riqi", date);

        paramMap.put("riqi", "2019-09-10");

        paramMap.put("splb", type);
        Log.d("zkf", "params:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")) {
                    SuyuanJinData.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), SuyuanJinData.DataBean[].class);
                    dataBeanList.addAll(Arrays.asList(dataBeans));
                    dataAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }


}
