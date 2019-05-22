package com.osiris.farmers.login;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.utils.T;

public class ForgetPwdActivity extends BaseActivity implements View.OnClickListener {

    private EditText etForgetPhone;
    private TextView tvForgetSend;
    private EditText etForgetCode;
    private EditText etForgetNewPassword;
    private EditText etForgetCheckPassword;
    private Button btnForget;

    private int mCodeTime = 60;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_forget_pwd;
    }

    @Override
    public void init() {
        initView();
        initListener();
    }

    private void initView() {
        etForgetPhone = (EditText) findViewById(R.id.et_forget_phone);
        tvForgetSend = (TextView) findViewById(R.id.tv_forget_send);
        etForgetCode = (EditText) findViewById(R.id.et_forget_code);
        etForgetNewPassword = (EditText) findViewById(R.id.et_forget_new_password);
        etForgetCheckPassword = (EditText) findViewById(R.id.et_forget_check_password);
        btnForget = (Button) findViewById(R.id.btn_forget);
    }

    private void initListener() {
        tvForgetSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_send:
                getCode();
                break;

            case R.id.btn_forget:

                break;
        }
    }

    public void getCode() {
        String phone = etForgetPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
            T.showShort(mActivity, "请输入正确的手机号！");
            return;
        }
        T.showShort(mActivity, "验证码发送成功！");

        tvForgetSend.setEnabled(false);
        tvForgetSend.setTextColor(getResources().getColor(R.color.color_00d39d));
        mCodeTime = 60;
        getCodeTime();
    }

    public void getCodeTime() {
        new Thread() {
            public void run() {
                while (mCodeTime > 0) {
                    mCodeTime--;
                    btnCodeTextHandler.sendEmptyMessage(mCodeTime);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @SuppressLint("HandlerLeak")
    public Handler btnCodeTextHandler = new Handler() {
        @SuppressLint("SetTextI18n")
        public void handleMessage(android.os.Message msg) {
            if (msg.what > 0) {
                tvForgetSend.setText(mCodeTime + "s");
            } else {
                tvForgetSend.setText("重新获取");
                tvForgetSend.setTextColor(getResources().getColor(R.color.color_000006));
                tvForgetSend.setEnabled(true);
            }
        }
    };
}
