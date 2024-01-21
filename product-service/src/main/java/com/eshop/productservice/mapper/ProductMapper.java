package com.eshop.productservice.mapper;

import com.eshop.productservice.dto.ProductDto;
import com.eshop.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromProductDto(ProductDto productDto);

    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDto(List<Product> products);
}
