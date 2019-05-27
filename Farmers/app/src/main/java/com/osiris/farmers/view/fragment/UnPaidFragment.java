package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.PayDetail;
import com.osiris.farmers.view.adapter.PayDetailAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UnPaidFragment extends BaseFragment {
    @BindView(R.id.rv_pay)
    RecyclerView rv_pay;

    private List<PayDetail> dataList = new ArrayList<>();
    private PayDetailAdapter payAdapter = new PayDetailAdapter(dataList);


    @Override
    protected int setLayout() {
        return R.layout.fragment_paydetail;
    }

    @Override
    protected void initView() {
        dataList.add(new PayDetail("300","2019-05-11   18:00","物业费"));
        dataList.add(new PayDetail("300","2019-05-11   18:00","物业费"));
        dataList.add(new PayDetail("300","2019-05-11   18:00","物业费"));


        rv_pay.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_pay.setAdapter(payAdapter);
        payAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }
}
