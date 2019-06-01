package com.osiris.farmers.view;

import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.OnClick;

public class NewMarketScoreActivity extends BaseActivity {



	@Override
	public int getLayoutResId() {
		return R.layout.activity_market_score;
	}

	@Override
	public void init() {

	}


	@OnClick({R.id.rl_back,R.id.tv_cancel,R.id.tv_confirm})
	void onClick(View v){
		switch (v.getId()){
			case R.id.rl_back:
				finish();
				break;
			case R.id.tv_cancel:
				finish();
				break;
			case R.id.tv_confirm:
				finish();
				break;
		}
	}
}
