package com.osiris.farmers.goods.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.event.BoothgEvent;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.model.StockListData;
import com.osiris.farmers.model.StoreSupplier;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.AddJinhuoListActivity;
import com.osiris.farmers.view.AddSampleActivity;
import com.osiris.farmers.view.ChooseStoreSuoolierActivity;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.StockListAdapter;
import com.osiris.farmers.view.dialog.BillOflandingDialog;
import com.osiris.farmers.view.dialog.DialogClickListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class StockListFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.rl_right)
    RelativeLayout rl_right;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rl_top_info)
    RelativeLayout rl_top_info;
    @BindView(R.id.rl_top_add_info)
    RelativeLayout rl_top_add_info;
    @BindView(R.id.rl_add_list)
    RelativeLayout rl_add_list;
    @BindView(R.id.rl_input_info)
    RelativeLayout rl_input_info;
    @BindView(R.id.edit_name)
    EditText edit_name;
    @BindView(R.id.edit_num)
    EditText edit_num;
    @BindView(R.id.edit_type)
    EditText edit_type;
    @BindView(R.id.edit_connect)
    EditText edit_connect;
    @BindView(R.id.edit_adress)
    EditText edit_adress;
    @BindView(R.id.edit_phone)
    EditText edit_phone;
    @BindView(R.id.edit_card)
    EditText edit_card;
    @BindView(R.id.tv_booth_num)
    TextView tv_booth_num;

    private StoreSupplier.CustomerBean customerBean;
    private List<StockListData> dataList = new ArrayList<>();
    private StockListAdapter dataAdapter = new StockListAdapter(dataList);
    private List<StoreSupplier.CustomerBean> customer = new ArrayList<>();
    private List<SampleNameData.CommodityBean> commodityList = new ArrayList<>();

    @Override
    protected int setLayout() {
        return R.layout.fragment_stock_list;
    }

    @Override
    protected void initView() {

        dataList.add(new StockListData("紫包菜", "蔬菜", "30斤", "2元", "60元", true));
        dataList.add(new StockListData("紫包菜", "蔬菜", "30斤", "2元", "60元", true));
        dataList.add(new StockListData("紫包菜", "蔬菜", "30斤", "2元", "60元", false));

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        getStoreList();
        getStallName();
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_add, R.id.tv_add, R.id.rl_back, R.id.tv_confirm, R.id.tv_booth_num})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_booth_num:
                Intent intent = new Intent(getActivity(), ChooseStoreSuoolierActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_confirm:
                postStoreInfor();
                break;
            case R.id.rl_add:
                Intent intent1 = new Intent(getActivity(), AddJinhuoListActivity.class);
                intent1.putParcelableArrayListExtra("data_list", (ArrayList<? extends Parcelable>) commodityList);
                intent1.putExtra("jinhuo",customerBean.getUserid());
                startActivity(intent1);
                // showBillOfLandingDetailDialog();
                break;
            case R.id.tv_add:
                rl_back.setVisibility(View.VISIBLE);
                rl_right.setVisibility(View.VISIBLE);
                rl_top_info.setVisibility(View.GONE);
                rl_top_add_info.setVisibility(View.VISIBLE);
                rl_add_list.setVisibility(View.GONE);
                rl_input_info.setVisibility(View.VISIBLE);
                tv_title.setText(getString(R.string.add_new_supplier));
                break;
            case R.id.rl_back:
                rl_back.setVisibility(View.GONE);
                rl_right.setVisibility(View.GONE);
                rl_top_info.setVisibility(View.VISIBLE);
                rl_top_add_info.setVisibility(View.GONE);
                rl_add_list.setVisibility(View.VISIBLE);
                rl_input_info.setVisibility(View.GONE);
                tv_title.setText(getString(R.string.add_bill_of_sales));
                break;
        }
    }

    private void showBillOfLandingDetailDialog() {
        BillOflandingDialog.Builder builder = new BillOflandingDialog.Builder(getActivity());
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


    private void getStoreList() {


        String url = ApiParams.API_HOST + "/app/changecustomer.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userid", String.valueOf(GlobalParams.id));
        //  paramMap.put("customernm","null");
        LogUtils.d("zkf userid:" + String.valueOf(GlobalParams.id));
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf success data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(successResult).getAsJsonObject();
                if (json.has("msg") && json.get("msg").getAsString().equals("ok")) {
                    StoreSupplier data = JsonUtils.fromJson(successResult, StoreSupplier.class);
                    if (null != data.getCustomer() && data.getCustomer().size() > 0) {
                        customer.addAll(data.getCustomer());
                        customerBean = customer.get(0);
                        tv_booth_num.setText(customerBean.getUserid());
                        LogUtils.d("zkf customer size:" + customer.size());
                    }
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }


    private void postStoreInfor() {

        String url = ApiParams.API_HOST + "/app/appcustomerAdd.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userid", String.valueOf(GlobalParams.id));
        paramMap.put("operatorbh", edit_num.getText().toString());
        paramMap.put("opernm", edit_name.getText().toString());
        paramMap.put("type", edit_type.getText().toString());
        paramMap.put("lianxir", edit_connect.getText().toString());
        paramMap.put("address", edit_adress.getText().toString());
        paramMap.put("phone", edit_phone.getText().toString());
        paramMap.put("commoditynm", edit_card.getText().toString());

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf post success data:" + successResult);

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }

    private void getStallName() {

        String url = ApiParams.API_HOST + "/app/xzCommodity.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.currentMarketId));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    LogUtils.d("zkf  successResult:" + successResult);
                    SampleNameData tempData = JsonUtils.fromJson(temp, SampleNameData.class);
                    commodityList.addAll(tempData.getCommodity());

                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(StoreSupplier.CustomerBean customerBean) {
        this.customerBean = customerBean;

        tv_booth_num.setText(customerBean.getUserid());


    }

}
