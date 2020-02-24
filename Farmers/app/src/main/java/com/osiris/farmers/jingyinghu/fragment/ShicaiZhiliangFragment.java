package com.osiris.farmers.jingyinghu.fragment;

import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;

import butterknife.OnClick;

public class ShicaiZhiliangFragment extends BaseFragment {

    @OnClick({R.id.rl_back})
    void onnClick(View v){
        switch (v.getId()){
            case R.id.rl_back:
                getActivity().finish();
                break;
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_shicaizhiliang;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
