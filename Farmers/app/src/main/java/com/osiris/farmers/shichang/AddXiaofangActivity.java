package com.osiris.farmers.shichang;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.view.adapter.GridImageAdapter;
import com.osiris.farmers.view.widget.FullyGridLayoutManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

public class AddXiaofangActivity extends BaseActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.edt_content)
    EditText edt_content;
    @BindView(R.id.tv_title)
    TextView tv_title;

    private GridImageAdapter adapter;
    private List<LocalMedia> selectList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.activity_marketcheck;
    }

    @Override
    public void init() {
        tv_title.setText("新增消防");

        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(3);
        recyclerView.setAdapter(adapter);

    }



    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            PictureSelector.create(AddXiaofangActivity.this)
                    .openGallery(PictureMimeType.ofImage()).compress(true).maxSelectNum(3)
                    .forResult(PictureConfig.CHOOSE_REQUEST);
        }

    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("zkf", "kkkkkk");
        System.out.println("zkf sdaddasdaaada");
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


    @OnClick({R.id.tv_ok})
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_ok:

                uploadPic();


                break;
        }
    }

    private void uploadPic() {

      //  http://localhost:8096/wisdom/app/addRichangxc.action?tupianBase64=tupianBase64&resultMsg=jieguo&userId=59&marketId=18
        showLoadDialog();
        String url = ApiParams.API_HOST + "/app/addXiaofangdw.action";//database
        Map<String, String> paramMap = new HashMap<>();

        StringBuffer stringBuffer = new StringBuffer();
        Log.d("zkf"," size:" + selectList.size());
        for (int i= 0;i<selectList.size();i++){
            if (i==selectList.size()-1){
                stringBuffer.append(imageToBase64(selectList.get(i).getCompressPath()));
            }else {
                stringBuffer.append(imageToBase64(selectList.get(i).getCompressPath())).append(",");

            }
        }


        paramMap.put("tupianBase64", "data:image/png;base64," + stringBuffer.toString());
        paramMap.put("name",edt_content.getText().toString());
        paramMap.put("userId", String.valueOf(GlobalParams.id));

        NetRequest.requestBase64(url, ApiRequestTag.DATA, paramMap, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                //String temp = successResult.substring(1, successResult.length() - 1);
                cancelLoadDialog();
                LogUtils.d("zkf temp:" + successResult);
                if (successResult.contains("新增成功")) {
                    LogUtils.d("zkf upload success");
                    Toast.makeText(AddXiaofangActivity.this,"新增成功",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void requestFailure(int tag, int code, String msg) {
                cancelLoadDialog();
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

}
