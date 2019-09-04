package com.osiris.farmers.login;

import android.Manifest;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.login.fragment.LoginFragment;
import com.osiris.farmers.login.fragment.RegisterFragment;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvLogin;
    private TextView tvRegister;
    private FrameLayout flLogin;

    private FragmentManager mFragmentManager;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        initData();
        initView();
        initListener();
    }

    private void initData() {
        mFragmentManager = getSupportFragmentManager();
    }

    private void initView() {
        tvLogin = (TextView) findViewById(R.id.tv_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        flLogin = (FrameLayout) findViewById(R.id.fl_login);
        changeView(true);
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(LoginActivity.this);
                } else {
                    Toast.makeText(LoginActivity.this,
                            getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }


    private void initListener() {
        tvLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
            //	Login();

                changeView(true);
                break;

            case R.id.tv_register:
                changeView(false);
                break;
        }
    }


	private void changeView(boolean isLogin) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (isLogin) {
            tvLogin.setBackgroundResource(R.drawable.bg_login_tv_write);
            tvLogin.setTextColor(getResources().getColor(R.color.color_000006));
            tvRegister.setBackgroundResource(R.color.transparent);
            tvRegister.setTextColor(getResources().getColor(R.color.write));
            transaction.replace(R.id.fl_login, new LoginFragment());
        } else {
            tvLogin.setBackgroundResource(R.color.transparent);
            tvLogin.setTextColor(getResources().getColor(R.color.write));
            tvRegister.setBackgroundResource(R.drawable.bg_login_tv_write);
            tvRegister.setTextColor(getResources().getColor(R.color.color_000006));
            transaction.replace(R.id.fl_login, new RegisterFragment());
        }
        transaction.commit();
    }



}
