package ru.aston.orderservice.dto;

import lombok.Builder;
import lombok.Data;
import ru.aston.orderservice.model.OrderStatus;

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
