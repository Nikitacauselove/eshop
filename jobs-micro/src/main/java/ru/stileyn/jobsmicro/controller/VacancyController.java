package ru.stileyn.jobsmicro.controller;

import ru.stileyn.jobsmicro.dto.VacancyDto;
import ru.stileyn.jobsmicro.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping
    public List<VacancyDto> getAllVacancies() {
        return vacancyService.getAllVacancies();
    }

    @GetMapping("/{id}")
    public VacancyDto getVacancyById(@PathVariable Long id) {
        return vacancyService.getVacancyById(id);
    }

    @PostMapping
    public VacancyDto createVacancy(@RequestBody VacancyDto VacancyDto) {
        return vacancyService.createVacancy(VacancyDto);
    }

    @PutMapping("/{id}")
    public VacancyDto updateVacancy(@PathVariable Long id, @RequestBody VacancyDto VacancyDto) {
        return vacancyService.updateVacancy(id, VacancyDto);
    }

    @DeleteMapping("/{id}")
    public void deleteVacancy(@PathVariable Long id) {
        vacancyService.deleteVacancy(id);
    }
}
