package com.crc.farming.service.Impl;

import com.crc.farming.dao.OrderDao;
import com.crc.farming.pojo.Ord;
import com.crc.farming.pojo.Order;
import com.crc.farming.pojo.Ordpro;
import com.crc.farming.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    OrderDao orderDao;
    @Override
    public boolean insertorder(Ord ord) {
        return orderDao.insertorder(ord);
    }

    @Override
    public Ord findOrderId(Integer orderid) {
        return orderDao.findOrderId(orderid);
    }

    @Override
    public List<Ord> findOrderByLikeId(Integer orderid, Integer id) {
        return orderDao.findOrderByLikeId(orderid,id);
    }


    @Override
    public boolean insertorder_product(Ordpro ordpro) {
        return orderDao.insertorder_product(ordpro);
    }

    @Override
    public List<Ord> findUserOrder(Integer id) {
        return orderDao.findUserOrder(id);
    }

    @Override
    public List<Ordpro> findUserOrderProduct(Integer orderid) {
        return orderDao.findUserOrderProduct(orderid);
    }


}
