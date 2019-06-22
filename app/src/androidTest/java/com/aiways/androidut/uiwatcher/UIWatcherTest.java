package com.aiways.androidut.uiwatcher;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import com.aiways.androidut.UIDeviceBase;
import com.aiways.androidut.Utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UIWatcherTest extends UIDeviceBase {

    private String text_check="check";

    private long timeout=1000l;

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
        /*Utils.closeAPP(mDevice,packageName);
        waitForAMoment();*/
    }

    @Test
    public void test1(){
        boolean result=true;
        UiObject ui=mDevice.findObject(new UiSelector().textStartsWith(text_check));

        //注册UIWatcher
        mDevice.registerWatcher("LogTrue",new LogAndTrueUIWatcher());
        mDevice.registerWatcher("LogFalse",new LogAndFalseUIWatcher());
        mDevice.registerWatcher("PressBack", new PressBackUIWatcher(mDevice));

        Assert.assertFalse(mDevice.hasAnyWatcherTriggered());

        //创建线程，在2秒后，启动其他APP，以打断现有操作
        new Thread() {
            @Override
            public void run() {
                Log.i(TAG, "run: start Salary APP");
                try {
                    sleep(timeout*2);
                } catch (InterruptedException e) {
                    Log.i(TAG, "Sleep failed");
                    e.printStackTrace();
                }

                Utils.startAPP(mDevice,"com.example.dagger2demo",".ui" + launchActivityName);
            }
        }.start();

        //连续点击checkbox，之后将被打断
        for(int loop=0;loop<10;loop++){
            try {
                Log.i(TAG, "Click Check "+loop);
                ui.click();
                waitForAMoment();
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
                result=false;
            }
        }

        //查看UIWatcher触发情况，即各UIWatcher的checkForCondition方法返回值
        Assert.assertTrue("LogTrue was Triggered", mDevice.hasWatcherTriggered("LogTrue"));
        Assert.assertFalse("LogFalse was not Triggered",mDevice.hasWatcherTriggered("LogFalse"));
        Assert.assertFalse("PressBack was not Triggered",mDevice.hasWatcherTriggered("PressBack"));

        //重置各UIWatcher的触发标志位
        mDevice.resetWatcherTriggers();

        //再次查看UIWatcher触发情况
        Assert.assertFalse("LogTrue was not Triggered",mDevice.hasWatcherTriggered("LogTrue"));
        Assert.assertFalse("LogFalse was not Triggered",mDevice.hasWatcherTriggered("LogFalse"));
        Assert.assertFalse("PressBack was not Triggered",mDevice.hasWatcherTriggered("PressBack"));

        //移除LogTrue，然后运行剩余UIWatcher
        mDevice.removeWatcher("LogTrue");
        mDevice.runWatchers();

        //移除LogFalse，然后运行剩余UIWatcher
        mDevice.removeWatcher("LogFalse");
        mDevice.runWatchers();

        //移除PressBack，然后运行剩余UIWatcher
        mDevice.removeWatcher("PressBack");
        mDevice.runWatchers();

        //查看打断后的CASE是否能够PASS
        assertTrue(result);
    }
}
