package com.srs.proxy.stat;

/**
 * 二房东
 * @author shaorensheng
 * @date 2022/3/18
 */
public class LandlordSecond implements RoomRent {

    private RoomRent landlordSecond;


    public LandlordSecond(RoomRent landlordSecond) {
        this.landlordSecond = landlordSecond;
    }

    public void roomRent() {
        System.out.println("二房东出租房屋");
        landlordSecond.roomRent();
    }
}
