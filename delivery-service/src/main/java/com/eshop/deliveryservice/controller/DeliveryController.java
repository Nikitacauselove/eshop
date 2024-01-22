package com.eshop.deliveryservice.controller;

import com.eshop.deliveryservice.mapper.DeliveryMapper;
import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.entity.Delivery;
import com.eshop.deliveryservice.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/deliveries")
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @Autowired
    public DeliveryController (DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    @PostMapping("/create")
    public HttpStatus createDelivery (@RequestBody DeliveryDto deliveryDto) {
        if (deliveryDto != null) {
            Delivery delivery = deliveryMapper.deliveryDtoToDelivery(deliveryDto);
            deliveryRepository.save(delivery);
            return HttpStatus.CREATED;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/findbyid")
    public ResponseEntity<DeliveryDto> findDeliveryById (@RequestParam Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Delivery delivery1 = delivery.get();
        DeliveryDto deliveryDto = deliveryMapper.deliveryToDeliveryDto(delivery1);
        return new ResponseEntity<>(deliveryDto, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<DeliveryDto>> findAllDeliveries() {
        List<DeliveryDto> deliveries = deliveryRepository.findAll().stream()
                .map(deliveryMapper::deliveryToDeliveryDto)
                .toList();
        return new ResponseEntity<>(deliveries, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DeliveryDto> updateDelivery (@RequestParam Long id, @RequestBody DeliveryDto updatedDelivery) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Delivery newDelivery = deliveryMapper.deliveryDtoToDelivery(updatedDelivery);
        newDelivery.setId(id);
        deliveryRepository.save(newDelivery);
        return new ResponseEntity<>(deliveryMapper.deliveryToDeliveryDto(newDelivery), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteDelivery (@RequestParam Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isEmpty()) return HttpStatus.NOT_FOUND;
        deliveryRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }


}
