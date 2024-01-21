package com.eshop.apigateway.controller;

import com.eshop.apigateway.dto.RecommendationDto;
import com.eshop.apigateway.openfeign.RecommendationClient;
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
@RequestMapping("/api/v1/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationClient recommendationClient;

    @GetMapping
    public List<RecommendationDto> getAllRecommendations() {
        return recommendationClient.getAllRecommendations();
    }

    @GetMapping("/{id}")
    public RecommendationDto getRecommendationById(@PathVariable Long id) {
        return recommendationClient.getRecommendationById(id);
    }

    @GetMapping("/byGoodId/{id}")
    public RecommendationDto getRecommendationByGoodId(@PathVariable Long id) {
        return getRecommendationByGoodId(id);
    }

    @PostMapping
    public RecommendationDto createRecommendation(@RequestBody RecommendationDto recommendationDto) {
        return recommendationClient.createRecommendation(recommendationDto);
    }

    @PutMapping
    public RecommendationDto updateRecommendation( @RequestBody RecommendationDto updatedRecommendationDto) {
        return recommendationClient.updateRecommendation(updatedRecommendationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRecommendation(@PathVariable Long id) {
        recommendationClient.deleteRecommendation(id);
    }
}
