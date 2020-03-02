package com.osiris.farmers.shichang;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.Rules;
import com.osiris.farmers.model.XiaofangXc;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RulesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MyItemClickListener myItemClickListener;

    private List<Rules.DataBean> dataList = new ArrayList<>();



    public RulesAdapter(List<Rules.DataBean> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<Rules.DataBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rules, parent, false);//解决宽度不能铺满

        return new PunishListHolder(view, myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((PunishListHolder) holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class PunishListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.tv_name)
        TextView tv_name;


        private MyItemClickListener myItemClickListener;

        public PunishListHolder(View itemView, MyItemClickListener myItemClickListener) {
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

        public void bindData(Rules.DataBean data) {
            if (!TextUtils.isEmpty(data.getZlkmc()))
                tv_name.setText(data.getZlkmc());


        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }
}


