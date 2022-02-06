package com.srs.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSalarySortDemo {


    public static void main(String[] args) {
        Employee zhangsan = new Employee("emp001","张三", 1800);
        Employee lisi = new Employee("emp002","李四", 2500);
        Employee wangwu = new Employee("emp003","王五", 1600);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(zhangsan);
        employeeList.add(lisi);
        employeeList.add(wangwu);
        System.out.println("按薪资降序排序前：");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
        Collections.sort(employeeList);
        System.out.println("按薪资降序排序后：");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
        //如果既实现了comparable接口，又实现了comparator接口，到底谁生效呢
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        System.out.println("按名字降序排序后：");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }



    }

}
