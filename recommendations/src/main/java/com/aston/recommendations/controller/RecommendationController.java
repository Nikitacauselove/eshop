package com.aston.recommendations.controller;

import com.aston.recommendations.dto.RecommendationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aston.recommendations.service.RecommendationService;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public List<RecommendationDto> getAllRecommendations() {
        return recommendationService.findAll();
    }

    @GetMapping("/{id}")
    public RecommendationDto getRecommendationById(@PathVariable Long id) {
        return recommendationService.findById(id);
    }


    @GetMapping("/byGoodId/{id}")
    public RecommendationDto getRecommendationByGoodId(@PathVariable Long id) {
        return recommendationService.findRecommendationByGoodId(id);
    }


    @PostMapping
    public RecommendationDto createRecommendation(@RequestBody RecommendationDto recommendationDto) {
        return recommendationService.save(recommendationDto);
    }

    @PutMapping
    public RecommendationDto updateRecommendation( @RequestBody RecommendationDto updatedRecommendationDto) {

        return recommendationService.update(updatedRecommendationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRecommendation(@PathVariable Long id) {
        recommendationService.delete(id);
    }
}
