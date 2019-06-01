package com.osiris.farmers.goods.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.StockPurchase;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.StockPurchaseAdapter;
import com.osiris.farmers.view.adapter.TypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class StockPurchaseFragment extends BaseFragment {

    @BindView(R.id.linear_detail)
    LinearLayout linear_detail;
    @BindView(R.id.rl_stock_list)
    RelativeLayout rl_stock_list;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;
    private List<StockPurchase> dataList = new ArrayList<>();
    private StockPurchaseAdapter dataAdapter = new StockPurchaseAdapter(dataList);
    private List<DateModel> typeList = new ArrayList<>();
    private TypeAdapter typeAdapter = new TypeAdapter(typeList);


    @Override
    protected int setLayout() {
        return R.layout.fragment_stock_purchase;
    }

    @Override
    protected void initView( ) {
//  紫包菜        蔬菜     30斤     60元     华北市场   2019.03.20
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));
        dataList.add(new StockPurchase("紫包菜","蔬菜","30斤","60元","华北市场","2019.03.20"));


        typeList.add(new DateModel("蔬菜", true));
        typeList.add(new DateModel("水果", false));
        typeList.add(new DateModel("肉类", false));
        typeList.add(new DateModel("海鲜", false));


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


        rv_data.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                linear_pay.setVisibility(View.VISIBLE);
//                rl_context.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_back:
                linear_detail.setVisibility(View.GONE);
                rl_stock_list.setVisibility(View.VISIBLE);
                break;
        }
    }


}
