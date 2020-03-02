package com.osiris.farmers.shichang;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.XiaofangDe;
import com.osiris.farmers.model.XingweiDetail;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class XingWeiDetailActivity extends BaseActivity {


    @BindView(R.id.tv_content)
    TextView tv_content;

    @BindView(R.id.iv_pic1)
    ImageView iv_pic1;
    @BindView(R.id.iv_pic2)
    ImageView iv_pic2;
    @BindView(R.id.iv_pic3)
    ImageView iv_pic3;
    private int id;


    @OnClick({R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_back:
              finish();

                break;
        }
    }


    @Override
    public int getLayoutResId() {
        return R.layout.activity_check_detai2;
    }

    @Override
    public void init() {
        id = getIntent().getIntExtra("data",0) ;
        getData();

    }
    //消防巡查列表
    //http://39.97.235.7:8086/wisdom/app/getXiaofangxcByUserId.action?userId=53&pageNo=1&pageSize=10
//http://39.97.235.7:8086/wisdom/app/getXiaofangxcById.action?id=5
    private void getData() {

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/getRichangxcById.action";//database
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id",String.valueOf(id));

        NetRequest.requestBase64(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                cancelLoadDialog();
                LogUtils.d("zkf temp:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){
                    XingweiDetail.DataBean dataBean = JsonUtils.fromJson(jsonObject.get("data"),XingweiDetail.DataBean.class);
                    if (!TextUtils.isEmpty(dataBean.getResultMsg())){
                        tv_content.setText(dataBean.getResultMsg());
                    }
                    if (!TextUtils.isEmpty(dataBean.getTupian())){
                        Glide.with(XingWeiDetailActivity.this).load(ApiParams.API_HOST + "/richang/" + dataBean.getTupian()).into(iv_pic1);

                    }
                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });


    }
}
