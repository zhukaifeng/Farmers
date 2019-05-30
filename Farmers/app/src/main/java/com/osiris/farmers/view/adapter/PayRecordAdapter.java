package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.PayDetail;
import com.osiris.farmers.model.PayRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<PayRecord> dataList = new ArrayList<>();


    public PayRecordAdapter(List<PayRecord> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_recordl, parent, false);

        return new PayRecordHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((PayRecordHolder) holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class PayRecordHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.tv_pay_count)
        TextView tv_pay_count;
        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_pay_type)
        TextView tv_pay_type;
        @BindView(R.id.linear_bg)
        LinearLayout linear_bg;

        private MyItemClickListener myItemClickListener;

        public PayRecordHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.myItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != myItemClickListener) {
                myItemClickListener.onItemClick(itemView, getLayoutPosition());
            }
        }

        public void bindData(PayRecord data) {
            if (getLayoutPosition()%2 == 1){
                linear_bg.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                linear_bg.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }

            tv_pay_count.setText(data.getPayCount());
            tv_date.setText(data.getPayDate());
            tv_pay_type.setText(data.getPayType());
        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}


