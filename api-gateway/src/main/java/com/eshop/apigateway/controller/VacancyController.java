package com.eshop.apigateway.controller;

import com.eshop.apigateway.dto.VacancyDto;
import com.eshop.apigateway.openfeign.VacancyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vacancies")
public class VacancyController {

    @Autowired
    private VacancyClient vacancyClient;

    @GetMapping
    public List<VacancyDto> getAllVacancies() {
        return vacancyClient.getAllVacancies();
    }

    @GetMapping("/{id}")
    public VacancyDto getVacancyById(@PathVariable Long id) {
        return vacancyClient.getVacancyById(id);
    }

    @PostMapping
    public VacancyDto createVacancy(@RequestBody VacancyDto VacancyDto) {
        return vacancyClient.createVacancy(VacancyDto);
    }

    @PutMapping("/{id}")
    public VacancyDto updateVacancy(@PathVariable Long id, @RequestBody VacancyDto VacancyDto) {
        return vacancyClient.updateVacancy(id, VacancyDto);
    }

    @DeleteMapping("/{id}")
    public void deleteVacancy(@PathVariable Long id) {
        vacancyClient.deleteVacancy(id);
    }
}
