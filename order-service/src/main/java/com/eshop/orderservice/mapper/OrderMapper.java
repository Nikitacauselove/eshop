package com.eshop.orderservice.mapper;

import com.eshop.orderservice.dto.OrderDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import com.eshop.orderservice.entity.Order;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order fromOrderDto(OrderDto orderDto);

    OrderDto toOrderDto(Order order);
}
