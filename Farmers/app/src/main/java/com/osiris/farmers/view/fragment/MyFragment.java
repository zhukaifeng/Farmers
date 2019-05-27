package com.osiris.farmers.view.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.view.AccountActivity;
import com.osiris.farmers.view.widget.APSTSViewPager;
import com.osiris.farmers.view.widget.AdvancedPagerSlidingTabStrip;
import com.osiris.farmers.view.widget.CustomPagerSlidingTabStrip;
import com.osiris.farmers.view.widget.ViewHolder;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends BaseFragment {

    @BindView(R.id.tab_strip)
    AdvancedPagerSlidingTabStrip tab_strip;
    @BindView(R.id.viewPager)
    APSTSViewPager mViewPager;
    String[] title;
    private PayDetailFragment mPayDetailFragment = null;
    private UnPaidFragment mUnPaidFragment = null;
    private static final int VIEW_FIRST 		= 0;
    private static final int VIEW_SECOND	    = 1;
    private static final int VIEW_SIZE = 2;


    @Override
    protected int setLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        initViewPage();
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.rl_setting})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_setting:
                Intent intent = new Intent(getActivity(), AccountActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void initViewPage() {
        title = new String[]{getResources().getString(R.string.pay_detail), getResources().getString(R.string
                .unpaid)};
        FragmentAdapter adapter = new FragmentAdapter(getActivity().getSupportFragmentManager());

        mViewPager.setAdapter(new FragmentAdapter(getActivity().getSupportFragmentManager()));
        adapter.notifyDataSetChanged();

        tab_strip.setViewPager(mViewPager);
        tab_strip.showDot(1, "3");
       // mAPSTS.setOnPageChangeListener(this);

        // tab_strip.setTextSize((int) getResources().getDimension(R.dimen.sp16));
    }
    public class FragmentAdapter extends FragmentStatePagerAdapter implements CustomPagerSlidingTabStrip.CustomTabProvider{

        protected LayoutInflater mInflater;

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public Fragment getItem(int position) {
            if(position >= 0 && position < VIEW_SIZE){
                switch (position){
                    case  VIEW_FIRST:
                        if(null == mPayDetailFragment)
                            mPayDetailFragment = new PayDetailFragment();
                        return mPayDetailFragment;

                    case VIEW_SECOND:
                        if(null == mUnPaidFragment)
                            mUnPaidFragment = new UnPaidFragment();
                        return mUnPaidFragment;


                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return VIEW_SIZE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position >= 0 && position < VIEW_SIZE){
                switch (position){
                    case  VIEW_FIRST:
                        return  getResources().getString(R.string.pay_detail);
                    case  VIEW_SECOND:
                        return  getResources().getString(R.string.unpaid);
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public View getSelectTabView(int position, View convertView) {
            if (convertView == null){
                convertView = mInflater.inflate(R.layout.custom_select_tab, null);
            }

            TextView tv = ViewHolder.get(convertView, R.id.tvTab);

            tv.setText(getPageTitle(position));

            return convertView;
        }

        @Override
        public View getDisSelectTabView(int position, View convertView) {
            if (convertView == null){
                convertView = mInflater.inflate(R.layout.custom_disselect_tab, null);
            }

            TextView tv = ViewHolder.get(convertView, R.id.tvTab);

            tv.setText(getPageTitle(position));

            return convertView;
        }
    }
}
