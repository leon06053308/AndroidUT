package com.aiways.androidut.junit;

import org.junit.Test;

public class TimeoutTest {
    //该方法会在一个单独的线程中执行，单位为毫秒，这里超时时间为2秒
    @Test(timeout = 2000)
    public void testTimeout() {
        System.out.println("timeout method called in thread " + Thread.currentThread().getName());
    }

    //该方法默认会在主线程中执行
    @Test
    public void testNormalMethod() {
        System.out.println("normal method called in thread " + Thread.currentThread().getName());
    }

    //该方法指定了timeout时间为1秒，实际运行时会超过1秒，该方法测试无法通过
    @Test(timeout = 1000)
    public void testTimeout2() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
