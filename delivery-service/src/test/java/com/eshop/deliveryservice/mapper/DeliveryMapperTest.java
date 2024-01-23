package com.eshop.deliveryservice.mapper;

import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.entity.Delivery;
import com.eshop.deliveryservice.entity.EType;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryMapperTest {

    private final DeliveryMapper deliveryMapper = Mappers.getMapper(DeliveryMapper.class);

    @Test
    public void testFromDto() {
        DeliveryDto deliveryDto = DeliveryDto.builder()
                .address("пушкина")
                .orderId(1L)
                .date(LocalDate.now())
                .type(EType.PICKUP)
                .build();
        Delivery delivery = deliveryMapper.fromDto(deliveryDto);
        assertEquals(deliveryDto.getAddress(), delivery.getAddress());
        assertEquals(deliveryDto.getOrderId(), delivery.getOrderId());
        assertEquals(deliveryDto.getDate(), delivery.getDate());
        assertEquals(deliveryDto.getType(), delivery.getType());
    }

    @Test
    public void testToDto() {
        Delivery delivery = new Delivery("пушкина", EType.PICKUP, 1L, LocalDate.now());
        DeliveryDto deliveryDto = deliveryMapper.toDto(delivery);
        assertEquals(delivery.getAddress(), deliveryDto.getAddress());
        assertEquals(delivery.getDate(), deliveryDto.getDate());
        assertEquals(delivery.getOrderId(), deliveryDto.getOrderId());
        assertEquals(delivery.getType(), deliveryDto.getType());
    }
}
