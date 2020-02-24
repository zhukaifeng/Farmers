package com.osiris.farmers.goods.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.goods.TypeData;
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


	private List<StockPurchase.DataBean> dataList = new ArrayList<>();
	private StockPurchaseAdapter dataAdapter = new StockPurchaseAdapter(dataList);
	private List<DateModel> typeList = new ArrayList<>();
	private TypePurchaseAdapter typeAdapter = new TypePurchaseAdapter(typeList);

	private List<DateModel> monthList = new ArrayList<>();
	private DateAdapter monthAdapter = new DateAdapter(monthList);
	private List<DateModel> yearList = new ArrayList<>();
	private DateAdapter yearAdapter = new DateAdapter(yearList);
	private List<WeekModel> weekList = new ArrayList<>();
	private WeekAdapter weekAdapter = new WeekAdapter(weekList);
	private int currentMonth;
	private int currentYear;
	private int currentWeek;

	@Override
	protected int setLayout() {
		return R.layout.fragment_stock_purchase;
	}

	@Override
	protected void initView() {

	    getType();

		yearList.add(new DateModel("2020", true));
		yearList.add(new DateModel("2021", false));
		yearList.add(new DateModel("2022", false));
		yearList.add(new DateModel("2023", false));
		yearList.add(new DateModel("2024", false));
		currentYear = 2020;
		tv_year.setText(currentYear+"年");
		tv_year_two.setText(currentYear+"年");
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH)+1;
		currentMonth  = month;
		tv_month.setText(month+"月");
		tv_month_two.setText(month+"月");
		tv_month_three.setText(month+"");
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		currentWeek = day;
		tv_date.setText(day+"");
		for (int i = 1; i < 13; i++) {
			if (i == month) {
				monthList.add(new DateModel(i + "月", true));
			} else {
				monthList.add(new DateModel(i + "月", false));
			}
		}
		LogUtils.d("zkf date count:" + DateUtil.getMonthLastDay(currentYear, currentMonth));
		for (int i = 1; i < DateUtil.getMonthLastDay(currentYear, currentMonth) + 1; i++) {
			if (i == day) {
				weekList.add(new WeekModel(String.valueOf(i), DateUtil.getWeek(currentYear + "-" + currentMonth + "-" + i), true));
			} else {
				weekList.add(new WeekModel(String.valueOf(i), DateUtil.getWeek(currentYear + "-" + currentMonth + "-" + i), false));
			}
		}


		rv_month.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
		rv_month.setAdapter(monthAdapter);
		monthAdapter.notifyDataSetChanged();
		monthAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				for (DateModel dateModel : monthList) {
					dateModel.setClicked(false);
				}
				monthList.get(position).setClicked(true);
				monthAdapter.notifyDataSetChanged();
				currentMonth = Integer.parseInt(monthList.get(position).getDate().replace("月", ""));

				weekList.clear();
				for (int i = 1; i < DateUtil.getMonthLastDay(currentYear, currentMonth) + 1; i++) {
					if (i == currentWeek) {
						weekList.add(new WeekModel(String.valueOf(i), DateUtil.getWeek(currentYear + "-" + currentMonth + "-" + i), true));
					} else {
						weekList.add(new WeekModel(String.valueOf(i), DateUtil.getWeek(currentYear + "-" + currentMonth + "-" + i), false));
					}
				}
				weekAdapter.notifyDataSetChanged();
				tv_month.setText(currentMonth+"月");
				tv_month_two.setText(currentMonth+"月");
				tv_month_three.setText(currentMonth+"");


			}
		});
		rv_year.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
		rv_year.setAdapter(yearAdapter);
		yearAdapter.notifyDataSetChanged();
		yearAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				for (DateModel dateModel : yearList) {
					dateModel.setClicked(false);
				}
				yearList.get(position).setClicked(true);
				yearAdapter.notifyDataSetChanged();
				currentYear = Integer.parseInt(yearList.get(position).getDate());
				LogUtils.d("zkf date count:" + DateUtil.getMonthLastDay(currentYear, currentMonth));
				weekList.clear();
				for (int i = 1; i < DateUtil.getMonthLastDay(currentYear, currentMonth) + 1; i++) {
					if (i == currentWeek) {
						weekList.add(new WeekModel(String.valueOf(i), DateUtil.getWeek(currentYear + "-" + currentMonth + "-" + i), true));
					} else {
						weekList.add(new WeekModel(String.valueOf(i), DateUtil.getWeek(currentYear + "-" + currentMonth + "-" + i), false));
					}
				}
				weekAdapter.notifyDataSetChanged();
				tv_year.setText(currentYear+"年");
				tv_year_two.setText(currentYear+"年");
			}
		});

		rv_date.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
		rv_date.setAdapter(weekAdapter);
		weekAdapter.notifyDataSetChanged();
		weekAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				for (WeekModel weekModel : weekList) {
					weekModel.setSelect(false);
				}
				weekList.get(position).setSelect(true);
				weekAdapter.notifyDataSetChanged();
				currentWeek = Integer.parseInt(weekList.get(position).getDate());
				// currentMonth = Integer.parseInt(monthList.get(position).getDate().replace("月",""));
				tv_date.setText(currentWeek+"");
				LogUtils.d("zkf date count:" + DateUtil.getMonthLastDay(currentYear, currentMonth));

			}
		});


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


			}
		});


		rv_data.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
		rv_data.setAdapter(dataAdapter);
		dataAdapter.notifyDataSetChanged();
		dataAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
