package ru.aston.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.orderservice.dto.OrderDto;
import ru.aston.orderservice.mapper.OrderMapper;
import ru.aston.orderservice.model.Order;
import ru.aston.orderservice.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    public OrderDto create(OrderDto order) {
        if (order.getId() == null) {
            order.setCreated(LocalDateTime.now());
            Order saved = orderRepository.save(mapper.fromDto(order));
            return mapper.toDto(saved);
        }
        throw new RuntimeException("Id must be null");
    }

    @Override
    public OrderDto findById(long orderId) {
        Optional<Order> byId = orderRepository.findById(orderId);
        return byId.map(mapper::toDto).orElse(null);
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> all = orderRepository.findAll();
        return all.stream().map(mapper::toDto).toList();
    }

    @Override
    public OrderDto update(long id, OrderDto order) {
        order.setId(id);
        Order saved = orderRepository.save(mapper.fromDto(order));
        return mapper.toDto(saved);
    }

    @Override
    public boolean delete(long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

}
