package com.srs.proxy.stat;

/**
 * 静态代理
 * @author shaorensheng
 * @date 2022/3/18
 */
public class RoomRentApplication {

    public static void main(String[] args) {
        RoomRent roomRentProxy = new LandlordSecond(new RoomRentProxy(new Landlord()));
        roomRentProxy.roomRent();
    }


}
