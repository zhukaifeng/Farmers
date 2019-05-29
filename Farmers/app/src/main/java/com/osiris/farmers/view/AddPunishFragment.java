package com.osiris.farmers.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osiris.farmers.R;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.PunishList;
import com.osiris.farmers.model.StockListData;
import com.osiris.farmers.view.adapter.MyItemClickListener;
import com.osiris.farmers.view.adapter.PunishListAdapter;
import com.osiris.farmers.view.adapter.StockListAdapter;
import com.osiris.farmers.view.dialog.ChooseRulesDialog;
import com.osiris.farmers.view.dialog.DialogClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AddPunishFragment extends BaseFragment {

    @BindView(R.id.rv_data)
    RecyclerView rv_data;

    private List<PunishList> dataList = new ArrayList<>();
    private PunishListAdapter dataAdapter = new PunishListAdapter(dataList);

    @Override
    protected int setLayout() {
        return R.layout.fragment_add_punish;
    }

    @Override
    protected void initView() {
        dataList.add(new PunishList("镇江江南", "028", "张浩", "200元","03.22",false));
        dataList.add(new PunishList("镇江江南", "028", "张浩", "200元","03.22",false));
        dataList.add(new PunishList("镇江江南", "028", "张浩", "200元","03.22",true));
        dataList.add(new PunishList("镇江江南", "028", "张浩", "200元","03.22",true));

        rv_data.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_data.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
        dataAdapter.setOnItemClick(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (!dataList.get(position).isClicked()){
                    dataList.get(position).setClicked(true);
                }else {
                    dataList.get(position).setClicked(false);
                }
                dataAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_add})
    void onClick(View v){
        switch (v.getId()){
            case R.id.rl_add:
                showChooseRulesDialog();
                break;
        }
    }

    private void showChooseRulesDialog() {
        ChooseRulesDialog.Builder builder = new ChooseRulesDialog.Builder(getActivity());
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
