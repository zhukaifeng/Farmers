package com.osiris.farmers.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.EvaluateList;
import com.osiris.farmers.model.MakeScoreData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MarketScoreAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class ScoringDetailActivity extends BaseActivity {


	private EvaluateList.ZhugpingjiasBean data;

	@BindView(R.id.tv_market)
	TextView tv_market;
	@BindView(R.id.rv_data)
	RecyclerView rv_data;

	private List<MakeScoreData.PingjiaxxsBean>  dataList = new ArrayList<>();
	private MarketScoreAdapter marketScoreAdapter = new MarketScoreAdapter(dataList);



	@Override
	public int getLayoutResId() {
		return R.layout.activity_scoring_detail;
	}

	@Override
	public void init() {
		data = getIntent().getParcelableExtra("data");


		if (null != data){
			tv_market.setText(data.getMarketnm());
		}

		rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
		rv_data.setAdapter(marketScoreAdapter);

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



	private void getData(){
		String url = ApiParams.API_HOST + "/app/zgscpingjiaDetal.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id",String.valueOf(data.getId()));
		paramMap.put("xxz","1");

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
