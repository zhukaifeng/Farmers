package com.osiris.farmers.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.login.SalesAccountActivity;
import com.osiris.farmers.model.AccountDetail;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.view.adapter.AccountDetailAdapter;
import com.osiris.farmers.view.adapter.DateAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SalsersAccountActivity extends BaseActivity {


	@BindView(R.id.rv_data)
	RecyclerView rv_data;
	@BindView(R.id.rv_month)
	RecyclerView rv_month;
	@BindView(R.id.rv_year)
	RecyclerView rv_year;


	private List<DateModel> monthList = new ArrayList<>();
	private DateAdapter monthAdapter = new DateAdapter(monthList);
	private List<DateModel> yearList = new ArrayList<>();
	private DateAdapter yearAdapter = new DateAdapter(yearList);
	private List<AccountDetail> dataList = new ArrayList<>();
	private AccountDetailAdapter accountDetailAdapter = new AccountDetailAdapter(dataList);

	@Override
	public int getLayoutResId() {
		return R.layout.activity_salers_account;
	}

	@Override
	public void init() {

		yearList.add(new DateModel("2019", true));
		yearList.add(new DateModel("2020", false));
		yearList.add(new DateModel("2021", false));
		yearList.add(new DateModel("2022", false));
		yearList.add(new DateModel("2023", false));
		yearList.add(new DateModel("2024", false));

		for (int i = 1; i < 13; i++) {
			if (i == 1) {
				monthList.add(new DateModel(i + "月", true));
			} else {
				monthList.add(new DateModel(i + "月", false));
			}
		}


		dataList.add(new AccountDetail("今天","2019年5月29日",0.00,0.00));
		dataList.add(new AccountDetail("本周","2019年5月27日~2019年6月2日",0.00,0.00));
		dataList.add(new AccountDetail("本月","2019年5月1日~2019年5月31日",0.00,0.00));
		dataList.add(new AccountDetail("本年","2019年1月1日~2019年12月31日",0.00,0.00));


		rv_month.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
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


			}
		});
		rv_year.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
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


			}
		});

		rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		rv_data.setAdapter(accountDetailAdapter);
		accountDetailAdapter.notifyDataSetChanged();

	}


	@OnClick({R.id.tv_remeber,R.id.rl_back})
	void onClick(View v){
		switch (v.getId()){
			case R.id.tv_remeber:
				Intent intent = new Intent(this, SalesAccountActivity.class);
				startActivity(intent);
				break;
			case R.id.rl_back:
				finish();
				break;
		}
	}
}
