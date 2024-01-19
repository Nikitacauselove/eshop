package ru.aston.orderservice.util;

import ru.aston.orderservice.dto.OrderDto;
import ru.aston.orderservice.model.Order;
import ru.aston.orderservice.model.OrderStatus;

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
