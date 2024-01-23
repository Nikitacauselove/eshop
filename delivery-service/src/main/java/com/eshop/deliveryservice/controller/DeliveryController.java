package com.eshop.deliveryservice.controller;

import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryDto> createDelivery (@RequestBody DeliveryDto deliveryDto) {
        DeliveryDto created = deliveryService.create(deliveryDto);
        return created != null ? new ResponseEntity<>(created, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDto> findDeliveryById (@PathVariable Long id) {
        DeliveryDto deliveryDto = deliveryService.findById(id);
        return deliveryDto != null ? new ResponseEntity<>(deliveryDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDto>> findAllDeliveries() {
        return new ResponseEntity<>(deliveryService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDto> updateDelivery (@PathVariable Long id, @RequestBody DeliveryDto updatedDelivery) {
        DeliveryDto newDelivery = deliveryService.update(id, updatedDelivery);
        return newDelivery != null ? new ResponseEntity<>(newDelivery, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery (@PathVariable Long id) {
        boolean isDeleted = deliveryService.delete(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
