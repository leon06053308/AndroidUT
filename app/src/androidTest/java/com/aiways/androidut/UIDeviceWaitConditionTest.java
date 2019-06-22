package com.aiways.androidut;

import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.Test;

public class UIDeviceWaitConditionTest extends UIDeviceBase{

    @Test
    public void test1(){

        Utils.startAPP(mDevice, packageName, launchActivityName);


        boolean result1 = mDevice.performActionAndWait(new Runnable() {
            @Override
            public void run() {

            }
        }, Until.newWindow(), 5000);

        Log.i(TAG, "test1:result=" + result1);


        mDevice.waitForWindowUpdate(packageName, 5000);


        //Utils.closeAPP(mDevice, packageName);
    }
}
