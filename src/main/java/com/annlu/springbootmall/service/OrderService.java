package com.annlu.springbootmall.service;

import com.annlu.springbootmall.dto.CreateOrderRequest;
import com.annlu.springbootmall.dto.OrderQueryParams;
import com.annlu.springbootmall.model.Order;
import com.annlu.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
