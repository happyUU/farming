package com.crc.farming.service;

import com.crc.farming.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryAllProduct();

    Product queryProductById(Integer product_id);

    boolean addProduct(Product product);
}
