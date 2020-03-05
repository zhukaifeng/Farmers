package com.osiris.farmers.shichang;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.PunishList;
import com.osiris.farmers.model.RichangXc;
import com.osiris.farmers.model.XiaofangXc;
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
import butterknife.OnClick;

public class RcXingweiFragment extends BaseFragment {



    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    private List<String> xiaofangNameList = new ArrayList<>();
    private List<RichangXc.DataBean> dataList = new ArrayList<>();

    private XingweiAdapter xiaofangAdapter = new XingweiAdapter(dataList);
    @OnClick({R.id.tv_add,R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_add:
                Intent intent = new Intent(getActivity(), AddRcXcActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_back:
                getActivity().finish();

                break;
        }
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_xingwei;
    }

    @Override
    protected void initView() {

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(xiaofangAdapter);
        xiaofangAdapter.notifyDataSetChanged();
        xiaofangAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), XingWeiDetailActivity.class);
                intent.putExtra("data",dataList.get(position).getId());
                startActivity(intent);

            }
        });


        getTypeData();

    }


    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    protected void initData() {

    }


    private void getTypeData() {

        //richangxcPageList.action?
        String url = ApiParams.API_HOST + "/app/richangxcPageList.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
//        paramMap.put("pageNo", String.valueOf(1));
//        paramMap.put("pageSize", String.valueOf(10));

        Log.d("zkf", "params:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){

                    RichangXc.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), RichangXc.DataBean[].class);
                    dataList.addAll(Arrays.asList(dataBeans));
                    xiaofangAdapter.notifyDataSetChanged();


                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }









}
