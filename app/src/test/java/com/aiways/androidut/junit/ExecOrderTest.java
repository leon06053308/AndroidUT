package com.aiways.androidut.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//MethodSorters.NAME_ASCENDING（按名称升序），MethodSorters.JVM（每次执行可能都不一样）
@FixMethodOrder(MethodSorters.JVM)
public class ExecOrderTest {
    @Test
    public void testD() {
        System.out.println("DDDDD");
    }

    @Test
    public void testA() {
        System.out.println("AAAAA");
    }

    @Test
    public void testB() {
        System.out.println("BBBBB");
    }

    @Test
    public void testC() {
        System.out.println("CCCCC");
    }
}
