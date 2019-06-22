package com.aiways.androidut.uiwatcher;

import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

public class LogAndTrueUIWatcher implements UiWatcher {
    private final String TAG=getClass().getName();

    @Override
    public boolean checkForCondition() {
        Log.i(TAG, "only return true");
        return true;
    }
}
