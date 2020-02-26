package com.osiris.farmers.view.adapter;

import android.app.Activity;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.adapter.BaseAdapter;
import com.osiris.farmers.model.Product;

public class SimpleProdAdapter extends BaseAdapter<Product> {
    public SimpleProdAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public int getItemResId() {
        return R.layout.item_test;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position, Product item) {
        super.onBindViewHolder(viewHolder, position, item);
        TextView tvText = (TextView) viewHolder.getView(R.id.tv_text);
        tvText.setText(item.getCommoditynm());
    }
}
