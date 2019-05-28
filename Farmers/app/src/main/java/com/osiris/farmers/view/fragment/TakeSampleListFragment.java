package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
    @BindView(R.id.linear_list)
    LinearLayout linear_list;
    @BindView(R.id.linear_add)
    LinearLayout linear_add;
    @BindView(R.id.iv_function)
    ImageView iv_function;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;


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

    @OnClick({R.id.iv_function,R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.iv_function:
                linear_add.setVisibility(View.VISIBLE);
                iv_function.setBackgroundResource(R.drawable.bg_qr);
                rl_back.setVisibility(View.VISIBLE);
                for (TakeSampleList takeSampleList:dataList){
                    takeSampleList.setDelete(true);
                }
                dataAdapter.notifyDataSetChanged();
                break;
            case R.id.rl_back:
                linear_add.setVisibility(View.GONE);
                iv_function.setBackgroundResource(R.drawable.bg_add);
                rl_back.setVisibility(View.GONE);
                for (TakeSampleList takeSampleList:dataList){
                    takeSampleList.setDelete(false);
                }
                dataAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }







}
