package com.annlu.springbootmall.service;

import com.annlu.springbootmall.dto.CreateOrderRequest;
import com.annlu.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
