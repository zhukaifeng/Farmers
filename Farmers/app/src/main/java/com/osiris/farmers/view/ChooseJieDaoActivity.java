package com.osiris.farmers.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.MarketEvent;
import com.osiris.farmers.model.JiedaoMarket;
import com.osiris.farmers.model.Market;
import com.osiris.farmers.model.QuData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.JieDaoNoAdapter;
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


public class ChooseJieDaoActivity extends BaseActivity {


    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.tv_title)
    TextView tv_title;


    private List<QuData> marketList = new ArrayList<>();
    private JieDaoNoAdapter typeAdapter = new JieDaoNoAdapter(marketList);

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
        tv_title.setText("选择街道");
        List<QuData> marketList1 = getIntent().getParcelableArrayListExtra("data");
        marketList.addAll(marketList1);
        LogUtils.d("zkf liset size: "+ marketList.size());
        rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvData.setAdapter(typeAdapter);
        typeAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                postEvent(marketList.get(position));
                finish();

            }
        });
        typeAdapter.notifyDataSetChanged();

    }


}
