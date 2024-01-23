package com.eshop.vacancyservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;

@Setter
@Getter
@Entity
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Другие поля и методы доступа (геттеры, сеттеры и т.д.)

}
