package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.DateBackto;
import com.osiris.farmers.model.PayDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<PayDetail> dataList = new ArrayList<>();


    public PayDetailAdapter(List<PayDetail> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_detail, parent, false);//解决宽度不能铺满

        return new PayDetailHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((PayDetailHolder) holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class PayDetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_symbol)
        TextView tv_symbol;
        @BindView(R.id.tv_count)
        TextView tv_count;
        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_pay_type)
        TextView tv_pay_type;


        private MyItemClickListener myItemClickListener;

        public PayDetailHolder(View itemView, MyItemClickListener myItemClickListener) {
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

        public void bindData(PayDetail data) {
            tv_count.setText(data.getPayCount());
            tv_date.setText(data.getPayDate());
            tv_pay_type.setText(data.getPayType());
        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}


