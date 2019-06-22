package com.aiways.androidut;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UIDeviceWaitTest extends UIDeviceBase{
    private String text_button1 = "Goto";

    private String text_button2 = "OPEN ACTIVITY";

    private String text_check = "check";
    private long timeout = 2000l;

    @Before
    public void start(){
        Utils.startAPP(mDevice,packageName,launchActivityName);
        waitForAMoment();
    }

    private void waitForAMoment(){
        mDevice.waitForWindowUpdate(packageName,timeout);
    }

    @After
    public void end(){
        //Utils.closeAPP(mDevice,packageName);
        //waitForAMoment();
    }

    @Test
    public void Test1(){
        UiObject2 ui2 = null;
        List<UiObject2> uiObject2List = null;
        boolean result = false;

        Log.i(TAG, "Test: start");
        ui2=mDevice.wait(Until.findObject(By.text(text_button1)), timeout);
        Log.i(TAG, "Test1: "+(ui2!=null?"":"Do Not ")+"find UI with txt "+text_button1);

        ui2=mDevice.wait(Until.findObject(By.text(text_button2)),timeout);
        Log.i(TAG, "Test2: "+(ui2!=null?"":"Do Not ")+"find UI with txt "+text_button2);

        result=mDevice.wait(Until.hasObject(By.text(text_button1)),timeout);
        Log.i(TAG, "Test3: "+(result?"":"Do Not ")+"find UI with txt "+text_button1);

        result=mDevice.wait(Until.hasObject(By.text(text_button2)),timeout);
        Log.i(TAG, "Test4: "+(result?"":"Do Not ")+"find UI with txt "+text_button2);

        result=mDevice.wait(Until.gone(By.text(text_button1)),timeout);
        Log.i(TAG, "Test5: "+(result?"Do Not ":"")+"find UI with txt "+text_button1);

        result=mDevice.wait(Until.gone(By.text(text_button2)),timeout);
        Log.i(TAG, "Test6: "+(result?"Do Not ":"")+"find UI with txt "+text_button2);

        uiObject2List=mDevice.wait(Until.findObjects(By.textStartsWith(text_check)),timeout);
        Log.i(TAG, "Test7: "+(uiObject2List!=null?"":"Do Not ")+"find UI with txt "+text_check);
        if(uiObject2List!=null){
            for (UiObject2 item :
                    uiObject2List) {
                item.click();
                waitForAMoment();
            }
        }

        uiObject2List=mDevice.wait(Until.findObjects(By.text(text_check)),timeout);
        Log.i(TAG, "Test8: "+(uiObject2List!=null?"":"Do Not ")+"find UI with txt "+text_check);
        if(uiObject2List!=null){
            for (UiObject2 item :
                    uiObject2List) {
                item.click();
                waitForAMoment();
            }
        }
        Log.i(TAG, "Test: end");
    }
}
