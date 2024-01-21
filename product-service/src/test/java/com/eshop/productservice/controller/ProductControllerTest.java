package com.eshop.productservice.controller;

import com.eshop.productservice.dto.ProductDto;
import com.eshop.productservice.entity.ProductType;
import com.eshop.productservice.service.GoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoodService goodService;

    private ProductDto productDto;

    @BeforeEach
    public void setup() {
        productDto = new ProductDto(1L, "Test Good", ProductType.LAPTOP, 10);
    }

    @Test
    public void getAllGoodsTest() throws Exception {
        List<ProductDto> goods = Collections.singletonList(productDto);
        when(goodService.findAll()).thenReturn(goods);

        mockMvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getGoodByIdTest() throws Exception {
        when(goodService.findById(anyLong())).thenReturn(productDto);

        mockMvc.perform(get("/products/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createGoodTest() throws Exception {
        when(goodService.create(any(ProductDto.class))).thenReturn(productDto);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Test Good\",\"type\":\"LAPTOP\",\"quantity\":10}"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateGoodTest() throws Exception {
        when(goodService.update(anyLong(), any(ProductDto.class))).thenReturn(productDto);

        mockMvc.perform(put("/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Test Good\",\"type\":\"LAPTOP\",\"quantity\":10}"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteGoodTest() throws Exception {
        when(goodService.delete(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/products/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

