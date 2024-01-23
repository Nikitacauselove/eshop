package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.dto.DeliveryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("delivery-service/auth/deliveries")
public interface DeliveryClient {

    @PostMapping("/create")
    HttpStatus createDelivery (@RequestBody DeliveryDto deliveryDto);

    @GetMapping("/findbyid")
    ResponseEntity<DeliveryDto> findDeliveryById (@RequestParam Long id);

    @GetMapping("/findall")
    ResponseEntity<List<DeliveryDto>> findAllDeliveries();

    @PutMapping("/update")
    ResponseEntity<DeliveryDto> updateDelivery (@RequestParam Long id, @RequestBody DeliveryDto updatedDelivery);

    @DeleteMapping("/delete")
    HttpStatus deleteDelivery (@RequestParam Long id);
}
