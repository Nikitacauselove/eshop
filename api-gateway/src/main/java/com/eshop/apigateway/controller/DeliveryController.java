package com.eshop.apigateway.controller;

import com.eshop.apigateway.dto.DeliveryDto;
import com.eshop.apigateway.openfeign.DeliveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryClient deliveryClient;

    @PostMapping
    public ResponseEntity<DeliveryDto> createDelivery (@RequestBody DeliveryDto deliveryDto) {
        return deliveryClient.createDelivery(deliveryDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDto> findDeliveryById (@PathVariable Long id) {
        return deliveryClient.findDeliveryById(id);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDto>> findAllDeliveries() {
        return deliveryClient.findAllDeliveries();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDto> updateDelivery (@PathVariable Long id, @RequestBody DeliveryDto updatedDelivery) {
        return deliveryClient.updateDelivery(id, updatedDelivery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery (@PathVariable Long id) {
        return deliveryClient.deleteDelivery(id);
    }
}
