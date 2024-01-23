package com.eshop.orderservice.service.impl;

import com.eshop.orderservice.dto.OrderDto;
import com.eshop.orderservice.repository.OrderRepository;
import com.eshop.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.eshop.orderservice.mapper.OrderMapper;
import com.eshop.orderservice.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
        if (orderDto.getId() == null) {
            orderDto.setCreated(LocalDateTime.now());
            Order saved = orderRepository.save(orderMapper.fromOrderDto(orderDto));
            return orderMapper.toOrderDto(saved);
        }
        throw new RuntimeException("Id must be null");
    }

    @Override
    public OrderDto update(Long id, OrderDto orderDto) {
        orderDto.setId(id);
        Order saved = orderRepository.save(orderMapper.fromOrderDto(orderDto));
        return orderMapper.toOrderDto(saved);
    }

    @Override
    public OrderDto findById(Long id) {
        Optional<Order> byId = orderRepository.findById(id);
        return byId.map(orderMapper::toOrderDto).orElse(null);
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> all = orderRepository.findAll();
        return all.stream().map(orderMapper::toOrderDto).toList();
    }

    @Override
    public boolean delete(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
