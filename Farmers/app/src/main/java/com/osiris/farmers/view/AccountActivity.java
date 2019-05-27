package com.osiris.farmers.view;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountActivity extends BaseActivity {



	@BindView(R.id.tv_exit)
	TextView tv_exit;


	@OnClick({R.id.iv_back,R.id.rl_person_info})
	void onClick(View v){
		switch (v.getId()){
			case R.id.iv_back:
				finish();
				break;
			case R.id.rl_person_info:
				Intent intent = new Intent(this, PersonalInforActivity.class);
				startActivity(intent);
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
