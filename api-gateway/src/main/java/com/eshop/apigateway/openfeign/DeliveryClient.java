package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.dto.DeliveryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("delivery-service/auth/deliveries")
public interface DeliveryClient {

    @PostMapping
    ResponseEntity<DeliveryDto> createDelivery (@RequestBody DeliveryDto deliveryDto);

    @GetMapping("/{id}")
    ResponseEntity<DeliveryDto> findDeliveryById (@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<DeliveryDto>> findAllDeliveries();

    @PutMapping("/{id}")
    ResponseEntity<DeliveryDto> updateDelivery (@PathVariable Long id, @RequestBody DeliveryDto updatedDelivery);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDelivery (@PathVariable Long id);
}
