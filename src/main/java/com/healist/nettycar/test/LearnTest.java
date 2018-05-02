package com.healist.nettycar.test;

import org.springframework.util.Assert;

/**
 * @Author healist
 * @Description
 * @Create 2018-03-31 上午9:29
 */
public class LearnTest {

    public static void main(String[] args) {
        Object obj = null;
        Assert.isAssignable(Object.class, String.class, "nonono");
        Assert.notNull(obj, "null");
        System.out.println("hello world");
    }

}
