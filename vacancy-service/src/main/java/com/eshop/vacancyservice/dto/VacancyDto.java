package com.eshop.vacancyservice.dto;

import lombok.Data;

@Data
public class VacancyDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    // Другие поля вакансии для передачи на фронт
}
