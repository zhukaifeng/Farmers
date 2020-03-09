package com.osiris.farmers.jingyinghu;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.OperatorInquery;
import com.osiris.farmers.network.ApiParams;

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
                .putExtra("idCode", data.getCardId()).putExtra("market", data.getMarketnm())
                .putExtra("tanwei", data.getTwhma()).putExtra("busNo", data.getJyhid())
                .putExtra("wechat", data.getMark()).putExtra("alipay", data.getMbrk())
                .putExtra("businessUser", data.getUser()).putExtra("license_code", data.getRemark())
                .putExtra("address", data.getShengName() + data.getShiName() + data.getRegionname() + data.getJiedaoName())
                .putExtra("job", data.getZhiwei());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_business_detail;
    }

    @Override
    public void init() {
        Intent dataIntent = getIntent();
        String baseUrl = ApiParams.API_HOST + "/";
        Glide.with(this).load(baseUrl + dataIntent.getStringExtra("avatar")).into(iv_user_head);
        Glide.with(this).load(baseUrl + dataIntent.getStringExtra("wechat")).into(iv_wx_code);
        Glide.with(this).load(baseUrl + dataIntent.getStringExtra("alipay")).into(iv_zfb_code);
        iv_sex.setSelected(dataIntent.getIntExtra("sex", 0) == 1);
        real_name.setText(dataIntent.getStringExtra("real_name"));
        tv_phone.setText(dataIntent.getStringExtra("phone"));
        id_card.setText(dataIntent.getStringExtra("idCode"));
        tv_market.setText(dataIntent.getStringExtra("market"));
        tw_no.setText(dataIntent.getStringExtra("tanwei"));
        tv_account.setText(dataIntent.getStringExtra("phone"));
        business_code.setText(dataIntent.getStringExtra("busNo"));
        bus_contact.setText(dataIntent.getStringExtra("businessUser"));
        license_code.setText(dataIntent.getStringExtra("license_code"));
        tv_address.setText(dataIntent.getStringExtra("address"));
        tv_job.setText(dataIntent.getStringExtra("job"));
    }
}
