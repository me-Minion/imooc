package com.srs.imooc.collection;

import java.util.ArrayList;

public class ListDemo {


    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("语文");
        strings.add("数学");
        strings.add("英语");
        strings.add("化学");
        strings.add("物理");
        strings.add("生物");
        System.out.println("列表中元素的个数为：" + strings.size());
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("第" + (i + 1)+ "个为"+strings.get(i));
        }

        System.out.println("--------------------------");


        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("张三", 5000);
        Employee employee2 = new Employee("李四", 5500);
        Employee employee3 = new Employee("赵六", 5000);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println("员工姓名    员工薪资");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

}
