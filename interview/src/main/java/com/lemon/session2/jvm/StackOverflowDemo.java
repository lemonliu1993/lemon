package com.lemon.session2.jvm;

/**
 * Created by lemoon on 20/2/25 上午10:00
 */
public class StackOverflowDemo {

    public static void main(String[] args) {
        stackOverflow();
    }

    private static void stackOverflow() {
        stackOverflow();
        //Exception in thread "main" java.lang.StackOverflowError
    }
}
