package com.osiris.farmers.shichang;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.EvaluateList;
import com.osiris.farmers.model.MakeScoreData;
import com.osiris.farmers.model.ShiChangPijgjia;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MarketScoreAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class ScoringDetailScActivity extends BaseActivity {


	private EvaluateList.ZhugpingjiasBean data;

	@BindView(R.id.tv_market)
	TextView tv_market;
	@BindView(R.id.rv_data)
	RecyclerView rv_data;
	@BindView(R.id.linear_info)
	LinearLayout linear_info;
	@BindView(R.id.tv_title)
	TextView tv_title;


	private int id;
	private List<MakeScoreData.PingjiaxxsBean>  dataList = new ArrayList<>();
	private MarketScoreAdapter marketScoreAdapter = new MarketScoreAdapter(dataList);

	private int xxz = 0;

	@Override
	public int getLayoutResId() {
		return R.layout.activity_scoring_detail;
	}

	@Override
	public void init() {
		linear_info.setVisibility(View.GONE);
		xxz = getIntent().getIntExtra("xxz",0);
		Log.d("zkf "," ssss   xxz:" + xxz);
		id = getIntent().getIntExtra("id",0);
		if (xxz == 1){
			data = getIntent().getParcelableExtra("data");
			if (null != data){
				tv_market.setText(data.getMarketnm());
			}
		}



		tv_title.setText("经营行为详情");

		rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
		rv_data.setAdapter(marketScoreAdapter);
		marketScoreAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
//				Intent intent = new Intent(ScoringDetailActivity.this,AddScorelActivity.class);
//				intent.putExtra("data",data);
//				startActivity(intent);
			}
		});
		getData();

	}


	@OnClick({R.id.rl_back})
	void onClick(View v){
		switch (v.getId()){
			case R.id.rl_back:
				finish();
				break;
		}
	}


//http://39.97.235.7:8086/wisdom/app/getMarketpingjiaById.action
	private void getData(){
		String url = ApiParams.API_HOST + "/app/getMarketpingjiaById.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id",String.valueOf(id));
		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf successResult:" + successResult);
				JsonParser parser = new JsonParser();
				JsonObject json = parser.parse(successResult).getAsJsonObject();
				if (json.has("pingjiaxxs")){
					MakeScoreData.PingjiaxxsBean[] datas = JsonUtils.fromJson(json.get("pingjiaxxs").getAsJsonArray(),
							MakeScoreData.PingjiaxxsBean[].class);
					dataList.addAll(Arrays.asList(datas));
					marketScoreAdapter.notifyDataSetChanged();

				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});

	}

}
