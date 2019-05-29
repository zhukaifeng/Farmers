package com.osiris.farmers.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.MarketEvaluate;
import com.osiris.farmers.model.PunishList;
import com.osiris.farmers.view.adapter.MarketEvaluateAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MarketEvaluateActivity extends BaseActivity {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    private List<MarketEvaluate> dataList = new ArrayList<>();
    private MarketEvaluateAdapter dataAdapter = new MarketEvaluateAdapter(dataList);

    @Override
    public int getLayoutResId() {
        return R.layout.activity_evaluate_market;
    }

    @Override
    public void init() {
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));

        rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
    }
}
