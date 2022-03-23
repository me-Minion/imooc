package com.srs.proxy.stat;

/**
 * @author shaorensheng
 * @date 2022/3/18
 */
public class RoomRentProxy implements RoomRent {

    private RoomRent landlord;

    public RoomRentProxy(RoomRent landlord) {
        this.landlord = landlord;
    }

    public void roomRent() {
        System.out.println("中介促成交易成功");
        landlord.roomRent();
    }
}
