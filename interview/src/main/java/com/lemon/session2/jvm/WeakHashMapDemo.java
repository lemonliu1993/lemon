package com.lemon.session2.jvm;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by lemoon on 20/2/24 上午11:23
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("===================");
        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Integer key = new Integer(2);
        String value = "map";
        map.put(key, value);
        System.out.println(map);

        key = null;
        value = null;
        System.out.println(map);
        System.gc();
        System.out.println(map + "\t" + map.size());
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<Integer, String>();
        Integer key = new Integer(2);
        String value = "map";
        map.put(key, value);
        System.out.println(map);

//        key = null;
        value = null;
        System.out.println(map);
        System.gc();
        System.out.println(map + "\t" + map.size());
    }
}
