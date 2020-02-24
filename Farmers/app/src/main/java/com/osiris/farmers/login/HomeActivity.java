package com.osiris.farmers.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.MarketEvent;
import com.osiris.farmers.jingyinghu.MenuHomeJYhActivity;
import com.osiris.farmers.jingyinghu.MenuHomeScGlActivity;
import com.osiris.farmers.jingyinghu.MenuHomeShouFeiActivity;
import com.osiris.farmers.jingyinghu.MenuHomeSuyuanActivity;
import com.osiris.farmers.model.Market;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.MarketEvaluateActivity;
import com.osiris.farmers.view.SalsersAccountActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

import static com.osiris.farmers.network.GlobalParams.currentMarketId;
import static com.osiris.farmers.network.GlobalParams.currentMarkrtName;

public class HomeActivity extends BaseActivity {

	@BindView(R.id.ll_home_name)
	LinearLayout llHomeName;

	@BindView(R.id.ll_home_1)
	LinearLayout llHome1;
	@BindView(R.id.iv_home_1)
	ImageView ivHome1;
	@BindView(R.id.tv_home_1)
	TextView tvHome1;
	@BindView(R.id.ll_home_2)
	LinearLayout llHome2;
	@BindView(R.id.iv_home_2)
	ImageView ivHome2;
	@BindView(R.id.tv_home_2)
	TextView tvHome2;
	@BindView(R.id.ll_home_3)
	LinearLayout llHome3;
	@BindView(R.id.iv_home_3)
	ImageView ivHome3;
	@BindView(R.id.tv_home_3)
	TextView tvHome3;
	@BindView(R.id.ll_home_4)
	LinearLayout llHome4;
	@BindView(R.id.iv_home_4)
	ImageView ivHome4;
	@BindView(R.id.tv_home4)
	TextView tvHome4;
	@BindView(R.id.spinner_market)
	Spinner spinner_market;


	private ArrayAdapter marketAdapter;
	private int pageType;
	private List<Market.MarketBean> marketList = new ArrayList<>();
	private List<String> marketNameList = new ArrayList<>();
	private int marketId = 0;
	private String marketName;

	@Override
	public int getLayoutResId() {
		return R.layout.activity_home;
	}

	@Override
	public void init() {
		initData();
		initView();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (marketList.size()>0){
			for (int i =0;i<marketList.size();i++)
				if (marketList.get(i).getId() == currentMarketId){
					spinner_market.setSelection(i);
				}

		}
	}

	private void initData() {

	}

