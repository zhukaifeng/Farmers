package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.EvaluateList;
import com.osiris.farmers.model.MarketEvaluate;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.MarketEvaluateActivity;
import com.osiris.farmers.view.NewMarketScoreActivity;
import com.osiris.farmers.view.ScoringDetailActivity;
import com.osiris.farmers.view.adapter.MarketEvaluateAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
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
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    private List<EvaluateList.ZhugpingjiasBean> dataList = new ArrayList<>();
    private MarketEvaluateAdapter dataAdapter = new MarketEvaluateAdapter(dataList);
    private boolean selectVisible = true;
    private int pageNum = 1;
    private int pageCount = 8;
    @Override
    protected int setLayout() {
        return R.layout.activity_evaluate_market;
    }

    @Override
    protected void initView() {



        rv_data.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), ScoringDetailActivity.class);
                intent.putExtra("data",dataList.get(position));
                startActivity(intent);
            }
        });
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
                loadMoreData();
            }
        });

        getListData();

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
                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(successResult).getAsJsonObject();
                if (json.has("zhugpingjias")){

                    EvaluateList.ZhugpingjiasBean[] datas = JsonUtils.fromJson(json.get("zhugpingjias").getAsJsonArray(),
                            EvaluateList.ZhugpingjiasBean[].class);
                    if (pageNum == 1) {
                        dataList.clear();
                    }
                    dataList.addAll(Arrays.asList(datas));

                    dataAdapter.notifyDataSetChanged();

                }




            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                LogUtils.d("zkf code:" +code +" msg:" +msg);
            }
        });




    }





}
