package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.DateBackto;
import com.osiris.farmers.model.StockListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<StockListData> dataList = new ArrayList<>();


    public StockListAdapter(List<StockListData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill_of_sales, parent,false);

        return new StockListHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((StockListHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class StockListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_count)
        TextView tv_count;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_type)
        TextView tv_type;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_total)
        TextView tv_total;
        @BindView(R.id.iv_voucher)
        ImageView iv_voucher;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;


        private MyItemClickListener myItemClickListener;

        public StockListHolder(View itemView,MyItemClickListener myItemClickListener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.myItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != myItemClickListener){
                myItemClickListener.onItemClick(itemView,getLayoutPosition());
            }
        }

        public void bindData(StockListData data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_count.setText(String.valueOf(data.getCount()));
            tv_name.setText(data.getName());
            tv_type.setText(data.getType());
            tv_price.setText(data.getPrice());
            tv_total.setText(data.getTotal());
            if (data.isVoucher()){
                iv_voucher.setBackgroundResource(R.drawable.bg_has_voucher);
            }else {
                iv_voucher.setBackgroundResource(R.drawable.bg_not_voucher);
            }

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


