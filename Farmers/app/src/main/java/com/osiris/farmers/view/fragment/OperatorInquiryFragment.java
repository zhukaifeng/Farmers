package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.OperatorInquery;
import com.osiris.farmers.view.OperatorInputActivity;
import com.osiris.farmers.view.adapter.OperatorInquiryAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class OperatorInquiryFragment extends BaseFragment {

	@BindView(R.id.rv_data)
	RecyclerView rv_data;
	private List<OperatorInquery> dataList = new ArrayList<>();
	private OperatorInquiryAdapter dataAdapter = new OperatorInquiryAdapter(dataList);


	@Override
	protected int setLayout() {
		return R.layout.fragment_operator_inquiry;
	}

	@Override
	protected void initView() {
		dataList.add(new OperatorInquery("028", "镇江2单位", "查看", "张浩"));
		dataList.add(new OperatorInquery("028", "镇江2单位", "查看", "张浩"));
		dataList.add(new OperatorInquery("028", "镇江2单位", "查看", "张浩"));
		dataList.add(new OperatorInquery("028", "镇江2单位", "查看", "张浩"));
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
				if (dataList.get(position).isClicked()) {
					dataList.get(position).setClicked(false);
				} else {
					dataList.get(position).setClicked(true);
				}
				dataAdapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	protected void initData() {

	}

	@OnClick({R.id.rl_right})
	void onClick(View v) {
		switch (v.getId()) {
			case R.id.rl_right:
				Intent intent = new Intent(getActivity(), OperatorInputActivity.class);
				startActivity(intent);
				break;
		}
	}

}
