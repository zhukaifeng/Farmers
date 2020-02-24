package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.Market;
import com.osiris.farmers.model.MarketCX;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketCXAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<MarketCX.DataBean> dataList = new ArrayList<>();


    public MarketCXAdapter(List<MarketCX.DataBean> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<MarketCX.DataBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_button, parent,false);//解决宽度不能铺满

        return new DateHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((DateHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class DateHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.rl_bg)
        RelativeLayout rl_bg;



        private MyItemClickListener myItemClickListener;

        public DateHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(MarketCX.DataBean data){
            tv_date.setText(data.getMarketnm());

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


