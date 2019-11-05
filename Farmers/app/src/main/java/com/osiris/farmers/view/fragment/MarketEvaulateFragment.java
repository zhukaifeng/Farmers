package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.MarketEvaluate;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.view.MarketEvaluateActivity;
import com.osiris.farmers.view.NewMarketScoreActivity;
import com.osiris.farmers.view.ScoringDetailActivity;
import com.osiris.farmers.view.adapter.MarketEvaluateAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class MarketEvaulateFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.linear_calendar)
    LinearLayout linear_calendar;
    @BindView(R.id.iv_select)
    ImageView iv_select;

    private List<MarketEvaluate> dataList = new ArrayList<>();
    private MarketEvaluateAdapter dataAdapter = new MarketEvaluateAdapter(dataList);
    private boolean selectVisible = true;

    @Override
    protected int setLayout() {
        return R.layout.activity_evaluate_market;
    }

    @Override
    protected void initView() {
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));
        dataList.add(new MarketEvaluate("百花市场", "泰州市市场监管局", "90分", "2019.03.20"));

        rv_data.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), ScoringDetailActivity.class);
                startActivity(intent);
            }
        });

        getListData();

    }

    @Override
    protected void initData() {

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
//                Intent intent = new Intent(this, getActivity());
//                startActivity(intent);

                break;
            case R.id.rl_back:

                break;
        }
    }

    private void getListData(){
        String url = ApiParams.API_HOST +"/app/getAllzgscpingja.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.id));

        paramMap.put("pageNo",String.valueOf(1));
        paramMap.put("marketnm","");

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf successResult:" + successResult);
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                LogUtils.d("zkf code:" +code +" msg:" +msg);
            }
        });




    }



}
