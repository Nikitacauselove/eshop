package com.eshop.vacancyservice.service;

import com.eshop.vacancyservice.dto.VacancyDto;
import com.eshop.vacancyservice.entity.Vacancy;
import com.eshop.vacancyservice.mapper.VacancyMapper;
import com.eshop.vacancyservice.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository, VacancyMapper vacancyMapper) {
        this.vacancyRepository = vacancyRepository;
        this.vacancyMapper = vacancyMapper;
    }

    public List<VacancyDto> getAllVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();
        return vacancyMapper.vacanciesToVacancyDtos(vacancies);
    }

    public VacancyDto getVacancyById(Long id) {
        Optional<Vacancy> optionalVacancy = vacancyRepository.findById(id);
        return optionalVacancy.map(vacancyMapper::vacancyToVacancyDto).orElse(null);
    }

    public VacancyDto createVacancy(VacancyDto VacancyDto) {
        Vacancy vacancy = vacancyMapper.VacancyDtoToVacancy(VacancyDto);
        Vacancy savedVacancy = vacancyRepository.save(vacancy);
        return vacancyMapper.vacancyToVacancyDto(savedVacancy);
    }

    public VacancyDto updateVacancy(Long id, VacancyDto VacancyDto) {
        Optional<Vacancy> optionalVacancy = vacancyRepository.findById(id);

        if (optionalVacancy.isPresent()) {
            Vacancy existingVacancy = optionalVacancy.get();
            existingVacancy.setTitle(VacancyDto.getTitle()); // Обновите другие поля по необходимости
            Vacancy updatedVacancy = vacancyRepository.save(existingVacancy);
            return vacancyMapper.vacancyToVacancyDto(updatedVacancy);
        }

        return null; // или выбросьте исключение, если необходимо
    }

    public void deleteVacancy(Long id) {
        vacancyRepository.deleteById(id);
    }
}
