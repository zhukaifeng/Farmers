package com.osiris.farmers.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.view.adapter.BillOflandSelectAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class AddJinhuoListActivity extends BaseActivity {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.edt_count)
    EditText edt_count;
    @BindView(R.id.edt_price)
    EditText edt_price;
    @BindView(R.id.edt_date)
    EditText edt_date;
    @BindView(R.id.edt_no)
    EditText edt_no;

    private BillOflandSelectAdapter billOflandSelectAdapter;
    private List<SampleNameData.CommodityBean> dataList = new ArrayList<>();
    private List<SampleNameData.CommodityBean> showDataList = new ArrayList<>();
    private int commodityid = -1;
    private SampleNameData.CommodityBean commodityBean;
    private String gongyingshang;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_add_jinhuo;
    }

    @Override
    public void init() {
        dataList = getIntent().getParcelableArrayListExtra("data_list");
        gongyingshang = getIntent().getStringExtra("jinhuo");
        showDataList.addAll(dataList);
        billOflandSelectAdapter = new BillOflandSelectAdapter(showDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rv_data.setLayoutManager(gridLayoutManager);
        rv_data.setAdapter(billOflandSelectAdapter);
        billOflandSelectAdapter.notifyDataSetChanged();
        billOflandSelectAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (int i = 0; i < showDataList.size(); i++) {
                    if (i == position) {
                        showDataList.get(i).setSelect(true);
                    } else {
                        showDataList.get(i).setSelect(false);
                    }
                }
                commodityid = showDataList.get(position).getId();
                billOflandSelectAdapter.notifyDataSetChanged();

                commodityBean = showDataList.get(position);
            }
        });


    }

    @OnClick(R.id.tv_count_ok)
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_count_ok:
                postDataToServer();
                break;
        }
    }


    private void postDataToServer(){
        String url = ApiParams.API_HOST + "/app/appstorageAdd.action";

        Map<String, String> paramMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(commodityBean.getCommoditynm()).append("，")
                .append(gongyingshang).append("，").append(edt_count.getText().toString()).append("，")
                .append(edt_price.getText().toString()).append("，")
                .append(edt_date.getText().toString()).append("，")
                .append(edt_no.getText().toString()).append("，").append("874").append("，").append("1");
        paramMap.put("data",stringBuffer.toString());
        paramMap.put("userid", String.valueOf(GlobalParams.id));
        LogUtils.d("zkf data:" + stringBuffer.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });

    }


}
