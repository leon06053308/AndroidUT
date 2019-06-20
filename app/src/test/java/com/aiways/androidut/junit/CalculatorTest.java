package com.aiways.androidut.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
    Caculator caculator;

    //必须为static void
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass...");
    }

    @Before
    public void before(){
        System.out.println("before...");
        caculator = new Caculator();
    }

    @Test
    public void testAdd() throws Exception{
        System.out.println("testAdd...");
        int sum = caculator.add(1,2);
        Assert.assertEquals(3, sum);
    }

    @Test
    public void testAdd2() throws Exception{
        System.out.println("testAdd2...");
        int sum = caculator.add(3,2);
        Assert.assertEquals(6, sum);
    }

    @Test
    public void testMultiply() throws Exception{
        System.out.println("testMultiply...");
        int product = caculator.multiply(2,4);
        Assert.assertEquals(8, product);
    }

    @Test
    @Ignore("not implemented yet")
    public void testFactorial() {
        System.out.println("testFactorial...");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivide(){
        System.out.println("testDivide...");
        caculator.divide(4, 0);
    }

    @After
    public void after(){
        System.out.println("after...");
        caculator = new Caculator();
    }

    //必须为static void
    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass...");
    }
}
