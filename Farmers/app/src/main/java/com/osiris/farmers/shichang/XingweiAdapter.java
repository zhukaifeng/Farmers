package com.osiris.farmers.shichang;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.RichangXc;
import com.osiris.farmers.model.XiaofangXc;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XingweiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<RichangXc.DataBean> dataList = new ArrayList<>();
    private View.OnClickListener onButtonClickListener;
    private View.OnClickListener onNameClickListener;


    public XingweiAdapter(List<RichangXc.DataBean> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<RichangXc.DataBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xiaofang, parent,false);//解决宽度不能铺满

        return new PunishListHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((PunishListHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnNameClickListener(View.OnClickListener onNameClickListener) {
        this.onNameClickListener = onNameClickListener;
    }

    public void setOnButtonClickListener(View.OnClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    class PunishListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_market)
        TextView tv_market;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;
        @BindView(R.id.tv_msg)
        TextView tv_msg;


        private MyItemClickListener myItemClickListener;

        public PunishListHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(RichangXc.DataBean data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.white));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }
            tv_market.setText(data.getMarketName());
            tv_name.setText(data.getZlkMc());
            if (!TextUtils.isEmpty(data.getResultMsg())){
                tv_msg.setText(data.getResultMsg());
            }else {
                tv_msg.setText("");
            }

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


