package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.dto.RecommendationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("recommendation-service/auth/recommendations")
public interface RecommendationClient {

    @GetMapping
    List<RecommendationDto> getAllRecommendations();

    @GetMapping("/{id}")
    RecommendationDto getRecommendationById(@PathVariable Long id);

    @GetMapping("/byGoodId/{id}")
    RecommendationDto getRecommendationByGoodId(@PathVariable Long id);

    @PostMapping
    RecommendationDto createRecommendation(@RequestBody RecommendationDto recommendationDto);

    @PutMapping
    RecommendationDto updateRecommendation( @RequestBody RecommendationDto updatedRecommendationDto);

    @DeleteMapping("/{id}")
    void deleteRecommendation(@PathVariable Long id);
}
