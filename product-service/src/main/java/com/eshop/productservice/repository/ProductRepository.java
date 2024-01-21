package com.eshop.productservice.repository;

import com.eshop.productservice.entity.Product;
import com.eshop.productservice.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameAndType(String name, ProductType type);
}
