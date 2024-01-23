package com.eshop.vacancyservice.repository;

import com.eshop.vacancyservice.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    // Можно добавить кастомные методы для работы с вакансиями, если нужно
}
