package com.eshop.apigateway.dto;

import com.eshop.apigateway.entity.EType;

import java.time.LocalDate;

public class DeliveryDto {
    private String address;
    private EType type;
    private Long orderId;
    private LocalDate date;
}
