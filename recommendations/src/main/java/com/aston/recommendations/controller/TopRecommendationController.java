package com.aston.recommendations.controller;

import com.aston.recommendations.dto.RecommendationDto;
import com.aston.recommendations.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/topRecommendations")
public class TopRecommendationController {
    private final RecommendationService recommendationService;

    @Autowired
    public TopRecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }
    @GetMapping("/{howMany}")
    public List<RecommendationDto> getTopRecommendations(@PathVariable int howMany) {
        return recommendationService.findTopRecomendations(howMany);
    }
}