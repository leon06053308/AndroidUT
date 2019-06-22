package com.aiways.androidut.mockito;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestSpy {

    @Test
    public void test(){
        List list = new LinkedList();
        List spy = spy(list);

// optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

// using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

// prints "one" - the first element of a list
        System.out.println(spy.get(0));

// size() method was stubbed - 100 is printed
        System.out.println(spy.size());

// optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
    }
}
