package com.osiris.farmers.view.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.CheckProject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BillOflandProjectSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


	private MyItemClickListener myItemClickListener;

	private List<CheckProject.JcxmBean> dataList = new ArrayList<>();


	public BillOflandProjectSelectAdapter(List<CheckProject.JcxmBean> dataList) {
		this.dataList = dataList;
	}

	public void setDataList(List<CheckProject.JcxmBean> dataList) {
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
		TextView rb_check;




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

		@SuppressLint("ResourceAsColor")
		public void bindData(CheckProject.JcxmBean data){
			if (data.isSelect()){
				rb_check.setBackgroundResource(R.drawable.bg_tv_select);
				GradientDrawable gd = (GradientDrawable) rb_check.getBackground();
				gd.setColor(itemView.getResources().getColor(R.color.color_00d39d));
				rb_check.setTextColor(itemView.getResources().getColor(R.color.write));
			}else {
				rb_check.setBackgroundResource(R.drawable.bg_tv_unselect);
				rb_check.setTextColor(itemView.getResources().getColor(R.color.black));
				GradientDrawable gd = (GradientDrawable) rb_check.getBackground();
				gd.setColor(Color.parseColor("#ECECEC"));
			}
			rb_check.setText(data.getJcmc());

		}
	}


	public void setOnItemClick(MyItemClickListener myItemClickListener){
		this.myItemClickListener = myItemClickListener;
	}
}
