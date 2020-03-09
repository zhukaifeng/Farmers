package com.osiris.farmers.shichang;

import android.view.View;
import android.widget.LinearLayout;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.model.ChargeDetail;
import com.osiris.farmers.view.adapter.ChargeDetailAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PunishDetailActivity extends BaseActivity {
    @BindView(R.id.linear_charge_manager)
    LinearLayout linear_charge_manager;
    private List<ChargeDetail> dataDetailList = new ArrayList<>();
    private ChargeDetailAdapter dataDetailAdapter = new ChargeDetailAdapter(dataDetailList);
    @Override
    public int getLayoutResId() {
        return R.layout.activity_punish_detail;
    }

    @OnClick({R.id.rl_back})
    void onnClick(View v){
        switch (v.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

    @Override
    public void init() {

    }
}
