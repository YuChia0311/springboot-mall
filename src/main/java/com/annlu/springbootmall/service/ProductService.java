package com.annlu.springbootmall.service;

import com.annlu.springbootmall.dto.ProductRequest;
import com.annlu.springbootmall.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
