package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.dto.VacancyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("vacancy-service/auth/vacancies")
public interface VacancyClient {

    @GetMapping
    List<VacancyDto> getAllVacancies();

    @GetMapping("/{id}")
    VacancyDto getVacancyById(@PathVariable Long id);

    @PostMapping
    VacancyDto createVacancy(@RequestBody VacancyDto VacancyDto);

    @PutMapping("/{id}")
    VacancyDto updateVacancy(@PathVariable Long id, @RequestBody VacancyDto VacancyDto);

    @DeleteMapping("/{id}")
    void deleteVacancy(@PathVariable Long id);
}
