package com.osiris.farmers.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.event.BoothgEvent;
import com.osiris.farmers.event.MarketEvent;
import com.osiris.farmers.model.ChooseStallData;
import com.osiris.farmers.model.Market;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.model.Task;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

import static com.osiris.farmers.view.fragment.TakeSampleListFragment.REQUEST_A;

public class TaskDetailActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_sheng)
    TextView tvSheng;
    @BindView(R.id.tv_shi)
    TextView tvShi;
    @BindView(R.id.tv_qu)
    TextView tvQu;
    @BindView(R.id.tv_jiedao)
    TextView tvJiedao;
    @BindView(R.id.tv_shichang)
    TextView tvShichang;
    @BindView(R.id.tv_tanwei)
    TextView tvTanwei;
    @BindView(R.id.tv_yplb)
    TextView tvYplb;
    @BindView(R.id.tv_ypmc)
    TextView tvYpmc;
    @BindView(R.id.tv_jcxm)
    TextView tvJcxm;
    @BindView(R.id.tv_jcy)
    TextView tvJcy;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.tv_time)
    TextView tvTime;

    private Task task;
    private int marketId;
    private int tanWeiId;
    private List<ChooseStallData.BoothglBean> stallList = new ArrayList<>();
    private List<String> stallNameList = new ArrayList<>();
    private ChooseStallData.BoothglBean boothglBean = new ChooseStallData.BoothglBean();
    private List<Market.MarketBean> marketList = new ArrayList<>();
    private List<SampleNameData.CommodityBean> commodityList = new ArrayList<>();
    private boolean choosed;
    private int yourChoice = 0;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_task_detail;
    }

    @Override
    public void init() {

        task = getIntent().getParcelableExtra("data");

        if (null != task){

            if (!TextUtils.isEmpty(task.getShengid())){
                tvSheng.setText(task.getShengid());
            }

            if (!TextUtils.isEmpty(task.getShiid())){
                tvShi.setText(task.getShiid());
            }

            if (!TextUtils.isEmpty(task.getQuid())){
                tvQu.setText(task.getQuid());
            }

            if (!TextUtils.isEmpty(task.getJiedaoid())){
                tvJiedao.setText(task.getJiedaoid());
            }

            if (!TextUtils.isEmpty(task.getScid())){
                tvShichang.setText(task.getScid().replace(",","\n"));

                    for (Market.MarketBean marketBean:GlobalParams.marketList){
                        if (task.getScid().contains(marketBean.getMarketnm())){
                            LogUtils.d("zkf market name:" + marketBean.getMarketnm());
                            marketList.add(marketBean);
                        }
                    }
                    if (marketList.size()==1){
                        LogUtils.d("zkf  market " + marketList.get(0).getMarketnm());
                        marketId = marketList.get(0).getId();
                        getStallNo();
                    }else {
                        for (Market.MarketBean marketBean:marketList){
                            LogUtils.d("zkf  dsdsdd:" + marketBean.getMarketnm());



                        }
                    }




            }else {
                tvShichang.setText("请点击选择市场");
            }

            if (!TextUtils.isEmpty(task.getTwhid())){
                tvTanwei.setText(task.getTwhid());
            }else {
                tvTanwei.setText("请点击选择摊位");
            }

            if (!TextUtils.isEmpty(task.getJcyid())){
                tvYplb.setText(task.getJcyid());
            }

            if (!TextUtils.isEmpty(task.getYpmc())){
                tvYpmc.setText(task.getYpmc());
            }

            if (!TextUtils.isEmpty(task.getJcymc())){
                tvJcxm.setText(task.getJcymc());
            }

            if (!TextUtils.isEmpty(task.getByo())){
                tvJcy.setText(task.getByo());
            }

            if (!TextUtils.isEmpty(task.getCysl())){
                tvCount.setText(task.getCysl());
            }

            if (!TextUtils.isEmpty(task.getLlrq())){
                tvTime.setText(task.getLlrq());
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    private void showSingleChoiceDialog(){

       final String items[]=task.getScid().split("[,]");

       // final String[] items = { "01","02","03","04"};
        final AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(TaskDetailActivity.this);
        singleChoiceDialog.setTitle("请选择市场");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LogUtils.d("zkf which:" + which);
                        yourChoice = which;

                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LogUtils.d("zkf yourChoice :" + yourChoice);
                        tvShichang.setText(items[yourChoice]);
                        for (Market.MarketBean marketBean:GlobalParams.marketList){
                            if (task.getScid().contains(marketBean.getMarketnm())){
                                LogUtils.d("zkf market name:" + marketBean.getMarketnm());
                                marketList.add(marketBean);
                            }
                        }
                        if (marketList.size()==1){
                            LogUtils.d("zkf  market " + marketList.get(0).getMarketnm());
                            marketId = marketList.get(0).getId();
                            getStallNo();
                        }else {
                                LogUtils.d("zkf  dsdsdd:" + marketList.get(yourChoice).getMarketnm());
                                marketId = marketList.get(yourChoice).getId();
                                LogUtils.d("zkf marketId:" + marketId);
                                getStallNo();

                        }
                        choosed = true;
                        dialog.dismiss();

                    }

                });
        singleChoiceDialog.show();
    }



    @OnClick({R.id.rl_back,R.id.tv_shichang,R.id.tv_tanwei,R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                if (marketId ==0){
                    Toast toast = Toast.makeText(TaskDetailActivity.this, "请您先选择市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    tvShichang.setTextColor(getResources().getColor(R.color.red));
                }
                if (stallNameList.size() == 0) {
                    Toast toast = Toast.makeText(TaskDetailActivity.this, "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }

                Intent intent = new Intent(TaskDetailActivity.this, AddSampleDataActivity.class);
                intent.putExtra("boothglid", boothglBean.getId());
                if (!TextUtils.isEmpty(tvTanwei.getText().toString())) {
                    intent.putExtra("stall_name", tvTanwei.getText().toString());
                }
                intent.putExtra("data",task);
                LogUtils.d("zkf boothglid222222:" + boothglBean.getId());
                startActivity(intent);


                break;
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_shichang:
           //     if (!tvShichang.getText().toString().contains("请点击选择市场"))return;

                if (task.getScid().contains(",") && !choosed){
                    showSingleChoiceDialog();
                }else {
                    Intent intent1 = new Intent(this, ChooseMarketActivity.class);
                    startActivity(intent1);
                }



                break;
            case R.id.tv_tanwei:

                if (marketId ==0){
                    Toast toast = Toast.makeText(TaskDetailActivity.this, "请您先选择市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }


            //    if (!tvTanwei.getText().toString().contains("请点击选择摊位"))return;

                if (stallNameList.size() == 0) {
                    Toast toast = Toast.makeText(this, "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }

                Intent i = new Intent(this, ChooseStallNoActivity.class);
                i.putExtra("marketId",marketId);
                startActivityForResult(i, REQUEST_A);


                break;
        }

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        LogUtils.d("zkf position:");
        switch (requestCode) {
            case REQUEST_A:
//                int position = intent.getExtras().getInt("position", 0);
//                LogUtils.d("zkf position:" + position);
//                tvTanwei.setText(stallNameList.get(position));

                break;
        }


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(BoothgEvent boothglBean) {
        this.boothglBean.setId(boothglBean.getId());
        this.boothglBean.setMarketid(boothglBean.getMarketid());
        this.boothglBean.setTwhmc(boothglBean.getTwhmc());

        tvTanwei.setText(boothglBean.getTwhmc());
      //  getCheckProject();


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMarketData(MarketEvent marketEvent) {
        marketId = marketEvent.getMarketId();
        tvShichang.setTextColor(getResources().getColor(R.color.black));
        tvShichang.setText(marketEvent.getMarketName());
        LogUtils.d("zkf receive 222222  :" + marketId);
        getStallNo();
    }

    private void getStallNo() {

        String url = ApiParams.API_HOST + "/app/xzboothgl.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(marketId));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    ChooseStallData tempData = JsonUtils.fromJson(temp, ChooseStallData.class);
                    if (stallList.size() > 0) stallList.clear();
                    stallList.addAll(tempData.getBoothgl());
                    if (stallNameList.size() > 0) stallNameList.clear();
                    for (ChooseStallData.BoothglBean boothgl : stallList) {
                        LogUtils.d("zkf boothgl.getTwhmc():" + boothgl.getTwhmc());
                        stallNameList.add(boothgl.getTwhmc());
                        if (boothgl.getTwhmc().contains(task.getTwhid())){
                            LogUtils.d("zkf boothgl.getTwhmc()222334:" + boothgl.getTwhmc());
                            boothglBean = boothgl;
                        }
                    }


                    if (null != stallList && stallList.size() > 0) {
                        if (stallNameList.size() > 0) {
                           // tv_shop_num.setText(stallNameList.get(0));
                        }
                      //  getCheckProject();
                    } else {
                        tvTanwei.setText("");
                        Toast toast = Toast.makeText(TaskDetailActivity.this, "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        return;

                    }


                } else {
                    tvTanwei.setText("");
                    Toast toast = Toast.makeText(TaskDetailActivity.this, "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }


}
