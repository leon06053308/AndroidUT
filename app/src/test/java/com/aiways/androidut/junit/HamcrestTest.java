package com.aiways.androidut.junit;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.closeTo;

public class HamcrestTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("HamcrestTest start...");

    }

    @Test
    public void testString(){
        System.out.println("testString...");
        Assert.assertThat("android studio", startsWith("and"));
        Assert.assertThat("android studio", endsWith("dio"));
        Assert.assertThat("android studio", containsString("android"));
        Assert.assertThat("android studio", equalToIgnoringCase("ANDROID studio"));
        Assert.assertThat("android studio ", equalToIgnoringWhiteSpace(" android studio "));
    }

    //数字测试
    @Test
    public void testNumber(){
        System.out.println("testNumber...");

        //测试数字在某个范围之类，10.6在[10.5-0.2, 10.5+0.2]范围之内
        Assert.assertThat(10.6, closeTo(10.5, 0.2));
        //测试数字大于某个值
        Assert.assertThat(10.6, greaterThan(10.5));
        //测试数字小于某个值
        Assert.assertThat(10.6, lessThan(11.0));
        //测试数字小于等于某个值
        Assert.assertThat(10.6, lessThanOrEqualTo(10.6));
        //测试数字大于等于某个值
        Assert.assertThat(10.6, greaterThanOrEqualTo(10.6));
    }

    //集合类测试
    @Test
    public void testCollection(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "hello");
        map.put("b", "world");
        map.put("c", "haha");
        //测试map包含某个entry
        Assert.assertThat(map, hasEntry("a", "hello"));
        //测试map是否包含某个key
        Assert.assertThat(map, hasKey("a"));
        //测试map是否包含某个value
        Assert.assertThat(map, hasValue("hello"));
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        //测试list是否包含某个item
        Assert.assertThat(list, hasItem("a"));
        Assert.assertThat(list, hasItems("a", "b"));
        //测试数组是否包含某个item
        String[] array = new String[]{"a", "b", "c", "d"};
        Assert.assertThat(array, hasItemInArray("a"));
    }

    //测试对象
    @Test
    public void testObject(){
        //测试对象不为null
        Assert.assertThat(new Object(), notNullValue());
        Object obj = null;
        //测试对象为null
        Assert.assertThat(obj, nullValue());
        String str = null;
        Assert.assertThat(str, nullValue(String.class));
        obj = new Object();
        Object obj2 = obj;
        //测试2个引用是否指向的通一个对象
        Assert.assertThat(obj, sameInstance(obj2));
        str = "abc";
        Assert.assertThat(str, instanceOf(String.class));

        //测试JavaBean对象是否有某个属性
        //Assert.assertThat(new UserInfo(), hasProperty("name"));
        //Assert.assertThat(new UserInfo(), hasProperty("age"));
    }

    //组合逻辑测试
    public void testLogic(){
        //两者都满足，a && b
        Assert.assertThat(10.4, both(greaterThan(10.0)).and(lessThan(10.5)));
        //所有的条件都满足，a && b && c...
        Assert.assertThat(10.4, allOf(greaterThan(10.0), lessThan(10.5)));
        //任一条件满足，a || b || c...
        Assert.assertThat(10.4, anyOf(greaterThan(10.3), lessThan(10.4)));
        //两者满足一个即可，a || b
        Assert.assertThat(10.4, either(greaterThan(10.0)).or(lessThan(10.2)));
        Assert.assertThat(10.4, is(10.4));
        Assert.assertThat(10.4, is(equalTo(10.4)));
        Assert.assertThat(10.4, is(greaterThan(10.3)));
        String str = new String("abc");
        Assert.assertThat(str, is(instanceOf(String.class)));
        Assert.assertThat(str, isA(String.class));
        Assert.assertThat(10.4, not(10.5));
        Assert.assertThat(str, not("abcd"));

        Assert.assertThat(str, any(String.class));
        Assert.assertThat(str, anything());
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("HamcrestTest end...");
    }
}
