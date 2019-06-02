package com.osiris.farmers.goods.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.StockPurchase;
import com.osiris.farmers.model.WeekModel;
import com.osiris.farmers.utils.DateUtil;
import com.osiris.farmers.view.adapter.DateAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.StockPurchaseAdapter;
import com.osiris.farmers.view.adapter.TypePurchaseAdapter;
import com.osiris.farmers.view.adapter.WeekAdapter;

import java.util.ArrayList;
import java.util.List;

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

	private List<StockPurchase> dataList = new ArrayList<>();
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

		yearList.add(new DateModel("2019", true));
		yearList.add(new DateModel("2020", false));
		yearList.add(new DateModel("2021", false));
		yearList.add(new DateModel("2022", false));
		yearList.add(new DateModel("2023", false));
		yearList.add(new DateModel("2024", false));
		currentYear = 2019;
		currentWeek = 1;

		for (int i = 1; i < 13; i++) {
			if (i == 1) {
				monthList.add(new DateModel(i + "月", true));
			} else {
				monthList.add(new DateModel(i + "月", false));
			}
		}
		currentMonth = 1;
		LogUtils.d("zkf date count:" + DateUtil.getMonthLastDay(currentYear, currentMonth));
		for (int i = 1; i < DateUtil.getMonthLastDay(currentYear, currentMonth) + 1; i++) {
			if (i == currentWeek) {
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

				LogUtils.d("zkf date count:" + DateUtil.getMonthLastDay(currentYear, currentMonth));

			}
		});


//  紫包菜        蔬菜     30斤     60元     华北市场   2019.03.20
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));
		dataList.add(new StockPurchase("紫包菜", "蔬菜", "30斤", "60元", "华北市场", "2019.03.20"));


		typeList.add(new DateModel("蔬菜", true));
		typeList.add(new DateModel("水果", false));
		typeList.add(new DateModel("肉类", false));
		typeList.add(new DateModel("海鲜", false));


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

	@OnClick({R.id.rl_back})
	void onClick(View v) {
		switch (v.getId()) {
			case R.id.rl_back:
				linear_detail.setVisibility(View.GONE);
				rl_stock_list.setVisibility(View.VISIBLE);
				break;
		}
	}


}
