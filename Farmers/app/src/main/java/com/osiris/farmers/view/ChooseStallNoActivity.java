package com.osiris.farmers.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.BoothgEvent;
import com.osiris.farmers.model.ChooseStallData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.StallNoAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseStallNoActivity extends BaseActivity {


	@BindView(R.id.rv_data)
	RecyclerView rvData;


	private List<ChooseStallData.BoothglBean> stallList = new ArrayList<>();
	private StallNoAdapter typeAdapter = new StallNoAdapter(stallList);


	@Override
	public int getLayoutResId() {
		return R.layout.activity_choose_stall_no;
	}

	@Override
	public void init() {

		getStallNo();
		rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		rvData.setAdapter(typeAdapter);
		typeAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				postEvent(new BoothgEvent(stallList.get(position).getId(),stallList.get(position).getTwhmc(),stallList.get(position).getMarketid()));
				//把返回数据存入Intent
				finish();

			}
		});


	}



	private void getStallNo() {

		String url = ApiParams.API_HOST + "/app/xzboothgl.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", String.valueOf(GlobalParams.currentMarketId));

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				String temp = successResult.substring(1, successResult.length() - 1);
				if (!TextUtils.isEmpty(successResult)) {
					ChooseStallData tempData = JsonUtils.fromJson(temp, ChooseStallData.class);
					if (stallList.size() > 0) stallList.clear();
					stallList.addAll(tempData.getBoothgl());
					typeAdapter.notifyDataSetChanged();

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
