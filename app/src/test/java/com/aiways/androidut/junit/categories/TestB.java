package com.aiways.androidut.junit.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({CategoryMarker.FastTests.class, CategoryMarker.SlowTests.class})
public class TestB {
    @Test
    public void c() {
        System.out.println("method c() called in class TestB");
    }
}
