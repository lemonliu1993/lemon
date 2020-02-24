package com.lemon.session2.jvm;

import java.lang.ref.WeakReference;

/**
 * Created by lemoon on 20/2/24 下午4:31
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        ;
        System.out.println("==================");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
