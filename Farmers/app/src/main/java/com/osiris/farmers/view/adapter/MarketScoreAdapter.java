package com.osiris.farmers.view.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.MakeScoreData;
import com.osiris.farmers.model.SerachGoodData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketScoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


	private MyItemClickListener myItemClickListener;

	private List<MakeScoreData.PingjiaxxsBean> dataList = new ArrayList<>();


	public MarketScoreAdapter(List<MakeScoreData.PingjiaxxsBean> dataList) {
		this.dataList = dataList;
	}

	public void setDataList(List<MakeScoreData.PingjiaxxsBean> dataList) {
		this.dataList = dataList;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_make_score_detail, parent,false);//解决宽度不能铺满

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


		@BindView(R.id.iv_one)
		ImageView iv_one;
		@BindView(R.id.iv_two)
		ImageView iv_two;
		@BindView(R.id.iv_three)
		ImageView iv_three;
		@BindView(R.id.iv_four)
		ImageView iv_four;
		@BindView(R.id.iv_five)
		ImageView iv_five;
		@BindView(R.id.tv_name)
		TextView tv_name;
		@BindView(R.id.tv_score)
		TextView tv_score;
		@BindView(R.id.linear_item)
		LinearLayout linear_item;


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

		@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
		@SuppressLint("ResourceAsColor")
		public void bindData(MakeScoreData.PingjiaxxsBean data){

			if (getLayoutPosition()%2 == 1){
				linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
			}else {
				linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
			}

			if (!TextUtils.isEmpty(data.getPingjianr())){
				tv_name.setText(data.getPingjianr());
			}

			if (!TextUtils.isEmpty(data.getMcrk())){
				tv_score.setText(data.getMcrk());
			}

			if (data.getMbrk().equals("5")){
				iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));

			}else if (data.getMbrk().equals("4")){
				iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
			}else if (data.getMbrk().equals("3")){
				iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
			}else if (data.getMbrk().equals("2")){
				iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
			}else if (data.getMbrk().equals("1")){
				iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
			}else {
				iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
			}


		}
	}


	public void setOnItemClick(MyItemClickListener myItemClickListener){
		this.myItemClickListener = myItemClickListener;
	}
}
