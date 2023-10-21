package com.annlu.springbootmall.service;

import com.annlu.springbootmall.dto.ProductRequest;
import com.annlu.springbootmall.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
