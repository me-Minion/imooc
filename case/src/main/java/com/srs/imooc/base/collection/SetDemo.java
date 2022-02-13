package com.srs.imooc.base.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {


    public static void main(String[] args) {
        Set<Integer> set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 5) {
                iterator.remove();
            }
        }

        System.out.println(set);

        System.out.println("---------------------------");


        HashSet<Student> students = new HashSet<>();
        Student student1 = new Student(1, "Lucy", 87);
        Student student2 = new Student(2, "Tom", 95);
        Student student3 = new Student(3, "Wiliam", 65);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("添加重复元素");
        Student student4 = new Student(3, "Wiliam", 65);
//        Student student4 = new Student(3, "Wiliam4", 65);
        students.add(student4);
        for (Student student : students) {
            System.out.println(student);
        }




    }

}
