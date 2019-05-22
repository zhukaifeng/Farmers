package com.osiris.farmers.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiris.farmers.R;


public class TabItem extends LinearLayout {
    private final ImageView tabItemIcon;
    private final TextView textTabItemName;

    public TabItem(Context context, int icon, int name, int msgCount) {
        super(context);
        inflate(context, R.layout.ui_tab_item, this);
        tabItemIcon = (ImageView) findViewById(R.id.img_tab_item_icon);
        tabItemIcon.setImageResource(icon);
        textTabItemName = (TextView) findViewById(R.id.text_tab_item_name);
        textTabItemName.setText(name);
    }



    public void setEmpty() {
        tabItemIcon.setVisibility(INVISIBLE);
        textTabItemName.setVisibility(INVISIBLE);
        setEnabled(false);
    }
}
