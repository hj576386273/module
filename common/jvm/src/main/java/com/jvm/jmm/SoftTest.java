package com.jvm.jmm;

import java.lang.ref.SoftReference;

/**
 * 软引用测试
 * @author huangjian
 * @version 1.0
 * @date: 2020年03月27日 16:47
 */
public class SoftTest {

    public static void main(String[] args) {

        SoftReference<byte[]> sr = new SoftReference<byte[]>(new byte[1024*1024*10]);

        System.gc();
        System.out.println("1:"+sr.get());

        byte[] bytes = new byte[1024*1024*15];
        System.out.println("2:"+sr.get());

    }
}
