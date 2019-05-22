package com.osiris.farmers.network;

import android.text.TextUtils;

import com.osiris.farmers.beans.BaseBean;
import com.osiris.farmers.utils.JsonUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;

public class NetRequest {

    public static void request(String url, final int tag, Map<String, String> paramMap, final NetRequestResultListener listener) {


//
//        Map<String, String> map = new HashMap<>();
////        map.put("Accept", "*/*");
//        map.put("Content-Type","application/json");

        OkHttpUtils
                .post()
                .url(url)
                .params(paramMap)
                .addHeader("Content-Type", "application/json")

                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.requestFailure(tag, -2, "");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (TextUtils.isEmpty(response)) {
                            listener.requestFailure(tag, -2, "");
                            return;
                        }
                        BaseBean baseBean = JsonUtils.deserialize(response, BaseBean.class);
                        if (baseBean.getError() == 200) {
                            if (baseBean.getInfo() == null) {
                                listener.requestSuccess(tag, "");
                            } else {
                                listener.requestSuccess(tag, baseBean.getInfo());
                            }

                        } else {
                            listener.requestFailure(tag, baseBean.getError(), baseBean.getMsg());
                        }
                    }
                });
    }


    public static void requestPostContent(String url, final int tag, String content, final NetRequestResultListener listener) {


        OkHttpUtils
                .postString()
                .url(url)
                .content(content)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                             @Override
                             public void onError(Call call, Exception e, int id) {
                                 listener.requestFailure(tag, -2, "");
                             }

                             @Override
                             public void onResponse(String response, int id) {

                                 listener.requestSuccess(tag, response);


//                                 if (TextUtils.isEmpty(response)) {
//                                     listener.requestFailure(tag, -2, "");
//                                     return;
//                                 }
//                                 BaseBean baseBean = JsonUtils.deserialize(response, BaseBean.class);
//                                 if (baseBean.getCode() == 0) {
//                                     listener.requestSuccess(tag, baseBean.getData());
//                                 } else {
//                                     listener.requestFailure(tag, baseBean.getCode(), baseBean.getMsg());
//                                 }
                             }
                         }
                );


//        OkHttpUtils
//                .post()
//                .url(url)
//                .addHeader("Content-Type","application/json")
//
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        listener.requestFailure(tag, -2, "");
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        if (TextUtils.isEmpty(response)) {
//                            listener.requestFailure(tag, -2, "");
//                            return;
//                        }
//                        BaseBean baseBean = JsonUtils.deserialize(response, BaseBean.class);
//                        if (baseBean.getCode() == 0) {
//                            listener.requestSuccess(tag, baseBean.getData());
//                        } else {
//                            listener.requestFailure(tag, baseBean.getCode(), baseBean.getMsg());
//                        }
//                    }
//                });
    }


    public static void postFile(final String url, final int tag, File file, Map<String, String> paramMap, final NetRequestResultListener listener) {

        OkHttpUtils
                .post()
                .url(url)
                .params(paramMap)
                .addFile("file", file.getName(), file)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.requestFailure(tag, -2, url + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        BaseBean baseBean = JsonUtils.deserialize(response, BaseBean.class);
                        if (baseBean.getError() == 0) {
                            listener.requestSuccess(tag, baseBean.getMsg());
                        } else {
                            listener.requestFailure(tag, baseBean.getError(), baseBean.getMsg());
                        }
                    }
                });
    }


    public static void postVideoFile(String url, final int tag, File file, Map<String, String> paramMap, final NetRequestResultListener listener) {

//        Map<String,File> fileMap = new HashMap<>();
//        fileMap

//        PostFormBuilder formBuilder = OkHttpUtils.post();

//        formBuilder.addFile("file",file.getName(),file);
//        formBuilder


        OkHttpUtils.post()
                .addFile("file", file.getName(), file)
                .url(url)
                .params(paramMap)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.requestFailure(tag, -2, "");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        BaseBean baseBean = JsonUtils.deserialize(response, BaseBean.class);
                        if (baseBean.getError() == 0) {
                            listener.requestSuccess(tag, baseBean.getMsg());
                        } else {
                            listener.requestFailure(tag, baseBean.getError(), baseBean.getMsg());
                        }
                    }
                });


//        OkHttpUtils
//                .post()
//                .url(url)
//                .params(paramMap)
//                .addFile("file", file.getName(), file)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        listener.requestFailure(tag, -2, "");
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        BaseBean baseBean = JsonUtils.deserialize(response, BaseBean.class);
//                        if (baseBean.getCode() == 0) {
//                            listener.requestSuccess(tag, baseBean.getMsg());
//                        } else {
//                            listener.requestFailure(tag, baseBean.getCode(), baseBean.getMsg());
//                        }
//                    }
//                });
    }


    public static void requestGet(String url, final int tag, Map<String, String> paramMap, final NetRequestResultListener listener) {
        OkHttpUtils
                .get()
                .url(url)
                .params(paramMap)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.requestFailure(tag, -2, "");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        BaseBean baseBean = JsonUtils.deserialize(response, BaseBean.class);
                        if (baseBean.getError() == 0) {
                            listener.requestSuccess(tag, baseBean.getInfo());
                        } else {
                            listener.requestFailure(tag, baseBean.getError(), baseBean.getMsg());
                        }
                    }
                });
    }


}
