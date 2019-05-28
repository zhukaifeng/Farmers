package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.AccountDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<AccountDetail> dataList = new ArrayList<>();


    public AccountDetailAdapter(List<AccountDetail> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<AccountDetail> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_detail, parent,false);//解决宽度不能铺满

        return new AccountDetailHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((AccountDetailHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class AccountDetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_date_range)
        TextView tv_date_range;
        @BindView(R.id.tv_sale_count)
        TextView tv_sale_count;
        @BindView(R.id.tv_buy_count)
        TextView tv_buy_count;
        @BindView(R.id.rl_bg)
        RelativeLayout rl_bg;



        private MyItemClickListener myItemClickListener;

        public AccountDetailHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(AccountDetail data){
            if (getLayoutPosition()%2 == 1){
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }

            tv_date.setText(data.getDate());
            tv_date_range.setText(data.getDateRange());
            tv_buy_count.setText(String.valueOf(data.getBuyCount()));
            tv_sale_count.setText(String.valueOf(data.getSaleCount()));

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


