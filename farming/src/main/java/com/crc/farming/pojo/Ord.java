package com.crc.farming.pojo;

import java.util.Date;

public class Ord {
    private Integer orderid;
    private Integer id;
    private Date ordertime;

    public Ord() {
    }

    public Ord(Integer id, Date ordertime) {
        this.id = id;
        this.ordertime = ordertime;
    }

    public Ord(Integer orderid, Integer id, Date ordertime) {
        this.orderid = orderid;
        this.id = id;
        this.ordertime = ordertime;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @Override
    public String toString() {
        return "Ord{" +
                "orderid=" + orderid +
                ", id=" + id +
                ", ordertime=" + ordertime +
                '}';
    }
}
