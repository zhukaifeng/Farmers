package com.osiris.farmers.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.MarketBusinessBean;
import com.osiris.farmers.model.OperatorInquery;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.shichang.ChargeManageActivity;
import com.osiris.farmers.shichang.ChargeManagerPunishActivity;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MarketBusinessAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class MarketBusinessFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.et_market_name)
    EditText et_market_name;
    @BindView(R.id.tv_title)
    TextView tv_title;
    private ArrayList<MarketBusinessBean> dataList = new ArrayList<>();
    private MarketBusinessAdapter dataAdapter = new MarketBusinessAdapter(dataList);
    private String searchMarketName;
    public static final int TYPE_PUNISH = 1;
    public static final int TYPE_CONSUME = 2;
    private int pageType;


    @Override
    protected int setLayout() {
        return R.layout.fragment_market_business;
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            pageType = getArguments().getInt("pageType");
            tv_title.setText(pageType==TYPE_PUNISH?"处罚查询":"消费查询");
        }
        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("zkf click");
                Object positionTag = v.getTag(R.id.tag_operator_inquiry);
                if (positionTag == null) {
                    return;
                }
                if (!(positionTag instanceof Integer)) {
                    return;
                }
                int position = Integer.parseInt(String.valueOf(positionTag));
                LogUtils.d("zkf click  position:" + position);

                dataAdapter.notifyDataSetChanged();
            }
        });

        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MarketBusinessBean item=dataList.get(position);
                if (pageType == TYPE_CONSUME) {
                    startActivity(ChargeManageActivity.getStartIntent(getActivity(), item.getLoginId(), item.getId()));
                }else {
                    startActivity(ChargeManagerPunishActivity.getStartIntent(getActivity(), item.getLoginId(), item.getId()));
                }
            }
        });

    }

    @Override
    protected void initData() {
        getTypeData();
    }

    @OnClick({R.id.btn_search})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                getActivity().finish();
                break;
            case R.id.btn_search:
                searchMarketName = et_market_name.getText().toString();
                initData();
                break;
        }
    }

    //13813714259
    //http://localhost:8096/wisdom/app/getOperatorByUserId.action?userId=53
    private void getTypeData() {


        String url = ApiParams.API_HOST + "/app/getJYHByJyhName.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
        if (searchMarketName != null) {
            paramMap.put("jyhName", searchMarketName);
        }
        Log.d("zkf", "params:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")) {

                    MarketBusinessBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), MarketBusinessBean[].class);
                    dataList.clear();
                    dataList.addAll(Arrays.asList(dataBeans));
                    dataAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }
}
