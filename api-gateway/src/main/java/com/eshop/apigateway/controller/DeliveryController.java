package com.eshop.apigateway.controller;

import com.eshop.apigateway.dto.DeliveryDto;
import com.eshop.apigateway.openfeign.DeliveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryClient deliveryClient;

    @PostMapping("/create")
    public HttpStatus createDelivery (@RequestBody DeliveryDto deliveryDto) {
        return deliveryClient.createDelivery(deliveryDto);
    }

    @GetMapping("/findbyid")
    public ResponseEntity<DeliveryDto> findDeliveryById (@RequestParam Long id) {
        return deliveryClient.findDeliveryById(id);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<DeliveryDto>> findAllDeliveries() {
        return deliveryClient.findAllDeliveries();
    }

    @PutMapping("/update")
    public ResponseEntity<DeliveryDto> updateDelivery (@RequestParam Long id, @RequestBody DeliveryDto updatedDelivery) {
        return deliveryClient.updateDelivery(id, updatedDelivery);
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteDelivery (@RequestParam Long id) {
        return deliveryClient.deleteDelivery(id);
    }
}
