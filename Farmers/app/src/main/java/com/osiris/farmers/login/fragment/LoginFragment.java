package com.osiris.farmers.login.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.login.ForgetPwdActivity;
import com.osiris.farmers.login.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    @BindView(R.id.ll_login_forget)
    LinearLayout llLoginForget;
    @BindView(R.id.et_login_username)
    EditText etLoginUsername;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ll_login_forget, R.id.btn_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_login_forget:
                toClass(getActivity(), ForgetPwdActivity.class);
                break;
            case R.id.btn_login:
                Intent intent = new Intent(getActivity(), HomeActivity.class);

                if (TextUtils.isEmpty(etLoginUsername.getText().toString())) {
                    intent.putExtra("type", 2);
                } else {
                    if (Integer.parseInt(etLoginUsername.getText().toString()) == 1) {
                        intent.putExtra("type", 1);
                    } else if (Integer.parseInt(etLoginUsername.getText().toString()) == 2) {
                        intent.putExtra("type", 2);
                    } else if (Integer.parseInt(etLoginUsername.getText().toString()) == 3) {
                        intent.putExtra("type", 3);
                    }
                }


                startActivity(intent);
                break;
        }
    }
}
