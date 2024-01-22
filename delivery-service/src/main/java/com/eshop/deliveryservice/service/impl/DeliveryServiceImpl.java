package com.eshop.deliveryservice.service.impl;

import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.entity.Delivery;
import com.eshop.deliveryservice.mapper.DeliveryMapper;
import com.eshop.deliveryservice.repository.DeliveryRepository;
import com.eshop.deliveryservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    private final DeliveryMapper deliveryMapper;


    @Override
    public DeliveryDto create(DeliveryDto deliveryDto) {
        if (deliveryDto != null) {
            Delivery delivery = deliveryMapper.fromDto(deliveryDto);
            deliveryRepository.save(delivery);
            return deliveryMapper.toDto(delivery);
        } else {
            return null;
        }
    }

    @Override
    public DeliveryDto update(Long id, DeliveryDto deliveryDto) {
       Delivery delivery = deliveryRepository.findById(id)
                .orElse(null);
       if (delivery == null) { return null; }
       Delivery newDelivery = deliveryMapper.fromDto(deliveryDto);
       newDelivery.setId(id);
       deliveryRepository.save(newDelivery);
       return deliveryMapper.toDto(newDelivery);
    }

    @Override
    public DeliveryDto findById(Long id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElse(null);
        if (delivery == null) { return null; }
        return deliveryMapper.toDto(delivery);
    }

    @Override
    public List<DeliveryDto> findAll() {
        return deliveryRepository.findAll().stream()
                .map(deliveryMapper::toDto)
                .toList();
    }

    @Override
    public boolean delete(Long id) {
       Delivery delivery = deliveryRepository.findById(id)
                .orElse(null);
        if (delivery == null) { return false; }
        deliveryRepository.deleteById(id);
        return true;
    }
}
