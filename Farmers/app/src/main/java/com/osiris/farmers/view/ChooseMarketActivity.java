package com.osiris.farmers.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.BoothgEvent;
import com.osiris.farmers.event.MarketEvent;
import com.osiris.farmers.model.JiedaoMarket;
import com.osiris.farmers.model.Market;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MarketNoAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;


public class ChooseMarketActivity extends BaseActivity {


    @BindView(R.id.rv_data)
    RecyclerView rvData;


    private List<Market.MarketBean> marketList = new ArrayList<>();
    private MarketNoAdapter typeAdapter = new MarketNoAdapter(marketList);
    private boolean isTask;

    @OnClick({R.id.rl_back})
    void onClick(View v) {
        switch (v.getId()) {

            case R.id.rl_back:
                finish();
                break;
        }
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_choose_market;
    }

    @Override
    public void init() {
        isTask = getIntent().getBooleanExtra("istask",false);
        if (isTask){
            String id = getIntent().getStringExtra("id");
            if (!TextUtils.isEmpty(id)){
                getMarketData1(id);
            }else {
                getMarketData();

            }

        }else {
            getMarketData();
        }
        rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvData.setAdapter(typeAdapter);
        typeAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                postEvent(new MarketEvent(marketList.get(position).getMarketnm(), marketList.get(position).getId()));

                finish();

            }
        });


    }

    private void getMarketData1(String id) {

        String url = ApiParams.API_HOST + "/app/getMarketByquid.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        LogUtils.d("zkf id；llll:" + id);
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                JiedaoMarket[] jiedaoMarkets = JsonUtils.fromJson(new JsonParser().parse(successResult).getAsJsonArray(),
                        JiedaoMarket[].class);
                List<JiedaoMarket> jiedaoMarkets1 = Arrays.asList(jiedaoMarkets);

                for (JiedaoMarket jiedaoMarket : jiedaoMarkets1) {
                    LogUtils.d("zkf market name:" + jiedaoMarket.getMarketnm());
                    Market.MarketBean marketBean = new Market.MarketBean();
                    marketBean.setId(jiedaoMarket.getId());
                    marketBean.setMarketnm(jiedaoMarket.getMarketnm());
                    marketList.add(marketBean);

                }
                typeAdapter.notifyDataSetChanged();

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });

    }


    private void getMarketData() {


        String url = ApiParams.API_HOST + "/app/xzmarket.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.id));


        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf  market data:" + successResult);
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    Market market = JsonUtils.fromJson(temp, Market.class);
                    if (marketList.size() > 0) {
                        marketList.clear();
                    }
                    marketList.addAll(market.getMarket());
                    typeAdapter.notifyDataSetChanged();

                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }
}
