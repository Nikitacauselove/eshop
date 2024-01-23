package com.eshop.orderservice.service;

import com.eshop.orderservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.eshop.orderservice.dto.OrderDto;
import com.eshop.orderservice.mapper.OrderMapper;
import com.eshop.orderservice.entity.Order;
import com.eshop.orderservice.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static com.eshop.orderservice.util.TestObjectsBuilder.dto;

@SpringBootTest
class OrderServiceTest {

    @Mock
    private OrderRepository repository;
    @Mock
    private OrderMapper mapper;
    @InjectMocks
    private OrderServiceImpl service;
    private OrderDto orderDto;

    @BeforeEach
    void setUp() {
        orderDto = dto();
    }

    @Test
    void create_WhenIdNotNull_ThenThrowException() {
        assertThrows(RuntimeException.class, () -> service.create(orderDto));
    }

    @Test
    void create_WhenIdNull_ThenOk() {
        orderDto.setId(null);
        when(mapper.fromOrderDto(any(OrderDto.class))).thenReturn(new Order());
        when(repository.save(any(Order.class))).thenReturn(new Order());
        when(mapper.toOrderDto(any(Order.class))).thenReturn(orderDto);

        OrderDto actual = service.create(orderDto);

        assertEquals(orderDto, actual);
    }

    @Test
    void findById() {
        when(mapper.fromOrderDto(any(OrderDto.class))).thenReturn(new Order());
        when(repository.findById(any(Long.class))).thenReturn(Optional.of(new Order()));
        when(mapper.toOrderDto(any(Order.class))).thenReturn(orderDto);

        OrderDto actual = service.findById(1L);

        assertEquals(orderDto, actual);
    }

    @Test
    void findAll() {
        when(mapper.fromOrderDto(any(OrderDto.class))).thenReturn(new Order());
        when(repository.findAll()).thenReturn(List.of(new Order()));
        when(mapper.toOrderDto(any(Order.class))).thenReturn(orderDto);

        List<OrderDto> actual = service.findAll();

        assertFalse(actual.isEmpty());
    }

    @Test
    void update() {
        when(mapper.fromOrderDto(any(OrderDto.class))).thenReturn(new Order());
        when(repository.save(any(Order.class))).thenReturn((new Order()));
        when(mapper.toOrderDto(any(Order.class))).thenReturn(orderDto);

        OrderDto actual = service.update(1L, orderDto);

        assertEquals(orderDto, actual);
    }

    @Test
    void delete() {
        when(repository.existsById(1L)).thenReturn(true);

        assertTrue(service.delete(1L));
        verify(repository).deleteById(1L);
    }

}