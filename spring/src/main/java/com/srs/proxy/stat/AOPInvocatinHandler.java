package com.srs.proxy.stat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author shaorensheng
 * @date 2022/3/18
 */
public class AOPInvocatinHandler implements InvocationHandler {


    private RoomRent roomRent;

    public AOPInvocatinHandler(RoomRent roomRent) {
        this.roomRent = roomRent;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法前
        System.out.println(method.getName() + "方法调用前");
        Object invoke = method.invoke(roomRent, args);//方法调用
        //方法后
        System.out.println(method.getName() + "方法调用后");
        return invoke;
    }

    public static void main(String[] args) {
        //房东通过proxy的方式出租房屋
        Landlord landlord = new Landlord();
        AOPInvocatinHandler aopInvocatinHandler = new AOPInvocatinHandler(landlord);
        RoomRent roomRentProxy = (RoomRent) Proxy.newProxyInstance(landlord.getClass().getClassLoader(),//委托类的类加载器
                landlord.getClass().getInterfaces(),//委托类的接口
                aopInvocatinHandler);//代理对象
        roomRentProxy.roomRent();
    }
}
