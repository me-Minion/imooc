package com.srs.imooc.lambda;

public class LambdaDemo {

    public static void main(String[] args) {
        //1、标准使用方式
        //约束条件：Lambda表达式只能实现有且只有一个抽象方法的接口，Java称之为“函数式接口”
        //接口中只有一个抽象方法--> 接口中只能有一个方法呗
        MathOperation addition = (Integer a, Integer b) -> {
            return a + b + 0f;
        };
        System.out.println(addition.oprate(5, 8));
        System.out.println("-------------------------");
        //2、忽略参数类型
        MathOperation substraction = (a, b) -> {
            return a - b + 0f;
        };
        System.out.println(substraction.oprate(5, 8));
        //3、单行可以忽略{} 和 return ；参数只有一个时可以省略()
        System.out.println("-------------------------");
        MathOperation multiplication = (a, b) -> a * b + 0f;
        System.out.println(multiplication.oprate(5, 8));
    }

}
