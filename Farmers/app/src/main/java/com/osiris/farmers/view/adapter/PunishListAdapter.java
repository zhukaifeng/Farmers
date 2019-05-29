package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.PunishList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PunishListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<PunishList> dataList = new ArrayList<>();


    public PunishListAdapter(List<PunishList> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<PunishList> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_punishl, parent,false);//解决宽度不能铺满

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



    class PunishListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_wholesale_market)
        TextView tv_wholesale_market;
        @BindView(R.id.tv_pay_stall)
        TextView tv_pay_stall;
        @BindView(R.id.tv_punish)
        TextView tv_punish;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_violation_of_regulations)
        TextView tv_violation_of_regulations;
        @BindView(R.id.rl_bg)
        RelativeLayout rl_bg;
        @BindView(R.id.iv_tri)
        ImageView iv_tri;


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

        public void bindData(PunishList data){
            tv_date.setText(data.getDate());
            tv_pay_stall.setText(data.getPayStall());
            tv_price.setText(data.getPrice());
            tv_punish.setText(data.getPunish());
            tv_wholesale_market.setText(data.getWholesaleMarket());
            if (data.isSelect()){
                tv_violation_of_regulations.setText(itemView.getResources().getString(R.string.select));
            }else {
                tv_violation_of_regulations.setText(itemView.getResources().getString(R.string.unselect));
            }

            if (data.isClicked()){
                rl_bg.setVisibility(View.VISIBLE);
                iv_tri.setBackgroundResource(R.drawable.bg_arrow_up_tri);
            }else {
                rl_bg.setVisibility(View.GONE);
                iv_tri.setBackgroundResource(R.drawable.bg_arrow_down_tri);
            }
        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


