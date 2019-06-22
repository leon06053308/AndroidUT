package com.aiways.androidut;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

public class UIDeviceTest2 extends UIDeviceBase{

    private static UiDevice mDevice;

    @BeforeClass
    public static void initDevice(){
        mDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void NameTestCase1(){
        String value;

        //(1)start APP
        Log.i(TAG, "TestCase1: open APP");
        Utils.startAPP(mDevice, packageName ,launchActivityName);

        //(2)wait 1s
        mDevice.waitForWindowUpdate(packageName,1000);
        Log.i(TAG, "TestCase1: wait for 1s");

        //(3)Get Infos
        Log.i(TAG, "TestCase1: Get Package Name = "+mDevice.getProductName() + " in MainActivity");
        Log.i(TAG, "TestCase1: Get Current Package Name = "+mDevice.getCurrentPackageName() + " in MainActivity");
        Log.i(TAG, "TestCase1: Get Launcher Package Name = "+mDevice.getLauncherPackageName() + " in MainActivity");

        //(3)Jump to another Activity and get Infos again
        UiObject2 button=mDevice.findObject(By.res(packageName +  ":id/btn_goto2"));

        if(button==null){
            Log.i(TAG, "TestCase1: Do not find Button");
        }else {
            if(button.isEnabled()){
                button.click();
                mDevice.waitForWindowUpdate(packageName,1000);

                Log.i(TAG, "TestCase1: Get Package Name = "+mDevice.getProductName() + " in Main2Activity");
                Log.i(TAG, "TestCase1: Get Current Package Name = "+mDevice.getCurrentPackageName() + " in Main2Activity");
                Log.i(TAG, "TestCase1: Get Launcher Package Name = "+mDevice.getLauncherPackageName() + " in Main2Activity");
            }
        }

        //Utils.closeAPP(mDevice,packageName);
    }
}
