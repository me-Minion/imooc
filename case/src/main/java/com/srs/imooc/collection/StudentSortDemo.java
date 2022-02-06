package com.srs.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSortDemo {


    public static void main(String[] args) {
        StudentSort peter = new StudentSort(40, "peter", 20);
        StudentSort angel = new StudentSort(28, "angel", 5);
        StudentSort tom = new StudentSort(35, "tom", 18);

        List<StudentSort> studentSortList = new ArrayList<>();
        studentSortList.add(peter);
        studentSortList.add(angel);
        studentSortList.add(tom);


        System.out.println("按名字排序前：");
        for (StudentSort studentSort : studentSortList) {
            System.out.println(studentSort.toString());
        }

//        Collections.sort(studentSortList, new StudentNameSort());

        //使用匿名内部类
        Collections.sort(studentSortList, new Comparator<StudentSort>() {
            @Override
            public int compare(StudentSort o1, StudentSort o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        System.out.println("按名字排序后：");
        for (StudentSort studentSort : studentSortList) {
            System.out.println(studentSort.toString());
        }
    }


}
