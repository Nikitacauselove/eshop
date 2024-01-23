package com.eshop.vacancyservice.controller;

import com.eshop.vacancyservice.dto.VacancyDto;
import com.eshop.vacancyservice.service.VacancyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VacancyController.class)
class VacancyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacancyService vacancyService;

    @Test
    void testGetAllVacancies() throws Exception {
        VacancyDto VacancyDto = new VacancyDto();
        VacancyDto.setId(1L);

        when(vacancyService.getAllVacancies()).thenReturn(Collections.singletonList(VacancyDto));

        mockMvc.perform(get("/auth/vacancies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1));

        verify(vacancyService, times(1)).getAllVacancies();
    }

    @Test
    void testCreateVacancy() throws Exception {
        VacancyDto VacancyDto = new VacancyDto();
        VacancyDto.setId(1L);

        when(vacancyService.createVacancy(any(VacancyDto.class))).thenReturn(VacancyDto);

        mockMvc.perform(post("/auth/vacancies")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));

        verify(vacancyService, times(1)).createVacancy(any(VacancyDto.class));
    }

    // Другие тесты для обновления, удаления вакансий и т.д.
}
