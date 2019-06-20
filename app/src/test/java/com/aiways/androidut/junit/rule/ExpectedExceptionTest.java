package com.aiways.androidut.junit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.Matchers.startsWith;

//与@Test的属性expected作用类似，用来测试异常，但是它更灵活方便。
public class ExpectedExceptionTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    //不抛出任何异常
    @Test
    public void throwsNothing() {
    }

    //抛出指定的异常
    @Test
    public void throwsIndexOutOfBoundsException() {
        exception.expect(IndexOutOfBoundsException.class);
        new ArrayList<String>().get(0);
    }

    @Test
    public void throwsNullPointerException() {
        exception.expect(NullPointerException.class);
        exception.expectMessage(startsWith("null pointer"));
        throw new NullPointerException("null pointer......oh my god.");
    }
}
