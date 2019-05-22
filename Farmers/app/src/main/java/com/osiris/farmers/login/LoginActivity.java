package com.osiris.farmers.login;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.login.fragment.LoginFragment;
import com.osiris.farmers.login.fragment.RegisterFragment;

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
    }

    private void initListener() {
        tvLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
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
