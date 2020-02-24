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
import com.osiris.farmers.marketcheck.MarketCheckActivity;
import com.osiris.farmers.model.PunishList;
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

public class XiaofangFragment extends BaseFragment {


    @BindView(R.id.tv_home_name)
    TextView tv_home_name;
    @BindView(R.id.spinner_market)
    Spinner spinner_market;
    private ArrayAdapter marketAdapter;
    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    private List<String> xiaofangNameList = new ArrayList<>();
    private List<PunishList.DataBean> dataList = new ArrayList<>();
    private int xiaofangId =0;

    private List<XiaofangXc.DataBean> dataXcList= new ArrayList<>();
    private XiaofangAdapter xiaofangAdapter = new XiaofangAdapter(dataXcList);
    @OnClick({R.id.tv_add,R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_add:
                Intent intent = new Intent(getActivity(), AddXfXcActivity.class);
                intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) dataList);
                startActivity(intent);
                break;
            case R.id.rl_back:
                getActivity().finish();

                break;
        }
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_xiaofang;
    }

    @Override
    protected void initView() {
        marketAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,xiaofangNameList);
        marketAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_market.setAdapter(marketAdapter);
        spinner_market.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xiaofangId = dataList.get(position).getId();
                getXcData(dataList.get(position).getId());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(xiaofangAdapter);
        xiaofangAdapter.notifyDataSetChanged();
        xiaofangAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), XiaofangDetailActivity.class);
                intent.putExtra("data",dataXcList.get(position).getId());
                startActivity(intent);

            }
        });


        getTypeData();






    }


    @Override
    public void onResume() {
        super.onResume();
        if (xiaofangId>0){
            getXcData(xiaofangId);
        }

    }

    @Override
    protected void initData() {
        getXcData(xiaofangId);
    }


    private void getTypeData() {


        String url = ApiParams.API_HOST + "/app/getXiaofangdwByUserId.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
        paramMap.put("pageNo", String.valueOf(1));
        paramMap.put("pageSize", String.valueOf(10));

        Log.d("zkf", "params:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){

                    PunishList.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), PunishList.DataBean[].class);

                    dataList.addAll(Arrays.asList(dataBeans));


                    if (xiaofangNameList.size()>0){
                        xiaofangNameList.clear();
                    }
                    for (PunishList.DataBean marketBean:dataList){
                        xiaofangNameList.add("               " +marketBean.getName()+"               ");
                    }
                    marketAdapter.notifyDataSetChanged();
                    if (dataList.size()>0){
                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                xiaofangId = dataList.get(0).getId();
                                getXcData(dataList.get(0).getId());

                            }
                        });
                    }

                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }



    private void getXcData(int id){

       // http://localhost:8096/wisdom/app/getXiaofangxcByDwId.action?dwId=1
        String url = ApiParams.API_HOST + "/app/getXiaofangxcByDwId.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("dwId",String.valueOf(id));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){

                    XiaofangXc.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), XiaofangXc.DataBean[].class);
                    if (dataXcList.size()>0)dataXcList.clear();

                    dataXcList.addAll(Arrays.asList(dataBeans));


                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            xiaofangAdapter.notifyDataSetChanged();
                        }
                    });


                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });

    }






}
