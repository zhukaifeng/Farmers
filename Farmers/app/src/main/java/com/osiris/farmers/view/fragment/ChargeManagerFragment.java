package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.ChargeDetail;
import com.osiris.farmers.model.ChargeManager;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.view.adapter.ChargeDetailAdapter;
import com.osiris.farmers.view.adapter.ChargeManagerAdapter;
import com.osiris.farmers.view.adapter.ChargeTypeAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChargeManagerFragment extends BaseFragment {

	@BindView(R.id.rv_data)
	RecyclerView rv_data;
	@BindView(R.id.rv_type)
	RecyclerView rv_type;
	@BindView(R.id.rv_data_detail)
	RecyclerView rv_data_detail;

	private List<ChargeManager> dataList = new ArrayList<>();
	private ChargeManagerAdapter dataAdapter = new ChargeManagerAdapter(dataList);
	private List<DateModel> typeList = new ArrayList<>();
	private ChargeTypeAdapter typeAdapter = new ChargeTypeAdapter(typeList);
	private List<ChargeDetail> dataDetailList = new ArrayList<>();
	private ChargeDetailAdapter dataDetailAdapter = new ChargeDetailAdapter(dataDetailList);


	@Override
	protected int setLayout() {
		return R.layout.fragment_charge_manager;
	}

	@Override
	protected void initView() {

		typeList.add(new DateModel("全部", true));
		typeList.add(new DateModel("电费", false));
		typeList.add(new DateModel("水费", false));
		typeList.add(new DateModel("摊位费", false));
		typeList.add(new DateModel("保证金", false));
		typeList.add(new DateModel("物业费", false));
		typeList.add(new DateModel("卫生费", false));
		typeList.add(new DateModel("电梯费", false));
		typeList.add(new DateModel("其他", false));

		//摊位费            未交80元            已交30元            2019.03.22
		dataDetailList.add(new ChargeDetail("谁费", "未交80元","已交30元","2019.03.22"));
		dataDetailList.add(new ChargeDetail("电费", "未交80元","已交30元","2019.03.22"));
		dataDetailList.add(new ChargeDetail("摊位费", "未交80元","已交30元","2019.03.22"));
		dataDetailList.add(new ChargeDetail("保证金", "未交80元","已交30元","2019.03.22"));
		dataDetailList.add(new ChargeDetail("物业费", "未交80元","已交30元","2019.03.22"));
		dataDetailList.add(new ChargeDetail("卫生费", "未交80元","已交30元","2019.03.22"));
		dataDetailList.add(new ChargeDetail("电梯费", "未交80元","已交30元","2019.03.22"));



//镇江江南        028       张浩         500元       0元      2019.03.22
		dataList.add(new ChargeManager("镇江江南", "028", "张浩", "500元","0元","2019.03.22"));
		dataList.add(new ChargeManager("镇江江南", "028", "张浩", "500元","0元","2019.03.22"));
		dataList.add(new ChargeManager("镇江江南", "028", "张浩", "500元","0元","2019.03.22"));
		dataList.add(new ChargeManager("镇江江南", "028", "张浩", "500元","0元","2019.03.22"));
		dataList.add(new ChargeManager("镇江江南", "028", "张浩", "500元","0元","2019.03.22"));
		dataList.add(new ChargeManager("镇江江南", "028", "张浩", "500元","0元","2019.03.22"));


		rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
		rv_data.setAdapter(dataAdapter);
		dataAdapter.notifyDataSetChanged();


		rv_type.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
		rv_type.setAdapter(typeAdapter);
		typeAdapter.notifyDataSetChanged();
		typeAdapter.setOnItemClick(new MyItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				for (DateModel dateModel : typeList) {
					dateModel.setClicked(false);
				}
				typeList.get(position).setClicked(true);
				typeAdapter.notifyDataSetChanged();


			}
		});

		rv_data_detail.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
		rv_data_detail.setAdapter(dataDetailAdapter);
		dataDetailAdapter.notifyDataSetChanged();


	}

	@Override
	protected void initData() {

	}
}
