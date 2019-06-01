package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.WeekModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeekAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<WeekModel> dataList = new ArrayList<>();


    public WeekAdapter(List<WeekModel> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<WeekModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar_week, parent,false);//解决宽度不能铺满

        return new WeekHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((WeekHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class WeekHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_week)
        TextView tv_week;
        @BindView(R.id.linear_bg)
        LinearLayout linear_bg;



        private MyItemClickListener myItemClickListener;

        public WeekHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(WeekModel data){
            tv_date.setText(data.getDate());
            tv_week.setText(data.getWeek());
            if (data.isSelect()){
                linear_bg.setBackgroundResource(R.drawable.bg_small_green_radio);
                tv_date.setTextColor(itemView.getResources().getColor(R.color.write));
                tv_week.setTextColor(itemView.getResources().getColor(R.color.write));
            }else {
                linear_bg.setBackgroundResource(R.color.background_gray);
                tv_date.setTextColor(itemView.getResources().getColor(R.color.calendar_txt));
                tv_week.setTextColor(itemView.getResources().getColor(R.color.calendar_txt));
            }

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


