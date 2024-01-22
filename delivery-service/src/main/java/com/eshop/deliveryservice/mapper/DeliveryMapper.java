package com.eshop.deliveryservice.mapper;

import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.entity.Delivery;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryDto deliveryToDeliveryDto (Delivery delivery);
    Delivery deliveryDtoToDelivery (DeliveryDto deliveryDto);
}
