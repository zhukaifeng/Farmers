package com.osiris.farmers.shichang;

import android.annotation.SuppressLint;
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
import com.osiris.farmers.model.AddScore;
import com.osiris.farmers.model.JinghuPingjia;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.jessyan.autosize.utils.LogUtils;

public class AddScoreShichangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


	private MyItemClickListener myItemClickListener;

	private List<JinghuPingjia.PingjiaxxsBean>  dataList = new ArrayList<>();
	private View.OnClickListener fiveClickListener;
	private View.OnClickListener fourClickListener;
	private View.OnClickListener threeClickListener;
	private View.OnClickListener twoClickListener;
	private View.OnClickListener oneClickListener;

	public void setFiveClickListener(View.OnClickListener fiveClickListener) {
		this.fiveClickListener = fiveClickListener;
	}

	public void setFourClickListener(View.OnClickListener fourClickListener) {
		this.fourClickListener = fourClickListener;
	}

	public void setThreeClickListener(View.OnClickListener threeClickListener) {
		this.threeClickListener = threeClickListener;
	}

	public void setTwoClickListener(View.OnClickListener twoClickListener) {
		this.twoClickListener = twoClickListener;
	}

	public void setOneClickListener(View.OnClickListener oneClickListener) {
		this.oneClickListener = oneClickListener;
	}

	public AddScoreShichangAdapter(List<JinghuPingjia.PingjiaxxsBean> dataList) {
		this.dataList = dataList;
	}

	public void setDataList(List<JinghuPingjia.PingjiaxxsBean> dataList) {
		this.dataList = dataList;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_make_score_detail, parent,false);//解决宽度不能铺满

		return new BillOflandSelectHolder(view,myItemClickListener);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
		@BindView(R.id.linear_item)
		LinearLayout linear_item;
		@BindView(R.id.tv_score)
		TextView tv_score;


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
		public void bindData(JinghuPingjia.PingjiaxxsBean data){

			if (getLayoutPosition()%2 == 1){
				linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.bg_gray_e9));
			}else {
				linear_item.setBackgroundColor(itemView.getResources().getColor(R.color.write));
			}


			if (!TextUtils.isEmpty(data.getMarketnm())){
				tv_name.setText(data.getPingjianr());
			}

			setFive(iv_five,getLayoutPosition());
			setFour(iv_four,getLayoutPosition());
			setThree(iv_three,getLayoutPosition());
			setTwo(iv_two,getLayoutPosition());
			setOne(iv_one,getLayoutPosition());

            if (String.valueOf(data.getScore()).equals("5")){
                iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				tv_score.setText("非常满意");

			}else if (String.valueOf(data.getScore()).equals("4")){
                iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				tv_score.setText("满意");

			}else if (String.valueOf(data.getScore()).equals("3")){
                iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				tv_score.setText("一般");

			}else if (String.valueOf(data.getScore()).equals("2")){
                iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
                iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				tv_score.setText("差");

			}else if (String.valueOf(data.getScore()).equals("1")){
                iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star));
				tv_score.setText("极差");

			}else {
                iv_five.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_four.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_three.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_two.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
                iv_one.setBackground(itemView.getContext().getDrawable(R.drawable.ic_star_un));
				tv_score.setText("");

			}




        }


		private void setOne(ImageView iv, int position) {
			if (oneClickListener != null) {
				iv.setTag(R.id.tag_position_one, position);
				iv.setOnClickListener(oneClickListener);
			}
		}
		private void setTwo(ImageView iv, int position) {
			if (oneClickListener != null) {
				iv.setTag(R.id.tag_position_two, position);
				iv.setOnClickListener(twoClickListener);
			}
		}
		private void setThree(ImageView iv, int position) {
			if (oneClickListener != null) {
				iv.setTag(R.id.tag_position_three, position);
				iv.setOnClickListener(threeClickListener);
			}
		}
		private void setFour(ImageView iv, int position) {
			if (oneClickListener != null) {
				iv.setTag(R.id.tag_position_four, position);
				iv.setOnClickListener(fourClickListener);
			}
		}
		private void setFive(ImageView iv, int position) {
			if (oneClickListener != null) {
				iv.setTag(R.id.tag_position_five, position);
				iv.setOnClickListener(fiveClickListener);
			}
		}

	}


	public void setOnItemClick(MyItemClickListener myItemClickListener){
		this.myItemClickListener = myItemClickListener;
	}
}
