package com.osiris.farmers.view.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.osiris.farmers.R;
import com.osiris.farmers.model.StockPurchase;
import com.osiris.farmers.network.ApiParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockPurchaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<StockPurchase.DataBean> dataList = new ArrayList<>();


    public StockPurchaseAdapter(List<StockPurchase.DataBean> dataList) {
        this.dataList = dataList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stock_purchase, parent, false);

        return new StockPurchaseHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((StockPurchaseHolder) holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class StockPurchaseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.tv_product_name)
        TextView tv_product_name;
        @BindView(R.id.tv_product_type)
        TextView tv_product_type;
        @BindView(R.id.tv_product_count)
        TextView tv_product_count;
        @BindView(R.id.tv_product_price)
        TextView tv_product_price;
        @BindView(R.id.tv_product_suppliert)
        TextView tv_product_suppliert;
        @BindView(R.id.tv_product_date)
        TextView tv_product_date;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;

        private MyItemClickListener myItemClickListener;

        public StockPurchaseHolder(View itemView, MyItemClickListener myItemClickListener) {
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

        public void bindData(StockPurchase.DataBean data) {
            if (getLayoutPosition() % 2 == 1) {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            } else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_product_name.setText(data.getSpmc());
            tv_product_count.setText(data.getSum());
            tv_product_price.setText(data.getSpdj());
            tv_product_suppliert.setText(data.getGongys());
            tv_product_type.setText(data.getSplb());
            tv_product_date.setText(data.getHycompany());

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}


