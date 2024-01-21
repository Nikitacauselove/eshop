package com.example.deliveryservice.mapper;

import com.example.deliveryservice.dto.DeliveryDto;
import com.example.deliveryservice.entity.Delivery;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryDto deliveryToDeliveryDto (Delivery delivery);
    Delivery deliveryDtoToDelivery (DeliveryDto deliveryDto);
}
