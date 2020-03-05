package com.osiris.farmers.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.jingyinghu.BusinessActivity;
import com.osiris.farmers.model.MarketBusinessBean;
import com.osiris.farmers.model.OperatorInquery;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketBusinessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<MarketBusinessBean> dataList = new ArrayList<>();
    private View.OnClickListener onButtonClickListener;

    public void setOnButtonClickListener(View.OnClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }


    public MarketBusinessAdapter(List<MarketBusinessBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_market_business, parent, false);//解决宽度不能铺满

        return new TakeSampleListHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((TakeSampleListHolder) holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class TakeSampleListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.login_id)
        TextView login_id;
        @BindView(R.id.background_view)
        View background_view;
        @BindView(R.id.tv_market)
        TextView tv_market;
        @BindView(R.id.tv_twh)
        TextView tv_twh;


        private MyItemClickListener myItemClickListener;

        public TakeSampleListHolder(View itemView, MyItemClickListener myItemClickListener) {
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

        public void bindData(MarketBusinessBean data) {
            if (getLayoutPosition() % 2 == 1) {
                background_view.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            } else {
                background_view.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_name.setText(data.getJcyname());
            login_id.setText(data.getLoginId());
//            tv_market.setText(data.getMarket());

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}
