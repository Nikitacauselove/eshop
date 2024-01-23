package com.eshop.productservice.dto;

import com.eshop.productservice.entity.ProductType;

public record ProductDto(Long id, String name, ProductType type, Integer quantity) { }
