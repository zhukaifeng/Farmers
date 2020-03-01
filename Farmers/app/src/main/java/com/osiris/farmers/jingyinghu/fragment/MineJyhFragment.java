package com.osiris.farmers.jingyinghu.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.BusinessInfo;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MineJyhFragment extends BaseFragment {

    @BindView(R.id.iv_avatar)
    ImageView iv_avatar;
    @BindView(R.id.tv_user_name)
    TextView tv_user_name;
    @BindView(R.id.tv_account)
    TextView tv_account;
    @BindView(R.id.tv_dept)
    TextView tv_dept;
    @BindView(R.id.tv_tw)
    TextView tv_tw;


    @OnClick({R.id.rl_back})
    void onnClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                getActivity().finish();
                break;
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine_jyh;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        String url = ApiParams.API_HOST + "/app/myInfo.action";
        Map<String, String> params = new HashMap<>();
        params.put("userId", String.valueOf(GlobalParams.id));
        NetRequest.request(url, ApiRequestTag.DATA, params, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")) {
                    BusinessInfo info = JsonUtils.fromJson(jsonObject.get("data"), BusinessInfo.class);
                    Glide.with(getActivity()).load(ApiParams.API_HOST + "/jynsprk/" + info.getHeadpic()).into(iv_avatar);
                    tv_user_name.setText("用户名：" + info.getUsername());
                    tv_account.setText("账号：" + info.getLoginname());
                    tv_dept.setText("所属市场：" + info.getMarketName());
                    tv_tw.setText("摊位号：" + info.getTwhma());
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }
}
