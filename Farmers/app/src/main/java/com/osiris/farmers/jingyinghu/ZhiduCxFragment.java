package com.osiris.farmers.jingyinghu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.jingyinghu.fragment.RegulationFragment;
import com.osiris.farmers.jingyinghu.fragment.ZhenceFaguiFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class ZhiduCxFragment extends BaseFragment {


    @BindView(R.id.tab_strip)
    PagerSlidingTabStrip tab_strip;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private int type;

    @OnClick({R.id.rl_back})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                getActivity().finish();
                break;
        }
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_zhiducx;
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            type = getArguments().getInt("type");
        }
        mViewPager.setAdapter(new myPagerAdapter(getActivity().getSupportFragmentManager()));
        tab_strip.setViewPager(mViewPager);
        tab_strip.setTextSize((int) getResources().getDimension(R.dimen.sp16));

    }

    @Override
    protected void initData() {

    }


    private class myPagerAdapter extends FragmentPagerAdapter {

        String[] title = {"市场管理制度", type == 3 ? "科普知识" : "政策法规"};
        RegulationFragment fragment1;
        RegulationFragment fragment2;

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment1 = RegulationFragment.newInstance(RegulationFragment.TYPE_MANAGE_REGULAR);
                    return fragment1;
                case 1:
                    fragment2 = RegulationFragment.newInstance(RegulationFragment.TYPE_LAW_REGULAR);
                    return fragment2;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }
}
