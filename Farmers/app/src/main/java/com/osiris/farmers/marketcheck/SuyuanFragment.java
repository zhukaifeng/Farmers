package com.osiris.farmers.marketcheck;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.marketcheck.adapter.SuyuanSelectAdapter;
import com.osiris.farmers.model.SerachGoodData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.BillOflandSelectAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class SuyuanFragment extends BaseFragment {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.tv_choose_time)
    TextView tv_choose_time;
    @BindView(R.id.tv_time)
    TextView tv_time;


    private List<SerachGoodData> showDataList = new ArrayList<>();
    private SuyuanSelectAdapter suyuanSelectAdapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_suyuan;
    }

    @Override
    protected void initView() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        tv_time.setText(str);


        getTypeData();

//        for (int i = 0; i < 50; i++) {
//
//            SerachGoodData serachGoodData = new SerachGoodData();
//            serachGoodData.setSelect(false);
//            serachGoodData.setCommoditynm("大白菜" + i);
//            showDataList.add(serachGoodData);
//        }
//        showDataList.get(0).setSelect(true);

        suyuanSelectAdapter = new SuyuanSelectAdapter(showDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        rv_data.setLayoutManager(gridLayoutManager);
        rv_data.setAdapter(suyuanSelectAdapter);
        suyuanSelectAdapter.notifyDataSetChanged();
        suyuanSelectAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (SerachGoodData serachGoodData : showDataList) {
                    serachGoodData.setSelect(false);
                }
                showDataList.get(position).setSelect(true);
                suyuanSelectAdapter.notifyDataSetChanged();
                Intent intent = new Intent(getActivity(), SuyuanListActivity.class);
                intent.putExtra("data",showDataList.get(position).getCommoditynm());
                intent.putExtra("date",tv_time.getText().toString());
                startActivity(intent);
            }
        });


    }


    //getJYHSpckSplbByUserId.action








    private void getTypeData() {


        String url = ApiParams.API_HOST + "/app/getJYHSprkSplbByUserId.action";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
//        paramMap.put("marketId", String.valueOf(GlobalParams
//                .currentMarketId));
        paramMap.put("marketId", String.valueOf(18));
        Log.d("zkf", "marketid:" + GlobalParams.currentMarketId);
      //  paramMap.put("riqi", tv_time.getText().toString());
        paramMap.put("riqi", "2019-09-10");

        Log.d("zkf", "params:" + paramMap.toString());
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                Log.d("zkf", "data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")){
                    String[] strings = JsonUtils.fromJson(jsonObject.get("data"),String[].class);
                    for (String str: Arrays.asList(strings)){
                        SerachGoodData serachGoodData = new SerachGoodData();
                        serachGoodData.setSelect(false);
                        serachGoodData.setCommoditynm(str);
                        showDataList.add(serachGoodData);
                    }
                    if (showDataList.size()>0){
                        showDataList.get(0).setSelect(true);
                        suyuanSelectAdapter.notifyDataSetChanged();

                    }

                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }

    @OnClick({R.id.tv_choose_time, R.id.tv_time})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_time:
                showTimeSelect();
                break;
            case R.id.tv_choose_time:
                showTimeSelect();

                break;
        }
    }

    private void showTimeSelect() {

        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        //正确设置方式 原因：注意事项有说明
        startDate.set(2019, 0, 1);
        endDate.set(2024, 11, 31);

        TimePickerView pvTime = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String str = formatter.format(date);
                tv_time.setText(str);
                if (showDataList.size()>0){
                    showDataList.clear();

                }
                suyuanSelectAdapter.notifyDataSetChanged();
                getTypeData();
            }
        }).setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setTitleSize(20)//标题文字大小
                .setTitleText("")//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTitleBgColor(Color.WHITE)//标题背景颜色 Night mode
                .setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();
        pvTime.show();

    }

    @Override
    protected void initData() {

    }


}
