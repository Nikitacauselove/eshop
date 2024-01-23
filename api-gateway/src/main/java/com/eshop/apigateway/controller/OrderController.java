package com.eshop.apigateway.controller;

import com.eshop.apigateway.dto.OrderDto;
import com.eshop.apigateway.openfeign.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderClient orderClient;

    @PostMapping
    ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        return orderClient.create(orderDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<OrderDto> update(@PathVariable Long id, @RequestBody OrderDto updatedOrderDto) {
        return orderClient.update(id, updatedOrderDto);
    }

    @GetMapping("/{id}")
    ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        return orderClient.findById(id);
    }

    @GetMapping
    ResponseEntity<List<OrderDto>> findAll() {
        return orderClient.findAll();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        return orderClient.delete(id);
    }
}
