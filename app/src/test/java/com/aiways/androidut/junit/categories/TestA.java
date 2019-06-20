package com.aiways.androidut.junit.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestA {
    @Test
    public void a(){
        System.out.println("method a() called in Class TestA");
    }

    @Category(CategoryMarker.SlowTests.class)
    @Test
    public void b(){
        System.out.println("method b() called in Class TestA");
    }
}
