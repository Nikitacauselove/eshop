package com.eshop.apigateway.dto;

import com.eshop.apigateway.entity.OrderStatus;

import java.time.LocalDateTime;

public class OrderDto {
    private Long id;
    private Long userId;
    private Long goodId;
    private OrderStatus status;
    private LocalDateTime created;
}
