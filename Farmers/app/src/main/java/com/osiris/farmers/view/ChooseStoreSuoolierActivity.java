package com.osiris.farmers.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.BoothgEvent;
import com.osiris.farmers.model.ChooseStallData;
import com.osiris.farmers.model.StoreSupplier;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.StallNoAdapter;
import com.osiris.farmers.view.adapter.StallSupplierAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.jessyan.autosize.utils.LogUtils;

public class ChooseStoreSuoolierActivity extends BaseActivity {


	@BindView(R.id.rv_data)
	RecyclerView rvData;
	@BindView(R.id.tv_title)
	TextView tv_title;


	private List<StoreSupplier.CustomerBean> customer = new ArrayList<>();
	private StallSupplierAdapter typeAdapter = new StallSupplierAdapter(customer);


	@Override
	public int getLayoutResId() {
		return R.layout.activity_choose_stall_no;
	}

	@Override
	public void init() {
		tv_title.setText("选择供应商");

		getStoreList();
		rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		rvData.setAdapter(typeAdapter);
		typeAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				//postEvent(new BoothgEvent(stallList.get(position).getId(),stallList.get(position).getTwhmc(),stallList.get(position).getMarketid()));
				//把返回数据存入Intent
				postEvent(customer.get(position));
				finish();

			}
		});


	}


	private void getStoreList(){


		String url = ApiParams.API_HOST + "/app/changecustomer.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("userid",String.valueOf(GlobalParams.id));
		//  paramMap.put("customernm","null");
		LogUtils.d("zkf userid:" + String.valueOf(GlobalParams.id));
		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf success data:" + successResult);
				JsonParser parser = new JsonParser();
				JsonObject json = parser.parse(successResult).getAsJsonObject();
				if (json.has("msg")&& json.get("msg").getAsString().equals("ok")){
					StoreSupplier data = JsonUtils.fromJson(successResult,StoreSupplier.class);
					if (null != data.getCustomer()&&data.getCustomer().size()>0){
						customer.addAll(data.getCustomer());
						typeAdapter.notifyDataSetChanged();
						LogUtils.d("zkf customer size:" + customer.size());
					}
				}
			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});



	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}




}
