package com.osiris.farmers.shichang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.Rules;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaoFangRuleActivity extends BaseActivity {


    @BindView(R.id.rb_purchaser)
    AppCompatRadioButton rbPurchaser;
    @BindView(R.id.rg_company_option_type_title)
    RadioGroup rgCompanyOptionTypeTitle;
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.edit_conext)
    EditText edit_conext;
    @BindView(R.id.iv_search)
    ImageView iv_search;

    private List<Rules.DataBean> dataBeanList = new ArrayList<>();
    private RulesAdapter rulesAdapter = new RulesAdapter(dataBeanList);
    private List<Rules.DataBean> dataBeanAllList = new ArrayList<>();


    @Override
    public int getLayoutResId() {
        return R.layout.activity_xiaofang_rules;
    }

    @Override
    public void init() {

        rvData.setLayoutManager(new GridLayoutManager(this, 2));
        rvData.setAdapter(rulesAdapter);
        rulesAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                postEvent(dataBeanList.get(position));
                finish();

            }
        });
        getTypeData();
    }



    @OnClick({R.id.rl_back,R.id.iv_search})
    void OnClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_search:
                if (TextUtils.isEmpty(edit_conext.getText().toString())){
                    dataBeanList.clear();
                    dataBeanList.addAll(dataBeanAllList);
                    rulesAdapter.notifyDataSetChanged();
                }else {
                    dataBeanList.clear();
                    for (Rules.DataBean dataBean:dataBeanAllList){
                        if (dataBean.getZlkmc().contains(edit_conext.getText().toString().trim())){
                            dataBeanList.add(dataBean);
                        }
                    }
                    rulesAdapter.notifyDataSetChanged();


                }
                break;
        }
    }


    private void getTypeData() {

        //richangxcPageList.action?
        String url = ApiParams.API_HOST + "/app/allDataMag.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("leibie", String.valueOf(3));
//        paramMap.put("pageNo", String.valueOf(1));
//        paramMap.put("pageSize", String.valueOf(10));

        Log.d("zkf", "params:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){

                    Rules.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), Rules.DataBean[].class);
                    dataBeanList.addAll(Arrays.asList(dataBeans));
                    dataBeanAllList.addAll(Arrays.asList(dataBeans));
                    rulesAdapter.notifyDataSetChanged();


                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }

}
