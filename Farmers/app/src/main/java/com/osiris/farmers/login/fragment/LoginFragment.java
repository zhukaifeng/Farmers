package com.osiris.farmers.login.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.login.ForgetPwdActivity;
import com.osiris.farmers.login.HomeActivity;
import com.osiris.farmers.model.LoginData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.GlobalParams;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;
import com.osiris.farmers.view.dialog.BillOfSalesDetailDialog;
import com.osiris.farmers.view.dialog.DialogClickListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.LogUtils;

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

				//toClass(getActivity(), MarketEvaluateActivity.class);
				break;
			case R.id.btn_login:
				Login();
//				Intent intent = new Intent(getActivity(), HomeActivity.class);
//
//				if (TextUtils.isEmpty(etLoginUsername.getText().toString())) {
//					intent.putExtra("type", 1);
//				} else {
//					if (Integer.parseInt(etLoginUsername.getText().toString()) == 1) {
//						intent.putExtra("type", 1);
//					} else if (Integer.parseInt(etLoginUsername.getText().toString()) == 2) {
//						intent.putExtra("type", 2);
//					} else if (Integer.parseInt(etLoginUsername.getText().toString()) == 3) {
//						intent.putExtra("type", 3);
//					} else if (Integer.parseInt(etLoginUsername.getText().toString()) == 4) {
//						intent.putExtra("type", 4);
//					}
//
//				}
//
//
//				startActivity(intent);
				break;
		}
	}


	private void showBillOfSalesDetailDialog() {
		BillOfSalesDetailDialog.Builder builder = new BillOfSalesDetailDialog.Builder(getActivity());
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


	private void Login() {


		String url = ApiParams.API_HOST + "/inloginApp.action";

//		if (TextUtils.isEmpty(etLoginUsername.getText().toString())) {
//			Toast.makeText(getActivity(), "请输入账号", Toast.LENGTH_SHORT).show();
//			return;
//		}
//		if (TextUtils.isEmpty(etLoginPassword.getText().toString())) {
//			Toast.makeText(getActivity(), "请输入登录密码", Toast.LENGTH_SHORT).show();
//			return;
//		}
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("username", etLoginUsername.getText().toString());
		paramMap.put("password", etLoginPassword.getText().toString());

//		paramMap.put("username", "34");
//		paramMap.put("password", "a123456");

		NetRequest.request(url, ApiRequestTag.LOGIN, paramMap, new NetRequestResultListener() {
			@Override
			public void requestSuccess(int tag, String successResult) {
				LogUtils.d("zkf login rsp:" + successResult);
				String temp = successResult.substring(1, successResult.length() - 1);
				if (!TextUtils.isEmpty(successResult)) {
					LoginData loginData = JsonUtils.fromJson(temp, LoginData.class);
					if (loginData.getMessage().equals("1")) {
						GlobalParams.authority = loginData.getUser().getAuthority();
						GlobalParams.username = loginData.getUser().getUsername();
						GlobalParams.id = loginData.getUser().getId();
						Intent intent = new Intent(getActivity(), HomeActivity.class);
						if (GlobalParams.authority.equals("经营户")) {
							intent.putExtra("type", 1);

						} else if (GlobalParams.authority.equals("监管部门")) {
							intent.putExtra("type", 3);

						} else if (GlobalParams.authority.equals("检测机构")) {
							intent.putExtra("type", 2);

						} else if (GlobalParams.authority.equals("市场管理")) {
							intent.putExtra("type", 4);

						}
						startActivity(intent);
					}
				}


			}

			@Override
			public void requestFailure(int tag, int code, String msg) {

			}
		});


	}


}
