package com.osiris.farmers.view.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.osiris.farmers.R;
import com.osiris.farmers.model.StockListData;
import com.osiris.farmers.view.BigImageActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<StockListData> dataList = new ArrayList<>();
    private OnDeleteClickListener onDeleteClickListener;
    private Activity activity;

    public void setOnDeleteClickListener(OnDeleteClickListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public StockListAdapter(Activity activity, List<StockListData> dataList) {
        this.activity = activity;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill_of_sales, parent, false);

        return new StockListHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((StockListHolder) holder).bindData(dataList.get(position));
        ((StockListHolder) holder).iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onDeleteClickListener != null) {
                    onDeleteClickListener.onDeleteClick(position);
                }
            }
        });
        Context context = holder.itemView.getContext();
        ((StockListHolder) holder).pic_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imgPath = dataList.get(position).getLocalUrl();
                if (TextUtils.isEmpty(imgPath)) {
                    return;
                }
                BigImageActivity.showImage(activity, imgPath);
            }
        });

    }

    public interface OnDeleteClickListener {
        void onDeleteClick(int position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class StockListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
        @BindView(R.id.iv_delete)
        ImageView iv_delete;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;
        @BindView(R.id.pic_detail)
        View pic_detail;

        private MyItemClickListener myItemClickListener;

        public StockListHolder(View itemView, MyItemClickListener myItemClickListener) {
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

        public void bindData(StockListData data) {
            if (getLayoutPosition() % 2 == 1) {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            } else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_count.setText(String.valueOf(data.getCount()));
            tv_name.setText(data.getName());
            tv_type.setText(data.getType());
            tv_price.setText(String.valueOf(data.getPrice()));
            tv_total.setText(String.valueOf(data.getTotal()));
//            if (data.isVoucher()){
//                iv_voucher.setBackgroundResource(R.drawable.bg_has_voucher);
//            }else {
//                iv_voucher.setBackgroundResource(R.drawable.bg_not_voucher);
//            }

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}


