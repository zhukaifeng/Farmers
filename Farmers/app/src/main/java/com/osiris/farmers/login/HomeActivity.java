package com.osiris.farmers.login;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity{

    @BindView(R.id.ll_home_name)
    LinearLayout llHomeName;
    @BindView(R.id.tv_home_name)
    TextView tvHomeName;
    @BindView(R.id.ll_home_1)
    LinearLayout llHome1;
    @BindView(R.id.iv_home_1)
    ImageView ivHome1;
    @BindView(R.id.tv_home_1)
    TextView tvHome1;
    @BindView(R.id.ll_home_2)
    LinearLayout llHome2;
    @BindView(R.id.iv_home_2)
    ImageView ivHome2;
    @BindView(R.id.tv_home_2)
    TextView tvHome2;
    @BindView(R.id.ll_home_3)
    LinearLayout llHome3;
    @BindView(R.id.iv_home_3)
    ImageView ivHome3;
    @BindView(R.id.tv_home_3)
    TextView tvHome3;
    @BindView(R.id.ll_home_4)
    LinearLayout llHome4;
    @BindView(R.id.iv_home_4)
    ImageView ivHome4;
    @BindView(R.id.tv_home4)
    TextView tvHome4;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    public void init() {
        initData();
        initView();
    }

    private void initData() {

    }

    private void initView() {


        changeViewStatus(0);
    }

   @OnClick({R.id.ll_home_name, R.id.ll_home_1, R.id.ll_home_2, R.id.ll_home_3, R.id.ll_home_4})
    void click(View view) {
        switch (view.getId()) {
            case R.id.ll_home_name:

                break;

            case R.id.ll_home_1:
                Intent intent = new Intent(this,MenuHomeActivity.class);
                startActivity(intent);
                break;

            case R.id.ll_home_2:

                break;

            case R.id.ll_home_3:

                break;

            case R.id.ll_home_4:

                break;
            default:
                break;
        }
    }


    private void changeViewStatus(int type) {
        switch (type) {
            case 0:
                ivHome1.setBackgroundResource(R.drawable.bg_home_purchasing);
                tvHome1.setText(getString(R.string.purchasing));
                ivHome2.setBackgroundResource(R.drawable.bg_home_sell);
                tvHome2.setText(getString(R.string.sell));
                ivHome3.setBackgroundResource(R.drawable.bg_home_stock);
                tvHome3.setText(getString(R.string.stock));
                ivHome4.setBackgroundResource(R.drawable.bg_home_booking);
                tvHome4.setText(getString(R.string.booking));
                break;

            case 1:
                ivHome1.setBackgroundResource(R.drawable.bg_home_retrospect);
                tvHome1.setText(getString(R.string.retrospect));
                ivHome2.setBackgroundResource(R.drawable.bg_home_sampling);
                tvHome2.setText(getString(R.string.sampling));
                ivHome3.setBackgroundResource(R.drawable.bg_home_check);
                tvHome3.setText(getString(R.string.check));
                ivHome4.setBackgroundResource(R.drawable.bg_home_appraise);
                tvHome4.setText(getString(R.string.appraise));
                break;

            case 2:
                ivHome1.setBackgroundResource(R.drawable.bg_home_operator_management);
                tvHome1.setText(getString(R.string.operator_management));
                ivHome2.setBackgroundResource(R.drawable.bg_home_marketing_management);
                tvHome2.setText(getString(R.string.marketing_management));
                ivHome3.setBackgroundResource(R.drawable.bg_home_charge);
                tvHome3.setText(getString(R.string.charge));
                ivHome4.setBackgroundResource(R.drawable.bg_home_appraise_management);
                tvHome4.setText(getString(R.string.appraise_management));
                break;
        }
    }
}
