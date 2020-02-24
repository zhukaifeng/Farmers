package com.osiris.farmers.view.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.OperatorInquery;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OperatorInquiryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<OperatorInquery.DataBean> dataList = new ArrayList<>();
    private View.OnClickListener onButtonClickListener;

    public void setOnButtonClickListener(View.OnClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }


    public OperatorInquiryAdapter(List<OperatorInquery.DataBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_operator_inquery, parent,false);//解决宽度不能铺满

        return new TakeSampleListHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((TakeSampleListHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class TakeSampleListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_company_name)
        TextView tv_company_name;
        @BindView(R.id.tv_stall_num)
        TextView tv_stall_num;
        @BindView(R.id.tv_business_lincense)
        TextView tv_business_lincense;
        @BindView(R.id.tv_connect)
        TextView tv_connect;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;
        @BindView(R.id.linear_info)
        LinearLayout linear_info;
        @BindView(R.id.iv_location)
        ImageView iv_location;



        private MyItemClickListener myItemClickListener;

        public TakeSampleListHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(OperatorInquery.DataBean data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_business_lincense.setText(data.getRemark());
            tv_company_name.setText(data.getMarketnm());
            tv_connect.setText(data.getJyhmc());
            tv_stall_num.setText(data.getTwhmc());


            if (onButtonClickListener != null) {
                tv_connect.setOnClickListener(onButtonClickListener);
                tv_connect.setTag(R.id.tag_operator_inquiry, getLayoutPosition());
            }

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


