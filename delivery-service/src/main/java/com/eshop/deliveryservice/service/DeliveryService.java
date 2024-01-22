package com.eshop.deliveryservice.service;

import com.eshop.deliveryservice.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {
    DeliveryDto create(DeliveryDto deliveryDto);

    DeliveryDto update(Long id, DeliveryDto deliveryDto);

    DeliveryDto findById(Long id);

    List<DeliveryDto> findAll();

    boolean delete(Long id);
}
