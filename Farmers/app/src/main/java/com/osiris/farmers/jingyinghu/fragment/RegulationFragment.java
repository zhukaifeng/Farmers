package com.osiris.farmers.jingyinghu.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.osiris.farmers.R;
import com.osiris.farmers.adapter.RegularAdapter;
import com.osiris.farmers.base.BaseFragment;
import com.osiris.farmers.model.PurchaseDetail;
import com.osiris.farmers.model.RegularData;
import com.osiris.farmers.network.ApiParams;
import com.osiris.farmers.network.ApiRequestTag;
import com.osiris.farmers.network.NetRequest;
import com.osiris.farmers.network.NetRequestResultListener;
import com.osiris.farmers.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class RegulationFragment extends BaseFragment {
    private int type;
    public static final int TYPE_MANAGE_REGULAR = 3;
    public static final int TYPE_LAW_REGULAR = 2;
    @BindView(R.id.search_content)
    EditText search_content;
    @BindView(R.id.rv_data)
    RecyclerView rv_data;
    private RegularAdapter adapter;
    private String searchContent;

    public static RegulationFragment newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt("type", type);
        RegulationFragment fragment = new RegulationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_list_regulation;
    }

    @Override
    protected void initView() {
        type = getArguments().getInt("type");
        adapter = new RegularAdapter(getActivity());
        rv_data.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_data.setAdapter(adapter);
        search_content.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    String content = search_content.getText().toString();
                    if (TextUtils.isEmpty(content)) {
                        Toast.makeText(getActivity(), "搜索内容不能为空", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    //点击搜索的时候隐藏软键盘
                    hideKeyboard(search_content);
                    searchContent = content;
                    initData();
                    // 在这里写搜索的操作,一般都是网络请求数据
                    return true;
                }
                return false;
            }
        });
    }

    private void hideKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void initData() {
        String url = ApiParams.API_HOST + "/app/allDataMag.action";
        Map<String, String> params = new HashMap<>();
        params.put("leibie", String.valueOf(type));
        if (!TextUtils.isEmpty(searchContent)) {
            params.put("zlkmc", searchContent);
        }
        NetRequest.request(url, ApiRequestTag.DATA, params, new NetRequestResultListener() {
            @Override
            public void requestSuccess(int tag, String successResult) {
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(successResult).getAsJsonObject();
                if (jsonObject.has("data")) {
                    RegularData[] dataBean = JsonUtils.fromJson(jsonObject.get("data"), RegularData[].class);
                    adapter.setDatas(dataBean);
                }
            }

            @Override
            public void requestFailure(int tag, int code, String msg) {

            }
        });
    }
}
