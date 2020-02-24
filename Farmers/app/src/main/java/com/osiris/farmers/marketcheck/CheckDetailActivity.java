package com.osiris.farmers.marketcheck;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.CheckDetail;
import com.osiris.farmers.model.XiaofangDetail;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import me.jessyan.autosize.utils.LogUtils;

public class CheckDetailActivity extends BaseActivity {


    @BindView(R.id.tv_content)
    TextView tv_content;

    @BindView(R.id.iv_pic1)
    ImageView iv_pic1;
    @BindView(R.id.iv_pic2)
    ImageView iv_pic2;
    @BindView(R.id.iv_pic3)
    ImageView iv_pic3;
    private int id;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_check_detai;
    }

    @Override
    public void init() {
        id = getIntent().getIntExtra("data",0) ;
        getData();

    }
    //http://localhost:8096/wisdom/app/getRichangxcById.action?id=1

    private void getData() {

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/getXiaofangxcById.action";
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
                    XiaofangDetail.DataBean dataBean = JsonUtils.fromJson(jsonObject.get("data"),XiaofangDetail.DataBean.class);
                    if (!TextUtils.isEmpty(dataBean.getTitleMsg())){
                        tv_content.setText(dataBean.getTitleMsg());
                    }
                    if (!TextUtils.isEmpty(dataBean.getTupian())){
                        Glide.with(CheckDetailActivity.this).load(ApiParams.API_HOST + "/richangxc/" + dataBean.getTupian()).into(iv_pic1);

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
