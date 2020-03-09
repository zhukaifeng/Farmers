package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.ChargeManager;
import com.osiris.farmers.model.ChargePunish;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChargeManagerPunishAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<ChargePunish> dataList = new ArrayList<>();
    private String account;

    public void setAccount(String account) {
        this.account = account;
        notifyDataSetChanged();
    }

    public ChargeManagerPunishAdapter(List<ChargePunish> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<ChargePunish> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_charge_manager, parent, false);//解决宽度不能铺满

        return new ChargeManagerHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((ChargeManagerHolder) holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class ChargeManagerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.tv_wholesale_market)
        TextView tv_wholesale_market;
        @BindView(R.id.tv_account)
        TextView tv_account;
        @BindView(R.id.tv_pay_stall)
        TextView tv_pay_stall;
        @BindView(R.id.tv_person_charge)
        TextView tv_person_charge;
        @BindView(R.id.tv_pay_not)
        TextView tv_pay_not;
        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_pay_should)
        TextView tv_pay_should;
        @BindView(R.id.tv_check_detail)
        TextView tv_check_detail;


        private MyItemClickListener myItemClickListener;

        public ChargeManagerHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.myItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);
//            tv_person_charge.setOnClickListener(this);
//            tv_check_detail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != myItemClickListener) {
                myItemClickListener.onItemClick(itemView, getLayoutPosition());
            }
        }

        public void bindData(ChargePunish data) {

            tv_pay_should.setText(data.getMoney());
            tv_wholesale_market.setText(data.getMarketName());
            tv_pay_stall.setText(data.getTwhmc());
            tv_person_charge.setText(data.getUserName());
            tv_pay_not.setText(data.getStatus());
            tv_date.setText(data.getJiaokuanriqi());
            tv_person_charge.setText(data.getJyhName());
            tv_account.setText(data.getJyhName() + "  " + account);


        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}


