package com.lemon.principle.inversion;

/**
 * Created by lemoon on 2020/5/2 10:33 PM
 */
public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

//完成Person接受消息的功能
//方式1分析
//1.简单，比较容器想到
//2.如果我们获取到的对象是微信，短信等等，则新增类，同时Person类也要增加相应的接受方法
//3.解决思路：引入一个抽象的接口IReceiver,表示接收者，这样Person类与接口发送依赖
//  因为Email，微信等都属于接收的范围，它们各自实现IReceiver接口就ok，这样我们就符合依赖倒转原则
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
