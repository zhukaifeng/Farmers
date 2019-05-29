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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayElectricAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<Electric> dataList = new ArrayList<>();


    public PayElectricAdapter(List<Electric> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<Electric> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment_electric, parent,false);//解决宽度不能铺满

        return new PayElectricHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((PayElectricHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class PayElectricHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_num)
        TextView tv_num;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_pay)
        TextView tv_pay;
        @BindView(R.id.iv_remind)
        ImageView iv_remind;
        @BindView(R.id.rl_bg)
        RelativeLayout rl_bg;



        private MyItemClickListener myItemClickListener;

        public PayElectricHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(Electric data){
            if (getLayoutPosition()%2 == 1){
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }else {
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }
            tv_num.setText(data.getNum());
            tv_name.setText(data.getName());
            tv_pay.setText(data.getPayCount());
        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


