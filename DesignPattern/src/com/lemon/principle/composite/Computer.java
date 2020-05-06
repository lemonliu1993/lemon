package com.lemon.principle.composite;

/**
 * Created by lemoon on 2020/5/6 11:24 PM
 */
public class Computer {
    private Mouse mouse;
    private Monitor monitor;

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}

class Mouse{

}

class Monitor{

}