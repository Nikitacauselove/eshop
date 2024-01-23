package com.eshop.apigateway.dto;

import com.eshop.apigateway.entity.OrderStatus;

import java.time.LocalDateTime;

public record OrderDto(Long id, Long userId, Long goodId, OrderStatus status, LocalDateTime created) {
}
