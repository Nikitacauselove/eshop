package ru.stileyn.jobsmicro.repository;

import ru.stileyn.jobsmicro.entity.Vacancy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@DataJpaTest
class VacancyRepositoryTest {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Test
    void testSaveAndGetAllVacancies() {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle("Software Engineer");

        vacancyRepository.save(vacancy);

        List<Vacancy> vacancies = vacancyRepository.findAll();
        assertEquals(1, vacancies.size());
        assertEquals("Software Engineer", vacancies.get(0).getTitle());
    }

    // Другие тесты для методов репозитория, если нужно
}
