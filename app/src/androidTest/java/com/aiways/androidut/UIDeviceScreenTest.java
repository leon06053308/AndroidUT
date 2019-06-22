package com.aiways.androidut;

import android.graphics.Point;
import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;

import org.junit.Test;

public class UIDeviceScreenTest extends UIDeviceBase{
    boolean result;
    int timeOut=5000;

    @Test
    public void FunctionKeyTest(){

        Log.i(TAG, "Start Test");
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(1)Open APP
        Utils.startAPP(mDevice,packageName,launchActivityName);
        Log.i(TAG, "open APP");
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(2)Click Edit View1, then Search Button appear
        UiObject2 mInput1=mDevice.findObject(By.res(packageName + ":id/et_input1"));
        if(mInput1==null){
            Log.i(TAG, "Do not find Input1");
        }else {
            if (mInput1.isEnabled()) {
                mInput1.click();
                result = mDevice.waitForWindowUpdate(null, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                mInput1.setText("SSS");
                result=mDevice.pressSearch();
                Log.i(TAG, "Press Search Button, result = "+result);
                mDevice.waitForWindowUpdate(null,timeOut);
                Log.i(TAG, "wait For Window Update, result = "+result);
            }
        }

        //(3)Click Edit View2, then Menu Button appear
        UiObject2 mInput2=mDevice.findObject(By.res(packageName + ":id/et_input2"));
        if(mInput2==null){
            Log.i(TAG, "Do not find Input2");
        }else {
            if(mInput2.isEnabled()){
                mInput2.click();
                result=mDevice.waitForWindowUpdate(null,timeOut);
                Log.i(TAG, "wait For Window Update, result = "+result);

                mInput2.setText("AAA");
                result=mDevice.pressEnter();
                Log.i(TAG, "Press Enter Button, result = "+result);
                mDevice.waitForWindowUpdate(null,timeOut);
                Log.i(TAG, "wait For Window Update, result = "+result);

                result=mDevice.pressMenu();
                Log.i(TAG, "Press Menu Button, result = "+result);
                mDevice.waitForWindowUpdate(packageName,timeOut);
                Log.i(TAG, "wait For Window Update, result = "+result);
            }
        }

        //(4)Change Activity and Press Back Button
        UiObject2 button=mDevice.findObject(By.res(packageName + ":id/btn_goto2"));
        if(button==null){
            Log.i(TAG, "Do not find Button");
        }else {
            if (button.isEnabled()) {
                button.click();
                mDevice.waitForWindowUpdate(packageName, timeOut);
                result=mDevice.pressBack();
                Log.i(TAG, "Press Back Button, result = "+result);
                mDevice.waitForWindowUpdate(null,timeOut);
                Log.i(TAG, "wait For Window Update, result = "+result);
            }
        }

        //(5)Press Home Button
        result=mDevice.pressHome();
        Log.i(TAG, "Press Home Button, result = "+result);
        mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(6)Press Recent Button
        try {
            result=mDevice.pressRecentApps();
            Log.i(TAG, "Press Recet Apps Button, result = "+result);
            result=mDevice.waitForWindowUpdate(null,timeOut);
            Log.i(TAG, "wait For Window Update, result = "+result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //(7)Press Delete
        result=mDevice.pressDelete();
        Log.i(TAG, "Press Delete Button, result = "+result);
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(8)Press Home Button
        result=mDevice.pressHome();
        Log.i(TAG, "Press Home Button, result = "+result);
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(9)Open Notification
        result=mDevice.openNotification();
        Log.i(TAG, "Press Notification Button, result = "+result);
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(10)Press Home Button
        result=mDevice.pressHome();
        Log.i(TAG, "Press Home Button, result = "+result);
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(11)Open Quick Setting
        result=mDevice.openQuickSettings();
        Log.i(TAG, "Press Quick Setting Button, result = "+result);
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        //(12)Press Home Button
        result=mDevice.pressHome();
        Log.i(TAG, "Press Home Button, result = "+result);
        result=mDevice.waitForWindowUpdate(null,timeOut);
        Log.i(TAG, "wait For Window Update, result = "+result);

        Log.i(TAG, "End Test");
    }

    @Test
    public void FunctionKeyTest2() {

        Log.i(TAG, "Start Test");
        result = mDevice.waitForWindowUpdate(null, timeOut);
        Log.i(TAG, "wait For Window Update, result = " + result);

        //(1)Open APP
        Utils.startAPP(mDevice, packageName, launchActivityName);
        Log.i(TAG, "open APP");
        result = mDevice.waitForWindowUpdate(null, timeOut);
        Log.i(TAG, "wait For Window Update, result = " + result);

        //(2)Click Edit View1, then Search Button appear
        UiObject2 mInput1 = mDevice.findObject(By.res(packageName + ":id/et_input1"));
        if (mInput1 == null) {
            Log.i(TAG, "Do not find Input1");
        } else {
            if (mInput1.isEnabled()) {
                mInput1.click();
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                mInput1.setText("SSS");
                mDevice.waitForWindowUpdate(null, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                result = mDevice.pressDPadLeft();
                Log.i(TAG, "press DPad Left, result = " + result);
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                result = mDevice.pressDPadRight();
                Log.i(TAG, "press DPad Right, result = " + result);
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                result = mDevice.pressDPadDown();
                Log.i(TAG, "press DPad Down, result = " + result);
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                result = mDevice.pressDPadUp();
                Log.i(TAG, "press DPad Up, result = " + result);
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                result = mDevice.pressDPadDown();
                Log.i(TAG, "press DPad Down, result = " + result);
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);

                result = mDevice.pressDPadCenter();
                Log.i(TAG, "press DPad Center, result = " + result);
                result = mDevice.waitForWindowUpdate(packageName, timeOut);
                Log.i(TAG, "wait For Window Update, result = " + result);
            }
        }
    }

    @Test
    public void FunctionKeyTest4(){
        Log.i(TAG, "Start Test");
        mDevice.waitForIdle(timeOut);

        int h=mDevice.getDisplayHeight();
        int w=mDevice.getDisplayWidth();

        int left=200;
        int right=w-200;
        int step=50;
        Log.i(TAG, "left = "+left+" Right = "+right);

        //(1)From Right to Left
        Log.i(TAG, "from ("+right+","+h/2+") to ("+left+","+h/2+")");
        result=mDevice.swipe(right, h/2, left, h/2, step);
        Log.i(TAG, "Swipe result (Right to Left) = "+result);
        //mDevice.waitForIdle(timeOut);
        result = mDevice.waitForWindowUpdate(packageName, timeOut);
        Log.i(TAG, "wait For Window Update, result = " + result);


        //(2)From Left to Right
        Log.i(TAG, "from ("+left+","+h/2+") to ("+right+","+h/2+")");
        result=mDevice.swipe(left, h/2, right, h/2, step);
        Log.i(TAG, "Swipe result (Left to Right) = "+result);
        //mDevice.waitForIdle(timeOut);
        result = mDevice.waitForWindowUpdate(packageName, timeOut);
        Log.i(TAG, "wait For Window Update, result = " + result);


        //(3)Drag
        Log.i(TAG, "Dragfrom (300,1000) to (700,1000)");
        result=mDevice.drag(left, h/2, right, h/2, step);
        Log.i(TAG, "Drag result (Left to Right) = "+result);
        //mDevice.waitForIdle(timeOut);
        result = mDevice.waitForWindowUpdate(packageName, timeOut);
        Log.i(TAG, "wait For Window Update, result = " + result);


        //(4)From Left to Right
        Point[] pointArray=new Point[]{
                new Point(200,h/2),new Point(300,h/2),new Point(400,h/2),new Point(500,h/2),new Point(600,h/2),new Point(700,h/2),
        };
        result=mDevice.swipe(pointArray, step);
        Log.i(TAG, "Swipe by Array, result (Left to Right) = "+result);
        //mDevice.waitForIdle(timeOut);
        result = mDevice.waitForWindowUpdate(packageName, timeOut);
        Log.i(TAG, "wait For Window Update, result = " + result);


        //(5)Click
        result=mDevice.click(300, 1000);
        Log.i(TAG, "Click = "+result);
        //mDevice.waitForIdle(timeOut);
        result = mDevice.waitForWindowUpdate(packageName, timeOut);
        Log.i(TAG, "wait For Window Update, result = " + result);


    }
}
