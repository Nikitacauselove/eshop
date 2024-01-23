package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("order-service/auth/orders")
public interface OrderClient {

    @PostMapping
    ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto);

    @PutMapping("/{id}")
    ResponseEntity<OrderDto> update(@PathVariable Long id, @RequestBody OrderDto updatedOrderDto);

    @GetMapping("/{id}")
    ResponseEntity<OrderDto> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<OrderDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
