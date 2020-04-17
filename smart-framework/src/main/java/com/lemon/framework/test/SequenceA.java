package com.lemon.framework.test;

/**
 * Created by lemoon on 2020/4/10 9:52 AM
 */
public class SequenceA implements Sequence {

    private static int number = 0;

    public int getNumber() {
        number = number + 1;
        return number;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();

        ClientThread thread1= new ClientThread(sequence);
        ClientThread thread2= new ClientThread(sequence);
        ClientThread thread3= new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}