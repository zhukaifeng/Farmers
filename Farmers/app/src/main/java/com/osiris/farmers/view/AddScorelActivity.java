package com.osiris.farmers.view;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.AddScore;
import com.osiris.farmers.model.EvaluateList;
import com.osiris.farmers.model.MakeScoreData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MarketScoreAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class AddScorelActivity extends BaseActivity {
	@Override
	public int getLayoutResId() {
		return 0;
	}

	@Override
	public void init() {

	}


	/*//private EvaluateList.ZhugpingjiasBean data;

	@BindView(R.id.tv_market)
	TextView tv_market;
	@BindView(R.id.rv_data)
	RecyclerView rv_data;
	@BindView(R.id.rl_commit)
	RelativeLayout rl_commit;

	private List<AddScore.MarketsBean>  dataList = new ArrayList<>();
	private List<AddScore.ZhanghglsBean>  data2List = new ArrayList<>();

	private AddScoreAdapter marketScoreAdapter = new AddScoreAdapter(dataList);
	private AddScore2Adapter marketScore2Adapter = new AddScore2Adapter(data2List);

	private int totalCommitCount = 0;
    private int currentCommitCount = 0;

	private int xxz = 0;
	@Override
	public int getLayoutResId() {
		return R.layout.activity_scoring_detail;
	}

	@Override
	public void init() {
		//data = getIntent().getParcelableExtra("data");
		xxz = getIntent().getIntExtra("xxz",0);
		rl_commit.setVisibility(View.VISIBLE);

//		if (null != data){
//			tv_market.setText(data.getMarketnm());
//		}
		if (xxz == 1){
			rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
			rv_data.setAdapter(marketScoreAdapter);


			marketScoreAdapter.setFiveClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 5");
					Object positionTag = v.getTag(R.id.tag_position_five);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;

					dataList.get(position).setScore(5);
					marketScoreAdapter.notifyDataSetChanged();

				}
			});
			marketScoreAdapter.setFourClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 4");
					Object positionTag = v.getTag(R.id.tag_position_four);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;

					dataList.get(position).setScore(4);
					marketScoreAdapter.notifyDataSetChanged();


				}
			});
			marketScoreAdapter.setThreeClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 3");

					Object positionTag = v.getTag(R.id.tag_position_three);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;
					dataList.get(position).setScore(3);
					marketScoreAdapter.notifyDataSetChanged();
				}
			});
			marketScoreAdapter.setTwoClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 2");

					Object positionTag = v.getTag(R.id.tag_position_two);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;
					dataList.get(position).setScore(2);
					marketScoreAdapter.notifyDataSetChanged();
				}
			});
			marketScoreAdapter.setOneClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 1");
					Object positionTag = v.getTag(R.id.tag_position_one);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;
					dataList.get(position).setScore(1);
					marketScoreAdapter.notifyDataSetChanged();
				}
			});
		}else {
			rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
			rv_data.setAdapter(marketScore2Adapter);


			marketScore2Adapter.setFiveClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 5");
					Object positionTag = v.getTag(R.id.tag_position_five);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;

					data2List.get(position).setScore(5);
					marketScore2Adapter.notifyDataSetChanged();

				}
			});
			marketScore2Adapter.setFourClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 4");
					Object positionTag = v.getTag(R.id.tag_position_four);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;

					data2List.get(position).setScore(4);
					marketScore2Adapter.notifyDataSetChanged();


				}
			});
			marketScore2Adapter.setThreeClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 3");

					Object positionTag = v.getTag(R.id.tag_position_three);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;
					data2List.get(position).setScore(3);
					marketScore2Adapter.notifyDataSetChanged();
				}
			});
			marketScore2Adapter.setTwoClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 2");

					Object positionTag = v.getTag(R.id.tag_position_two);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;
					data2List.get(position).setScore(2);
					marketScoreAdapter.notifyDataSetChanged();
				}
			});
			marketScore2Adapter.setOneClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					LogUtils.d("zkf 1");
					Object positionTag = v.getTag(R.id.tag_position_one);
					if (positionTag == null) {
						return;
					}
					if (!(positionTag instanceof Integer)) {
						return;
					}
					int position = (int) positionTag;
					data2List.get(position).setScore(1);
					marketScore2Adapter.notifyDataSetChanged();
				}
			});
		}




		if (xxz == 1){
			getData();

		}else {
			getData2();
		}
	}


	@OnClick({R.id.rl_back,R.id.rl_commit})
	void onClick(View v){
		switch (v.getId()){
			case R.id.rl_back:
				finish();
				break;
			case R.id.rl_commit:
				if (xxz ==1 ){
					for (AddScore.MarketsBean data:dataList){
						if (data.getScore()>0){
							totalCommitCount++;
						}
					}

					for (AddScore.MarketsBean data:dataList){
						if (data.getScore()>0){
							commitData(data);
						}
					}

				}else {
					for (AddScore.ZhanghglsBean data:data2List){
						if (data.getScore()>0){
							totalCommitCount++;
						}
					}

					for (AddScore.ZhanghglsBean data:data2List){
						if (data.getScore()>0){
							commitData(data);
						}
					}

				}

				break;
		}
	}




	private void commitData(AddScore.MarketsBean marketsBean){
		String url = ApiParams.API_HOST + "/app/xzZgpingjiaAdd.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id",String.valueOf(GlobalParams.id));
		paramMap.put("type","1");
		paramMap.put("marketid",String.valueOf(marketsBean.getId()));

		if (marketsBean.getScore() ==5){
			paramMap.put("data","5|非常满意|"+marketsBean.getId());

		}else if (marketsBean.getScore() ==4){
			paramMap.put("data","4|满意|"+marketsBean.getId());

		}else if (marketsBean.getScore() ==3){
			paramMap.put("data","3|一般|"+marketsBean.getId());

		}else if (marketsBean.getScore() ==2){
			paramMap.put("data","2|差|"+marketsBean.getId());

		}else {
			paramMap.put("data","1|差|"+marketsBean.getId());

		}

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf successResult   make score:" + successResult);
				currentCommitCount++;
				if (currentCommitCount == totalCommitCount){
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AddScorelActivity.this,"全部提交成功",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                }
//				JsonParser parser = new JsonParser();
//				JsonObject json = parser.parse(successResult).getAsJsonObject();
//				if (json.has("markets")){
//					AddScore.MarketsBean[] datas = JsonUtils.fromJson(json.get("markets").getAsJsonArray(),
//							AddScore.MarketsBean[].class);
//					dataList.addAll(Arrays.asList(datas));
//					marketScoreAdapter.notifyDataSetChanged();
//
//				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}


	private void commitData(AddScore.ZhanghglsBean marketsBean){
		String url = ApiParams.API_HOST + "/app/xzZgpingjiaAdd.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id",String.valueOf(GlobalParams.id));
		paramMap.put("type","1");
		paramMap.put("marketid",String.valueOf(marketsBean.getId()));

		if (marketsBean.getScore() ==5){
			paramMap.put("data","5|非常满意|"+marketsBean.getId());

		}else if (marketsBean.getScore() ==4){
			paramMap.put("data","4|满意|"+marketsBean.getId());

		}else if (marketsBean.getScore() ==3){
			paramMap.put("data","3|一般|"+marketsBean.getId());

		}else if (marketsBean.getScore() ==2){
			paramMap.put("data","2|差|"+marketsBean.getId());

		}else {
			paramMap.put("data","1|差|"+marketsBean.getId());

		}

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf successResult   make score:" + successResult);
				currentCommitCount++;
				if (currentCommitCount == totalCommitCount){
					new Handler().post(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(AddScorelActivity.this,"全部提交成功",Toast.LENGTH_SHORT).show();
							finish();
						}
					});
				}
//				JsonParser parser = new JsonParser();
//				JsonObject json = parser.parse(successResult).getAsJsonObject();
//				if (json.has("markets")){
//					AddScore.MarketsBean[] datas = JsonUtils.fromJson(json.get("markets").getAsJsonArray(),
//							AddScore.MarketsBean[].class);
//					dataList.addAll(Arrays.asList(datas));
//					marketScoreAdapter.notifyDataSetChanged();
//
//				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}


	private void getData(){
		String url = ApiParams.API_HOST + "/app/showgetZgpingjiaAdd.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id",String.valueOf(GlobalParams.id));
		paramMap.put("type","1");

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf successResult:" + successResult);
				JsonParser parser = new JsonParser();
				JsonObject json = parser.parse(successResult).getAsJsonObject();
				if (json.has("markets")){
					AddScore.MarketsBean[] datas = JsonUtils.fromJson(json.get("markets").getAsJsonArray(),
							AddScore.MarketsBean[].class);
					dataList.addAll(Arrays.asList(datas));
					marketScoreAdapter.notifyDataSetChanged();

				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});

	}


	private void getData2(){
		String url = ApiParams.API_HOST + "/app/showgetZgpingjiaAdd.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id",String.valueOf(GlobalParams.id));
		paramMap.put("type","2");

		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf successResult:" + successResult);
				JsonParser parser = new JsonParser();
				JsonObject json = parser.parse(successResult).getAsJsonObject();
				if (json.has("zhanghgls")){
					AddScore.ZhanghglsBean[] datas = JsonUtils.fromJson(json.get("zhanghgls").getAsJsonArray(),
							AddScore.ZhanghglsBean[].class);
					data2List.addAll(Arrays.asList(datas));
					marketScore2Adapter.notifyDataSetChanged();
					LogUtils.d("zkf data2List size:" + data2List.size());

				}

			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});

	}
*/




}
