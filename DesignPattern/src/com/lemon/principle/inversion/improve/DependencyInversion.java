package com.lemon.principle.inversion.improve;

/**
 * Created by lemoon on 2020/5/2 10:33 PM
 */
public class DependencyInversion {

    public static void main(String[] args) {
        //客户端无需改变
        Person person = new Person();
        person.receive(new WeiXin());
    }
}

//定义接口
interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}


//增加微信
class WeiXin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信,hello,world";
    }
}

//方式2
class Person {
    //这里我们是对接口的依赖
    public void receive(IReceiver iReceiver) {
        System.out.println(iReceiver.getInfo());
    }
}
