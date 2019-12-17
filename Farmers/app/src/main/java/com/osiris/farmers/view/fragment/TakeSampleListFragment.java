package com.osiris.farmers.view.fragment;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.BitmapDrawable;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.event.BoothgEvent;
import com.osiris.farmers.event.MarketEvent;
import com.osiris.farmers.event.RefreshEvent;
import com.osiris.farmers.model.ChooseStallData;
import com.osiris.farmers.model.GoodsType;
import com.osiris.farmers.model.Market;
import com.osiris.farmers.model.SampleListData;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.model.TakeSampleList;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.AddSampleActivity;
import com.osiris.farmers.view.ChooseMarketActivity;
import com.osiris.farmers.view.ChooseStallNoActivity;
import com.osiris.farmers.view.PrintDetailActivity;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.TakeSampleListAdapter;
import com.osiris.farmers.view.adapter.TypeGoodsAdapter;
import com.osiris.farmers.view.dialog.BillOflandingDialog;
import com.osiris.farmers.view.dialog.DialogClickListener;
import com.smartdevice.aidl.IZKCService;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import me.jessyan.autosize.utils.LogUtils;

public class TakeSampleListFragment extends BaseFragment {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.linear_list)
    LinearLayout linear_list;
    @BindView(R.id.linear_add)
    LinearLayout linear_add;
    @BindView(R.id.iv_function)
    ImageView iv_function;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;

    @BindView(R.id.rl_type)
    RelativeLayout rl_type;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;
    @BindView(R.id.iv_select_arrow)
    ImageView iv_select_arrow;
    @BindView(R.id.tv_shop_num)
    TextView tv_shop_num;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.tv_market_name)
    TextView tv_market_name;


    private List<GoodsType.DescriptionBean> typeList = new ArrayList<>();
    private TypeGoodsAdapter typeAdapter = new TypeGoodsAdapter(typeList);
    public static final int REQUEST_A = 1;


    private List<TakeSampleList> dataList = new ArrayList<>();
    private PopupWindow popupWindow;

    private List<ChooseStallData.BoothglBean> stallList = new ArrayList<>();
    private List<String> stallNameList = new ArrayList<>();

    private List<SampleNameData.CommodityBean> commodityList = new ArrayList<>();

    private List<SampleListData.CangysjglsBean> cangysjglsList = new ArrayList<>();
    private TakeSampleListAdapter dataAdapter = new TakeSampleListAdapter(cangysjglsList);

    //线程运行标志 the running flag of thread
    private boolean runFlag = true;
    //打印机检测标志 the detect flag of printer
    private boolean detectFlag = false;
    //打印机连接超时时间 link timeout of printer
    private float PINTER_LINK_TIMEOUT_MAX = 30 * 1000L;
    //标签打印标记 the flag of tag print
    private boolean autoOutputPaper = false;

    private int pageNum = 1;
    private int pageCount = 8;
    private int countGetData = 0;

    private ChooseStallData.BoothglBean boothglBean = new ChooseStallData.BoothglBean();


    @Override
    protected int setLayout() {
        return R.layout.fragment_sample;
    }

    @Override
    protected void initView() {

        tv_market_name.setText(GlobalParams.currentMarkrtName);
        rv_type.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv_type.setAdapter(typeAdapter);
        typeAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (GoodsType.DescriptionBean dateModel : typeList) {
                    dateModel.setClicked(false);
                }
                typeList.get(position).setClicked(true);
                typeAdapter.notifyDataSetChanged();


            }
        });
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                previousTotal = 0;
                pageNum = 1;
                getData();

            }
        });
