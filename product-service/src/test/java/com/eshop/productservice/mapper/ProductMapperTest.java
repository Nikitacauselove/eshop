package com.eshop.productservice.mapper;

import com.eshop.productservice.dto.ProductDto;
import com.eshop.productservice.entity.Product;
import com.eshop.productservice.entity.ProductType;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    public void testFromDto() {
        ProductDto productDto = new ProductDto(1L, "name", ProductType.LAPTOP, 10);
        Product product = productMapper.fromProductDto(productDto);
        assertEquals(productDto.id(), product.getId());
        assertEquals(productDto.name(), product.getName());
        assertEquals(productDto.type(), product.getType());
        assertEquals(productDto.quantity(), product.getQuantity());
    }

    @Test
    public void testToDto() {
        Product product = new Product(1L, "name", ProductType.LAPTOP, 10);
        ProductDto productDto = productMapper.toProductDto(product);
        assertEquals(product.getId(), productDto.id());
        assertEquals(product.getName(), productDto.name());
        assertEquals(product.getType(), productDto.type());
        assertEquals(product.getQuantity(), productDto.quantity());
    }
}

