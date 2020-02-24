package com.osiris.farmers.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.MarketCXEvent;
import com.osiris.farmers.model.MarketCX;
import com.osiris.farmers.model.StallCX;
import com.osiris.farmers.view.adapter.MarketCXAdapter;
import com.osiris.farmers.view.adapter.MarketStallCXAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class CXStallActivity extends BaseActivity {


    @BindView(R.id.rv_data)
    RecyclerView rvData;


    private List<StallCX.DataBean> dataList = new ArrayList<>();
    private MarketStallCXAdapter typeAdapter = new MarketStallCXAdapter(dataList);
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

                postEvent(dataList.get(position));

                finish();

            }
        });

        typeAdapter.notifyDataSetChanged();
    }



}
