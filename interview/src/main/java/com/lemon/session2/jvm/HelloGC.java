package com.lemon.session2.jvm;

/**
 * Created by lemoon on 20/2/20 下午3:17
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("HelloGC");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
