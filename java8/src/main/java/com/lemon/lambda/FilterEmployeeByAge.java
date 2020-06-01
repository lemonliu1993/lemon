package com.lemon.lambda;

/**
 * Created by lemoon on 2020/6/1 11:49 PM
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getAge() >= 35;
    }
}
