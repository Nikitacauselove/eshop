package ru.stileyn.jobsmicro.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VacancyDtoTest {

    @Test
    void testVacancyDto() {
        VacancyDto VacancyDto = new VacancyDto();
        VacancyDto.setId(1L);
        VacancyDto.setTitle("Software Engineer");

        assertEquals(1L, VacancyDto.getId());
        assertEquals("Software Engineer", VacancyDto.getTitle());
    }
}
