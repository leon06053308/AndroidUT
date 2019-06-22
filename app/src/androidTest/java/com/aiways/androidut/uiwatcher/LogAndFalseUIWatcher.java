package com.aiways.androidut.uiwatcher;

import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

public class LogAndFalseUIWatcher implements UiWatcher {
    private final String TAG=getClass().getName();

    @Override
    public boolean checkForCondition() {
        Log.i(TAG, "only return false");
        return false;
    }
}
