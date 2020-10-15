package com.crc.farming.dao;

import com.crc.farming.pojo.Ord;
import com.crc.farming.pojo.Order;
import com.crc.farming.pojo.Ordpro;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderDao {

    boolean insertorder(Ord ord);

    Ord findOrderId(Integer orderid);

    List<Ord> findOrderByLikeId(Integer orderid,Integer id);


    boolean insertorder_product(Ordpro ordpro);


    List<Ord> findUserOrder(Integer id);

    List<Ordpro> findUserOrderProduct(Integer orderid);
}
