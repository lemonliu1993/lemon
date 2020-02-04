package com.lemon.session2.juc.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * volatile学习
 * Created by lemoon on 20/2/3 上午10:24
 */
class MyData {
//     int number = 0;
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}

/**
 * 验证volatile的可见性
 * 1.1假如int number=0;number变量之前根本没有添加volatile关键字修饰，没有可见性
 */

public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();//资源类
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            //暂停一会线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {

            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value" + myData.number);
        }, "AAA").start();
        //第二个线程就是我们的main线程
        while (myData.number == 0) {
            //main线程就一直在这里等待循环，知道number值不等于0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission over" + myData.number);

    }


}
