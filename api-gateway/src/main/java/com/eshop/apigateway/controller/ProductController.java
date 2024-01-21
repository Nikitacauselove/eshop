package com.eshop.apigateway.controller;

import com.eshop.apigateway.dto.ProductDto;
import com.eshop.apigateway.openfeign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductClient productClient;

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productClient.create(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto updatedProductDto) {
        return productClient.update(id, updatedProductDto);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productClient.findById(id);
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return productClient.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productClient.delete(id);
    }
}
