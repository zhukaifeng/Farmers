package com.osiris.farmers.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseActivity;

import butterknife.BindView;

public class BigImageActivity extends BaseActivity {
    private String url;
    @BindView(R.id.back_img)
    ImageView back_img;
    @BindView(R.id.imageView)
    ImageView imageView;

    public static void showImage(Context context, String url) {
        context.startActivity(new Intent(context, BigImageActivity.class).putExtra("url", url));
    }


    @Override
    public int getLayoutResId() {
        return R.layout.activity_big_image;
    }

    @Override
    public void init() {
        url = getIntent().getStringExtra("url");
        Glide.with(this).load(url).into(imageView);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
