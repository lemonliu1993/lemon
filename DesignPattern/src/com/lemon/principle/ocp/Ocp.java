package com.lemon.principle.ocp;

/**
 * Created by lemoon on 2020/5/3 6:40 PM
 */
public class Ocp {
    public static void main(String[] args) {

    }
}

//这是一个用于绘图的类
class GraphicEditor {
    //接收Shape对象，然后根据type来绘制不同的图形
    public void drawShape(Shape s) {
        if (s.m_type == 1) {
            drawRectangle(s);
        } else if (s.m_type == 2) {
            drawCircle(s);
        }
    }

    private void drawCircle(Shape s) {
        System.out.println("圆形");
    }

    private void drawRectangle(Shape s) {
        System.out.println("矩形");
    }
}


class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        this.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        this.m_type = 2;
    }
}
