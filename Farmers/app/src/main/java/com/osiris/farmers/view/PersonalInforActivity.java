package com.osiris.farmers.view;

import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.OnClick;

public class PersonalInforActivity extends BaseActivity {






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
		return R.layout.activity_personal_info;
	}

	@Override
	public void init() {

	}
}
