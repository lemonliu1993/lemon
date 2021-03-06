package com.lemon.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemoon on 2020/5/3 9:51 PM
 */
public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//管理学院员工的管理类
class CollegeManager {
    //返回学院的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id=" + i);
            list.add(emp);
        }
        return list;
    }

}


//学校管理类

//分析 SchoolManager类的直接朋友类有哪些 Employee,CollegeManager
//CollegeEmployee 不是直接朋友 而是一个陌生类，这样违背了迪米特法则
class SchoolManager {

    //该方法完成输出学习总部和学院员工信息(id)
    void printAllEmployee(CollegeManager sub) {
        //分析问题
        //1.这里的CollegeEmployee不是SchoolManager的直接朋友
        //2.CollegeEmployee是以局部变量方式出现在SchoolManager
        //3.违反了迪米特法则

        //获取到学院员工
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("---------学院员工----------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }

        //获取到学校总部员工
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("---------学校总部员工----------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }

    private List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee emp = new Employee();
            emp.setId("学校员工id=" + i);
            list.add(emp);
        }
        return list;
    }
}