//		dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));
//		dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));
//		dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));
//		dataList.add(new TakeSampleList(0123456, "牛肉", "10斤", "2019.03.20"));

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), PrintDetailActivity.class);
                intent.putExtra("data", cangysjglsList.get(position));
                startActivity(intent);

            }
        });
        final LinearLayoutManager manager = (LinearLayoutManager) rv_data
                .getLayoutManager();
        rv_data.addOnScrollListener(new EndLessOnScrollListener(manager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
        ((SimpleItemAnimator) rv_data.getItemAnimator()).setSupportsChangeAnimations(false);
        getData();

        getGoodsType();
        getStallNo();
        bindService();
        getStallName();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(RefreshEvent boothglBean) {
        refreshLayout.setRefreshing(true);
        previousTotal = 0;
        pageNum = 1;
        getData();
    }

    private void getGoodsType() {

        String url = ApiParams.API_HOST + "/app/xzDescription.action";
        Map<String, String> paramMap = new HashMap<>();

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    GoodsType tempData = JsonUtils.fromJson(temp, GoodsType.class);
                    if (typeList.size() > 0) typeList.clear();
                    typeList.addAll(tempData.getDescription());
                    typeAdapter.notifyDataSetChanged();

                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        LogUtils.d("zkf position:");
        switch (requestCode) {
            case REQUEST_A:
                int position = intent.getExtras().getInt("position", 0);
                LogUtils.d("zkf position:" + position);
                tv_shop_num.setText(stallNameList.get(position));
                break;
        }


    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.iv_function, R.id.rl_back, R.id.tv_type, R.id.rl_select, R.id.tv_market_name})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_function:
//				linear_add.setVisibility(View.VISIBLE);
//				iv_function.setBackgroundResource(R.drawable.bg_qr);
//				rl_back.setVisibility(View.VISIBLE);
//				for (TakeSampleList takeSampleList : dataList) {
//					takeSampleList.setDelete(true);
//				}
//				dataAdapter.notifyDataSetChanged();

                if (stallNameList.size() == 0) {
                    Toast toast = Toast.makeText(getActivity(), "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }


                Intent intent = new Intent(getActivity(), AddSampleActivity.class);
                intent.putParcelableArrayListExtra("data_list", (ArrayList<? extends Parcelable>) commodityList);
                intent.putExtra("boothglid", boothglBean.getId());
                if (!TextUtils.isEmpty(tv_shop_num.getText().toString())) {
                    intent.putExtra("stall_name", tv_shop_num.getText().toString());
                }
                LogUtils.d("zkf boothglid222222:" + boothglBean.getId());
                startActivity(intent);
                //	showBillOfLandingDetailDialog();

                break;
            case R.id.rl_back:
                linear_add.setVisibility(View.GONE);
                iv_function.setBackgroundResource(R.drawable.bg_add);
                rl_back.setVisibility(View.GONE);
                for (TakeSampleList takeSampleList : dataList) {
                    takeSampleList.setDelete(false);
                }
                dataAdapter.notifyDataSetChanged();

                break;
            case R.id.tv_type:
                if (rl_type.getVisibility() == View.VISIBLE) {
                    rl_type.setVisibility(View.GONE);
                    iv_select_arrow.setVisibility(View.GONE);
                } else {
                    rl_type.setVisibility(View.VISIBLE);
                    iv_select_arrow.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.rl_select:
                Log.d("zkf", "click");
                if (stallNameList.size() == 0) {
                    Toast toast = Toast.makeText(getActivity(), "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }

                Intent i = new Intent(getActivity(), ChooseStallNoActivity.class);
                getActivity().startActivityForResult(i, REQUEST_A);

                //	startActivityForResult(i, REQUEST_A);


				/*String text = "---------------" +
						"lllllllllllllllllllll" +
						"=====================" +
						"+++++++++++++++++++++" +
						"666666666666666666666";
				try {
//			mIzkcService.printerInit();
//			mIzkcService.sendRAWData("printer", new byte[] { 0x1E, 0x04, 0x00, (byte) 0xBF, (byte) 0xD8, (byte) 0xD6, (byte) 0xC6});
					mIzkcService.printGBKText(text);
//			mIzkcService.printGBKText("\nАа Бб Вв Гг Дд  Ее Ёё  Жж Зз Ии Йй Кк Лл Мм Нн Оо Пп Рр Сс Тт Уу Фф Хх Цц Чч Шш Щщ ъ ы ь Ээ Юю Яя\n");
				//	mIzkcService.generateSpace();

				} catch (RemoteException e) {
					LogU.e("", "远程服务未连接...");
					e.printStackTrace();
				}
				showPopwindow();*/
                break;
            case R.id.tv_market_name:
                Intent intent1 = new Intent(getActivity(), ChooseMarketActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }


    private void getData() {
        String url = ApiParams.API_HOST + "/app/showAllCysjxz.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pageNo", String.valueOf(pageNum));
        paramMap.put("pageSize", String.valueOf(pageCount));
        paramMap.put("id", String.valueOf(GlobalParams.id));
        if (pageNum > 1) {
            showLoadDialog();
        }


        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {

            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    SampleListData tempData = JsonUtils.fromJson(successResult, SampleListData.class);
                    countGetData = tempData.getCangysjgls().size();
                    if (pageNum == 1) {
                        cangysjglsList.clear();
                    }
                    cangysjglsList.addAll(tempData.getCangysjgls());
                    LogUtils.d("zkf cangysjglsList:" + cangysjglsList.size());
                    dataAdapter.notifyDataSetChanged();
                    refreshLayout.setRefreshing(false);
                    cancelLoadDialog();
                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                refreshLayout.setRefreshing(false);
                cancelLoadDialog();
            }
        });

    }


    private void showPopwindow() {
        contentView = LayoutInflater.from(getActivity()).inflate(
                R.layout.layout_choose_stall, null);

        ListView list_data = contentView.findViewById(R.id.list_data);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                android.R.id.text1, stallNameList);
        list_data.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);// 取得焦点
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);

    }


    private void getStallNo() {

        String url = ApiParams.API_HOST + "/app/xzboothgl.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(GlobalParams.currentMarketId));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    ChooseStallData tempData = JsonUtils.fromJson(temp, ChooseStallData.class);
                    if (stallList.size() > 0) stallList.clear();
                    stallList.addAll(tempData.getBoothgl());
                    if (stallNameList.size() > 0) stallNameList.clear();
                    for (ChooseStallData.BoothglBean boothglBean : stallList) {
                        stallNameList.add(boothglBean.getTwhmc());
                    }
                    if (null != stallList && stallList.size() > 0) {
                        boothglBean = stallList.get(0);
                        if (stallNameList.size() > 0) {
                            tv_shop_num.setText(stallNameList.get(0));
                        }
                        getCheckProject();
                    } else {
                        tv_shop_num.setText("");
                        Toast toast = Toast.makeText(getActivity(), "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        return;

                    }


                } else {

                    tv_shop_num.setText("");
                    Toast toast = Toast.makeText(getActivity(), "此菜市场暂无摊位,请重新选择菜市场", Toast.LENGTH_SHORT);
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

    public static IZKCService mIzkcService;
    private ServiceConnection mServiceConn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIzkcService = IZKCService.Stub.asInterface(service);
            if (mIzkcService != null) {
                try {
                    //获取产品型号 get product model
                    DEVICE_MODEL = mIzkcService.getDeviceModel();
                    //设置当前模块 set current function module
                    mIzkcService.setModuleFlag(module_flag);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public static int DEVICE_MODEL = 0;
    public static int module_flag = 0;

    public void bindService() {
        //com.zkc.aidl.all为远程服务的名称，不可更改
        //com.smartdevice.aidl为远程服务声明所在的包名，不可更改，
        // 对应的项目所导入的AIDL文件也应该在该包名下
        Intent intent = new Intent("com.zkc.aidl.all");
        intent.setPackage("com.smartdevice.aidl");
        getActivity().bindService(intent, mServiceConn, Context.BIND_AUTO_CREATE);
    }

	/*class DetectPrinterThread extends Thread {
		@Override
		public void run() {
			super.run();
			while (runFlag) {
				float start_time = SystemClock.currentThreadTimeMillis();
				float end_time = 0;
				float time_lapse = 0;
				if (detectFlag) {
					//检测打印是否正常 detect if printer is normal
					try {
						if (mIzkcService != null) {
							String printerSoftVersion = mIzkcService.getFirmwareVersion1();
							if (TextUtils.isEmpty(printerSoftVersion)) {
								mIzkcService.setModuleFlag(module_flag);
								end_time = SystemClock.currentThreadTimeMillis();
								time_lapse = end_time - start_time;
//								enableOrDisEnableKey(false);
								if (time_lapse > PINTER_LINK_TIMEOUT_MAX) {
									detectFlag = false;
									//打印机连接超时 printer link timeout
									sendEmptyMessage(MessageType.BaiscMessage.PRINTER_LINK_TIMEOUT);
								}
							} else {
								//打印机连接成功 printer link success
								sendMessage(MessageType.BaiscMessage.DETECT_PRINTER_SUCCESS, printerSoftVersion);
								detectFlag = false;
							}
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}

				}
				SystemClock.sleep(1);
			}
		}
	}*/


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

        builder.setDataBillList(commodityList);

        builder.setNegativeButton(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(BoothgEvent boothglBean) {
        this.boothglBean.setId(boothglBean.getId());
        this.boothglBean.setMarketid(boothglBean.getMarketid());
        this.boothglBean.setTwhmc(boothglBean.getTwhmc());

        tv_shop_num.setText(boothglBean.getTwhmc());
        getCheckProject();


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMarketData(MarketEvent marketEvent) {
        LogUtils.d("zkf receive 222222");
        GlobalParams.currentMarketId = marketEvent.getMarketId();
        tv_market_name.setText(marketEvent.getMarketName());
        GlobalParams.currentMarkrtName = marketEvent.getMarketName();
        getStallName();
        getStallNo();

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
                    if (commodityList.size() > 0) {
                        commodityList.clear();
                    }
                    commodityList.addAll(tempData.getCommodity());

                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }


    private void getCheckProject() {

        String url = ApiParams.API_HOST + "/app/xzjcxm.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(boothglBean.getId()));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    LogUtils.d("zkf 222 successResult:" + successResult);
//					SampleNameData tempData = JsonUtils.fromJson(temp, SampleNameData.class);
//					commodityList.addAll(tempData.getCommodity());


                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });

    }

    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;


    public abstract class EndLessOnScrollListener extends RecyclerView.OnScrollListener {

        //声明一个LinearLayoutManager
        private LinearLayoutManager mLinearLayoutManager;

        //当前页，从0开始    private int currentPage = 0;
        //已经加载出来的Item的数量
        private int totalItemCount;

        //在屏幕上可见的item数量
        private int visibleItemCount;

        //在屏幕可见的Item中的第一个
        private int firstVisibleItem;

        //是否正在上拉数据
        private boolean loading = true;

        public EndLessOnScrollListener(LinearLayoutManager linearLayoutManager) {
            this.mLinearLayoutManager = linearLayoutManager;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            visibleItemCount = recyclerView.getChildCount();
            totalItemCount = mLinearLayoutManager.getItemCount();
            firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                }
            }

            if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem) {
                // pageCount ++;
                onLoadMore(pageCount);
                loading = true;
            }
        }

        /**
         * 提供一个抽闲方法，在Activity中监听到这个EndLessOnScrollListener
         * 并且实现这个方法
         */
        public abstract void onLoadMore(int currentPage);
    }

    private void loadMoreData() {
        pageNum++;
        getData();
    }


}
