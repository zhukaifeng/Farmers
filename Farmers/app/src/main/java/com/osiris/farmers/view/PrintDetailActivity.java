package com.osiris.farmers.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.CheckProject;
import com.osiris.farmers.model.SampleListData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.ZXingUtils;
import com.osiris.farmers.view.adapter.GridImageAdapter;
import com.osiris.farmers.view.widget.FullyGridLayoutManager;
import com.smartdevice.aidl.IZKCService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class PrintDetailActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_market)
    TextView tvMarket;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.tv_price_ok)
    TextView tvPriceOk;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.rl_print)
    RelativeLayout rl_print;

    private SampleListData.CangysjglsBean data;
    private List<LocalMedia> selectList = new ArrayList<>();
    private GridImageAdapter adapter;


    @Override

    public int getLayoutResId() {
        return R.layout.activity_print_detail;
    }

    @Override
    public void init() {
        data = getIntent().getParcelableExtra("data");
        if (null != data) {
            tvId.setText(String.valueOf(data.getId()));
            tvMarket.setText(data.getComname());
            tvNum.setText(data.getSczhutfl());
            tvType.setText(data.getYpbh());
            tvTime.setText(data.getLlrq().substring(0, 10));
            Bitmap bitmap = ZXingUtils.createQRImage(String.valueOf(data.getId()), 200, 200);
            ivCode.setImageBitmap(bitmap);

        }
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(1);
        recyclerView.setAdapter(adapter);
       bindService();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_back, R.id.tv_price_ok,R.id.rl_upload,R.id.tv_upload_pic})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.rl_back:

                break;
            case R.id.tv_price_ok:
                String title = "";

                String text = "样品编码:" + data.getId()
                        + "\n";
                if (!TextUtils.isEmpty(data.getComname()) && !TextUtils.isEmpty(data.getSczhutfl())) {
                    title = text + data.getComname() + " 摊位号:" + data.getSczhutfl()
                            + "\n";
                }
                if (!TextUtils.isEmpty(data.getYpbh())) {
                    title = title + "样品名称:" + data.getYpbh()
                            + "\n";
                }
                StringBuffer stringBuffer = new StringBuffer();
//                for (CheckProject.JcxmBean jcxmBean : checkProjectList) {
//                    if (jcxmBean.isSelect()) {
//                        stringBuffer.append(jcxmBean.getJcmc()).append("\n");
//                    }
//                }
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    title = title + "检测项目:" + stringBuffer.toString();
                } else {
                    title = title + "检测项目:自选"
                            + "\n";
                }


                title = title + "时间:" + data.getLlrq()
                        + "\n"+"检测员:" + GlobalParams.username;



                //"检测项目:" + printJcmName
                //                        + "\n";

                try {
                    if (!TextUtils.isEmpty(title)) {
                        mIzkcService.printGBKText(title);
                    }
                } catch (RemoteException e) {
                    Log.e("", "远程服务未连接...");
                    e.printStackTrace();
                }
                printPic();
                String text2 = "\n" + "\n"+ "\n";
                try {
                    mIzkcService.printGBKText(text2);
                } catch (RemoteException e) {
                    Log.e("", "远程服务未连接...");
                    e.printStackTrace();
                }
                break;
            case R.id.rl_upload:
                if (selectList.size()==0){
                    Toast.makeText(this,"请拍照",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_upload_pic:
                if (selectList.size()==0){
                    Toast.makeText(PrintDetailActivity.this,"请拍照",Toast.LENGTH_SHORT).show();
                    return;
                }
                showLoadDialog();
                uploadTwoBeforePic(selectList.get(0).getCompressPath());
                break;
            default:

                break;
        }
    }



    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            PictureSelector.create(PrintDetailActivity.this)
                    .openCamera(PictureMimeType.ofImage()).compress(true)
                    .forResult(PictureConfig.CHOOSE_REQUEST);
        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (LocalMedia media : selectList) {
                        Log.i("图片-----》", media.getPath());
                    }
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
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
        bindService(intent, mServiceConn, Context.BIND_AUTO_CREATE);
    }

    private void printPic() {
        Bitmap mBitmap = ZXingUtils.createQRImage(String.valueOf(data.getId()), 200, 200);

        if (mBitmap != null) {
            /*switch (imageType) {
                case 0:
                    mIzkcService.printBitmap(mBitmap);
                    break;
                case 1:
                    mIzkcService.printImageGray(mBitmap);
                    break;
                case 2:
                    mIzkcService.printRasterImage(mBitmap);
                    break;
            }*/
            LogUtils.d("zkf sss1111ssss");
            ivCode.setImageBitmap(mBitmap);
            try {
                mIzkcService.printBitmap(mBitmap);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

//				if (autoOutputPaper) {
//					mIzkcService.generateSpace();
//				}
        }else {
            LogUtils.d("zkf sssssss");
        }
    }

    private Bitmap createViewBitmap(View v) {
        v.clearFocus();
        v.setPressed(false);
        boolean willNotCache = v.willNotCacheDrawing();
        v.setWillNotCacheDrawing(false);
        int color = v.getDrawingCacheBackgroundColor();
        v.setDrawingCacheBackgroundColor(0);
        if (color != 0) {
            v.destroyDrawingCache();
        }
        v.buildDrawingCache();
        Bitmap cacheBitmap = v.getDrawingCache();
        if (cacheBitmap == null) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
        v.destroyDrawingCache();
        v.setWillNotCacheDrawing(willNotCache);
        v.setDrawingCacheBackgroundColor(color);
        return bitmap;
    }


    public static String imageToBase64(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        InputStream is = null;
        byte[] data = null;
        String result = null;
        try {
            is = new FileInputStream(path);
            //创建一个字符流大小的数组。
            data = new byte[is.available()];
            //写入数组
            is.read(data);
            //用默认的编码格式进行编码
            result = Base64.encodeToString(data, Base64.NO_WRAP);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

    private void uploadTwoBeforePic(String path) {

        String url = ApiParams.API_HOST + "/app/picUpload.action";//database

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("database", "data:image/png;base64," + imageToBase64(path));
        NetRequest.requestBase64(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);

                LogUtils.d("zkf temp:" + successResult);
                if (successResult.contains("png")) {
                    uploadTwoPic(successResult);
                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });


    }


    private void uploadTwoPic(String path) {
        String url = ApiParams.API_HOST + "/app/uploadTwoPic.action";//database

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("pic", path);
        paramMap.put("id", String.valueOf(data.getId()));
        NetRequest.requestBase64(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                LogUtils.d("zkf temp:" + successResult);
                Toast.makeText(PrintDetailActivity.this,"照片上传成功",Toast.LENGTH_SHORT).show();
                cancelLoadDialog();

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
            }
        });


    }

}
