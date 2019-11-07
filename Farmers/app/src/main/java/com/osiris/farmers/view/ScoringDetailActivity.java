package com.osiris.farmers.view;

import android.view.View;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.EvaluateList;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class ScoringDetailActivity extends BaseActivity {


	private EvaluateList.ZhugpingjiasBean data;

	@BindView(R.id.tv_market)
	TextView tv_market;




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
			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});

	}

}
