package com.aiways.androidut;

import android.graphics.Point;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;
import android.view.Surface;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


public class UIDeviceTest1 extends UIDeviceBase{


    @Before
    public void screenOn(){
        try {
            if(!mDevice.isScreenOn()){
                Log.i(TAG, "Screen is OFF, so Wakeup");
                mDevice.wakeUp();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDisplayInfo(){
        Log.i(TAG, "get Device Display High: "+mDevice.getDisplayHeight());
        Log.i(TAG, "get Device Display Width: "+mDevice.getDisplayWidth());
        checkRotation();
        Point point=mDevice.getDisplaySizeDp();
        Log.i(TAG, "get Device Size X: "+point.x);
        Log.i(TAG, "get Device Size Y: "+point.y);
    }

    @Test
    public void OrientationTest(){
        //(1)start APP
        Utils.startAPP(mDevice,packageName,packageName);
        mDevice.waitForWindowUpdate(packageName,1000);

        //(2)freeze Orientation
        try {
            mDevice.freezeRotation();
            Log.i(TAG, "Freeze Orientation");
            mDevice.waitForWindowUpdate(packageName,1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkRotation();

        //(3)turn left and check Orientation
        try {
            mDevice.setOrientationLeft();
            Log.i(TAG, "turn left");
            mDevice.waitForWindowUpdate(packageName,1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkRotation();

        //(4)turn right and check Orientation
        try {
            mDevice.setOrientationRight();
            Log.i(TAG, "turn right");
            mDevice.waitForWindowUpdate(packageName,1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkRotation();

        //(5)unfreeze Orientation
        try {
            mDevice.unfreezeRotation();
            Log.i(TAG, "Unfreeze Orientation");
            mDevice.waitForWindowUpdate(packageName,1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //(6)turn left and check Orientation
        try {
            mDevice.setOrientationLeft();
            Log.i(TAG, "turn left");
            mDevice.waitForWindowUpdate(packageName,1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkRotation();

        //(7)turn right and check Orientation
        try {
            mDevice.setOrientationRight();
            Log.i(TAG, "turn right");
            mDevice.waitForWindowUpdate(packageName,1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkRotation();

        //(8)check whether is Natural Orientation
        if(mDevice.isNaturalOrientation()){
            Log.i(TAG, "Natural Orientation");
        }else {
            Log.i(TAG, "Not Natural Orientation");
        }
        mDevice.waitForWindowUpdate(packageName,1000);

        //(9)set to Natural Orientation and then check Orientation
        try {
            Log.i(TAG, "set Orientation Natural");
            mDevice.setOrientationNatural();
            mDevice.waitForWindowUpdate(packageName,1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkRotation();

        //(10)close APP
        //Utils.closeAPP(mDevice,packageName);
    }

    private void checkRotation(){
        int rotation=mDevice.getDisplayRotation();
        switch (rotation){
            case Surface.ROTATION_0:
                Log.i(TAG, "get Device Display Rotation: 0");
                break;
            case Surface.ROTATION_90:
                Log.i(TAG, "get Device Display Rotation: 90");
                break;
            case Surface.ROTATION_180:
                Log.i(TAG, "get Device Display Rotation: 180");
                break;
            case Surface.ROTATION_270:
                Log.i(TAG, "get Device Display Rotation: 270");
                break;
        }
    }

    @After
    public void screenOff(){
        try {
            if(mDevice.isScreenOn()){
                Log.i(TAG, "Screen is ON, so Sleep");
                mDevice.sleep();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
