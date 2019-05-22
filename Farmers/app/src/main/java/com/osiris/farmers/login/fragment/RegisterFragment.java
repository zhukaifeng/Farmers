package com.osiris.farmers.login.fragment;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.utils.T;

public class RegisterFragment extends BaseFragment {
    private RelativeLayout rlRegFirst;
    private EditText etRegPhone;
    private TextView tvRegSend;
    private EditText etRegCode;
    private EditText etRegPassword;
    private EditText etRegCheckPassword;
    private Button btnRegNext;
    private RelativeLayout rlRegSound;
    private EditText etRegMerchant;
    private EditText etRegCorporation;
    private EditText etRegOrganize;
    private TextView etRegCheckScan;
    private Button btnRegSubmit;

    private int mCodeTime = 60;

    @Override
    protected int setLayout() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView(View view) {
        rlRegFirst = (RelativeLayout) view.findViewById(R.id.rl_reg_first);
        etRegPhone = (EditText) view.findViewById(R.id.et_reg_phone);
        tvRegSend = (TextView) view.findViewById(R.id.tv_reg_send);
        etRegCode = (EditText) view.findViewById(R.id.et_reg_code);
        etRegPassword = (EditText) view.findViewById(R.id.et_reg_password);
        etRegCheckPassword = (EditText) view.findViewById(R.id.et_reg_check_password);
        btnRegNext = (Button) view.findViewById(R.id.btn_reg_next);
        rlRegSound = (RelativeLayout) view.findViewById(R.id.rl_reg_sound);
        etRegMerchant = (EditText) view.findViewById(R.id.et_reg_merchant);
        etRegCorporation = (EditText) view.findViewById(R.id.et_reg_corporation);
        etRegOrganize = (EditText) view.findViewById(R.id.et_reg_organize);
        etRegCheckScan = (TextView) view.findViewById(R.id.et_reg_check_scan);
        btnRegSubmit = (Button) view.findViewById(R.id.btn_reg_submit);

        tvRegSend.setOnClickListener(this);
        btnRegNext.setOnClickListener(this);
        btnRegSubmit.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reg_next:
                checkCode();
                break;

            case R.id.btn_reg_submit:
                submit();
                break;

            case R.id.tv_forget_send:
                getCode();
                break;
        }
    }

    private void checkCode() {
        rlRegFirst.setVisibility(View.GONE);
        rlRegSound.setVisibility(View.VISIBLE);
    }

    private void submit() {
        getActivity().finish();
    }

    public void getCode() {
        String phone = etRegPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone) || !phone.startsWith("1") || phone.length() != 11) {
            T.showShort(getActivity(), "请输入正确的手机号！");
            return;
        }
        T.showShort(getActivity(), "验证码发送成功！");

        tvRegSend.setEnabled(false);
        tvRegSend.setTextColor(getResources().getColor(R.color.color_00d39d));
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
                tvRegSend.setText(mCodeTime + "s");
            } else {
                tvRegSend.setText("重新获取");
                tvRegSend.setTextColor(getResources().getColor(R.color.color_000006));
                tvRegSend.setEnabled(true);
            }
        }
    };

}
