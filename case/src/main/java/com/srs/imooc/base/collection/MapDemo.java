package com.srs.imooc.base.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2014, "德国");
        map.put(2010, "西班牙");
        map.put(2006, "意大利");
        map.put(2002, "巴西");
        map.put(1998, "法国");

        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }


}
