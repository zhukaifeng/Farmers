package com.osiris.farmers.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.MarketCXEvent;
import com.osiris.farmers.event.MarketEvent;
import com.osiris.farmers.model.JiedaoMarket;
import com.osiris.farmers.model.Market;
import com.osiris.farmers.model.MarketCX;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MarketCXAdapter;
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


public class CXMarketActivity extends BaseActivity {


    @BindView(R.id.rv_data)
    RecyclerView rvData;


    private List<MarketCX.DataBean> dataList = new ArrayList<>();
    private MarketCXAdapter typeAdapter = new MarketCXAdapter(dataList);
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
        dataList.addAll(getIntent().getParcelableArrayListExtra("data"));
        rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvData.setAdapter(typeAdapter);
        typeAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                postEvent(new MarketCXEvent(dataList.get(position).getMarketnm(), dataList.get(position).getId()));

                finish();

            }
        });

        typeAdapter.notifyDataSetChanged();
    }



}
