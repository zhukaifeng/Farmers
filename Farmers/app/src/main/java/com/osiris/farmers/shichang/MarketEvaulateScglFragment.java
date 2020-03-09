package com.osiris.farmers.shichang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.EvaluateList;
import com.osiris.farmers.model.ShiChangPijgjia;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.AddScorelJgMarketActivity;
import com.osiris.farmers.view.AddScorelJgUserActivity;
import com.osiris.farmers.view.ScoringDetailActivity;
import com.osiris.farmers.view.adapter.MarketEvaluateAdapter;
import com.osiris.farmers.view.adapter.MarketEvaluateJyhAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class MarketEvaulateScglFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.linear_calendar)
    LinearLayout linear_calendar;
    @BindView(R.id.iv_select)
    ImageView iv_select;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.edt_search)
    EditText edt_search;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_num)
    TextView tv_num;
    @BindView(R.id.linear_search)
    LinearLayout linear_search;


    private List<ShiChangPijgjia> dataList = new ArrayList<>();
    private MarketEvaluateScAdapter dataAdapter = new MarketEvaluateScAdapter(dataList);
    private boolean selectVisible = true;
    private int pageNum = 1;
    private int pageCount = 8;
    private int xxz = 1;


    private List<EvaluateList.ZhugjyhpingjiasBean> dataJyhList = new ArrayList<>();
    private MarketEvaluateJyhAdapter dataJyhAdapter = new MarketEvaluateJyhAdapter(dataJyhList);
    private boolean firstIn = true;

    @Override
    protected int setLayout() {
        return R.layout.activity_evaluate_market;
    }


    @Override
    protected void initView() {

        linear_search.setVisibility(View.GONE);

        rv_data.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(getActivity(), ScoringDetailScActivity.class);
                intent.putExtra("data", dataList.get(position));
                intent.putExtra("id", dataList.get(position).getId());

                startActivity(intent);


            }
        });

//        rv_data_jyh.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        rv_data_jyh.setAdapter(dataJyhAdapter);
//        dataJyhAdapter.setOnItemClick(new MyItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(getActivity(), ScoringDetailScActivity.class);
//                intent.putExtra("data",dataJyhList.get(position));
//                intent.putExtra("xxz",xxz);
//                intent.putExtra("id",dataJyhList.get(position).getId());
//                startActivity(intent);
//            }
//        });
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                previousTotal = 0;
                pageNum = 1;
                getListData();

            }
        });
        final LinearLayoutManager manager = (LinearLayoutManager) rv_data
                .getLayoutManager();
        rv_data.addOnScrollListener(new EndLessOnScrollListener(manager) {
            @Override
            public void onLoadMore(int currentPage) {
                Log.d("zkf", "load more");
                loadMoreData();
            }
        });

        getListData();
        // showSingleChoiceDialog();
        tv_title.setText("经营户行为");
        tv_num.setText("经营户");

    }


    @Override
    public void onResume() {
        super.onResume();
        if (!firstIn) {
            pageNum = 1;
            previousTotal = 0;
            getListData();
        }
        firstIn = false;


    }


    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;


    public abstract class EndLessOnScrollListener extends RecyclerView.OnScrollListener {

        //声明一个LinearLayoutManager
        private LinearLayoutManager mLinearLayoutManager;

        //当前页，从0开始    private int currentPage = 0;
        //已经加载出来的Item的数量
        private int totalItemCount;

        //在屏幕上可见的item数量
        private int visibleItemCount;

        //在屏幕可见的Item中的第一个
        private int firstVisibleItem;

        //是否正在上拉数据
        private boolean loading = true;

        public EndLessOnScrollListener(LinearLayoutManager linearLayoutManager) {
            this.mLinearLayoutManager = linearLayoutManager;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            visibleItemCount = recyclerView.getChildCount();
            totalItemCount = mLinearLayoutManager.getItemCount();
            firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                }
            }

            if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem) {
                // pageCount ++;
                Log.d("zkf", "load more ....");

                onLoadMore(pageCount);
                loading = true;
            }
        }

        /**
         * 提供一个抽闲方法，在Activity中监听到这个EndLessOnScrollListener
         * 并且实现这个方法
         */
        public abstract void onLoadMore(int currentPage);
    }

    private void loadMoreData() {
        pageNum++;
        getListData();
    }


    @Override
    protected void initData() {

    }

    @OnClick({R.id.linear_evaulate, R.id.rl_right, R.id.rl_back, R.id.rl_search})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_search:
                if (!TextUtils.isEmpty(edt_search.getText().toString())) {
                    return;
                }
                getListData();
                break;
            case R.id.linear_evaulate:
                if (selectVisible) {
                    selectVisible = false;
                    linear_calendar.setVisibility(View.GONE);
                    iv_select.setBackgroundResource(R.drawable.bg_arrow_down);
                } else {
                    selectVisible = true;
                    linear_calendar.setVisibility(View.VISIBLE);
                    iv_select.setBackgroundResource(R.drawable.bg_arrow_up);
                }
                break;
            case R.id.rl_right:
//                Intent intent = new Intent(this, getActivity());
//                startActivity(intent);

                Intent intent = new Intent(getActivity(), AddScorelShichangActivity.class);
                Log.d("zkf", "xxz：" + xxz);
                startActivity(intent);


                break;
            case R.id.rl_back:
                getActivity().finish();
                break;
        }
    }

    private int pages = 1;

    //http://39.97.235.7:8086/wisdom/app/getallmarketpingjia.action
    private void getListData() {
        String url = ApiParams.API_HOST + "/app/getallmarketpingjia.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.id));

//        paramMap.put("pageNo",String.valueOf(pageNum));
//        if (!TextUtils.isEmpty(edt_search.getText().toString())){
//            paramMap.put("marketnm",edt_search.getText().toString());
//        }else {
//            paramMap.put("marketnm","");
//        }

        Log.d("zkf  parame:", paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf successResult:" + successResult);
                refreshLayout.setRefreshing(false);
                if (!TextUtils.isEmpty(successResult)) {
                    ShiChangPijgjia[] datas = JsonUtils.fromJson(successResult,
                            ShiChangPijgjia[].class);
                    dataList.clear();
                    dataList.addAll(Arrays.asList(datas));
                    Log.d("zkf", "size 1:" + dataList.size());
                    dataAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                LogUtils.d("zkf code:" + code + " msg:" + msg);
                refreshLayout.setRefreshing(false);

            }
        });


    }


}
