package com.aiways.androidut.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutRuleTest {
    @Rule
    public final Timeout globalTimeout = Timeout.millis(20);

    @Test
    public void testInfiniteLoop1(){
        for (;;){}
    }

    @Test
    public void testInfiniteLoop2(){
        for (;;){}
    }
}
