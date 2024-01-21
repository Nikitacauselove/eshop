package ru.stileyn.jobsmicro.mapper;

import ru.stileyn.jobsmicro.dto.VacancyDto;
import ru.stileyn.jobsmicro.entity.Vacancy;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface VacancyMapper {
    VacancyDto vacancyToVacancyDto(Vacancy vacancy);
    Vacancy VacancyDtoToVacancy(VacancyDto VacancyDto);

    List<VacancyDto> vacanciesToVacancyDtos(List<Vacancy> vacancies);
}
