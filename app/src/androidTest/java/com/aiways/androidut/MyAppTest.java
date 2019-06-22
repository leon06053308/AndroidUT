package com.aiways.androidut;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyAppTest extends UIDeviceBase{
    private static final String TAG = "AW";

    public  static UiDevice mDevice;

    @BeforeClass
    public static void init(){
        Log.i(TAG, "init ");
        mDevice=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Before
    public void OpenAPP(){
        Log.i(TAG, "OpenAPP ");
        try {
            if(!mDevice.isScreenOn()){  //唤醒屏幕
                mDevice.wakeUp();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Utils.startAPP(packageName);  //启动app
        //Utils.startAPP(mDevice, packageName, launchActivityName);
        mDevice.waitForWindowUpdate(packageName, 2 * 2000);
    }

    @Test
    public void case1(){
        Log.i(TAG, "case1 ");
    }

    @Test
    public void case3(){
        Log.i(TAG, "case3 ");
    }

    @Test
    public void case20(){
        Log.i(TAG, "case20 ");
    }

    @Test
    public void case21(){
        Log.i(TAG, "case21 ");
    }

    @Test
    @Ignore
    public void case5(){
        Log.i(TAG, "case5 ");
    }

    @After
    public void closeAPP(){
        Log.i(TAG, "closeAPP ");
        //Utils.closeAPP(mDevice,packageName);
    }

    @AfterClass
    public static void destroy(){
        Log.i(TAG, "destroy ");
        mDevice=null;
    }
}
