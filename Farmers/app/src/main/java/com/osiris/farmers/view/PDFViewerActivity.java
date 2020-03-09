package com.osiris.farmers.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.joanzapata.pdfview.PDFView;
import com.luck.picture.lib.permissions.RxPermissions;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.login.MainActivity;
import com.osiris.farmers.utils.DownloadUtil;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

public class PDFViewerActivity extends BaseActivity {
    @BindView(R.id.pdfview)
    PDFView pdfview;

    private static final OkHttpClient client = new OkHttpClient();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    //调用方法。先请求权限
    public void downloadFile() {
        new RxPermissions(this).request(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            downloadFile(getIntent().getStringExtra("url"));
                        } else {
                            finish();
                        }
                    }
                });
    }

    //下载文件
    private void downloadFile(final String url) {
        DownloadUtil.get().download(url, Environment.getExternalStorageDirectory().getAbsolutePath(), System.currentTimeMillis()+".pdf",
                new DownloadUtil.OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess(File file) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pdfview.fromFile(file)
                                        .defaultPage(1)
                                        .showMinimap(false)
                                        .enableSwipe(true)
                                        .load();
                            }
                        });
                    }

                    @Override
                    public void onDownloading(int progress) {
                    }

                    @Override
                    public void onDownloadFailed(Exception e) {
                        e.printStackTrace();
                    }
                });

    }

    //下载
    private void download(final String url) {
        final long startTime = System.currentTimeMillis();
        Log.i("pdfPath", "startTime=" + startTime);
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 下载失败
                e.printStackTrace();
                Log.i("pdfPath", "download failed");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Sink sink = null;
                BufferedSink bufferedSink = null;
                try {
                    String mSDCardPath = Environment.getExternalStorageDirectory().getAbsolutePath();//SD卡路径
                    String appPath = PDFViewerActivity.this.getFilesDir().getAbsolutePath();//此APP的files路径
                    File dest = new File(appPath, url.substring(url.lastIndexOf("/") + 1));
                    sink = Okio.sink(dest);
                    bufferedSink = Okio.buffer(sink);
                    bufferedSink.writeAll(response.body().source());

                    bufferedSink.close();
                    Log.i("pdfPath", "download success");
                    Log.i("pdfPath", "totalTime=" + (System.currentTimeMillis() - startTime));
                    Log.i("pdfPath", dest.toString());
                    pdfview.fromAsset(dest.toString())
                            .defaultPage(1)
                            .showMinimap(false)
                            .enableSwipe(true)
                            .load();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("pdfPath", "download failed");
                } finally {
                    if (bufferedSink != null) {
                        bufferedSink.close();
                    }
                }
            }
        });
    }

    public static Intent getStartIntent(Context context, String url) {
        return new Intent(context, PDFViewerActivity.class).putExtra("url", url);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_pdf_viewer;
    }

    @Override
    public void init() {
        downloadFile();
    }

    @OnClick(R.id.backbtn)
    public void onClick(View view) {
        finish();
    }
}
