package com.annlu.springbootmall.dao;

import com.annlu.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);//根據productId去查詢商品數據
}