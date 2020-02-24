package com.osiris.farmers.marketcheck.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.MarketCheck;
import com.osiris.farmers.model.SuyuanJinData;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketCxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<MarketCheck.DataBean> dataList = new ArrayList<>();


    public MarketCxAdapter(List<MarketCheck.DataBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marketcheck, parent,false);//解决宽度不能铺满

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


        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_type)
        TextView tv_type;
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

        public void bindData(MarketCheck.DataBean data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_name.setText(data.getResultMsg());
            tv_type.setText(data.getUpTime());


        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


