package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.OperatorInquery;
import com.osiris.farmers.model.SerachGoodData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.OperatorInputActivity;
import com.osiris.farmers.view.adapter.OperatorInquiryAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class OperatorInquiryFragment extends BaseFragment {

	@BindView(R.id.rv_data)
	RecyclerView rv_data;
	private ArrayList<OperatorInquery.DataBean> dataList = new ArrayList<>();
	private OperatorInquiryAdapter dataAdapter = new OperatorInquiryAdapter(dataList);


	@Override
	protected int setLayout() {
		return R.layout.fragment_operator_inquiry;
	}

	@Override
	protected void initView() {
		rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
		rv_data.setAdapter(dataAdapter);
		dataAdapter.notifyDataSetChanged();
		dataAdapter.setOnButtonClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LogUtils.d("zkf click");
				Object positionTag = v.getTag(R.id.tag_operator_inquiry);
				if (positionTag == null) {
					return;
				}
				if (!(positionTag instanceof Integer)) {
					return;
				}
				int position = Integer.parseInt(String.valueOf(positionTag));
				LogUtils.d("zkf click  position:" + position);

				dataAdapter.notifyDataSetChanged();
			}
		});
		getTypeData();

	}

	@Override
	protected void initData() {

	}

	@OnClick({R.id.rl_back})
	void onClick(View v) {
		switch (v.getId()) {
			case R.id.rl_back:
				getActivity().finish();
				break;
		}
	}

	//13813714259
	//http://localhost:8096/wisdom/app/getOperatorByUserId.action?userId=53
	private void getTypeData() {


		String url = ApiParams.API_HOST + "/app/getOperatorByUserId.action";

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("userId", String.valueOf(GlobalParams.id));

		Log.d("zkf", "params:" + paramMap.toString());
		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				Log.d("zkf", "data:" + successResult);
				JsonParser parser = new JsonParser();
				JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
				if (jsonObject.has("data")){

					OperatorInquery.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), OperatorInquery.DataBean[].class);
					dataList.addAll(Arrays.asList(dataBeans));
					dataAdapter.notifyDataSetChanged();

				}
			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}
}
