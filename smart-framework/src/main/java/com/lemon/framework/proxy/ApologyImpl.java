package com.lemon.framework.proxy;

/**
 * Created by lemoon on 2020/3/24 4:47 PM
 */
public class ApologyImpl implements Apology {

    public void saySorry(String name) {
        System.out.println("Sorry!" + name);
    }
}