//                linear_pay.setVisibility(View.VISIBLE);
//                rl_context.setVisibility(View.GONE);
			}
		});
	}

	@Override
	protected void initData() {

	}

	@OnClick({R.id.rl_back,R.id.rl_back_one})
	void onClick(View v) {
		switch (v.getId()) {
			case R.id.rl_back:
				linear_detail.setVisibility(View.GONE);
				rl_stock_list.setVisibility(View.VISIBLE);
				break;
			case R.id.rl_back_one:
				getActivity().finish();
				break;
		}
	}


	private String splb="";

	private void getType(){

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/getSprkSplbByUserId.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(53));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        LogUtils.d("zkf date:" + String.valueOf(simpleDateFormat.format(date)));
        paramMap.put("hycompany", "2020-02-09");

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                LogUtils.d("zkf  successResult:" + successResult);
                if (!TextUtils.isEmpty(successResult)) {
                    cancelLoadDialog();
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
					TypeData  typeData = JsonUtils.fromJson(json,TypeData.class);
					if (typeData.getData().size()>0){
						for (String str:typeData.getData()){
							typeList.add(new DateModel(str, false));
						}
						typeList.get(0).setClicked(true);
						splb = typeList.get(0).getDate();
						typeAdapter.notifyDataSetChanged();
						getDataList();

					}


			//		typeList.add(new DateModel("蔬菜", true));

                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });

    }


	private void getDataList(){

		showLoadDialog();
		String url = ApiParams.API_HOST + "/app/getSprkByUserId.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("userId", String.valueOf(53));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
		Date date = new Date(System.currentTimeMillis());
		LogUtils.d("zkf date:" + String.valueOf(simpleDateFormat.format(date)));
		paramMap.put("hycompany", "2020-02-09");
		paramMap.put("splb",splb);

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

			@Override
			public void requestSuccess(int tag, String successResult) {
				//String temp = successResult.substring(1, successResult.length() - 1);
				LogUtils.d("zkf  successResult:" + successResult);
				if (!TextUtils.isEmpty(successResult)) {
					cancelLoadDialog();
					JsonParser parser = new JsonParser();
					JsonObject json = parser.parse(successResult).getAsJsonObject();
					if (json.has("data")){
						StockPurchase.DataBean[] taskList = JsonUtils.fromJson(json.get("data"), StockPurchase.DataBean[].class);
						if (dataList.size()>0){
							dataList.clear();
						}
						dataList.addAll(Arrays.asList(taskList));
						dataAdapter.notifyDataSetChanged();

						int sumMoney = 0;
						for (StockPurchase.DataBean dataBean:dataList){
							sumMoney = sumMoney + Integer.parseInt(dataBean.getSpdj())*Integer.parseInt(dataBean.getSum());
						}
						tv_total_money.setText(sumMoney+"");
					}


					//		typeList.add(new DateModel("蔬菜", true));

				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {
				cancelLoadDialog();
			}
		});

	}







}
