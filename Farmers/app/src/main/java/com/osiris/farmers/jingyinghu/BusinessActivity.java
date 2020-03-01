package com.osiris.farmers.jingyinghu;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.OperatorInquery;

import butterknife.BindView;

public class BusinessActivity extends BaseActivity {
    @BindView(R.id.iv_user_head)
    ImageView iv_user_head;
    @BindView(R.id.real_name)
    TextView real_name;
    @BindView(R.id.iv_sex)
    ImageView iv_sex;
    @BindView(R.id.tv_account)
    TextView tv_account;
    @BindView(R.id.tv_phone)
    TextView tv_phone;
    @BindView(R.id.tv_job)
    TextView tv_job;
    @BindView(R.id.id_card)
    TextView id_card;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.tv_market)
    TextView tv_market;
    @BindView(R.id.tw_no)
    TextView tw_no;
    @BindView(R.id.business_code)
    TextView business_code;
    @BindView(R.id.business_type)
    TextView business_type;
    @BindView(R.id.bus_contact)
    TextView bus_contact;
    @BindView(R.id.license_code)
    TextView license_code;
    @BindView(R.id.iv_wx_code)
    ImageView iv_wx_code;
    @BindView(R.id.iv_zfb_code)
    ImageView iv_zfb_code;

    public static Intent getStartIntent(Context context, OperatorInquery.DataBean data) {
        return new Intent(context, BusinessActivity.class)
                .putExtra("avatar", data.getHeadpic()).putExtra("real_name", data.getJyhmc())
                .putExtra("sex", "男".equals(data.getSex()) ? 0 : 1).putExtra("phone", data.getPhone())
                .putExtra("idCode", data.getRemark()).putExtra("market", data.getMarketnm())
                .putExtra("tanwei", data.getTwhma()).putExtra("busNo", data.getJyhid())
                .putExtra("businessUser", data.getUser());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_business_detail;
    }

    @Override
    public void init() {
        Intent dataIntent = getIntent();
        iv_sex.setSelected(dataIntent.getIntExtra("sex", 0) == 1);
        real_name.setText(dataIntent.getStringExtra("real_name"));
        tv_phone.setText(dataIntent.getStringExtra("phone"));
        id_card.setText(dataIntent.getStringExtra("idCode"));
        tv_market.setText(dataIntent.getStringExtra("market"));
        tw_no.setText(dataIntent.getStringExtra("tanwei"));
        business_code.setText(String.valueOf(dataIntent.getIntExtra("busNo", 0)));
        bus_contact.setText(dataIntent.getStringExtra("businessUser"));
    }
}
