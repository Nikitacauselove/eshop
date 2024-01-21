package com.eshop.vacancyservice.mapper;

import com.eshop.vacancyservice.dto.VacancyDto;
import com.eshop.vacancyservice.entity.Vacancy;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface VacancyMapper {
    VacancyDto vacancyToVacancyDto(Vacancy vacancy);
    Vacancy VacancyDtoToVacancy(VacancyDto VacancyDto);

    List<VacancyDto> vacanciesToVacancyDtos(List<Vacancy> vacancies);
}
