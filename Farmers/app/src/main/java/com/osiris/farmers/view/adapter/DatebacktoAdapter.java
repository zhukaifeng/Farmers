package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.DateBackto;
import com.osiris.farmers.model.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DatebacktoAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<Task> dataList = new ArrayList<>();


    public DatebacktoAdapter(List<Task> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_detail, parent,false);//解决宽度不能铺满

        return new DateBacktoHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((DateBacktoHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class DateBacktoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_location)
        TextView tv_location;
        @BindView(R.id.tv_market)
        TextView tv_market;
        @BindView(R.id.tv_yangpingname)
        TextView tv_yangpingname;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;
        @BindView(R.id.tv_project)
        TextView tv_project;



        private MyItemClickListener myItemClickListener;

        public DateBacktoHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(Task data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
//            tv_num.setText(String.valueOf(data.getId()));
//            tv_name.setText(data.getName());
//            tv_type.setText(data.getType());
//            tv_info.setText(data.getInfo());

            String location = "";
            if (!TextUtils.isEmpty(data.getQuid())){
                location = location+data.getQuid();
            }
            if (!TextUtils.isEmpty(data.getQuid())){
                location = location+"\n"+data.getJiedaoid();
            }
            tv_location.setText(location);

            String market = "";
            if (!TextUtils.isEmpty(data.getScid())){
                market = market + data.getScid();
            }
            tv_market.setText(market.replace(",","\n"));


            if (!TextUtils.isEmpty(data.getYpmc())){
                tv_yangpingname.setText(data.getYpmc());
            }else {
                tv_yangpingname.setText("");
            }

            if (!TextUtils.isEmpty(data.getJcymc())){
                tv_project.setText(data.getJcymc());
            }else {
                tv_project.setText("");
            }


            String shengshi = "";
            if (!TextUtils.isEmpty(data.getShengid())){
                shengshi = shengshi + data.getShengid();
            }
            if (!TextUtils.isEmpty(data.getShiid())){
                shengshi = shengshi + data.getShiid();
            }

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


