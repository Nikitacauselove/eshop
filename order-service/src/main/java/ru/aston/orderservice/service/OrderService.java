package ru.aston.orderservice.service;

import ru.aston.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto create(OrderDto order);

    OrderDto findById(long orderId);

    List<OrderDto> findAll();

    OrderDto update(long id, OrderDto order);

    boolean delete(long orderId);
}
