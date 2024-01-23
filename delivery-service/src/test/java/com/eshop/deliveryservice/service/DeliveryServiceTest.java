package com.eshop.deliveryservice.service;

import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.entity.Delivery;
import com.eshop.deliveryservice.entity.EType;
import com.eshop.deliveryservice.mapper.DeliveryMapper;
import com.eshop.deliveryservice.repository.DeliveryRepository;
import com.eshop.deliveryservice.service.impl.DeliveryServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DeliveryServiceTest {
    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private DeliveryMapper deliveryMapper;

    @InjectMocks
    private DeliveryServiceImpl deliveryService;

    @Test
    public void testFindAll() {
        List<Delivery> list = List.of(new Delivery());
        List<DeliveryDto> dtoList = list.stream()
                .map(deliveryMapper::toDto)
                .toList();
        when(deliveryRepository.findAll()).thenReturn(list);
        when(deliveryMapper.toDto(list)).thenReturn(dtoList);
        assertEquals(1, deliveryService.findAll().size());
    }

    @Test
    public void testFindOne() {
        Delivery delivery = new Delivery();
        delivery.setId(1L);
        when(deliveryRepository.findById(1L)).thenReturn(Optional.of(delivery));
        when(deliveryMapper.toDto(delivery)).thenReturn(new DeliveryDto());
        assertNotNull(deliveryService.findById(1L));
    }

    @Test
    public void testSave() {
        DeliveryDto deliveryDto = DeliveryDto.builder()
                .address("пушкина")
                .orderId(1L)
                .date(LocalDate.now())
                .type(EType.PICKUP)
                .build();
        Delivery delivery = new Delivery();
        when(deliveryMapper.fromDto(deliveryDto)).thenReturn(delivery);
        when(deliveryRepository.save(delivery)).thenReturn(delivery);
        when(deliveryMapper.toDto(delivery)).thenReturn(deliveryDto);
        assertEquals(deliveryDto, deliveryService.create(deliveryDto));
    }

    @Test
    public void testUpdate() {
        DeliveryDto deliveryDto = DeliveryDto.builder()
                .address("пушкина")
                .orderId(1L)
                .date(LocalDate.now())
                .type(EType.PICKUP)
                .build();
        Delivery delivery = new Delivery("пушкина", EType.PICKUP, 1L, LocalDate.now());
        delivery.setId(1L);
        when(deliveryMapper.fromDto(deliveryDto)).thenReturn(delivery);
        when(deliveryRepository.findById(1L)).thenReturn(Optional.of(delivery));
        when(deliveryRepository.save(delivery)).thenReturn(delivery);
        when(deliveryMapper.toDto(delivery)).thenReturn(deliveryDto);
        assertEquals(deliveryDto, deliveryService.update(1L, deliveryDto));
    }

    @Test
    public void testDelete() {
        Delivery delivery = new Delivery();
        when(deliveryRepository.findById(1L)).thenReturn(Optional.of(delivery));
        boolean result = deliveryService.delete(1L);
        assertTrue(result);
        verify(deliveryRepository, times(1)).deleteById(1L);
    }
}
