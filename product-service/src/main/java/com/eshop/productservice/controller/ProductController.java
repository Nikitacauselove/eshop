package com.eshop.productservice.controller;

import com.eshop.productservice.dto.ProductDto;
import com.eshop.productservice.service.GoodService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/auth/products")
@RequiredArgsConstructor
public class ProductController {

    private final GoodService goodService;

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return goodService.create(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto updatedProductDto) {
        return goodService.update(id, updatedProductDto);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return goodService.findById(id);
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return goodService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        goodService.delete(id);
    }
}
