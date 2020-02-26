package com.osiris.farmers.view.adapter;

import android.app.Activity;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.adapter.BaseAdapter;
import com.osiris.farmers.model.Product;
import com.osiris.farmers.model.StoreSupplier;

public class SimpleSupplyerAdapter extends BaseAdapter<StoreSupplier.CustomerBean> {
    public SimpleSupplyerAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public int getItemResId() {
        return R.layout.item_test;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position, StoreSupplier.CustomerBean item) {
        super.onBindViewHolder(viewHolder, position, item);
        TextView tvText = (TextView) viewHolder.getView(R.id.tv_text);
        tvText.setText(item.getCommoditynm());
    }
}
