package com.eshop.orderservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.eshop.orderservice.dto.OrderDto;
import com.eshop.orderservice.service.OrderService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.eshop.orderservice.util.TestObjectsBuilder.controllerDto;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderService orderService;
    private OrderDto orderDto;
    private final String orderJson = "{\"id\": \"1\", \"userId\": \"1\", \"goodId\": \"1\", \"status\": \"CREATED\", \"created\": \"1999-01-08T04:05:06\"}";

    @BeforeEach
    void setUp() {
        orderDto = controllerDto();
    }

    @Test
    void create() throws Exception {
        when(orderService.create(any(OrderDto.class))).thenReturn(orderDto);

        mockMvc.perform(post("/auth/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isCreated());
    }

    @Test
    void findById() throws Exception {
        when(orderService.findById(anyLong())).thenReturn(orderDto);

        mockMvc.perform(get("/auth/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        List<OrderDto> orders = List.of(orderDto);
        when(orderService.findAll()).thenReturn(orders);

        mockMvc.perform(get("/auth/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        when(orderService.update(anyLong(), any(OrderDto.class))).thenReturn(orderDto);

        mockMvc.perform(put("/auth/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        when(orderService.delete(anyLong())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/auth/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}