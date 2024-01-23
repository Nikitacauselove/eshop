package com.eshop.orderservice.util;

import com.eshop.orderservice.dto.OrderDto;
import com.eshop.orderservice.entity.Order;
import com.eshop.orderservice.entity.OrderStatus;

import java.time.LocalDateTime;

public class TestObjectsBuilder {

    public static OrderDto controllerDto() {
        return OrderDto.builder()
                .id(1L)
                .userId(1L)
                .goodId(1L)
                .status(OrderStatus.CREATED)
                .created(LocalDateTime.parse("1999-01-08T04:05:06"))
                .build();
    }

    public static OrderDto dto() {
        return OrderDto.builder()
                .id(1L)
                .userId(1L)
                .goodId(1L)
                .status(OrderStatus.CREATED)
                .created(LocalDateTime.now())
                .build();
    }

    public static Order model() {
        return Order.builder()
                .id(1L)
                .userId(1L)
                .goodId(1L)
                .status(OrderStatus.CREATED)
                .created(LocalDateTime.now())
                .build();
    }

}
