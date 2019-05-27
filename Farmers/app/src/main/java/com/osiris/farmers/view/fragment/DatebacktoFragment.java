package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateBackto;
import com.osiris.farmers.view.adapter.DatebacktoAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DatebacktoFragment extends BaseFragment {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.linear_datebackto_detail)
    LinearLayout linear_datebackto_detail;
    @BindView(R.id.linear_datebackto)
    LinearLayout linear_datebackto;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_right_arrow)
    ImageView iv_right_arrow;

    private List<DateBackto> dataList = new ArrayList<>();
    private DatebacktoAdapter dataAdapter = new DatebacktoAdapter(dataList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_datebackto;
    }

    @Override
    protected void initView() {
        dataList.add(new DateBackto(0123456, "牛肉", "销售", "农批，无"));
        dataList.add(new DateBackto(0123456, "羊肉", "采购", "农批，无"));
        dataList.add(new DateBackto(0123456, "鸡肉", "采购", "海批，有"));
        dataList.add(new DateBackto(0123456, "鱼肉", "采购", "海批，有"));

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                linear_datebackto.setVisibility(View.GONE);
                linear_datebackto_detail.setVisibility(View.VISIBLE);
                rl_back.setVisibility(View.VISIBLE);
                tv_title.setText(getActivity().getString(R.string.organization_datebackto_detail));
                iv_right_arrow.setVisibility(View.GONE);
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
                rl_back.setVisibility(View.GONE);
                tv_title.setText(getActivity().getString(R.string.organization_datebackto));
                iv_right_arrow.setVisibility(View.VISIBLE);
                linear_datebackto.setVisibility(View.VISIBLE);
                linear_datebackto_detail.setVisibility(View.GONE);
                break;
        }
    }


}
