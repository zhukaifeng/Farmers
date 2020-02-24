package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.ManagerData1;
import com.osiris.farmers.model.Task;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.TaskDetailActivity;
import com.osiris.farmers.view.adapter.DatebacktoAdapter;
import com.osiris.farmers.view.adapter.Manager1Adapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ManagerFragment extends BaseFragment {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.linear_datebackto_detail)
    LinearLayout linear_datebackto_detail;
    @BindView(R.id.linear_datebackto)
    LinearLayout linear_datebackto;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_right_arrow)
    ImageView iv_right_arrow;
    @BindView(R.id.tv_sell)
    TextView tv_sell;
    @BindView(R.id.tv_buy)
    TextView tv_buy;
    @BindView(R.id.linear_title)
    LinearLayout linear_title;

    private List<ManagerData1.DataBean> dataList = new ArrayList<>();
    private Manager1Adapter dataAdapter = new Manager1Adapter(dataList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_datebackto;
    }

    @Override
    protected void initView() {
        tv_title.setText("法律法规");
        linear_title.setVisibility(View.GONE);
        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(getActivity(), TaskDetailActivity.class);
//                intent.putExtra("data",dataList.get(position));
//                startActivity(intent);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(ApiParams.API_HOST +"/"+dataList.get(position).getJtnr());
                intent.setData(content_url);
                startActivity(intent);
            }
        });
        getData();
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_sell,R.id.tv_buy})
    void onClick(View v){
        switch (v.getId()){

            case R.id.tv_sell:

                tv_sell.setBackgroundResource(R.drawable.bg_green_round);
                tv_sell.setTextColor(getActivity().getResources().getColor(R.color.write));
                tv_buy.setBackgroundResource(R.color.bg_gray);
                tv_buy.setTextColor(getActivity().getResources().getColor(R.color.txt_black_51));
                break;
            case R.id.tv_buy:

                tv_buy.setBackgroundResource(R.drawable.bg_green_round);
                tv_buy.setTextColor(getActivity().getResources().getColor(R.color.write));
                tv_sell.setBackgroundResource(R.color.bg_gray);
                tv_sell.setTextColor(getActivity().getResources().getColor(R.color.txt_black_51));
                break;
        }
    }

    private void getData() {
        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/allDataMag.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNo", String.valueOf(1));
        paramMap.put("leibie", String.valueOf(2));


        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);

                if (!TextUtils.isEmpty(successResult)) {
                    cancelLoadDialog();
                    JsonParser parser = new JsonParser();
                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                    if (json.has("data")){
                        ManagerData1.DataBean[] taskList = JsonUtils.fromJson(json.get("data"), ManagerData1.DataBean[].class);
                        dataList.addAll(Arrays.asList(taskList));
                        dataAdapter.notifyDataSetChanged();
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
