package com.eshop.vacancyservice.mapper;

import com.eshop.vacancyservice.dto.VacancyDto;
import com.eshop.vacancyservice.entity.Vacancy;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacancyMapperTest {

    private VacancyMapper vacancyMapper = Mappers.getMapper(VacancyMapper.class);

    @Test
    void testVacancyToVacancyDto() {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);
        vacancy.setTitle("Software Engineer");

        VacancyDto VacancyDto = vacancyMapper.vacancyToVacancyDto(vacancy);

        assertEquals(vacancy.getId(), VacancyDto.getId());
        assertEquals(vacancy.getTitle(), VacancyDto.getTitle());
    }

    @Test
    void testVacanciesToVacancyDtos() {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);
        vacancy.setTitle("Software Engineer");

        List<Vacancy> vacancies = Collections.singletonList(vacancy);

        List<VacancyDto> VacancyDtos = vacancyMapper.vacanciesToVacancyDtos(vacancies);

        assertEquals(1, VacancyDtos.size());
        assertEquals(vacancy.getId(), VacancyDtos.get(0).getId());
        assertEquals(vacancy.getTitle(), VacancyDtos.get(0).getTitle());
    }

    @Test
    void testVacancyDtoToVacancy() {
        VacancyDto VacancyDto = new VacancyDto();
        VacancyDto.setId(1L);
        VacancyDto.setTitle("Software Engineer");

        Vacancy vacancy = vacancyMapper.VacancyDtoToVacancy(VacancyDto);

        assertEquals(VacancyDto.getId(), vacancy.getId());
        assertEquals(VacancyDto.getTitle(), vacancy.getTitle());
    }
}
