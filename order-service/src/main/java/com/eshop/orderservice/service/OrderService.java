package com.eshop.orderservice.service;

import com.eshop.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto create(OrderDto orderDto);

    OrderDto update(Long id, OrderDto orderDto);

    OrderDto findById(Long id);

    List<OrderDto> findAll();

    boolean delete(Long id);
}
