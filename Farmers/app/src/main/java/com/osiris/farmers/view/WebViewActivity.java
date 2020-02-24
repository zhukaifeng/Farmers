package com.osiris.farmers.view;

import android.app.ProgressDialog;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.network.ApiParams;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import me.jessyan.autosize.utils.LogUtils;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webView)
    WebView mWebView;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_webview;
    }

    @Override
    public void init() {
        loadPDF1();
    }


    //方法1:利用设备自带浏览器打开pdf
    private void loadPDF1() {



        String pdfUrl = ApiParams.API_HOST +"/"+getIntent().getStringExtra("data");
        LogUtils.d("zkf pdfurl:" + pdfUrl);







    }
    private void startDownloadPdf() {
//        final ProgressDialog mDownloadPD = new ProgressDialog(act);
//        mDownloadPD.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        mDownloadPD.setCanceledOnTouchOutside(false);
      //  mDownloadPD.show();
//        ThreadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    FileDownloader.downLoad(pdfUrl, pdfDir, pdfName, mDownloadPD, new FileDownloader.OnDownloadCompleteCallback() {
//
//                        @Override
//                        public void onDownloadComplete(File file) {
//                            mHandler.sendEmptyMessage(SEND_MSG_SUCCESS);
//                        }
//                    });
//                } catch (IOException e) {
//                    mHandler.sendEmptyMessage(SEND_MSG_FAILED);
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    mHandler.sendEmptyMessage(SEND_MSG_FAILED);
//                    e.printStackTrace();
//                } finally {
//                    mDownloadPD.dismiss();
//                }
//
//            }
//        });
    }


}
