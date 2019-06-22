package com.aiways.androidut;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class UIDeviceScreenShotTest extends UIDeviceBase{
    private String path;

    private void init(){
        Context context = InstrumentationRegistry.getTargetContext();
        path=context.getExternalCacheDir().getPath();
        Log.i(TAG, "init: path = " + path);
    }

    private File createFile(String path, String fileName){
        File file=new File(path,fileName);

        try {
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }

    @Test
    public void TestCase1(){
        init();
        File file = createFile(path, "1.png");
        Log.i(TAG, "TestCase1: file path =" + file.getPath());
        mDevice.takeScreenshot(file, 1.0f, 10);
        mDevice.waitForIdle();
    }
}
