package com.annlu.springbootmall.dao;

import com.annlu.springbootmall.dto.OrderQueryParams;
import com.annlu.springbootmall.model.Order;
import com.annlu.springbootmall.model.OrderItem;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId , Integer totalAmount);
    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
