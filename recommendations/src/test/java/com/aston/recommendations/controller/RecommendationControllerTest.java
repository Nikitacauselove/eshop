package com.aston.recommendations.controller;

import com.aston.recommendations.dto.RecommendationDto;
import com.aston.recommendations.service.RecommendationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class RecommendationControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private RecommendationService recommendationService;

        private RecommendationDto recommendationDto;

        @BeforeEach
        public void setup() {
            recommendationDto = new RecommendationDto();
            recommendationDto.setId(3L);
            recommendationDto.setGoodId(3L);
            recommendationDto.setViewCount(10);

        }

        @Test
        public void getRecommendationsTest() throws Exception {
            List<RecommendationDto> recommendations = Collections.singletonList(recommendationDto);
            when(recommendationService.findAll()).thenReturn(recommendations);

            mockMvc.perform(get("/recommendations")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void getRecommendationByGoodIdTest() throws Exception {
            when(recommendationService.findRecommendationByGoodId(anyLong())).thenReturn(recommendationDto);

            mockMvc.perform(get("/recommendations/3")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void createRecommendationTest() throws Exception {
            when(recommendationService.save(any(RecommendationDto.class))).thenReturn(recommendationDto);

            mockMvc.perform(post("/recommendations")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"id\":3,\"goodId\":3,\"viewCount\":10}"))
                    .andExpect(status().isOk());
        }

        @Test
        public void updateGoodTest() throws Exception {
            when(recommendationService.update(any(RecommendationDto.class))).thenReturn(recommendationDto);

            mockMvc.perform(put("/recommendations")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"id\":3,\"goodId\":3,\"viewCount\":10}"))
                    .andExpect(status().isOk());
        }

        @Test
        public void deleteGoodTest() throws Exception {
            when(recommendationService.delete(anyLong())).thenReturn(true);

            mockMvc.perform(delete("/recommendations/3")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }
    }
