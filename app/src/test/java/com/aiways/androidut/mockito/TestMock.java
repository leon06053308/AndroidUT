package com.aiways.androidut.mockito;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestMock {

    @Test
    public void test(){
        // 利用 List.class 创建一个 mock 对象 --- mockedList
        List mockedList = mock(List.class);

// 操作 mockedList
        mockedList.add("one");
        mockedList.clear();

// 验证
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
