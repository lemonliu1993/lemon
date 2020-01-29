package com.lemon.bean;

/**
 * Created by lemoon on 20/1/27 上午10:33
 */
public class Color {


    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

//    public Color(Car car) {
//        this.car = car;
//    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
