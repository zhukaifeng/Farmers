package com.osiris.farmers.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;

import butterknife.BindView;

public class DatebacktoFragment extends BaseFragment {



	@BindView(R.id.rv_data)
	RecyclerView rv_data;

	@Override
	protected int setLayout() {
		return R.layout.fragment_datebackto;
	}

	@Override
	protected void initView(View view) {

	}

	@Override
	protected void initData() {

	}

	@Override
	public void onClick(View v) {

	}
}
