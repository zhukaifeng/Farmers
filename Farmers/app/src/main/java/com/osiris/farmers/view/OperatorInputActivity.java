package com.osiris.farmers.view;

import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.OnClick;

public class OperatorInputActivity extends BaseActivity {



	@Override
	public int getLayoutResId() {
		return R.layout.activity_operator_input;
	}

	@Override
	public void init() {

	}

	@OnClick({R.id.rl_back})
	void onClick(View v){
		switch (v.getId()){
			case R.id.rl_back:
				finish();
				break;
		}
	}
}
