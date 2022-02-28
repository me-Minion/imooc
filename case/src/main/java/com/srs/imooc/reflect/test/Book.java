package com.srs.imooc.reflect.test;

public class Book {

    private Integer no;
    private String name;
    public  Float price;

    public Book() {
        System.out.println("Book无参构造器");
    }

    public Book(Integer no, String name, Float price) {
        this.no = no;
        this.name = name;
        this.price = price;
        System.out.println("Book有参构造器");
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

    @Override
    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
