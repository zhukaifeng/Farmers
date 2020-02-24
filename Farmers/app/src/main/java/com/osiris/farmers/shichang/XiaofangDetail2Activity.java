package com.osiris.farmers.shichang;

import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.SuyuanJinDetail;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class XiaofangDetail2Activity extends BaseActivity {

    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_count)
    TextView tv_count;
    @BindView(R.id.tv_chuku_num)
    TextView tv_chuku_num;
    @BindView(R.id.tv_spbm)
    TextView tv_spbm;
    @BindView(R.id.tv_rkck)
    TextView tv_rkck;
    @BindView(R.id.tv_gongys)
    TextView tv_gongys;
    private int id;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_suyuan_detail_jinn;
    }

    @Override
    public void init() {
        id = getIntent().getIntExtra("data",0);

        getDetail();

    }

    private void getDetail() {
        //   http://localhost:8096/wisdom/app/getXiaofangxcById.action?id=1
        String url = ApiParams.API_HOST + "/app/getXiaofangxcById.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(id));
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(successResult).getAsJsonObject();
                if (json.has("data")){
//                    SuyuanJinDetail.DataBean[] dataBeans = JsonUtils.fromJson(json.get("data"),SuyuanJinDetail.DataBean[].class);
//                    SuyuanJinDetail.DataBean dataBean = dataBeans[0];
//                    tv_type.setText(dataBean.getSpbm());
//                    tv_name.setText(dataBean.getSplb());
//                    tv_count.setText(dataBean.getSum());
//                    tv_date.setText(dataBean.getDanwei());
//                    tv_chuku_num.setText(dataBean.getRiqi());
//                    tv_rkck.setText(dataBean.getRkcangku());
//                    tv_spbm.setText(dataBean.getSplb());
//                    tv_gongys.setText(dataBean.getGongys());
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });



    }
}
