package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.EvaluateList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketEvaluateJyhAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<EvaluateList.ZhugjyhpingjiasBean> dataList = new ArrayList<>();


    public MarketEvaluateJyhAdapter(List<EvaluateList.ZhugjyhpingjiasBean> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<EvaluateList.ZhugjyhpingjiasBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evaulatel, parent, false);//解决宽度不能铺满

        return new MarketEvaluateHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((MarketEvaluateHolder) holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class MarketEvaluateHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_appraise)
        TextView tv_appraise;

        @BindView(R.id.rl_bg)
        RelativeLayout rl_bg;
        @BindView(R.id.tv_num)
        TextView tv_num;


        private MyItemClickListener myItemClickListener;

        public MarketEvaluateHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.myItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != myItemClickListener) {
                myItemClickListener.onItemClick(itemView, getLayoutPosition());
            }
        }

        public void bindData(EvaluateList.ZhugjyhpingjiasBean data) {
            if (getLayoutPosition() % 2 == 1) {
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            } else {
                rl_bg.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_date.setText(data.getLlrq().substring(0, 10));
            tv_name.setText(data.getMarketnm());
            if (!TextUtils.isEmpty(data.getPingjianr())) {
                String[] arr1 = data.getPingjianr().split("|");

            }


            tv_appraise.setText(data.getUserid());
            tv_num.setText(String.valueOf(getLayoutPosition()+1));
        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}


