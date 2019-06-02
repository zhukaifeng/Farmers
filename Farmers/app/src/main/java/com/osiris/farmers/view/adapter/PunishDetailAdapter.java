package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.PunishDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PunishDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<PunishDetail> dataList = new ArrayList<>();


    public PunishDetailAdapter(List<PunishDetail> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<PunishDetail> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_punish_detaill, parent,false);//解决宽度不能铺满

        return new PunishDetailHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((PunishDetailHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class PunishDetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_serial_num)
        TextView tv_serial_num;
        @BindView(R.id.tv_regulations)
        TextView tv_regulations;
        @BindView(R.id.tv_forfeit)
        TextView tv_forfeit;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;



        private MyItemClickListener myItemClickListener;

        public PunishDetailHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(PunishDetail data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_forfeit.setText(data.getForfeit());
            tv_regulations.setText(data.getRegulations());
            tv_serial_num.setText(data.getSerialNum());

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


