package com.annlu.springbootmall.dao;

import com.annlu.springbootmall.dto.ProductQueryParams;
import com.annlu.springbootmall.dto.ProductRequest;
import com.annlu.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);//根據productId去查詢商品數據

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
