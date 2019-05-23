package com.osiris.farmers.view;

import android.view.View;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountActivity extends BaseActivity {



	@BindView(R.id.tv_exit)
	TextView tv_exit;


	@OnClick({R.id.iv_back})
	void onClick(View v){
		switch (v.getId()){
			case R.id.iv_back:
				finish();
				break;
		}

	}

	@Override
	public int getLayoutResId() {
		return R.layout.activity_account;
	}

	@Override
	public void init() {

	}
}
