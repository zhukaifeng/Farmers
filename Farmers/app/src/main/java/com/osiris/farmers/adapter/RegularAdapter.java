package com.osiris.farmers.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.model.RegularData;

public class RegularAdapter extends BaseAdapter<RegularData> {
    public RegularAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public int getItemResId() {
        return R.layout.item_regular;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position, RegularData item) {
        super.onBindViewHolder(viewHolder, position, item);
        View parentView = viewHolder.itemView;
        TextView title = parentView.findViewById(R.id.title);
        TextView company = parentView.findViewById(R.id.company);
        TextView publish_time = parentView.findViewById(R.id.publish_time);
        TextView exec_time = parentView.findViewById(R.id.exec_time);
        title.setText(item.getZlkmc());
        company.setText("发布单位：" + item.getMbrk());
        publish_time.setText("发布时间：" + item.getScsj());
        exec_time.setText("执行时间：" + item.getMark());
    }
}
