package com.annlu.springbootmall.dao;

import com.annlu.springbootmall.model.OrderItem;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId , Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
