package com.example.deliveryservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @Enumerated(EnumType.STRING)
    private EType type;

    private Long orderId;

    private LocalDate date;

    public Delivery() {

    }
    public Delivery (String address, EType type, Long orderId, LocalDate date) {
        this.address = address;
        this.type = type;
        this.orderId = orderId;
        this.date = date;
    }
    //комментарии для теста
}
