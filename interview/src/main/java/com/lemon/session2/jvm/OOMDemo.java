package com.lemon.session2.jvm;

/**
 * Created by lemoon on 20/2/25 下午2:57
 */
public class OOMDemo {
    public static void main(String[] args) {
        String[] str = new String[80 * 1024 * 1024];
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
