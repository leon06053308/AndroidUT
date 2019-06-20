package com.aiways.androidut.junit.rule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class NameRuleTest {
    //用@Rule注解来标记一个TestRule，注意必须是public修饰的
    @Rule
    public final MethodNameExample name = new MethodNameExample();

    @Test
    public void testA() {
    }

    @Test
    public void testB() {
    }
}
