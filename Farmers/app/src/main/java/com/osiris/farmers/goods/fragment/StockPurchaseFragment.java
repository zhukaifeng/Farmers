package com.osiris.farmers.goods.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.goods.TypeData;
import com.osiris.farmers.jingyinghu.PurchaseDetailActivity;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.ManagerData1;
import com.osiris.farmers.model.StockPurchase;
import com.osiris.farmers.model.WeekModel;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.DateUtil;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.DateAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.StockPurchaseAdapter;
import com.osiris.farmers.view.adapter.TypePurchaseAdapter;
import com.osiris.farmers.view.adapter.WeekAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class StockPurchaseFragment extends BaseFragment {

    @BindView(R.id.linear_detail)
    LinearLayout linear_detail;
    @BindView(R.id.rl_stock_list)
    RelativeLayout rl_stock_list;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;

    @BindView(R.id.rv_month)
    RecyclerView rv_month;
    @BindView(R.id.rv_year)
    RecyclerView rv_year;
    @BindView(R.id.rv_date)
    RecyclerView rv_date;


    @BindView(R.id.tv_year)
    TextView tv_year;
    @BindView(R.id.tv_year_two)
    TextView tv_year_two;
    @BindView(R.id.tv_month)
    TextView tv_month;
    @BindView(R.id.tv_month_two)
    TextView tv_month_two;
    @BindView(R.id.tv_month_three)
    TextView tv_month_three;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.tv_total_money)
    TextView tv_total_money;
    @BindView(R.id.tv_nodata1)
    TextView tv_nodata1;
    @BindView(R.id.tv_nodata2)
    TextView tv_nodata2;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    private List<StockPurchase.DataBean> dataList = new ArrayList<>();
    private StockPurchaseAdapter dataAdapter = new StockPurchaseAdapter(dataList);
    private List<DateModel> typeList = new ArrayList<>();
    private TypePurchaseAdapter typeAdapter = new TypePurchaseAdapter(typeList);

    //    private List<DateModel> monthList = new ArrayList<>();
