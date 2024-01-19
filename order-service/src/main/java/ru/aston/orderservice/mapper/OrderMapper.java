package ru.aston.orderservice.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.aston.orderservice.dto.OrderDto;
import ru.aston.orderservice.model.Order;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order fromDto(OrderDto orderDto);

    OrderDto toDto(Order order);
}
