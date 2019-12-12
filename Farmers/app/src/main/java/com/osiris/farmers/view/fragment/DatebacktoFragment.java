package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateBackto;
import com.osiris.farmers.model.SampleListData;
import com.osiris.farmers.model.Task;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.AddSampleActivity;
import com.osiris.farmers.view.AddSampleDataActivity;
import com.osiris.farmers.view.TaskDetailActivity;
import com.osiris.farmers.view.adapter.DatebacktoAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class DatebacktoFragment extends BaseFragment {


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

    private List<Task> dataList = new ArrayList<>();
    private DatebacktoAdapter dataAdapter = new DatebacktoAdapter(dataList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_datebackto;
    }

    @Override
    protected void initView() {

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), TaskDetailActivity.class);
                intent.putExtra("data",dataList.get(position));
                startActivity(intent);
            }
        });
        getData();
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_back,R.id.tv_sell,R.id.tv_buy})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_back:
                rl_back.setVisibility(View.GONE);
                tv_title.setText(getActivity().getString(R.string.organization_datebackto));
                iv_right_arrow.setVisibility(View.VISIBLE);
                linear_datebackto.setVisibility(View.VISIBLE);
                linear_datebackto_detail.setVisibility(View.GONE);
                break;
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
        String url = ApiParams.API_HOST + "/app/getAllcaiyangsjlr.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.id));


        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    cancelLoadDialog();
                    Task[] taskList = JsonUtils.fromJson(successResult, Task[].class);
                    dataList.addAll(Arrays.asList(taskList));
                    dataAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });

    }





}