//    private DateAdapter monthAdapter = new DateAdapter(monthList);
//    private List<DateModel> yearList = new ArrayList<>();
//    private DateAdapter yearAdapter = new DateAdapter(yearList);
//    private List<WeekModel> weekList = new ArrayList<>();
//    private WeekAdapter weekAdapter = new WeekAdapter(weekList);
    private int currentMonth;
    private int currentYear;
    private int currentWeek;
    private int frontMonth;
    private int frontYear;
    private int frontWeek;


    @Override
    protected int setLayout() {
        return R.layout.fragment_stock_purchase;
    }

    @Override
    protected void initView() {


//        yearList.add(new DateModel("2020", true));
//        yearList.add(new DateModel("2021", false));
//        yearList.add(new DateModel("2022", false));
//        yearList.add(new DateModel("2023", false));
//        yearList.add(new DateModel("2024", false));
        currentYear = 2020;
        tv_year_two.setText(currentYear + "年");
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        currentMonth = month;
        tv_month_two.setText(month + "月");
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        currentWeek = day;
        tv_date.setText(day + "");


        for (int i = 0; i < 8; i++) {
            calendar.clear();//记住一定要clear一次
            calendar.set(Calendar.MONTH, currentMonth);
            calendar.set(Calendar.DAY_OF_MONTH, currentWeek);
            calendar.set(Calendar.YEAR, currentYear);
            calendar.add(Calendar.DATE, -i);//j记住是DATE
            frontMonth = calendar.get(Calendar.MONTH);// 获取当前月份
            frontWeek = calendar.get(Calendar.DAY_OF_MONTH);// 获取当前日份的日期号码
            frontYear = calendar.get(Calendar.YEAR);// 获取当前年份
            tv_year.setText(frontYear + "年");
            tv_month_three.setText(frontWeek + "");
            tv_month.setText(frontMonth + "月");

        }


//  紫包菜        蔬菜     30斤     60元     华北市场   2019.03.20
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
//		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));


//
//		typeList.add(new DateModel("水果", false));
//		typeList.add(new DateModel("肉类", false));
//		typeList.add(new DateModel("海鲜", false));


        rv_type.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv_type.setAdapter(typeAdapter);
        typeAdapter.notifyDataSetChanged();
        typeAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (DateModel dateModel : typeList) {
                    dateModel.setClicked(false);
                }
                typeList.get(position).setClicked(true);
                splb = typeList.get(position).getDate();

                typeAdapter.notifyDataSetChanged();

                getDataList();
            }
        });


        rv_data.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), PurchaseDetailActivity.class);
                intent.putExtra("id", dataList.get(position).getId());
                startActivity(intent);
            }
        });

        getType();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getType();
            }
        });

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_back, R.id.rl_back_one, R.id.linear_month, R.id.tv_month_three, R.id.linear_date, R.id.tv_date})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                linear_detail.setVisibility(View.GONE);
                rl_stock_list.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_back_one:
                getActivity().finish();
                break;
            case R.id.linear_month:
            case R.id.tv_month_three://front date
                new DatePickerDialog(getActivity(), onDateSetListener1, frontYear, frontMonth - 1, frontWeek).show();

                break;
            case R.id.linear_date:
            case R.id.tv_date://end date
                new DatePickerDialog(getActivity(), onDateSetListener, currentYear, currentMonth - 1, currentWeek).show();

                break;
        }
    }

    /**
     * 日期选择器对话框监听
     */
    private DatePickerDialog.OnDateSetListener onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            frontYear = year;
            frontMonth = monthOfYear + 1;
            frontWeek = dayOfMonth;

            tv_month_three.setText(frontWeek + "");
            tv_month.setText(frontMonth + "月");
            tv_year.setText(frontYear + "年");
            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 8; i++) {
                calendar.clear();//记住一定要clear一次
                calendar.set(Calendar.MONTH, frontMonth);
                calendar.set(Calendar.DAY_OF_MONTH, frontWeek);
                calendar.set(Calendar.YEAR, frontYear);
                calendar.add(Calendar.DATE, +i);//j记住是DATE
                currentMonth = calendar.get(Calendar.MONTH);// 获取当前月份
                currentWeek = calendar.get(Calendar.DAY_OF_MONTH);// 获取当前日份的日期号码
                currentYear = calendar.get(Calendar.YEAR);// 获取当前年份

                tv_year_two.setText(currentYear + "年");
                tv_month_two.setText(currentMonth + "月");
                tv_date.setText(currentWeek + "");


//
//                calendar.clear();//记住一定要clear一次
//                calendar.set(Calendar.MONTH,currentMonth);
//                calendar.set(Calendar.DAY_OF_MONTH,currentWeek);
//                calendar.set(Calendar.YEAR,currentYear);
//                calendar.add(Calendar.DATE,-i);//j记住是DATE
//                frontMonth = calendar.get(Calendar.MONTH);// 获取当前月份
//                frontWeek = calendar.get(Calendar.DAY_OF_MONTH);// 获取当前日份的日期号码
//                frontYear = calendar.get(Calendar.YEAR);// 获取当前年份
//                tv_year.setText(frontYear + "年");
//                tv_month_three.setText(frontWeek + "");
//                tv_month.setText(frontMonth + "月");

            }

            getType();

        }
    };


    /**
     * 日期选择器对话框监听
     */
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            currentYear = year;
            currentMonth = monthOfYear + 1;
            currentWeek = dayOfMonth;
            tv_year_two.setText(currentYear + "年");
            tv_month_two.setText(currentMonth + "月");
            tv_date.setText(currentWeek + "");
            Calendar calendar = Calendar.getInstance();
            for (int i = 0; i < 8; i++) {
                calendar.clear();//记住一定要clear一次
                calendar.set(Calendar.MONTH, currentMonth);
                calendar.set(Calendar.DAY_OF_MONTH, currentWeek);
                calendar.set(Calendar.YEAR, currentYear);
                calendar.add(Calendar.DATE, -i);//j记住是DATE
                frontMonth = calendar.get(Calendar.MONTH);// 获取当前月份
                frontWeek = calendar.get(Calendar.DAY_OF_MONTH);// 获取当前日份的日期号码
                frontYear = calendar.get(Calendar.YEAR);// 获取当前年份
                tv_year.setText(frontYear + "年");
                tv_month_three.setText(frontWeek + "");
                tv_month.setText(frontMonth + "月");

            }
            getType();

        }
    };


    private String splb = "";

    private String getFormatNumber(int num) {
        return num >= 10 ? String.valueOf(num) : ("0" + num);
    }


    ////经营户-进货菜品分类
    //http://localhost:8096/wisdom/app/getJYHSprkSplbByJYHUserId.action?userId=163&startDay=2020-01-01&endDay=2020-02-25
    private void getType() {

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/getJYHSprkSplbByJYHUserId.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
//        paramMap.put("startDay", "2020-01-01");
//        paramMap.put("endDay", "2020-02-25");

        paramMap.put("startDay", frontYear + "-" + getFormatNumber(frontMonth) + "-" + getFormatNumber(frontWeek));
        paramMap.put("endDay", currentYear + "-" + getFormatNumber(currentMonth) + "-" + getFormatNumber(currentWeek));
        Log.d("zkf", "params:" + paramMap.toString());

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                LogUtils.d("zkf  successResult:" + successResult);
                refreshLayout.setRefreshing(false);
                if (!TextUtils.isEmpty(successResult)) {
                    cancelLoadDialog();
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    TypeData typeData = JsonUtils.fromJson(json, TypeData.class);
                    if (typeList.size()>0)typeList.clear();
                    if (typeData.getData().size() > 0) {
                        for (String str : typeData.getData()) {
                            typeList.add(new DateModel(str, false));
                        }
                        typeList.get(0).setClicked(true);
                        splb = typeList.get(0).getDate();
                        getDataList();
                        tv_nodata1.setVisibility(View.GONE);
                        rv_type.setVisibility(View.VISIBLE);
                    }else {
                        rv_type.setVisibility(View.GONE);

                        tv_nodata1.setVisibility(View.VISIBLE);
                        tv_nodata2.setVisibility(View.VISIBLE);
                        rv_data.setVisibility(View.GONE);
                    }


                    typeAdapter.notifyDataSetChanged();


                    //		typeList.add(new DateModel("蔬菜", true));

                }else {
                    rv_type.setVisibility(View.GONE);

                    tv_nodata1.setVisibility(View.VISIBLE);
                    tv_nodata2.setVisibility(View.VISIBLE);
                    rv_data.setVisibility(View.GONE);
                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });

    }

    //http://localhost:8096/wisdom/app/getJYHSprkByJYHUserId.action?
