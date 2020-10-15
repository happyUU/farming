package com.crc.farming.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private String name;
    private Integer orderid;
    private Date ordertime;

    private List<Cart> carts;

    private Double sumprice;


    public Order() {
    }

    public Order( String name, Integer orderid, Date ordertime, List<Cart> carts, Double sumprice) {
        this.name = name;
        this.orderid = orderid;
        this.ordertime = ordertime;
        this.carts = carts;
        this.sumprice = sumprice;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Double getSumprice() {
        return sumprice;
    }

    public void setSumprice(Double sumprice) {
        this.sumprice = sumprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", name='" + name + '\'' +
                ", orderid=" + orderid +
                ", ordertime=" + ordertime +
                ", carts=" + carts +
                ", sumprice=" + sumprice +
                '}';
    }
}
