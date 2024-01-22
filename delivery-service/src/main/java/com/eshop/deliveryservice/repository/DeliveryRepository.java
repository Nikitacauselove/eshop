package com.eshop.deliveryservice.repository;

import com.eshop.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findById (Long id);
    List<Delivery> findAll ();
    void deleteById (Long id);
}
