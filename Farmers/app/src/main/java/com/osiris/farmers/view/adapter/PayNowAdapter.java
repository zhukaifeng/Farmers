package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.Electric;
import com.osiris.farmers.model.PayNow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayNowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<PayNow> dataList = new ArrayList<>();


    public PayNowAdapter(List<PayNow> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<PayNow> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_padding_pay_detail, parent,false);

        return new PayNowHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((PayNowHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class PayNowHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_pay_type)
        TextView tv_pay_type;
        @BindView(R.id.tv_pay)
        TextView tv_pay;
        @BindView(R.id.tv_count)
        TextView tv_count;
        @BindView(R.id.rl_bg)
        RelativeLayout rl_bg;



        private MyItemClickListener myItemClickListener;

        public PayNowHolder(View itemView,MyItemClickListener myItemClickListener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.myItemClickListener = myItemClickListener;
            tv_pay.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != myItemClickListener){
                myItemClickListener.onItemClick(itemView,getLayoutPosition());
            }
        }

        public void bindData(PayNow data){
            if (getLayoutPosition()%2 == 1){
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }else {
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }
            tv_pay_type.setText(data.getPayType());
            tv_count.setText(data.getPayCount());
        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


