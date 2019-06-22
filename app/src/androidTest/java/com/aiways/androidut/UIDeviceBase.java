package com.aiways.androidut;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UIDeviceBase {
    public static final String packageName = "com.aiways.androidut";
    public static final String launchActivityName=".MainActivity";
    public final static String TAG = "AW";


    public static UiDevice mDevice;

    @BeforeClass
    public static void initDevice(){
        mDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @AfterClass
    public static void destroy(){
        mDevice = null;
    }
}
