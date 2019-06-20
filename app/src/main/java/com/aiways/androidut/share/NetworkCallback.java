package com.aiways.androidut.share;

public interface NetworkCallback {
    void onSuccess(Object data);
    void onFailure(int code, String msg);
}
