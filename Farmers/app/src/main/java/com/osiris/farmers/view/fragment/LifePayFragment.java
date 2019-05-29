package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.Electric;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.PayElectricAdapter;
import com.osiris.farmers.view.adapter.TypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LifePayFragment extends BaseFragment {

	@BindView(R.id.rv_data_electric)
	RecyclerView rv_data_electric;
	@BindView(R.id.rv_data_other)
	RecyclerView rv_data_other;
	@BindView(R.id.rv_type)
	RecyclerView rv_type;


	private List<Electric> dataList = new ArrayList<>();
	private PayElectricAdapter dataAdapter = new PayElectricAdapter(dataList);
	private List<Electric> dataOtherList = new ArrayList<>();
	private PayElectricAdapter dataOtherAdapter = new PayElectricAdapter(dataOtherList);

	private List<DateModel> typeList = new ArrayList<>();
	private TypeAdapter typeAdapter = new TypeAdapter(typeList);

	@Override
	protected int setLayout() {
		return R.layout.fragment_life_payment;
	}

	@Override
	protected void initView() {

		typeList.add(new DateModel("农贸市场", true));
		typeList.add(new DateModel("农贸市场", false));
		typeList.add(new DateModel("农贸市场", false));
		typeList.add(new DateModel("农贸市场", false));
		typeList.add(new DateModel("农贸市场", false));
		typeList.add(new DateModel("农贸市场", false));


		dataList.add(new Electric("编号01", "张浩", "-65.32"));
		dataList.add(new Electric("编号01", "张浩", "-65.32"));
		dataList.add(new Electric("编号01", "张浩", "-65.32"));


		dataOtherList.add(new Electric("编号01", "张浩", "-200"));
		dataOtherList.add(new Electric("编号01", "张浩", "-200"));
		dataOtherList.add(new Electric("编号01", "张浩", "-200"));

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



		rv_data_electric.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
		rv_data_electric.setAdapter(dataAdapter);
		dataAdapter.notifyDataSetChanged();


		rv_data_other.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
		rv_data_other.setAdapter(dataOtherAdapter);
		dataOtherAdapter.notifyDataSetChanged();




	}

	@Override
	protected void initData() {

	}
}
