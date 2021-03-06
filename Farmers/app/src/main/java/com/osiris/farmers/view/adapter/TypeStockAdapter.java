package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.DateModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypeStockAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<DateModel> dataList = new ArrayList<>();


    public TypeStockAdapter(List<DateModel> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<DateModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_text, parent,false);

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

        public void bindData(DateModel data){
            tv_date.setText(data.getDate());
            if (data.isClicked()){
                tv_date.setTextColor(itemView.getResources().getColor(R.color.color_00d39d));
            }else {
                tv_date.setTextColor(itemView.getResources().getColor(R.color.write));
            }

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


