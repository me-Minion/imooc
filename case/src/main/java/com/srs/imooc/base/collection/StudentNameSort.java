package com.srs.imooc.base.collection;

import java.util.Comparator;

public class StudentNameSort implements Comparator<StudentSort> {
    @Override
    public int compare(StudentSort o1, StudentSort o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }
}
