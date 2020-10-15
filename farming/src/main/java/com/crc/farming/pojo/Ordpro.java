package com.crc.farming.pojo;

import java.util.Date;

public class Ordpro {
    private Integer orderid;
    private Integer product_id;
    private Integer product_num;

    public Ordpro() {
    }

    public Ordpro(Integer orderid, Integer product_id, Integer product_num) {
        this.orderid = orderid;
        this.product_id = product_id;
        this.product_num = product_num;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_num() {
        return product_num;
    }

    public void setProduct_num(Integer product_num) {
        this.product_num = product_num;
    }


    @Override
    public String toString() {
        return "Ordpro{" +
                "orderid=" + orderid +
                ", product_id=" + product_id +
                ", product_num=" + product_num +
                '}';
    }
}
