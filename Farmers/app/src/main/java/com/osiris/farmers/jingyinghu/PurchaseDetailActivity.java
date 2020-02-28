package com.osiris.farmers.jingyinghu;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.PurchaseDetail;
import com.osiris.farmers.model.StockPurchase;
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
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class PurchaseDetailActivity extends BaseActivity {

    @BindView(R.id.tv_product_name)
    TextView tv_product_name;
    @BindView(R.id.tv_product_type)
    TextView tv_product_type;
    @BindView(R.id.tv_product_count)
    TextView tv_product_count;
    @BindView(R.id.tv_product_price)
    TextView tv_product_price;
    @BindView(R.id.tv_product_total_price)
    TextView tv_product_total_price;
    @BindView(R.id.tv_product_date)
    TextView tv_product_date;
    @BindView(R.id.tv_product_num_ru)
    TextView tv_product_num_ru;
    @BindView(R.id.tv_product_num_left)
    TextView tv_product_num_left;
    @BindView(R.id.tv_product_price_dan)
    TextView tv_product_price_dan;
    @BindView(R.id.tv_product_total)
    TextView tv_product_total;

    private int id;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_purchase_detail;
    }

    @Override
    public void init() {

        id = getIntent().getIntExtra("id", 0);

        getDataList();
    }

    //http://localhost:8096/wisdom/app/getJYHSprkById.action?id=11


    private void getDataList() {

        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/getJYHSprkById.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(id));


        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                LogUtils.d("zkf  successResult:" + successResult);
                if (!TextUtils.isEmpty(successResult)) {
                    cancelLoadDialog();
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    if (json.has("data")) {
                        PurchaseDetail.DataBean dataBean = JsonUtils.fromJson(json.get("data"), PurchaseDetail.DataBean.class);
                        tv_product_name.setText(dataBean.getId() + "");

                        if (!TextUtils.isEmpty(dataBean.getSpbm()))
                            tv_product_type.setText(dataBean.getSpbm());


                        if (!TextUtils.isEmpty(dataBean.getSplb()))
                            tv_product_type.setText(dataBean.getSplb());

                        if (!TextUtils.isEmpty(dataBean.getHydh()))
                            tv_product_price.setText(dataBean.getHydh());


                        if (!TextUtils.isEmpty(dataBean.getDh()))
                            tv_product_total_price.setText(dataBean.getDh());


                        if (!TextUtils.isEmpty(dataBean.getMbrk()))
                            tv_product_date.setText(dataBean.getMbrk());


                        if (!TextUtils.isEmpty(dataBean.getRiqi()))
                            tv_product_num_ru.setText(dataBean.getRiqi());

                        if (!TextUtils.isEmpty(dataBean.getSum()))
                            tv_product_num_left.setText(dataBean.getSum());


                        if (!TextUtils.isEmpty(dataBean.getSpdj()))
                            tv_product_price_dan.setText(dataBean.getSpdj());


                        if (!TextUtils.isEmpty(dataBean.getSphj()))
                            tv_product_total.setText(dataBean.getSphj());

                    }


                    //		typeList.add(new DateModel("蔬菜", true));

                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });

    }


    @OnClick({R.id.rl_back})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
               finish();
                break;
        }
    }

}
