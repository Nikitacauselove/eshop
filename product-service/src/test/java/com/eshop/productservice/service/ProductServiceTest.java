package com.eshop.productservice.service;

import com.eshop.productservice.dto.ProductDto;
import com.eshop.productservice.entity.Product;
import com.eshop.productservice.entity.ProductType;
import com.eshop.productservice.mapper.ProductMapper;
import com.eshop.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private GoodService goodService;

    @Test
    public void testFindAll() {
        List<Product> list = List.of(new Product());
        List<ProductDto> dtoList = list.stream()
                .map(productMapper::toProductDto)
                .toList();
        when(productRepository.findAll()).thenReturn(list);
        when(productMapper.toProductDto(list)).thenReturn(dtoList);
        assertEquals(1, goodService.findAll().size());
    }

    @Test
    public void testFindOne() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productMapper.toProductDto(product)).thenReturn(new ProductDto(1L, "name", ProductType.LAPTOP, 10));
        assertNotNull(goodService.findById(1L));
    }

    @Test
    public void testSave() {
        ProductDto productDto = new ProductDto(1L, "name", ProductType.LAPTOP, 10);
        Product product = new Product();
        when(productMapper.fromProductDto(productDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toProductDto(product)).thenReturn(productDto);
        assertEquals(productDto, goodService.create(productDto));
    }

    @Test
    public void testUpdate() {
        ProductDto productDto = new ProductDto(1L, "name", ProductType.LAPTOP, 10);
        Product product = new Product();
        when(productMapper.fromProductDto(productDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toProductDto(product)).thenReturn(productDto);
        assertEquals(productDto, goodService.update(1L, productDto));
    }

    @Test
    public void testDelete() {
        when(productRepository.existsById(1L)).thenReturn(true);
        boolean result = goodService.delete(1L);
        assertTrue(result);
        verify(productRepository, times(1)).deleteById(1L);
    }

}

