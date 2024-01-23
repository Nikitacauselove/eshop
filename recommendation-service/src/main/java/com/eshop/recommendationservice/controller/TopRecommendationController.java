package com.eshop.recommendationservice.controller;

import com.eshop.recommendationservice.dto.RecommendationDto;
import com.eshop.recommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("auth/topRecommendations")
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