// userId=163&startDay=2020-01-01&endDay=2020-02-25&splb=%E5%B0%8F%E7%99%BD%E8%8F%9C
    private void getDataList() {

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/getJYHSprkByJYHUserId.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
//        paramMap.put("startDay", "2020-01-01");
//        paramMap.put("endDay", "2020-02-25");
        paramMap.put("startDay", frontYear+"-"+getFormatNumber(frontMonth)+"-"+getFormatNumber(frontWeek));
        paramMap.put("endDay", currentYear+"-"+getFormatNumber(currentMonth)+"-"+getFormatNumber(currentWeek));
        paramMap.put("splb", splb);
        Log.d("zkf", "params:" + paramMap.toString());

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                LogUtils.d("zkf  successResult:" + successResult);
                refreshLayout.setRefreshing(false);
                if (!TextUtils.isEmpty(successResult)) {
                    cancelLoadDialog();
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    if (dataList.size() > 0) {
                        dataList.clear();
                        tv_total_money.setText("0");
                    }
                    if (json.has("data")) {
                        StockPurchase.DataBean[] taskList = JsonUtils.fromJson(json.get("data"), StockPurchase.DataBean[].class);

                        dataList.addAll(Arrays.asList(taskList));
                        if (dataList.size()>0){
                            int sumMoney = 0;
                            for (StockPurchase.DataBean dataBean : dataList) {
                                sumMoney = sumMoney + Integer.parseInt(dataBean.getSpdj().replace(".0","")) * Integer.parseInt(dataBean.getSum());
                            }
                            tv_total_money.setText(sumMoney + "");

                            tv_nodata2.setVisibility(View.GONE);
                            rv_data.setVisibility(View.VISIBLE);
                        }else {
                            tv_nodata2.setVisibility(View.VISIBLE);
                            rv_data.setVisibility(View.GONE);
                            tv_total_money.setText("0");
                        }

                    }else {
                        tv_nodata2.setVisibility(View.VISIBLE);
                        rv_data.setVisibility(View.GONE);
                        tv_total_money.setText("0");
                    }

                    dataAdapter.notifyDataSetChanged();


                    //		typeList.add(new DateModel("蔬菜", true));

                }else {
                    tv_nodata2.setVisibility(View.VISIBLE);
                    rv_data.setVisibility(View.GONE);

                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });

    }


}
