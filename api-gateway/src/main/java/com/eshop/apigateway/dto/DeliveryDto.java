package com.eshop.apigateway.dto;

import com.eshop.apigateway.entity.EType;

import java.time.LocalDate;

public record DeliveryDto(String address, EType type, Long orderId, LocalDate date) { }
