package com.osiris.farmers.view.fragment;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.Electric;
import com.osiris.farmers.model.PayNow;
import com.osiris.farmers.model.PayRecord;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.PayElectricAdapter;
import com.osiris.farmers.view.adapter.PayNowAdapter;
import com.osiris.farmers.view.adapter.PayRecordAdapter;
import com.osiris.farmers.view.adapter.TypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalLifePayFragment extends BaseFragment {

    @BindView(R.id.rv_data_electric)
    RecyclerView rv_data_electric;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;

    @BindView(R.id.linear_details)
    LinearLayout linear_details;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.tv_pay_record)
    TextView tv_pay_record;

    @BindView(R.id.scroll_context)
    NestedScrollView scroll_context;
    @BindView(R.id.rv_pay_detail)
    RecyclerView rv_pay_detail;
    @BindView(R.id.rl_record_select)
    RelativeLayout rl_record_select;
    @BindView(R.id.rl_location)
    RelativeLayout rl_location;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rl_context)
    RelativeLayout rl_context;
    @BindView(R.id.linear_pay)
    LinearLayout linear_pay;

    private List<PayNow> dataList = new ArrayList<>();
    private PayNowAdapter dataAdapter = new PayNowAdapter(dataList);

    private List<DateModel> typeList = new ArrayList<>();
    private TypeAdapter typeAdapter = new TypeAdapter(typeList);
    private List<PayRecord> dataRecordList = new ArrayList<>();
    private PayRecordAdapter payRecordAdapter = new PayRecordAdapter(dataRecordList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_life_payment_personal;
    }

    @Override
    protected void initView() {

        typeList.add(new DateModel("农贸市场", true));
        typeList.add(new DateModel("农贸市场", false));
        typeList.add(new DateModel("农贸市场", false));
        typeList.add(new DateModel("农贸市场", false));
        typeList.add(new DateModel("农贸市场", false));
        typeList.add(new DateModel("农贸市场", false));


        dataList.add(new PayNow("电费", "-65.32"));
        dataList.add(new PayNow("物业费", "-65.32"));

        dataRecordList.add(new PayRecord("- 65.32", "2019-03-15 09:34", "电费-张浩"));
        dataRecordList.add(new PayRecord("- 15.32", "2019-03-15 09:34", "水费-张浩"));

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
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                linear_pay.setVisibility(View.VISIBLE);
                rl_context.setVisibility(View.GONE);
            }
        });

        rv_pay_detail.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_pay_detail.setAdapter(payRecordAdapter);
        payRecordAdapter.notifyDataSetChanged();


    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_pay_record, R.id.rl_back, R.id.rl_pay_back,R.id.iv_pay})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                scroll_context.setVisibility(View.VISIBLE);
                linear_details.setVisibility(View.GONE);
                rl_back.setVisibility(View.GONE);
                rl_location.setVisibility(View.VISIBLE);
                rl_record_select.setVisibility(View.GONE);
                typeList.clear();
                typeList.add(new DateModel("农贸市场", true));
                typeList.add(new DateModel("农贸市场", false));
                typeList.add(new DateModel("农贸市场", false));
                typeList.add(new DateModel("农贸市场", false));
                typeList.add(new DateModel("农贸市场", false));
                typeList.add(new DateModel("农贸市场", false));
                typeAdapter.notifyDataSetChanged();
                tv_title.setText(getString(R.string.life_payment));
                break;
            case R.id.tv_pay_record:
                scroll_context.setVisibility(View.GONE);
                linear_details.setVisibility(View.VISIBLE);
                rl_back.setVisibility(View.VISIBLE);
                rl_location.setVisibility(View.GONE);
                rl_record_select.setVisibility(View.VISIBLE);
                typeList.clear();
                typeList.add(new DateModel("去年", false));
                typeList.add(new DateModel("本年", true));
                typeList.add(new DateModel("本月", false));
                typeAdapter.notifyDataSetChanged();
                tv_title.setText(getString(R.string.life_payment_record));

                break;
            case R.id.rl_pay_back:
                linear_pay.setVisibility(View.GONE);
                rl_context.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_pay:
                linear_pay.setVisibility(View.VISIBLE);
                rl_context.setVisibility(View.GONE);
                break;
        }
    }

}
