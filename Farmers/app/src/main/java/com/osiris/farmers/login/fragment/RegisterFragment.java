package com.osiris.farmers.login.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
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
import com.osiris.farmers.view.dialog.DialogClickListener;
import com.osiris.farmers.view.dialog.RegistDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterFragment extends BaseFragment {
    @BindView(R.id.rl_reg_first)
    RelativeLayout rlRegFirst;
    @BindView(R.id.et_reg_phone)
    EditText etRegPhone;
    @BindView(R.id.tv_reg_send)
    TextView tvRegSend;
    @BindView(R.id.et_reg_code)
    EditText etRegCode;
    @BindView(R.id.et_reg_password)
    EditText etRegPassword;
    @BindView(R.id.et_reg_check_password)
    EditText etRegCheckPassword;
    @BindView(R.id.btn_reg_next)
    Button btnRegNext;
    @BindView(R.id.rl_reg_sound)
    RelativeLayout rlRegSound;
    @BindView(R.id.et_reg_merchant)
    EditText etRegMerchant;
    @BindView(R.id.et_reg_corporation)
    EditText etRegCorporation;
    @BindView(R.id.et_reg_organize)
    EditText etRegOrganize;
    @BindView(R.id.et_reg_check_scan)
    TextView etRegCheckScan;
    @BindView(R.id.btn_reg_submit)
    Button btnRegSubmit;

    private int mCodeTime = 60;

    @Override
    protected int setLayout() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView() {
//        rlRegFirst = (RelativeLayout) getActivity().findViewById(R.id.rl_reg_first);
//        etRegPhone = (EditText) getActivity().findViewById(R.id.et_reg_phone);
//        tvRegSend = (TextView) getActivity().findViewById(R.id.tv_reg_send);
//        etRegCode = (EditText) getActivity().findViewById(R.id.et_reg_code);
//        etRegPassword = (EditText) getActivity().findViewById(R.id.et_reg_password);
//        etRegCheckPassword = (EditText) getActivity().findViewById(R.id.et_reg_check_password);
//        btnRegNext = (Button) getActivity().findViewById(R.id.btn_reg_next);
//        rlRegSound = (RelativeLayout) getActivity().findViewById(R.id.rl_reg_sound);
//        etRegMerchant = (EditText) getActivity().findViewById(R.id.et_reg_merchant);
//        etRegCorporation = (EditText) getActivity().findViewById(R.id.et_reg_corporation);
//        etRegOrganize = (EditText) getActivity().findViewById(R.id.et_reg_organize);
//        etRegCheckScan = (TextView) getActivity().findViewById(R.id.et_reg_check_scan);
//        btnRegSubmit = (Button) getActivity().findViewById(R.id.btn_reg_submit);

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_reg_next, R.id.btn_reg_submit, R.id.tv_forget_send})
    void onClick(View view) {
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
        //getActivity().finish();
        showSubmitRegistDialog();
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

    private void showSubmitRegistDialog() {
        RegistDialog.Builder builder = new RegistDialog.Builder(getActivity());
        builder.setPositiveButton(new DialogClickListener() {
            @Override
            public void onClick(Dialog dialog, String msg) {

            }

            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


}
