package com.osiris.farmers.login.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.login.ForgetPwdActivity;
import com.osiris.farmers.view.PersonalInforActivity;

public class LoginFragment extends BaseFragment {

    private LinearLayout llLoginForget;
    private EditText etLoginUsername;
    private EditText etLoginPassword;
    private Button btnLogin;

    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View view) {
        llLoginForget = (LinearLayout) view.findViewById(R.id.ll_login_forget);
        etLoginUsername = (EditText) view.findViewById(R.id.et_login_username);
        etLoginPassword = (EditText) view.findViewById(R.id.et_login_password);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        llLoginForget.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_login_forget:
                toClass(getActivity(), ForgetPwdActivity.class);
                break;
            case R.id.btn_login:
                Intent intent = new Intent(getActivity(), PersonalInforActivity.class);
                if (etLoginUsername.getText().equals("1")){
                    intent.putExtra("type",1);
                }else if (etLoginUsername.getText().equals("2")){
                    intent.putExtra("type",2);
                }else if (etLoginUsername.getText().equals("3")){
                    intent.putExtra("type",3);
                }
                startActivity(intent);
                break;
        }
    }
}
