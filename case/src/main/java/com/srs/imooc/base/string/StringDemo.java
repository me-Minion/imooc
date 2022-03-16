package com.srs.imooc.base.string;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shaorensheng
 * @date 2022/1/28
 */
public class StringDemo {

    public static void main(String[] args) {
        User user = new User();
        user.setIid(4);
        user.setId(31);
        Integer i = user.getIid();
        i = i < 0 ? 0 :i;
        i = i > user.getId() ? user.getId()  :i;
        System.out.println(i);


        String asd = JSONObject.toJSONString("asd");
        System.out.println(asd);

        String obj= "asd";
        Type t = String.class;
        System.out.println(t.getTypeName());
        System.out.println( String.class.getTypeName().equals(t.getTypeName()));
        System.out.println(t.getTypeName() == String.class.getTypeName());
        //if (t instanceof String) {
        //    String asd1 = JSONObject.parseObject(obj, String.class);
        //    System.out.println(asd1);
        //}


        String a = null;
        System.out.println(JSONObject.toJSONString(a));

        System.out.println(JSONObject.parseObject("123", Integer.class));
        //Object o = JSONObject.parseObject("abc", String.class);
        //System.out.println(o);


        Date startTime = new Date(1646064000000L);
        Date endTime = new Date(1646755200000L);
        //Date endTime = new Date(1646841599000L);

        long l = DateUtil.betweenDay(startTime, endTime, true);
        System.out.println(l);


        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Map<Integer, Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toMap(x -> x, Function.identity()));
        //System.out.println(collect);



    }

}
