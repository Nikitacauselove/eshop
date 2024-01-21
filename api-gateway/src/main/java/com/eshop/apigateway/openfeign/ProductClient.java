package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("product-service/auth/products")
public interface ProductClient {

    @PostMapping
    ProductDto create(@RequestBody ProductDto productDto);

    @PutMapping("/{id}")
    ProductDto update(@PathVariable Long id, @RequestBody ProductDto updatedProductDto);

    @GetMapping("/{id}")
    ProductDto findById(@PathVariable Long id);

    @GetMapping
    List<ProductDto> findAll();

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
