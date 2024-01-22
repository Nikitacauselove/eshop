package com.eshop.apigateway.dto;

import com.eshop.apigateway.entity.ProductType;

public record ProductDto(Long id, String name, ProductType type, Integer quantity) { }
