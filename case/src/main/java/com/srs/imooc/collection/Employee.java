package com.srs.imooc.collection;

public class Employee implements Comparable<Employee> {

    private String id;

    private String name;

    private  double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "员工{" +
                "编号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 工资=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        //  薪资降序
        return new Double(o.getSalary() - this.getSalary()).intValue();
    }
}
