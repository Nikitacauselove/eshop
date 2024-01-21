package com.eshop.orderservice.dto;

import lombok.Builder;
import lombok.Data;
import com.eshop.orderservice.entity.OrderStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDto {
    private Long id;
    private Long userId;
    private Long goodId;
    private OrderStatus status;
    private LocalDateTime created;
}
