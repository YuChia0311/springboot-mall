package com.annlu.springbootmall.service;

import com.annlu.springbootmall.dto.ProductQueryParams;
import com.annlu.springbootmall.dto.ProductRequest;
import com.annlu.springbootmall.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
