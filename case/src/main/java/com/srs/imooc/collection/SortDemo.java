package com.srs.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("orange");
        stringList.add("tomato");
        stringList.add("apple");
        stringList.add("litchi");
        stringList.add("banana");
        System.out.println("排序前");
        for (String s : stringList) {
            System.out.print(s + " ");
        }
        Collections.sort(stringList);
        System.out.println("排序后");
        for (String s : stringList) {
            System.out.print(s + " ");
        }
    }

}
