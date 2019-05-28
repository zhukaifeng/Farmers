package com.osiris.farmers.goods.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.StockListData;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.StockListAdapter;
import com.osiris.farmers.view.dialog.BillOflandingDialog;
import com.osiris.farmers.view.dialog.DialogClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class StockListFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.rl_right)
    RelativeLayout rl_right;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rl_top_info)
    RelativeLayout rl_top_info;
    @BindView(R.id.rl_top_add_info)
    RelativeLayout rl_top_add_info;
    @BindView(R.id.rl_add_list)
    RelativeLayout rl_add_list;
    @BindView(R.id.rl_input_info)
    RelativeLayout rl_input_info;

    private List<StockListData> dataList = new ArrayList<>();
    private StockListAdapter dataAdapter = new StockListAdapter(dataList);
    @Override
    protected int setLayout() {
        return R.layout.fragment_stock_list;
    }

    @Override
    protected void initView() {

        dataList.add(new StockListData("紫包菜", "蔬菜", "30斤", "2元","60元",true));
        dataList.add(new StockListData("紫包菜", "蔬菜", "30斤", "2元","60元",true));
        dataList.add(new StockListData("紫包菜", "蔬菜", "30斤", "2元","60元",false));

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_add,R.id.tv_add,R.id.rl_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_add:
                showBillOfLandingDetailDialog();
                break;
            case R.id.tv_add:
                rl_back.setVisibility(View.VISIBLE);
                rl_right.setVisibility(View.VISIBLE);
                rl_top_info.setVisibility(View.GONE);
                rl_top_add_info.setVisibility(View.VISIBLE);
                rl_add_list.setVisibility(View.GONE);
                rl_input_info.setVisibility(View.VISIBLE);
                tv_title.setText(getString(R.string.add_new_supplier));
                break;
            case R.id.rl_back:
                rl_back.setVisibility(View.GONE);
                rl_right.setVisibility(View.GONE);
                rl_top_info.setVisibility(View.VISIBLE);
                rl_top_add_info.setVisibility(View.GONE);
                rl_add_list.setVisibility(View.VISIBLE);
                rl_input_info.setVisibility(View.GONE);
                tv_title.setText(getString(R.string.add_bill_of_sales));
                break;
        }
    }
    private void showBillOfLandingDetailDialog() {
        BillOflandingDialog.Builder builder = new BillOflandingDialog.Builder(getActivity());
        builder.setPositiveButton(new DialogClickListener() {
            @Override
            public void onClick(Dialog dialog, String msg) {

            }

            @Override
            public void onClick(Dialog dialog) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

}
