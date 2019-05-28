package com.osiris.farmers.login;

import android.view.View;
import android.widget.ImageView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SalesAccountActivity extends BaseActivity {


	@BindView(R.id.iv_one)
	ImageView iv_one;
	@BindView(R.id.iv_two)
	ImageView iv_two;
	@BindView(R.id.iv_three)
	ImageView iv_three;
	@BindView(R.id.iv_four)
	ImageView iv_four;
	@BindView(R.id.iv_five)
	ImageView iv_five;

	@Override
	public int getLayoutResId() {
		return R.layout.activity_accounting;
	}

	@Override
	public void init() {

	}


	@OnClick({R.id.iv_one,R.id.iv_two,R.id.iv_three,R.id.iv_four,R.id.iv_five,R.id.rl_back})
	void onClick(View v){
		switch (v.getId()){
			case R.id.iv_one:
				iv_one.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_two.setBackgroundResource(R.drawable.bg_gray_star);
				iv_three.setBackgroundResource(R.drawable.bg_gray_star);
				iv_four.setBackgroundResource(R.drawable.bg_gray_star);
				iv_five.setBackgroundResource(R.drawable.bg_gray_star);
				break;
			case R.id.iv_two:
				iv_one.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_two.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_three.setBackgroundResource(R.drawable.bg_gray_star);
				iv_four.setBackgroundResource(R.drawable.bg_gray_star);
				iv_five.setBackgroundResource(R.drawable.bg_gray_star);
				break;
			case R.id.iv_three:
				iv_one.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_two.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_three.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_four.setBackgroundResource(R.drawable.bg_gray_star);
				iv_five.setBackgroundResource(R.drawable.bg_gray_star);
				break;
			case R.id.iv_four:
				iv_one.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_two.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_three.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_four.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_five.setBackgroundResource(R.drawable.bg_gray_star);
				break;
			case R.id.iv_five:
				iv_one.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_two.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_three.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_four.setBackgroundResource(R.drawable.bg_yellow_star);
				iv_five.setBackgroundResource(R.drawable.bg_yellow_star);
				break;
			case R.id.rl_back:
				finish();

				break;
		}
	}


}
