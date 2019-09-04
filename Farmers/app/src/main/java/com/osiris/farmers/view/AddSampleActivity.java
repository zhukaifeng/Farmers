package com.osiris.farmers.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.osiris.farmers.R;
import com.osiris.farmers.base.ApiContants;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.login.MainActivity;
import com.osiris.farmers.model.CheckProject;
import com.osiris.farmers.model.ChooseStallData;
import com.osiris.farmers.model.SampleNameData;
import com.osiris.farmers.model.TypeSampleTitle;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.adapter.BillOflandProjectSelectAdapter;
import com.osiris.farmers.view.adapter.BillOflandSelectAdapter;
import com.osiris.farmers.view.adapter.BillOflandTypeSelectAdapter;
import com.osiris.farmers.view.adapter.GridImageAdapter;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.widget.FullyGridLayoutManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class AddSampleActivity extends BaseActivity {


    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.iv_close)
    ImageView iv_close;
    @BindView(R.id.edt_price)
    EditText edt_price;
    @BindView(R.id.edt_count)
    EditText edt_count;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.rv_project)
    RecyclerView rv_project;

    private Handler mHandler = new Handler();

    @OnClick({R.id.iv_close,R.id.tv_count_ok})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close:
                finish();
                break;
            case R.id.tv_count_ok:
                LogUtils.d("zkf click ok");
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        uploadPic(selectList.get(0).getCompressPath());
                    }
                });

                break;
        }
    }

    private BillOflandProjectSelectAdapter billOflandProjectSelectAdapter;
    private BillOflandSelectAdapter billOflandSelectAdapter;
    private List<SampleNameData.CommodityBean> dataList = new ArrayList<>();
    private BillOflandTypeSelectAdapter typeSelectAdapter;
    private GridImageAdapter adapter;
    private List<LocalMedia> selectList = new ArrayList<>();

    private List<CheckProject.JcxmBean> checkProjectList = new ArrayList<>();
    private List<SampleNameData.CommodityBean> showDataList = new ArrayList<>();
    private List<TypeSampleTitle> commodityNameList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.activity_add_sample;
    }


    @Override
    public void init() {


        dataList = getIntent().getParcelableArrayListExtra("data_list");
        showDataList.addAll(dataList);
        LogUtils.d("zkf dataList size:" + dataList.size());

        for (SampleNameData.CommodityBean commodityBean : dataList) {
            commodityNameList.add(new TypeSampleTitle(commodityBean.getBeifen(), false));
        }
        Set<TypeSampleTitle> ts = new HashSet<TypeSampleTitle>(commodityNameList);
        commodityNameList.clear();
        commodityNameList.addAll(ts);

        //  removeDuplicate(commodityNameList);
        LogUtils.d("zkf commodityNameList " + commodityNameList.size());
        if (showDataList.size() > 0) {
            showDataList.clear();
        }
        for (SampleNameData.CommodityBean commodityBean : dataList) {
            if (commodityBean.getBeifen().equals(commodityNameList.get(0).getName())) {
                showDataList.add(commodityBean);
            }
        }
        LogUtils.d("zkf showDataList :" + showDataList.size());

        typeSelectAdapter = new BillOflandTypeSelectAdapter(commodityNameList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_type.setLayoutManager(linearLayoutManager);
        rv_type.setAdapter(typeSelectAdapter);
        typeSelectAdapter.notifyDataSetChanged();
        typeSelectAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        billOflandProjectSelectAdapter = new BillOflandProjectSelectAdapter(checkProjectList);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 3);
        rv_project.setLayoutManager(gridLayoutManager1);
        rv_project.setAdapter(billOflandProjectSelectAdapter);
        billOflandProjectSelectAdapter.notifyDataSetChanged();
        billOflandProjectSelectAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogUtils.d("zkf click :" + position);


            }
        });

        billOflandSelectAdapter = new BillOflandSelectAdapter(showDataList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rv_data.setLayoutManager(gridLayoutManager);
        rv_data.setAdapter(billOflandSelectAdapter);
        billOflandSelectAdapter.notifyDataSetChanged();
        billOflandSelectAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogUtils.d("zkf click :" + position);
                for (SampleNameData.CommodityBean commodityBean : showDataList) {
                    for (int i = 0; i < dataList.size(); i++) {
                        if (i == position) {
                            commodityBean.setSelect(true);
                        } else {
                            commodityBean.setSelect(false);
                        }
                    }
                    LogUtils.d("zkf id:" + commodityBean.getId());
                    billOflandSelectAdapter.notifyDataSetChanged();
                }
                getCheckProject(showDataList.get(position).getId());

            }
        });

        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(2);
        recyclerView.setAdapter(adapter);

    }

    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            PictureSelector.create(AddSampleActivity.this)
                    .openGallery(PictureMimeType.ofImage())
                    .theme(R.style.picture_default_style)
                    .maxSelectNum(100)
                    .minSelectNum(1)
                    .imageSpanCount(4)
                    .selectionMode(PictureConfig.MULTIPLE)
                    .previewImage(true)
                    .previewVideo(true)
                    .enablePreviewAudio(false)
                    .isCamera(true)
                    .isZoomAnim(true)
                    .enableCrop(false)
                    .compress(true)
                    .synOrAsy(true)
                    .glideOverride(160, 160)
                    .isGif(true)
                    .openClickSound(false)
                    .selectionMedia(selectList)
                    .minimumCompressSize(100)
                    .forResult(PictureConfig.CHOOSE_REQUEST);
        }

    };

    private void getCheckProject(int id) {

        String url = ApiParams.API_HOST + "/app/xzjcxm.action";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("id", String.valueOf(id));

        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    CheckProject tempData = JsonUtils.fromJson(temp, CheckProject.class);
                    checkProjectList.addAll(tempData.getJcxm());

                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }

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


    private void uploadPic(String path) {
        LogUtils.d("zkf path:" + path);
        String url = ApiContants.HOST + "/app/picUpload";//database
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("database", imageToBase64(path));
        LogUtils.d("zkf imageToBase64(path):" + imageToBase64(path));
        NetRequest.request(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                String temp = successResult.substring(1, successResult.length() - 1);
                if (!TextUtils.isEmpty(successResult)) {
                    LogUtils.d("zkf  successResult:" + successResult);


                }


            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
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
            result = Base64.encodeToString(data, Base64.DEFAULT);
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


}
