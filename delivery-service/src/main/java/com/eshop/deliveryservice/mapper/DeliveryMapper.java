package com.eshop.deliveryservice.mapper;

import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.entity.Delivery;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryDto toDto (Delivery delivery);
    Delivery fromDto (DeliveryDto deliveryDto);

    List<DeliveryDto> toDto (List<Delivery> deliveries);
}
