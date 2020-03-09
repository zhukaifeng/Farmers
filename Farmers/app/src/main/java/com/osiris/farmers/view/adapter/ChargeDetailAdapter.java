package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.ChargeDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChargeDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<ChargeDetail> dataList = new ArrayList<>();


    public ChargeDetailAdapter(List<ChargeDetail> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<ChargeDetail> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_charge_detail, parent,false);//解决宽度不能铺满

        return new ChargeDetailHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((ChargeDetailHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class ChargeDetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_pay_type)
        TextView tv_pay_type;
        @BindView(R.id.tv_padding_pay)
        TextView tv_padding_pay;
        @BindView(R.id.tv_has_pay)
        TextView tv_has_pay;
        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;




        private MyItemClickListener myItemClickListener;

        public ChargeDetailHolder(View itemView,MyItemClickListener myItemClickListener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.myItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);
//            tv_person_charge.setOnClickListener(this);
//            tv_check_detail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != myItemClickListener){
                myItemClickListener.onItemClick(itemView,getLayoutPosition());
            }
        }

        public void bindData(ChargeDetail data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }
//            tv_pay_type.setText(data.getChargeType());
//            tv_padding_pay.setText(data.getPaddingPay());
//            tv_has_pay.setText(data.getHasPay());
//            tv_date.setText(data.getDate());

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


