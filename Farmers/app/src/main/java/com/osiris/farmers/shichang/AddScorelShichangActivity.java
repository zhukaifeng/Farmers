package com.osiris.farmers.shichang;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.AddScore;
import com.osiris.farmers.model.JinghuPingjia;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class AddScorelShichangActivity extends BaseActivity {


    //private EvaluateList.ZhugpingjiasBean data;

    @BindView(R.id.tv_market)
    TextView tv_market;
    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rl_commit)
    RelativeLayout rl_commit;

    private List<AddScore.MarketsBean> dataList = new ArrayList<>();
    private List<JinghuPingjia.PingjiaxxsBean> pingjiaxxs = new ArrayList<>();
    private List<JinghuPingjia.ZhanghglsBean> zhanghgls = new ArrayList<>();
    private AddScoreShichangAdapter marketScoreAdapter = new AddScoreShichangAdapter(pingjiaxxs);

    private int totalCommitCount = 0;
    private int currentCommitCount = 0;
    @BindView(R.id.spinner_market)
    Spinner spinner_market;
    private ArrayAdapter marketAdapter;
    private List<String> selectName = new ArrayList<>();
    private int jyhid = 0;

    private int xxz = 0;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_scoring_detail_shichangpingjia;
    }

    @Override
    public void init() {
        //data = getIntent().getParcelableExtra("data");
        xxz = getIntent().getIntExtra("xxz", 0);
        rl_commit.setVisibility(View.VISIBLE);

        marketAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, selectName);
        marketAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_market.setAdapter(marketAdapter);
        spinner_market.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("zkf jisid:" ," " + jyhid);
                jyhid = zhanghgls.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//		if (null != data){
//			tv_market.setText(data.getMarketnm());
//		}
        if (xxz == 1) {
            rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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

                    pingjiaxxs.get(position).setScore(5);
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

                    pingjiaxxs.get(position).setScore(4);
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
                    pingjiaxxs.get(position).setScore(3);
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
                    pingjiaxxs.get(position).setScore(2);
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
                    pingjiaxxs.get(position).setScore(1);
                    marketScoreAdapter.notifyDataSetChanged();
                }
            });
        } else {
            rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));




        }


        if (xxz == 1) {
            getData();

        } else {
        }
    }


    @OnClick({R.id.rl_back, R.id.rl_commit})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_commit:
                if (xxz == 1) {
//					for (JinghuPingjia.PingjiaxxsBean data:pingjiaxxs){
//						if (data.getScore()>0){
//							totalCommitCount++;
//						}
//					}
                    commitData();

//					for (JinghuPingjia.PingjiaxxsBean data:pingjiaxxs){
//						if (data.getScore()>0){
//							commitData(data);
//						}
//					}

                } else {


                }

                break;
        }
    }


    //http://39.97.235.7:8086/wisdom/app/appxzpjDetsAdd.action
    private void commitData() {
        String url = ApiParams.API_HOST + "/app/appxzpjDetsAdd.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.id));
        //	paramMap.put("type","1");
        paramMap.put("jyhid", String.valueOf(jyhid));
        StringBuffer stringBuffer = new StringBuffer();
        for (JinghuPingjia.PingjiaxxsBean marketsBean : pingjiaxxs) {
            Log.d("zkf","score:" + marketsBean.getScore());
            if (marketsBean.getScore() == 5) {
                stringBuffer.append("5|非常满意|" + marketsBean.getId()).append(",");
            } else if (marketsBean.getScore() == 4) {

                stringBuffer.append("4|满意|" + marketsBean.getId()).append(",");

            } else if (marketsBean.getScore() == 3) {
                stringBuffer.append("3|一般|" + marketsBean.getId()).append(",");

            } else if (marketsBean.getScore() == 2) {
                stringBuffer.append("2|差|" + marketsBean.getId()).append(",");

            } else {
                stringBuffer.append("1|极差|" + marketsBean.getId()).append(",");
            }
        }
        String data = stringBuffer.toString();
        paramMap.put("data",  data.substring(0, data.length() - 1));


//        if (marketsBean.getScore() == 5) {
//            paramMap.put("data", "5|非常满意|" + marketsBean.getId());
//
//        } else if (marketsBean.getScore() == 4) {
//            paramMap.put("data", "4|满意|" + marketsBean.getId());
//
//        } else if (marketsBean.getScore() == 3) {
//            paramMap.put("data", "3|一般|" + marketsBean.getId());
//
//        } else if (marketsBean.getScore() == 2) {
//            paramMap.put("data", "2|差|" + marketsBean.getId());
//
//        } else {
//            paramMap.put("data", "1|极差|" + marketsBean.getId());
//
//        }
        LogUtils.d("zkf paramMap:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf successResult   make score:" + successResult);
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AddScorelShichangActivity.this, "全部提交成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

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

    //http://39.97.235.7:8086/wisdom/app/appMarketpingjiaAdd.action



    //http://39.97.235.7:8086/wisdom/app/appMarketpingjiaAdd.action
    private void getData() {
        String url = ApiParams.API_HOST + "/app/appMarketpingjiaAdd.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.id));
        paramMap.put("type", "1");

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf successResult:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(successResult).getAsJsonObject();
                if (json.has("pingjiaxxs")) {
                    JinghuPingjia.PingjiaxxsBean[] datas = JsonUtils.fromJson(json.get("pingjiaxxs"),
                            JinghuPingjia.PingjiaxxsBean[].class);
                    pingjiaxxs.addAll(Arrays.asList(datas));
                    marketScoreAdapter.notifyDataSetChanged();

                }
                if (json.has("zhanghgls")) {
                    JinghuPingjia.ZhanghglsBean[] datas = JsonUtils.fromJson(json.get("zhanghgls"),
                            JinghuPingjia.ZhanghglsBean[].class);
                    zhanghgls.addAll(Arrays.asList(datas));
                    if (zhanghgls.size() > 0) {
                        for (JinghuPingjia.ZhanghglsBean zhanghglsBean : zhanghgls) {
                            //	selectName.add(zhanghglsBean.getJcyname());
                            selectName.add("               " + zhanghglsBean.getJcyname() + "               ");

                        }
                        jyhid = zhanghgls.get(0).getId();
                    }
                    marketAdapter.notifyDataSetChanged();

                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });

    }




}
