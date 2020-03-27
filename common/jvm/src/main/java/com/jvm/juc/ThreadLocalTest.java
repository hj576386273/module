package com.jvm.juc;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2020年03月27日 17:25
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("123");
    }
}
