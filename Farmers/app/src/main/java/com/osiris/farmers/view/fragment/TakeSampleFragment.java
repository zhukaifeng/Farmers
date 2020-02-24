package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.event.MarketCXEvent;
import com.osiris.farmers.event.MarketEvent;
import com.osiris.farmers.model.ManagerData1;
import com.osiris.farmers.model.MarketCX;
import com.osiris.farmers.model.StallCX;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.CXMarketActivity;
import com.osiris.farmers.view.CXStallActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class TakeSampleFragment extends BaseFragment {


    @BindView(R.id.tv_market)
    TextView tv_market;
    @BindView(R.id.tv_tanwei)
    TextView tv_tanwei;
    @BindView(R.id.tv_info)
    TextView tv_info;
    @BindView(R.id.tv_info_stall)
    TextView tv_info_stall;

    private int currentMarketId = 0;
    private int currentStallId = 0;


    private List<MarketCX.DataBean> dataList = new ArrayList<>();
    private List<StallCX.DataBean> stallDataList = new ArrayList<>();
    private MarketCX.DataBean currentMarket;

    @OnClick({R.id.rl_choose_market,R.id.rl_stall})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_choose_market:

                Intent intent = new Intent(getActivity(), CXMarketActivity.class);
                intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) dataList);
                startActivity(intent);
                break;
            case  R.id.rl_stall:
                if (stallDataList.size() == 0) {
                    Toast toast = Toast.makeText(getActivity(), "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
                Intent intent1 = new Intent(getActivity(), CXStallActivity.class);
                intent1.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) stallDataList);
                startActivity(intent1);

                break;
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_chaxun;
    }

    @Override
    protected void initView() {

        getMarketInfo();


    }

    private void getMarketInfo() {

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/allMarketByUser.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));


        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                cancelLoadDialog();
                if (!TextUtils.isEmpty(successResult)) {
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    if (json.has("data")){
                        MarketCX.DataBean[] taskList = JsonUtils.fromJson(json.get("data"), MarketCX.DataBean[].class);
                        dataList.addAll(Arrays.asList(taskList));
                        if (dataList.size()>0){
                            tv_market.setText(dataList.get(0).getMarketnm());
                            currentMarketId = dataList.get(0).getId();
                            currentMarket = dataList.get(0);
                            tv_info.setText(currentMarket.getAddress()+"\n" + currentMarket.getTel()+"\n"+currentMarket.getZhuren()
                                    +"\n"+currentMarket.getBeifen());
                            if (currentMarketId>0){
                                getStallInfo();
                                
                            }
                        }
                    }

                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });



    }

    private void getStallInfo() {

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/allBoothglByMarket.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("marketId", String.valueOf(currentMarketId));


        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                cancelLoadDialog();
                if (!TextUtils.isEmpty(successResult)) {
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    if (json.has("data")){
                        StallCX.DataBean[] taskList = JsonUtils.fromJson(json.get("data"), StallCX.DataBean[].class);
                        if (stallDataList.size()>0){
                            stallDataList.clear();
                        }
                        stallDataList.addAll(Arrays.asList(taskList));
                        if (stallDataList.size()>0){
                            tv_tanwei.setText(stallDataList.get(0).getTwhmc());
                            currentStallId = stallDataList.get(0).getId();
                            StallCX.DataBean stallData = stallDataList.get(0);
                            tv_info_stall.setText(stallData.getQuyu()+"\n" + stallData.getLouceng()+"\n" + stallData.getMianji()+
                                    "\n" + stallData.getMoney());
                            if (currentStallId>0){
                                getStallInfoDetail();

                            }
                        }else {
                            tv_tanwei.setText("此市场暂无摊位号信息");
                        }
                    }

                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });

    }

    private void getStallInfoDetail() {



    }

    @Override
    protected void initData() {

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMarketData(MarketCXEvent marketEvent) {
        LogUtils.d("zkf receive 222222");
        tv_market.setText(marketEvent.getMarketName());
        currentMarketId = marketEvent.getMarketId();
        getStallInfo();


        for (MarketCX.DataBean dataBean:dataList){
            if (dataBean.getId() == currentMarketId){
                currentMarket = dataBean;
            }
        }
        tv_info.setText(currentMarket.getAddress()+"\n" + currentMarket.getTel()+"\n"+currentMarket.getZhuren()
                +"\n"+currentMarket.getBeifen());

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMarketStallData(StallCX.DataBean stallData) {
        LogUtils.d("zkf receive 222222");
        tv_tanwei.setText(stallData.getTwhmc());
        currentStallId = stallData.getId();

        tv_info_stall.setText(stallData.getQuyu()+"\n" + stallData.getLouceng()+"\n" + stallData.getMianji()+
                "\n" + stallData.getMoney());
    }

}
