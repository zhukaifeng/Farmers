package com.osiris.farmers.view.fragment;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.DateModel;
import com.osiris.farmers.model.ShippingStock;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.ShippingStockAdapter;
import com.osiris.farmers.view.adapter.TypeStockAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ShippingStockFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rl_type)
    RelativeLayout rl_type;
    @BindView(R.id.rv_type)
    RecyclerView rv_type;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.iv_select_arrow)
    ImageView iv_select_arrow;

    private List<ShippingStock> dataList = new ArrayList<>();
    private ShippingStockAdapter dataAdapter = new ShippingStockAdapter(dataList);
    private List<DateModel> typeList = new ArrayList<>();
    private TypeStockAdapter typeAdapter = new TypeStockAdapter(typeList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_shipping_stock;
    }

    @Override
    protected void initView() {


        typeList.add(new DateModel("全部", true));
        typeList.add(new DateModel("蔬菜", false));
        typeList.add(new DateModel("水果", false));
        typeList.add(new DateModel("肉类", false));
        typeList.add(new DateModel("海鲜", false));


        dataList.add(new ShippingStock("蔬菜", "紫包菜", "500斤"));
        dataList.add(new ShippingStock("肉类", "猪肉", "500斤"));
        dataList.add(new ShippingStock("海鲜", "龙虾", "500斤"));
        dataList.add(new ShippingStock("水果", "西瓜", "50斤"));
        dataList.add(new ShippingStock("蔬菜", "紫包菜", "500斤"));
        dataList.add(new ShippingStock("肉类", "猪肉", "500斤"));
        dataList.add(new ShippingStock("海鲜", "龙虾", "500斤"));

        rv_type.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv_type.setAdapter(typeAdapter);
        typeAdapter.notifyDataSetChanged();
        typeAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (DateModel dateModel : typeList) {
                    dateModel.setClicked(false);
                }
                typeList.get(position).setClicked(true);
                typeAdapter.notifyDataSetChanged();


            }
        });



        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_type})
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_type:
                if (rl_type.getVisibility()== View.VISIBLE){
                    rl_type.setVisibility(View.GONE);
                    iv_select_arrow.setVisibility(View.GONE);
                    Drawable drawable= getResources().getDrawable(R.drawable.bg_arrow_down_tri);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tv_type.setCompoundDrawables(null,null,drawable,null);

                }else {
                    rl_type.setVisibility(View.VISIBLE);
                    iv_select_arrow.setVisibility(View.VISIBLE);
                    Drawable drawable= getResources().getDrawable(R.drawable.bg_arrow_up_tri);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tv_type.setCompoundDrawables(null,null,drawable,null);
                }

                break;
        }
    }

}
