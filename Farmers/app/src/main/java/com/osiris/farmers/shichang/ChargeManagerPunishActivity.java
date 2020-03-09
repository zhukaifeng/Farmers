package com.osiris.farmers.shichang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.ChargeManager;
import com.osiris.farmers.model.ChargePunish;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.PurchaseDetail;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.ChargeManagerAdapter;
import com.osiris.farmers.view.adapter.ChargeManagerPunishAdapter;
import com.osiris.farmers.view.adapter.ChargeTypeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ChargeManagerPunishActivity extends BaseActivity {
    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;
    private List<ChargePunish> dataList = new ArrayList<>();
    private ChargeManagerPunishAdapter dataAdapter = new ChargeManagerPunishAdapter(dataList);
    private List<DateModel> typeList = new ArrayList<>();
    private ChargeTypeAdapter typeAdapter = new ChargeTypeAdapter(typeList);

    public static Intent getStartIntent(Context context, String loginId, int jyhId) {
        return new Intent(context, ChargeManagerPunishActivity.class).putExtra("jyhId", String.valueOf(jyhId)).putExtra("loginId", loginId);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_charge_punish;
    }

    @OnClick({R.id.rl_back, R.id.rl_back_one})
    void onnClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back_one:
                finish();
                break;
        }
    }

    @Override
    public void init() {
        typeList.add(new DateModel("全部", true));
        rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.setAccount(getIntent().getStringExtra("loginId"));
        rv_type.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_type.setAdapter(typeAdapter);
        typeAdapter.notifyDataSetChanged();
        initDatas();
    }

    private void initDatas() {
        String url = ApiParams.API_HOST + "/app/getJingyingxwByJyhId.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("jyhId", getIntent().getStringExtra("jyhId"));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                if (!TextUtils.isEmpty(successResult)) {
                    cancelLoadDialog();
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    if (json.has("data")) {
                       ChargePunish[] dataBean = JsonUtils.fromJson(json.get("data"), ChargePunish[].class);
                       dataAdapter.setDataList(Arrays.asList(dataBean));
                       dataAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }
}
