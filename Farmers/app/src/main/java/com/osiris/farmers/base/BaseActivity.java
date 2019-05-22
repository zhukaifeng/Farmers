package com.osiris.farmers.base;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.osiris.farmers.utils.MyActivityUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends FragmentActivity {

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    protected Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        WindowManager manager = getWindowManager();
        Display display = manager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;

        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(flag);
        }

        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        MyActivityUtils.addActivity(this);
        init();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyActivityUtils.removeActivity(this);
    }

    public abstract int getLayoutResId();

    /**
     * 初始化逻辑
     */
    public abstract void init();

    /**
     * 返回上一页
     */
    public void backAction() {
        //finish();
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 跳转
     */
    public void startAction(@SuppressWarnings("rawtypes") Class cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtra("mydata", bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    /**
     * 跳转
     */
    public void startActionWithFinish(@SuppressWarnings("rawtypes") Class cls) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    /**
     * 跳转
     */
    public void startAction(@SuppressWarnings("rawtypes") Class cls) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    /**
     * 跳转
     */
    public void startAction(@SuppressWarnings("rawtypes") Class cls, String key, int id) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(key, id);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void sendMessageToUI(Handler mHandler, int mWhat) {
        mHandler.sendEmptyMessage(mWhat);
    }

    public void sendMessageToUI(Handler mHandler, int mWhat, String mData) {
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("data", mData);
        msg.setData(bundle);
        msg.what = mWhat;
        mHandler.sendMessage(msg);
    }
}
