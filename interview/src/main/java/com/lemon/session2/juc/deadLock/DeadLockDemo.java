package com.lemon.session2.juc.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by lemoon on 20/2/22 下午10:48
 */
class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"自己持有:"+lockA+"尝试获得:"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"自己持有:"+lockB+"尝试获得:"+lockA);

            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();
    }
}
