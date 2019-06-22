package com.aiways.androidut;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UIObjectTest extends UIDeviceBase{
    private String text_Text = "input";
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
        Utils.closeAPP(mDevice,packageName);
        waitForAMoment();
    }

    @Test
    public void test1(){
        UiObject2 uiObject2 = null;
        UiObject uiObject = null;
        List<UiObject2> uiObject2List = null;
        boolean result=false;
        String input1="hello";
        String input2="world";

        Log.i(TAG, "start");
        result = mDevice.hasObject(By.textStartsWith(text_Text));
        Log.i(TAG, (result?"":"Do Not ")+"find UI start with "+text_Text);
        waitForAMoment();

        uiObject2=mDevice.findObject(By.textStartsWith(text_Text));
        if(uiObject2!=null){
            uiObject2.setText(input1);
            waitForAMoment();
            uiObject2.setText(text_Text);
        }
        waitForAMoment();

        uiObject2List=mDevice.findObjects(By.textStartsWith(text_Text));
        if(uiObject2List!=null){
            Log.i(TAG, "find "+uiObject2List.size()+" items");
            for (UiObject2 item :
                    uiObject2List) {
                item.setText(input2);
                waitForAMoment();
            }
        }

        uiObject=mDevice.findObject(new UiSelector().textStartsWith(input2));
        if(uiObject!=null){
            Log.i(TAG, "find UIObject by text "+input2);
            uiObject2.setText(input1);
        }
        waitForAMoment();
        Log.i(TAG, "end");
    }
}
