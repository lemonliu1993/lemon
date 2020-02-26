package com.lemon.session2.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemoon on 20/2/25 下午3:04
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("****************");
            e.printStackTrace();
            throw e;
            //java.lang.OutOfMemoryError: GC overhead limit exceeded
        }
    }
}
