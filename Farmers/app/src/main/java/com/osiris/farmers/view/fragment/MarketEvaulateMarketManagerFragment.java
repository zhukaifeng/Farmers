package com.osiris.farmers.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.EvaluateList;
import com.osiris.farmers.model.MarketManagerEvaluate;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.shichang.AddScorelShichangActivity;
import com.osiris.farmers.shichang.ScoringDetailShichangActivity;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.AddScorelActivity;
import com.osiris.farmers.view.MarketManagerDetailActivity;
import com.osiris.farmers.view.ScoringDetailActivity;
import com.osiris.farmers.view.adapter.MarketEvaluateAdapter;
import com.osiris.farmers.view.adapter.MarketEvaluateManagerAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class MarketEvaulateMarketManagerFragment extends BaseFragment {

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
    @BindView(R.id.relative_search)
    RelativeLayout relative_search;
    @BindView(R.id.linear_search)
    LinearLayout linear_search;


    private List<MarketManagerEvaluate> dataList = new ArrayList<>();
    private MarketEvaluateManagerAdapter dataAdapter = new MarketEvaluateManagerAdapter(dataList);
    private boolean selectVisible = true;
    private int pageNum = 1;
    private int pageCount = 8;
    private int xxz = 1;

    @Override
    protected int setLayout() {
        return R.layout.activity_evaluate_mannager_market;
    }


    @Override
    protected void initView() {


        rv_data.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), ScoringDetailShichangActivity.class);
                intent.putExtra("id",dataList.get(position).getId());
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
        //  showSingleChoiceDialog();
        relative_search.setVisibility(View.GONE);
        edt_search.setVisibility(View.GONE);
        linear_search.setVisibility(View.GONE);
    }
    private boolean firstIn = true;


    @Override
    public void onResume() {
        super.onResume();
        if (!firstIn){
            pageNum = 1;
            previousTotal = 0;
            getListData();
        }
        firstIn = false;

    }

    private void showSingleChoiceDialog() {

        final String items[] = {"市场评价", "经营户评价"};

        // final String[] items = { "01","02","03","04"};
        final AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(getActivity());
        singleChoiceDialog.setCancelable(false);
        singleChoiceDialog.setTitle("请选择");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LogUtils.d("zkf which:" + which);
                        xxz = which + 1;

                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (xxz == 1) {
                            tv_title.setText("市场评价");
                        } else if (xxz == 2) {
                            tv_title.setText("经营户评价");
                        }
                    }

                });
        singleChoiceDialog.show();
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
                intent.putExtra("xxz", xxz);
                startActivity(intent);

                break;
            case R.id.rl_back:

                break;
        }
    }

    private void getListData() {

        //http://39.97.235.7:8086/wisdom/app/getallmarketpingjia.action
        String url = ApiParams.API_HOST + "/app/getallmarketpingjia.action";


        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.id));

        paramMap.put("pageNo",String.valueOf(pageNum));
        LogUtils.d("zkf parame:" + paramMap.toString());
       /* paramMap.put("pageNo",String.valueOf(1));
        if (!TextUtils.isEmpty(edt_search.getText().toString())){
            paramMap.put("marketnm",edt_search.getText().toString());
        }else {
            paramMap.put("marketnm","");
        }*/

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf successResult:" + successResult);
                refreshLayout.setRefreshing(false);
                JsonParser parser = new JsonParser();
                JsonArray json = parser.parse(successResult).getAsJsonArray();
                MarketManagerEvaluate[] data = JsonUtils.fromJson(json, MarketManagerEvaluate[].class);
                if (data.length > 0){
                    if (pageNum == 1)dataList.clear();
                    dataList.addAll(Arrays.asList(data));
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
