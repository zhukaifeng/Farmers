package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateBackto;
import com.osiris.farmers.model.ShippingStock;
import com.osiris.farmers.view.adapter.ShippingStockAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShippingStockFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    private List<ShippingStock> dataList = new ArrayList<>();
    private ShippingStockAdapter dataAdapter = new ShippingStockAdapter(dataList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_shipping_stock;
    }

    @Override
    protected void initView() {
        dataList.add(new ShippingStock("蔬菜", "紫包菜", "500斤"));
        dataList.add(new ShippingStock("肉类", "猪肉", "500斤"));
        dataList.add(new ShippingStock("海鲜", "龙虾", "500斤"));
        dataList.add(new ShippingStock("水果", "西瓜", "50斤"));
        dataList.add(new ShippingStock("蔬菜", "紫包菜", "500斤"));
        dataList.add(new ShippingStock("肉类", "猪肉", "500斤"));
        dataList.add(new ShippingStock("海鲜", "龙虾", "500斤"));
        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }
}
