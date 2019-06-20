package com.aiways.androidut.junit.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class, Test2.class})
public class TestSuite {
    //不需要有任何实现方法
}
