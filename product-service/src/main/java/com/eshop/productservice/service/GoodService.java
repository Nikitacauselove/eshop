package com.eshop.productservice.service;

import com.eshop.productservice.dto.ProductDto;
import com.eshop.productservice.entity.Product;
import com.eshop.productservice.mapper.ProductMapper;
import com.eshop.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GoodService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Transactional
    public ProductDto create(ProductDto productDto) {
        Optional<Product> existingGood = productRepository.findByNameAndType(productDto.name(), productDto.type());
        if (existingGood.isPresent()) {
            Product product = existingGood.get();
            product.setQuantity(product.getQuantity() + productDto.quantity());
            Product savedProduct = productRepository.save(product);
            return productMapper.toProductDto(savedProduct);
        } else {
            Product product = productMapper.fromProductDto(productDto);
            Product savedProduct = productRepository.save(product);
            return productMapper.toProductDto(savedProduct);
        }
    }

    @Transactional
    public ProductDto update(Long id, ProductDto updatedProductDto) {
        Product updatedProduct = productMapper.fromProductDto(updatedProductDto);
        updatedProduct.setId(id);
        productRepository.save(updatedProduct);
        return productMapper.toProductDto(updatedProduct);
    }

    public ProductDto findById(Long id) {
        Optional<Product> existingGood = productRepository.findById(id);
        if (existingGood.isPresent()) {
            Product product = existingGood.get();
            return productMapper.toProductDto(product);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Good not found");
        }
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDto(products);
    }

    @Transactional
    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
