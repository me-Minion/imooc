package com.srs.imooc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {


    /**
     * 使用Function<T,R>函数式接口，寻找list中最大值
     * T：为入参类型
     * R：为返回值类型
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(78,2,53,1104,189,101);

        Function<List<Integer>, Integer> function = x-> {
            int max = x.get(0);
            for (Integer integer : x) {
                if (integer > max) {
                    max = integer;
                }
            }
            return max;
        };
        System.out.println(function.apply(list));
    }

}
