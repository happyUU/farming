package com.crc.farming.service;

import com.crc.farming.pojo.Ord;
import com.crc.farming.pojo.Ordpro;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Date;
import java.util.List;

public interface OrderService{

    boolean insertorder(Ord ord);

    Ord findOrderId(Integer orderid);

    List<Ord> findOrderByLikeId(Integer orderid,Integer id);

    boolean insertorder_product(Ordpro ordpro);


    List<Ord> findUserOrder(Integer id);

    List<Ordpro> findUserOrderProduct(Integer orderid);



}
