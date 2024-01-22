package com.eshop.deliveryservice.controller;

import com.eshop.deliveryservice.dto.DeliveryDto;
import com.eshop.deliveryservice.entity.EType;
import com.eshop.deliveryservice.service.impl.DeliveryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DeliveryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryServiceImpl deliveryService;

    private DeliveryDto deliveryDto;

    @BeforeEach
    public void setup() {
        deliveryDto = DeliveryDto.builder()
                .address("пушкина")
                .orderId(1L)
                .date(LocalDate.parse("1999-01-08"))
                .type(EType.PICKUP)
                .build();
    }

    @Test
    public void findAllDeliveriesTest() throws Exception {
        List<DeliveryDto> deliveries = Collections.singletonList(deliveryDto);
        when(deliveryService.findAll()).thenReturn(deliveries);
        mockMvc.perform(get("/deliveries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findDeliveryByIdTest() throws Exception {
        when(deliveryService.findById(anyLong())).thenReturn(deliveryDto);
        mockMvc.perform(get("/deliveries/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createDeliveryTest() throws Exception {
        when(deliveryService.create(any(DeliveryDto.class))).thenReturn(deliveryDto);
        mockMvc.perform(post("/deliveries")
                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"address\"\"пушкина\",\"type\":\"PICKUP\",\"orderId\":1,\"date\":"1999-01-08"}")
                        .content("{\"address\":\"пушкина\",\"type\":\"PICKUP\",\"orderId\":1,\"date\":\"1999-01-08\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateDeliveryTest() throws Exception {
        when(deliveryService.update(anyLong(), any(DeliveryDto.class))).thenReturn(deliveryDto);

        mockMvc.perform(put("/deliveries/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"address\":\"пушкина\",\"type\":\"PICKUP\",\"orderId\":1,\"date\":\"1999-01-08\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteDeliveryTest() throws Exception {
        when(deliveryService.delete(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/deliveries/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
