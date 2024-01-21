package com.eshop.apigateway.openfeign;

import com.eshop.apigateway.dto.RecommendationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("recommendation-service/auth/topRecommendations")
public interface TopRecommendationClient {

    @GetMapping("/{howMany}")
    List<RecommendationDto> getTopRecommendations(@PathVariable int howMany);
}
