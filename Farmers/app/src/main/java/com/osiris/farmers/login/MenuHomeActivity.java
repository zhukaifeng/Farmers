package com.osiris.farmers.login;

import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;
import com.osiris.farmers.goods.fragment.PayFragment;
import com.osiris.farmers.goods.fragment.StockListFragment;
import com.osiris.farmers.goods.fragment.StockPurchaseFragment;
import com.osiris.farmers.view.AddPunishFragment;
import com.osiris.farmers.view.TabItem;
import com.osiris.farmers.view.fragment.DatebacktoFragment;
import com.osiris.farmers.view.fragment.LifePayFragment;
import com.osiris.farmers.view.fragment.MyFragment;
import com.osiris.farmers.view.fragment.OperatorInquiryFragment;
import com.osiris.farmers.view.fragment.PersonalLifePayFragment;
import com.osiris.farmers.view.fragment.ShippingStockFragment;
import com.osiris.farmers.view.fragment.TakeSampleFragment;
import com.osiris.farmers.view.fragment.TakeSampleListFragment;

import butterknife.BindView;

public class MenuHomeActivity extends BaseActivity {

	@BindView(R.id.tab_host_main_menu)
	FragmentTabHost tabhostMainMenu;
	@BindView(R.id.frame_home_content)
	FrameLayout framHomeContent;
	private final String tag_stock_purchase = "stock_purchase";
	private final String tag_stock_list = "stock_list";
	private final String tag_stock_goods = "stock_goods";
	private final String tag_stock_pay = "stock_pay";
	private int menuType;

	@Override
	public int getLayoutResId() {
		return R.layout.activity_menu_home;
	}

	@Override
	public void init() {
		initView();
	}

	private void initView() {

		menuType = getIntent().getIntExtra("type", 1);
		tabhostMainMenu.setup(this, getSupportFragmentManager(), R.id.frame_home_content);
		tabhostMainMenu.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
		tabhostMainMenu.getTabWidget().setDividerDrawable(null);
		switch (menuType) {
			case 1:

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_purchase).setIndicator(new TabItem
						(this, R.drawable.tab_stock_purchase, R.string.stock_purchase, 0)), StockPurchaseFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_list).setIndicator(new
						TabItem(this, R.drawable.tab_stock_lis, R.string
						.add_stock_list, 0)), StockListFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_goods).setIndicator(new TabItem(this, R.drawable.tab_stock_goods, R.string.stock_goods, 0)),
						ShippingStockFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_pay).setIndicator(new
								TabItem(this, R.drawable.tab_stock_pay, R.string.pay, 0)),
						PersonalLifePayFragment.class, null);

				tabhostMainMenu.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
					@Override
					public void onTabChanged(String tabId) {
						switch (tabId) {
							case tag_stock_purchase:
								break;
							case tag_stock_list:
								break;
							case tag_stock_goods:
								break;
							case tag_stock_pay:
								break;
						}
					}
				});
				break;

			case 2:

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_purchase).setIndicator(new TabItem
						(this, R.drawable.tab_date_back_to, R.string.date_back_to, 0)), DatebacktoFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_list).setIndicator(new
						TabItem(this, R.drawable.tab_sample, R.string
						.sample, 0)), TakeSampleListFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_goods).setIndicator(new TabItem(this, R.drawable.tab_examine, R.string.examine_menu, 0)),
						TakeSampleFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_pay).setIndicator(new
								TabItem(this, R.drawable.tab_mine, R.string.mine, 0)),
						MyFragment.class, null);

				tabhostMainMenu.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
					@Override
					public void onTabChanged(String tabId) {
						switch (tabId) {
							case tag_stock_purchase:
								break;
							case tag_stock_list:
								break;
							case tag_stock_goods:
								break;
							case tag_stock_pay:
								break;
						}
					}
				});
				break;
			case 3:

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_purchase).setIndicator(new TabItem
						(this, R.drawable.tab_operating, R.string.operating_households, 0)), OperatorInquiryFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_list).setIndicator(new
						TabItem(this, R.drawable.tab_market, R.string
						.market, 0)), AddPunishFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_goods).setIndicator(new
								TabItem(this, R.drawable.tab_collect_feels, R.string.collect_fees, 0)),
						LifePayFragment.class, null);

				tabhostMainMenu.addTab(tabhostMainMenu.newTabSpec(tag_stock_pay).setIndicator(new
								TabItem(this, R.drawable.tab_mine, R.string.mine, 0)),
						MyFragment.class, null);

				tabhostMainMenu.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
					@Override
					public void onTabChanged(String tabId) {
						switch (tabId) {
							case tag_stock_purchase:
								break;
							case tag_stock_list:
								break;
							case tag_stock_goods:
								break;
							case tag_stock_pay:
								break;
						}
					}
				});
				break;
			default:

				break;

		}


	}
}
