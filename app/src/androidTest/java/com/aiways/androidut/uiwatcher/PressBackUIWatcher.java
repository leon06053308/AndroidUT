package com.aiways.androidut.uiwatcher;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

public class PressBackUIWatcher implements UiWatcher {
    private final String TAG=getClass().getName();

    private UiDevice mUIDevice;

    public PressBackUIWatcher(UiDevice mUIDevice) {
        this.mUIDevice = mUIDevice;
    }

    @Override
    public boolean checkForCondition() {
        Log.i(TAG, "press back");
        mUIDevice.pressBack();
        return false;
    }
}
