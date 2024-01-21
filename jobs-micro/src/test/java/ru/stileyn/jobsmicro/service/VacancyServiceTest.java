package ru.stileyn.jobsmicro.service;

import ru.stileyn.jobsmicro.dto.VacancyDto;
import ru.stileyn.jobsmicro.entity.Vacancy;
import ru.stileyn.jobsmicro.mapper.VacancyMapper;
import ru.stileyn.jobsmicro.repository.VacancyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VacancyServiceTest {

    @Mock
    private VacancyRepository vacancyRepository;

    @Mock
    private VacancyMapper vacancyMapper;

    @InjectMocks
    private VacancyService vacancyService;

    @Test
    void testGetAllVacancies() {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);
        VacancyDto VacancyDto = new VacancyDto();
        VacancyDto.setId(1L);

        List<Vacancy> vacancies = Collections.singletonList(vacancy);
        List<VacancyDto> VacancyDtos = Collections.singletonList(VacancyDto);

        when(vacancyRepository.findAll()).thenReturn(vacancies);
        when(vacancyMapper.vacanciesToVacancyDtos(vacancies)).thenReturn(VacancyDtos);

        assertEquals(VacancyDtos, vacancyService.getAllVacancies());
        verify(vacancyRepository, times(1)).findAll();
    }

    @Test
    void testCreateVacancy() {
        VacancyDto VacancyDto = new VacancyDto();
        VacancyDto.setId(1L);
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);

        when(vacancyMapper.VacancyDtoToVacancy(VacancyDto)).thenReturn(vacancy);
        when(vacancyRepository.save(vacancy)).thenReturn(vacancy);
        when(vacancyMapper.vacancyToVacancyDto(vacancy)).thenReturn(VacancyDto);

        assertEquals(VacancyDto, vacancyService.createVacancy(VacancyDto));
        verify(vacancyRepository, times(1)).save(vacancy);
    }

    // Другие тесты для обновления, удаления вакансий и т.д.
}
