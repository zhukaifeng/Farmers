package com.osiris.farmers.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.OperatorInquery;
import com.osiris.farmers.model.PunishDetail;
import com.osiris.farmers.model.PunishList;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.shichang.AddXiaofangActivity;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.PunishDetailAdapter;
import com.osiris.farmers.view.adapter.PunishListAdapter;
import com.osiris.farmers.view.dialog.ChooseRulesDialog;
import com.osiris.farmers.view.dialog.DialogClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class AddPunishFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;



    @BindView(R.id.linear_search)
    LinearLayout linear_search;
    @BindView(R.id.scroll_context)
    NestedScrollView scroll_context;
    @BindView(R.id.linear_item)
    LinearLayout linear_item;

    @BindView(R.id.linear_title_type)
    LinearLayout linear_title_type;
    @BindView(R.id.rv_data_detail)
    RecyclerView rv_data_detail;

    @BindView(R.id.rl_back)
    RelativeLayout rl_back;

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rl_right)
    RelativeLayout rl_right;


    private List<PunishList.DataBean> dataList = new ArrayList<>();
    private PunishListAdapter dataAdapter = new PunishListAdapter(dataList);
    private List<PunishDetail> detailList = new ArrayList<>();
    private PunishDetailAdapter detailAdapter = new PunishDetailAdapter(detailList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_add_punish;
    }

    @Override
    protected void initView() {
        getTypeData();

        //01                      不守规章制度                    200元
        detailList.add(new PunishDetail("01","不守规章制度","200元"));
        detailList.add(new PunishDetail("02","不守规章制度","200元"));
        detailList.add(new PunishDetail("03","不守规章制度","200元"));

        rv_data_detail.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data_detail.setAdapter(detailAdapter);
        detailAdapter.notifyDataSetChanged();


        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                linear_search.setVisibility(View.GONE);
                scroll_context.setVisibility(View.GONE);
                linear_item.setVisibility(View.GONE);
                linear_title_type.setVisibility(View.VISIBLE);
                rv_data_detail.setVisibility(View.VISIBLE);
                rl_right.setVisibility(View.GONE);
                rl_back.setVisibility(View.VISIBLE);
                tv_title.setText(getString(R.string.violation_of_regulation));
            }
        });

        dataAdapter.setOnNameClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object positionTag = v.getTag(R.id.tag_punish_name);
                if (positionTag == null ) {
                    return;
                }
                if (!(positionTag instanceof Integer)) {
                    return;
                }
                int position = (int) positionTag;

                dataAdapter.notifyDataSetChanged();
            }
        });

        dataAdapter.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object positionTag = v.getTag(R.id.tag_punish_button);
                if (positionTag == null ) {
                    return;
                }
                if (!(positionTag instanceof Integer)) {
                    return;
                }
            }
        });

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_right,R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_right:

                Intent intent = new Intent(getActivity(), AddXiaofangActivity.class);
                startActivity(intent);


                break;

            case R.id.rl_back:
                linear_search.setVisibility(View.VISIBLE);
                scroll_context.setVisibility(View.VISIBLE);
                linear_item.setVisibility(View.VISIBLE);
                linear_title_type.setVisibility(View.GONE);
                rv_data_detail.setVisibility(View.GONE);
                rl_back.setVisibility(View.GONE);
                rl_right.setVisibility(View.VISIBLE);
                tv_title.setText(getString(R.string.market_add_new_punish));

                break;
        }
    }

    private void showChooseRulesDialog() {
        ChooseRulesDialog.Builder builder = new ChooseRulesDialog.Builder(getActivity());
        builder.setPositiveButton(new DialogClickListener() {
            @Override
            public void onClick(Dialog dialog, String msg) {

            }

            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


    private void getTypeData() {


        String url = ApiParams.API_HOST + "/app/getXiaofangdwByUserId.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
        paramMap.put("pageNo", String.valueOf(1));
        paramMap.put("pageSize", String.valueOf(10));

        Log.d("zkf", "params:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){

                    PunishList.DataBean[] dataBeans = JsonUtils.fromJson(jsonObject.get("data"), PunishList.DataBean[].class);
                    dataList.addAll(Arrays.asList(dataBeans));
                    dataAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }


}
