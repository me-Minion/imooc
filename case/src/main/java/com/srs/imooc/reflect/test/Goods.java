package com.srs.imooc.reflect.test;

public class Goods {

    private Integer no;
    private String name;
    private Float price;
    private String desc;

    public Goods() {
        System.out.println("Goods无参构造器");
    }

    public Goods(Integer no, String name, Float price, String desc) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.desc = desc;
        System.out.println("Goods有参构造器");
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void display(String desc) {
        this.desc = desc;
        System.out.println("商品描述更改为：" + desc);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
