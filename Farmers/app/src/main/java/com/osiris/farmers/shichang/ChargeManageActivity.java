package com.osiris.farmers.shichang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.ChargeDetail;
import com.osiris.farmers.model.ChargeManager;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.Product;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.ChargeDetailAdapter;
import com.osiris.farmers.view.adapter.ChargeManagerAdapter;
import com.osiris.farmers.view.adapter.ChargeTypeAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ChargeManageActivity extends BaseActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_charge_manage;
    }

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;
    @BindView(R.id.rv_data_detail)
    RecyclerView rv_data_detail;
    @BindView(R.id.linear_charge_manager)
    LinearLayout linear_charge_manager;
    @BindView(R.id.linear_detail)
    LinearLayout linear_detail;
    @BindView(R.id.tv_title)
    TextView tv_title;
    private List<ChargeManager> dataList = new ArrayList<>();
    private ChargeManagerAdapter dataAdapter = new ChargeManagerAdapter(dataList);
    private List<DateModel> typeList = new ArrayList<>();
    private String type = "";
    private ChargeTypeAdapter typeAdapter = new ChargeTypeAdapter(typeList);
    private List<ChargeDetail> dataDetailList = new ArrayList<>();
    private ChargeDetailAdapter dataDetailAdapter = new ChargeDetailAdapter(dataDetailList);
    private int jyhId;

    public static Intent getStartIntent(Context context, String account, int jyhId) {
        return new Intent(context, ChargeManageActivity.class).putExtra("account", account).putExtra("jyhId", jyhId);
    }


    @OnClick({R.id.rl_back, R.id.rl_back_one})
    void onnClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                linear_charge_manager.setVisibility(View.VISIBLE);
                linear_detail.setVisibility(View.GONE);

                break;
            case R.id.rl_back_one:
                finish();
                break;
        }
    }

    protected void initView() {
        tv_title.setText("交费查询");
        jyhId = getIntent().getIntExtra("jyhId", 0);
        typeList.add(new DateModel("全部", true));
        typeList.add(new DateModel("电费", false));
        typeList.add(new DateModel("水费", false));
        typeList.add(new DateModel("摊位费", false));
        typeList.add(new DateModel("保证金", false));
        typeList.add(new DateModel("物业费", false));
        typeList.add(new DateModel("卫生费", false));
        typeList.add(new DateModel("电梯费", false));

        dataAdapter.setAccount(getIntent().getStringExtra("account"));
        rv_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                linear_charge_manager.setVisibility(View.GONE);
                linear_detail.setVisibility(View.VISIBLE);
            }
        });


        rv_type.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_type.setAdapter(typeAdapter);
        typeAdapter.notifyDataSetChanged();
        typeAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (DateModel dateModel : typeList) {
                    dateModel.setClicked(false);
                }
                typeList.get(position).setClicked(true);
                typeAdapter.notifyDataSetChanged();
                type = "全部".equals(typeList.get(position).getDate()) ? "" : typeList.get(position).getDate();
                initData();
            }
        });

        rv_data_detail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_data_detail.setAdapter(dataDetailAdapter);
        dataDetailAdapter.notifyDataSetChanged();
        initData();


    }

    private void initData() {

        String url = ApiParams.API_HOST + "/app/getJiaofeiglByJyhId.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("jyhId", String.valueOf(jyhId));
        paramMap.put("jiaofeiType", type);
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                if (!TextUtils.isEmpty(successResult)) {
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    if (json.has("data")) {
                        ChargeManager[] dataBeans = JsonUtils.fromJson(json.get("data"), ChargeManager[].class);
                        dataList.clear();
                        dataList.addAll(Arrays.asList(dataBeans));
                        dataAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }

    @Override
    public void init() {
        initView();
    }
}
