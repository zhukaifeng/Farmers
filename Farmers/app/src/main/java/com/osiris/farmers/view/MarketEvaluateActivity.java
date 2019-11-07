package com.osiris.farmers.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.MarketEvaluate;
import com.osiris.farmers.view.adapter.MarketEvaluateAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MarketEvaluateActivity extends BaseActivity {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.linear_calendar)
    LinearLayout linear_calendar;
    @BindView(R.id.iv_select)
    ImageView iv_select;

    private List<MarketEvaluate> dataList = new ArrayList<>();
   // private MarketEvaluateAdapter dataAdapter = new MarketEvaluateAdapter(dataList);
    private boolean selectVisible = true;

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
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));

        rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        rv_data.setAdapter(dataAdapter);
//        dataAdapter.notifyDataSetChanged();
//        dataAdapter.setOnItemClick(new MyItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(MarketEvaluateActivity.this,ScoringDetailActivity.class);
//                startActivity(intent);
//            }
//        });
    }


    @OnClick({R.id.linear_evaulate,R.id.rl_right,R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.linear_evaulate:
                if (selectVisible){
                    selectVisible= false;
                    linear_calendar.setVisibility(View.GONE);
                    iv_select.setBackgroundResource(R.drawable.bg_arrow_down);
                }else {
                    selectVisible= true;
                    linear_calendar.setVisibility(View.VISIBLE);
                    iv_select.setBackgroundResource(R.drawable.bg_arrow_up);
                }
                break;
            case R.id.rl_right:
                Intent intent = new Intent(this,NewMarketScoreActivity.class);
                startActivity(intent);

                break;
            case R.id.rl_back:
                finish();
                break;
        }
    }

}
