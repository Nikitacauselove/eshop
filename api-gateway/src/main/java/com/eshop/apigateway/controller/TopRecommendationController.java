package com.eshop.apigateway.controller;

import com.eshop.apigateway.dto.RecommendationDto;
import com.eshop.apigateway.openfeign.TopRecommendationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topRecommendations")
public class TopRecommendationController {

    @Autowired
    private TopRecommendationClient topRecommendationClient;

    @GetMapping("/{howMany}")
    public List<RecommendationDto> getTopRecommendations(@PathVariable int howMany) {
        return topRecommendationClient.getTopRecommendations(howMany);
    }
}
