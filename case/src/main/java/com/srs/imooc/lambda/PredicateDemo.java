package com.srs.imooc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("php");
        list.add("python");
        list.add("HTML");
        filter(list, x->(x.indexOf("h") != -1));
    }

    public static void filter(List<String> list, Predicate<String> predicate) {
        for (String s : list) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }
    }

}
