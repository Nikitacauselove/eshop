package ru.stileyn.jobsmicro.repository;

import ru.stileyn.jobsmicro.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    // Можно добавить кастомные методы для работы с вакансиями, если нужно
}
