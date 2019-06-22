package com.aiways.androidut;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

//adb pull /storage/emulated/0/Android/data/com.aiways.androidut/cache/1.xml
public class UIDeviceHierarchyTest extends UIDeviceBase{
    private String path;

    private void init() {
        Context context = InstrumentationRegistry.getTargetContext();
        path = context.getExternalCacheDir().getPath();
        Log.i(TAG, "init:path=" + path);
    }

    @Test
    public void TestCase1(){
        init();

        dumpWindowHierarchy(false, "1.xml");
        dumpWindowHierarchy(true, "2.xml");
    }

    private void dumpWindowHierarchy(boolean pressed, String fileName){
        mDevice.setCompressedLayoutHeirarchy(pressed);
        Log.i(TAG, "TestCase1: set Compressed Layout Heirarchy to " + pressed);

        File file = new File(path, fileName);

        try{
            if (!file.exists()){
                file.createNewFile();
            }
            mDevice.dumpWindowHierarchy(file);
        }catch (IOException e){
            e.printStackTrace();
        }

        mDevice.waitForIdle();

        Log.i(TAG, "file path = " + file.getPath());
    }
}
