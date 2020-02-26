package com.osiris.farmers.goods.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.adapter.BaseAdapter;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.event.BoothgEvent;
import com.osiris.farmers.model.ListResponse;
import com.osiris.farmers.model.Product;
import com.osiris.farmers.model.Response;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.model.StockListData;
import com.osiris.farmers.model.StoreSupplier;
import com.osiris.farmers.model.SupplyerBean;
import com.osiris.farmers.model.SuyuanJinDetail;
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
import com.osiris.farmers.view.adapter.SimpleProdAdapter;
import com.osiris.farmers.view.adapter.SimpleSupplyerAdapter;
import com.osiris.farmers.view.adapter.StockListAdapter;
import com.osiris.farmers.view.dialog.AddCustomerDialog;
import com.osiris.farmers.view.dialog.DialogClickListener;
import com.osiris.farmers.view.dialog.InputProNumDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Calendar;
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
    //    @BindView(R.id.tv_title)
//    TextView tv_title;
    @BindView(R.id.rl_top_info)
    RelativeLayout rl_top_info;
    @BindView(R.id.rl_top_add_info)
    RelativeLayout rl_top_add_info;
    @BindView(R.id.rl_add_list)
    RelativeLayout rl_add_list;
    @BindView(R.id.tv_market)
    TextView tv_market;
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
    @BindView(R.id.prod_list_container)
    View prod_list_container;
    @BindView(R.id.prod_list)
    RecyclerView prod_list;
    @BindView(R.id.customer_container)
    View customer_container;
    @BindView(R.id.cus_list)
    RecyclerView cus_list;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.total_price)
    TextView total_price;
    private TextWatcher inputTextWatcher;

    private StoreSupplier.CustomerBean customerBean;
    private List<StockListData> dataList = new ArrayList<>();
    private StockListAdapter dataAdapter = new StockListAdapter(dataList);
    private List<StoreSupplier.CustomerBean> customer = new ArrayList<>();
    private List<SampleNameData.CommodityBean> commodityList = new ArrayList<>();
    private SimpleProdAdapter prodAdapter;
    private SimpleSupplyerAdapter supplyerAdapter;
    private Product product;

    @Override
    protected int setLayout() {
        return R.layout.fragment_stock_list;
    }

    @Override
    protected void initView() {

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        dataAdapter.setOnDeleteClickListener(new StockListAdapter.OnDeleteClickListener() {
            @Override
            public void onDeleteClick(int position) {
                dataList.remove(position);
                dataAdapter.notifyDataSetChanged();
                calculateTotalPrice();
            }
        });
        getStallName();
        prodAdapter = new SimpleProdAdapter(getActivity());
        prod_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        prod_list.setAdapter(prodAdapter);
        supplyerAdapter = new SimpleSupplyerAdapter(getActivity());
        cus_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        cus_list.setAdapter(supplyerAdapter);
        prodAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                tv_booth_num.removeTextChangedListener(inputTextWatcher);
                product = prodAdapter.getItem(position);
                tv_booth_num.setText(prodAdapter.getItem(position).getCommoditynm());
                prod_list_container.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initTextWatcher();
                        tv_booth_num.addTextChangedListener(inputTextWatcher);
                    }
                }, 2000);
            }
        });
        supplyerAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                customerBean = supplyerAdapter.getItem(position);
                tv_market.setText(customerBean.getCommoditynm());
                customer_container.setVisibility(View.GONE);
            }
        });
        initTextWatcher();
        tv_booth_num.addTextChangedListener(inputTextWatcher);
    }

    private void initTextWatcher() {
        inputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updateSearchProd(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    private void updateSearchProd(String prod) {
        String url = ApiParams.API_HOST + "/app/getAllommodityByName.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("commodityNm", prod);
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(successResult).getAsJsonObject();
                if (json.has("data")) {
                    Product[] dataBeans = JsonUtils.fromJson(json.get("data"), Product[].class);
                    if (dataBeans != null && dataBeans.length > 0) {
                        prod_list_container.setVisibility(View.VISIBLE);
                        prodAdapter.setDatas(dataBeans);
                    } else {
                        prod_list_container.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    private String getFormatNum(int num) {
        return num >= 10 ? String.valueOf(num) : ("0" + num);
    }

    @OnClick({R.id.rl_add, R.id.tv_add, R.id.rl_back, R.id.tv_confirm, R.id.tv_booth_num, R.id.tv_market, R.id.tv_time, R.id.add_prod, R.id.btn_save})
    void onClick(View v) {
        switch (v.getId()) {
//            case R.id.tv_booth_num:
//                Intent intent = new Intent(getActivity(), ChooseStoreSuoolierActivity.class);
//                startActivity(intent);
//                break;
            case R.id.btn_save:
                if (dataList == null || dataList.size() <= 0) {
                    Toast.makeText(getActivity(), "请先添加商品", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (customerBean==null){
                    Toast.makeText(getActivity(), "请先选择客户", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder(ApiParams.API_HOST).append("/app/jyhStorageAdd.action?");
                stringBuilder.append("userId=").append(String.valueOf(GlobalParams.id));
                for (int i = 0; i < dataList.size(); i++) {
                    StockListData item = dataList.get(i);
                    stringBuilder.append("&data[]=").append(item.getName()).append("，").append(item.getCusNo()).append("，")
                            .append(item.getCount()).append("，").append(item.getPrice()).append("，").append(item.getTime())
                            .append("，").append(item.getId()).append("，").append(item.getCusId());
                }

                NetRequest.request(stringBuilder.toString(), ApiRequestTag.DATA, new HashMap<>(), new NetRequestResultListener() {

                    @Override
                    public void requestSuccess(int tag, String successResult) {
                        if (successResult != null && successResult.contains("message") && successResult.contains("成功")) {
                            Toast.makeText(getActivity(), "添加成功！", Toast.LENGTH_SHORT).show();
                            getActivity().finish();
                        }
                    }

                    @Override
                    public void requestFailure(int tag, int code, String msg) {
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.tv_market:
                getStoreList();
                break;
            case R.id.tv_confirm:
                postStoreInfor();
                break;
            case R.id.add_prod:
                if (product == null) {
                    Toast.makeText(getActivity(), "请选择商品", Toast.LENGTH_SHORT).show();
                    return;
                }
                InputProNumDialog.Builder prodNumDialog = new InputProNumDialog.Builder(getActivity());
                prodNumDialog.setOnSaveClickListener(new InputProNumDialog.Builder.OnSaveClickListener() {
                    @Override
                    public void onSaveClick(int prodNum, double prodPrice) {

                        dataList.add(new StockListData(product.getId(), product.getCommoditynm(), product.getDescriptionnm()
                                , prodNum, prodPrice, prodNum * prodPrice, true, customerBean.getUserid()
                                , tv_time.getText().toString(), customerBean.getId()));
                        dataAdapter.notifyDataSetChanged();
                        calculateTotalPrice();
                    }
                });
                prodNumDialog.create().show();
                break;
            case R.id.tv_time:
                Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tv_time.setText(i + "-" + getFormatNum(i1 + 1) + "-" + getFormatNum(i2));
                    }
                }, calendar.get(Calendar.YEAR) - 5, 1, 1).show();
                break;
            case R.id.rl_add:
                Intent intent1 = new Intent(getActivity(), AddJinhuoListActivity.class);
                intent1.putParcelableArrayListExtra("data_list", (ArrayList<? extends Parcelable>) commodityList);
                intent1.putExtra("jinhuo", customerBean.getUserid());
                startActivity(intent1);
                break;
            case R.id.tv_add:
//                rl_back.setVisibility(View.VISIBLE);
//                rl_right.setVisibility(View.VISIBLE);
//                rl_top_info.setVisibility(View.GONE);
//                rl_top_add_info.setVisibility(View.VISIBLE);
//                rl_add_list.setVisibility(View.GONE);
//                c.setVisibility(View.VISIBLE);
//                tv_title.setText(getString(R.string.add_new_supplier));
                AddCustomerDialog.Builder dialogBuilder = new AddCustomerDialog.Builder(getActivity());
                dialogBuilder.setOnSaveClickListener(new AddCustomerDialog.Builder.OnSaveClickListener() {
                    @Override
                    public void onSaveClick(String cusNo, String cusName, String cusType, String cusLink
                            , String cusPhone, String cusAddr, String cusLicense) {
                        String url = ApiParams.API_HOST + "/app/customerAdd.action";
                        Map<String, String> paramMap = new HashMap<>();
                        paramMap.put("operatorbh", cusNo);
                        paramMap.put("opernm", cusName);
                        paramMap.put("type", cusType);
                        paramMap.put("lianxir", cusLink);
                        paramMap.put("phone", cusPhone);
                        paramMap.put("address", cusAddr);
                        paramMap.put("commoditynm", cusName);
                        paramMap.put("userId", String.valueOf(GlobalParams.id));
                        NetRequest.request(url, ApiRequestTag.ADD_CUSTOMER, paramMap, new NetRequestResultListener() {
                            @Override
                            public void requestSuccess(int tag, String successResult) {
                                if (!TextUtils.isEmpty(successResult)) {
                                    JsonParser parser = new JsonParser();
                                    JsonObject json = parser.parse(successResult).getAsJsonObject();
                                    if (json.has("message") && "1".equals(JsonUtils.fromJson(json.get("message"), String.class))) {
                                        Toast.makeText(getActivity(), "添加成功", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void requestFailure(int tag, int code, String msg) {
                                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                dialogBuilder.create().show();
                break;
            case R.id.rl_back:
                rl_back.setVisibility(View.GONE);
                rl_right.setVisibility(View.GONE);
                rl_top_info.setVisibility(View.VISIBLE);
                rl_top_add_info.setVisibility(View.GONE);
                rl_add_list.setVisibility(View.VISIBLE);
                rl_input_info.setVisibility(View.GONE);
//                tv_title.setText(getString(R.string.add_bill_of_sales));
                break;
        }
    }

    private void calculateTotalPrice() {
        double totalPrice = 0;
        for (StockListData data :
                dataList) {
            totalPrice += data.getTotal();
        }
        total_price.setText(totalPrice + "元");
    }


    private void getStoreList() {


//        String url = ApiParams.API_HOST + "/app/changecustomer.action";
//        Map<String, String> paramMap = new HashMap<>();
//        paramMap.put("userid", String.valueOf(GlobalParams.id));
//        //  paramMap.put("customernm","null");
//        LogUtils.d("zkf userid:" + String.valueOf(GlobalParams.id));
//        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
//            @Override
//            public void requestSuccess(int tag, String successResult) {
//                LogUtils.d("zkf success data:" + successResult);
//                JsonParser parser = new JsonParser();
//                JsonObject json = parser.parse(successResult).getAsJsonObject();
//
//                if (json.has("msg") && json.get("msg") != null && json.get("msg").getAsString().equals("ok")) {
//                    StoreSupplier data = JsonUtils.fromJson(successResult, StoreSupplier.class);
//                    if (null != data.getCustomer() && data.getCustomer().size() > 0) {
//                        customer.addAll(data.getCustomer());
//                        customerBean = customer.get(0);
//                        tv_booth_num.setText(customerBean.getUserid());
//                        LogUtils.d("zkf customer size:" + customer.size());
//                    }
//                }
//            }
//
//            @Override
//            public void requestFailure(int tag, int code, String msg) {
//
//            }
//        });
        String url = ApiParams.API_HOST + "/app/getAllCustomerByUserId.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", String.valueOf(GlobalParams.id));
        //  paramMap.put("customernm","null");
        LogUtils.d("zkf userid:" + String.valueOf(GlobalParams.id));
        NetRequest.getRequest(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                LogUtils.d("zkf success data:" + successResult);
                JsonParser parser = new JsonParser();
                JsonObject json = parser.parse(successResult).getAsJsonObject();

                if (json.has("message") && json.get("message") != null && json.get("message").getAsString().equals("1")) {
                    StoreSupplier.CustomerBean[] dataBeans = JsonUtils.fromJson(json.get("data"), StoreSupplier.CustomerBean[].class);
                    if (null != dataBeans && dataBeans.length > 0) {
                        LogUtils.d("zkf customer size:" + dataBeans.length);
                        supplyerAdapter.setDatas(dataBeans);
                        customer_container.setVisibility(View.VISIBLE);
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