	private void initView() {

		pageType = getIntent().getIntExtra("type", 1);
		Log.d("zkf", "type:" + pageType);
		changeViewStatus(pageType);
		getMarketData();
		marketAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,marketNameList);
		marketAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_market.setAdapter(marketAdapter);
		spinner_market.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				marketId = marketList.get(position).getId();
				currentMarkrtName = marketList.get(position).getMarketnm();
				currentMarketId = marketId;
				LogUtils.d("zkf marketId:" + marketId);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});


	}



	@OnClick({R.id.ll_home_name, R.id.ll_home_1, R.id.ll_home_2, R.id.ll_home_3, R.id.ll_home_4})
	void click(View view) {
		switch (view.getId()) {
			case R.id.ll_home_name:

				break;

			case R.id.ll_home_1:
				Intent intent = new Intent(this, MenuHomeActivity.class);
				if (pageType == 1) {
					intent.putExtra("type", 1);

				} else if (pageType == 2) {
					intent.putExtra("type", 2);

				} else if (pageType == 3) {
					intent.putExtra("type", 3);

				} else {
					intent = new Intent(this, MenuHomeJYhActivity.class);
					intent.putExtra("type", 4);

				}
				intent.putExtra("market_id",marketId);
				intent.putExtra("select",0);
				startActivity(intent);
				break;

			case R.id.ll_home_2:
				Intent intent2 = new Intent(this, MenuHomeActivity.class);
				if (pageType == 1) {
					intent2.putExtra("type", 1);
				} else if (pageType == 2) {
					intent2.putExtra("type", 2);
				} else if (pageType == 3) {
					intent2.putExtra("type", 3);

				} else {
					intent2 = new Intent(this, MenuHomeScGlActivity.class);
					intent2.putExtra("type", 4);

				}
				intent2.putExtra("market_id",marketId);
				intent2.putExtra("select",0);
				startActivity(intent2);
				break;

			case R.id.ll_home_3:
				Intent intent3 = new Intent(this, MenuHomeActivity.class);
				if (pageType == 1) {
					intent3.putExtra("type", 1);

				} else if (pageType == 2) {
					intent3.putExtra("type", 2);

				} else if (pageType == 3) {
					intent3.putExtra("type", 3);

				} else {
					intent3 = new Intent(this, MenuHomeShouFeiActivity.class);
					intent3.putExtra("type", 4);

				}
				intent3.putExtra("market_id",marketId);
				intent3.putExtra("select",0);
				startActivity(intent3);
				break;

			case R.id.ll_home_4:
				Intent intent4;
				if (pageType == 1) {
					LogUtils.d("zkf c");
					intent4 = new Intent(this, SalsersAccountActivity.class);
					intent4.putExtra("type", 1);

				} else if (pageType == 2) {
					LogUtils.d("zkf a");
					intent4 = new Intent(this, ManageHomeActivity.class);
					intent4.putExtra("type", 2);

				} else if (pageType == 3){
					LogUtils.d("zkf ab");
					intent4 = new Intent(this, MenuHomeActivity.class);
					intent4.putExtra("type", 3);

				}else {
					intent4 = new Intent(this, MenuHomeSuyuanActivity.class);
					intent4.putExtra("type", 4);
				}
				intent4.putExtra("market_id",marketId);
				intent4.putExtra("select",0);
				startActivity(intent4);
				break;
			default:
				break;
		}
	}


	private void changeViewStatus(int type) {
		switch (type) {
			case 1:
				ivHome1.setBackgroundResource(R.drawable.bg_home_purchasing);
				tvHome1.setText(getString(R.string.purchasing));
				ivHome2.setBackgroundResource(R.drawable.bg_home_sell);
				tvHome2.setText(getString(R.string.sell));
				ivHome3.setBackgroundResource(R.drawable.bg_home_stock);
				tvHome3.setText(getString(R.string.stock));
				ivHome4.setBackgroundResource(R.drawable.bg_home_booking);
				tvHome4.setText(getString(R.string.booking));
				break;

			case 2:
				ivHome1.setBackgroundResource(R.drawable.bg_home_retrospect);
				tvHome1.setText(getString(R.string.retrospect));
				ivHome2.setBackgroundResource(R.drawable.bg_home_sampling);
				tvHome2.setText(getString(R.string.sampling));
				ivHome3.setBackgroundResource(R.drawable.bg_home_check);
				tvHome3.setText(getString(R.string.danweicchaxun));
				ivHome4.setBackgroundResource(R.drawable.bg_home_appraise);
				tvHome4.setText(getString(R.string.manage));
				break;

			case 3:
				ivHome1.setBackgroundResource(R.drawable.bg_home_operator_management);
				tvHome1.setText(getString(R.string.shichangjiance));
				ivHome2.setBackgroundResource(R.drawable.bg_home_marketing_management);
				tvHome2.setText(getString(R.string.shangpingsuyuan));
//				ivHome3.setBackgroundResource(R.drawable.bg_home_charge);
//				tvHome3.setText(getString(R.string.charge));
				ivHome3.setBackgroundResource(R.drawable.bg_home_appraise_management);
				tvHome3.setText(getString(R.string.pingjiaguanli));
				llHome4.setVisibility(View.INVISIBLE);
				break;
			case 4:
				ivHome1.setBackgroundResource(R.drawable.bg_home_operator_management);
				tvHome1.setText("信息查询");
				ivHome2.setBackgroundResource(R.drawable.bg_home_marketing_management);
				tvHome2.setText("市场管理");
				ivHome3.setBackgroundResource(R.drawable.bg_home_charge);
				tvHome3.setText("缴费查询");
				ivHome4.setBackgroundResource(R.drawable.bg_home_appraise_management);
				tvHome4.setText("溯源质量");
				break;
		}
	}





	private void getMarketData() {


		String url = ApiParams.API_HOST + "/app/xzmarket.action";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", String.valueOf(GlobalParams.id));



		NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf  market data:" + successResult);
				String temp = successResult.substring(1, successResult.length() - 1);
				if (!TextUtils.isEmpty(successResult)) {
					Market market = JsonUtils.fromJson(temp, Market.class);
					if (marketList.size()>0){
						marketList.clear();
					}
					marketList.addAll(market.getMarket());
					GlobalParams.marketList = marketList;
					if (marketNameList.size()>0){
						marketNameList.clear();
					}
					for (Market.MarketBean marketBean:marketList){
						marketNameList.add(marketBean.getMarketnm());
					}
					marketAdapter.notifyDataSetChanged();
					if (marketList.size()>0){
						marketId = marketList.get(0).getId();
						currentMarketId = marketId;
					}

				}



			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}










}
