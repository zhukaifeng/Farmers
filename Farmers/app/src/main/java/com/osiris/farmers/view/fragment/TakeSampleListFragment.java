package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.TakeSampleList;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.TakeSampleListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TakeSampleListFragment extends BaseFragment {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;



    private List<TakeSampleList> dataList = new ArrayList<>();
    private TakeSampleListAdapter dataAdapter = new TakeSampleListAdapter(dataList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_sample;
    }

    @Override
    protected void initView() {
        dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));
        dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));
        dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));
        dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({})
    void onClick(View v){
        switch (v.getId()){

        }
    }







}
