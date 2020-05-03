package com.lemon.principle.ocp.improve;

/**
 * Created by lemoon on 2020/5/3 6:40 PM
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();

        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new OtherGraphics());
    }
}

//这是一个用于绘图的类
class GraphicEditor {
    //接收Shape对象，然调用draw方法
    public void drawShape(Shape s) {
        s.draw();
    }

}


abstract class Shape {
    int m_type;

    public abstract void draw();//抽象方法
}

class Rectangle extends Shape {
    Rectangle() {
        this.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape {
    Circle() {
        this.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}


//新增一个图形
class OtherGraphics extends Shape{
    @Override
    public void draw() {
        System.out.println("绘制其他图形");
    }
}