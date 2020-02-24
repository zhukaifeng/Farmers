package com.osiris.farmers.view;

import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.MarketManagerData;
import com.osiris.farmers.model.MarketManagerEvaluate;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import me.jessyan.autosize.utils.LogUtils;

public class MarketManagerDetailActivity extends BaseActivity {

    @BindView(R.id.tv_user_num)
    TextView tv_user_num;
    @BindView(R.id.tv_user_name)
    TextView tv_user_name;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_people)
    TextView tv_people;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.tv_phone)
    TextView tv_phone;
    @BindView(R.id.tv_zhizhao)
    TextView tv_zhizhao;

    private int id = 0;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_manager_detail;
    }

    @Override
    public void init() {
        id = getIntent().getIntExtra("id", 0);

        if (id > 0) {
            getData();

        }


    }

    private void getData() {


        String url = ApiParams.API_HOST + "/app/getAllJyhById.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(id));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf successResult:" + successResult);

                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(successResult).getAsJsonObject();
                MarketManagerData data = JsonUtils.fromJson(json, MarketManagerData.class);
                if (null != data){
                    tv_address.setText(data.getAddress());
                    tv_people.setText(data.getLianxir());
                    tv_phone.setText(data.getPhone());
                    tv_type.setText(data.getType());
                    tv_user_name.setText(data.getOpernm());
                    tv_user_num.setText(data.getOperatorbh());
                    tv_zhizhao.setText(data.getCommoditynm());
                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                LogUtils.d("zkf code:" + code + " msg:" + msg);

            }
        });


    }
}
