package com.osiris.farmers.network;

public interface NetRequestResultListener {
    void requestSuccess(int tag, String successResult);

    void requestFailure(int tag, int code, String msg);
}
