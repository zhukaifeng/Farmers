package com.osiris.farmers.view.adapter;

import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.SampleNameData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JinhuoAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<SampleNameData.CommodityBean> dataList = new ArrayList<>();


    public JinhuoAdapter(List<SampleNameData.CommodityBean> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<SampleNameData.CommodityBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_check_select_amount, parent,false);//解决宽度不能铺满

        return new BillOflandSelectHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((BillOflandSelectHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class BillOflandSelectHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.rb_check)
        AppCompatRadioButton rb_check;




        private MyItemClickListener myItemClickListener;

        public BillOflandSelectHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(SampleNameData.CommodityBean data){
            if (data.isSelect()){
                rb_check.setChecked(true);

            }else {
                rb_check.setChecked(false);
            }
            rb_check.setText(data.getCommoditynm());

        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}

