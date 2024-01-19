package ru.aston.orderservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.orderservice.dto.OrderDto;
import ru.aston.orderservice.model.Order;

import static ru.aston.orderservice.util.TestObjectsBuilder.dto;
import static ru.aston.orderservice.util.TestObjectsBuilder.model;

class OrderMapperTest {

    private final OrderMapper mapper = new OrderMapperImpl();
    private static Order order;
    private static OrderDto orderDto;

    @BeforeAll
    static void setUp() {
        order = model();
        orderDto = dto();
    }

    @Test
    void fromDto() {
        Order order = mapper.fromDto(orderDto);

        Assertions.assertEquals(orderDto.getId(), order.getId());
        Assertions.assertEquals(orderDto.getUserId(), order.getUserId());
        Assertions.assertEquals(orderDto.getGoodId(), order.getGoodId());
        Assertions.assertEquals(orderDto.getStatus(), order.getStatus());
        Assertions.assertEquals(orderDto.getCreated(), order.getCreated());
    }

    @Test
    void toDto() {
        OrderDto orderDto = mapper.toDto(order);

        Assertions.assertEquals(order.getId(), orderDto.getId());
        Assertions.assertEquals(order.getUserId(), orderDto.getUserId());
        Assertions.assertEquals(order.getGoodId(), orderDto.getGoodId());
        Assertions.assertEquals(order.getStatus(), orderDto.getStatus());
        Assertions.assertEquals(order.getCreated(), orderDto.getCreated());
    }
}