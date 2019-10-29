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
import com.osiris.farmers.model.SampleListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TakeSampleListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private MyItemClickListener myItemClickListener;

    private List<SampleListData.CangysjglsBean> dataList = new ArrayList<>();


    public TakeSampleListAdapter(List<SampleListData.CangysjglsBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_takesample_list, parent,false);//解决宽度不能铺满

        return new TakeSampleListHolder(view,myItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((TakeSampleListHolder)holder).bindData(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    class TakeSampleListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_num)
        TextView tv_num;
        @BindView(R.id.tv_count)
        TextView tv_count;
        @BindView(R.id.tv_type)
        TextView tv_type;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.linear_item)
        LinearLayout linear_item;
        @BindView(R.id.tv_print)
        TextView tv_print;


        private MyItemClickListener myItemClickListener;

        public TakeSampleListHolder(View itemView,MyItemClickListener myItemClickListener) {
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

        public void bindData(SampleListData.CangysjglsBean data){
            if (getLayoutPosition()%2 == 1){
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
            }else {
                linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
            }
            tv_num.setText(String.valueOf(data.getId()));
            //市场名称
            if (!TextUtils.isEmpty(data.getComname())){
	            tv_count.setText(data.getComname());
            }else {
	            tv_count.setText("");
            }

	        if (!TextUtils.isEmpty(data.getYpbh())){
		        tv_type.setText(data.getYpbh());
	        }else {
		        tv_type.setText("");
	        }

	        //摊位号
            if (!TextUtils.isEmpty(data.getSczhutfl())){
                tv_print.setText(data.getSczhutfl());
            }else {
                tv_print.setText("");
            }

	        //时间
	        if (!TextUtils.isEmpty(data.getLlrq())){
                tv_print.setText(data.getLlrq().substring(0,10));
	        }else {
                tv_print.setText("");
	        }


//            if (data.isDelete()){
//                tv_print.setVisibility(View.GONE);
//                iv_print.setBackgroundResource(R.drawable.bg_delete);
//            }else {
//                tv_print.setVisibility(View.VISIBLE);
//                iv_print.setBackgroundResource(R.drawable.bg_print_gray);
//            }
        }
    }


    public void setOnItemClick(MyItemClickListener myItemClickListener){
        this.myItemClickListener = myItemClickListener;
    }
}


