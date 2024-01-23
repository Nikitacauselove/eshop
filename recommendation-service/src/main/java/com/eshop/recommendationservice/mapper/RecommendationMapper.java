package com.eshop.recommendationservice.mapper;

import com.eshop.recommendationservice.dto.RecommendationDto;
import com.eshop.recommendationservice.entity.Recommendation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    Recommendation fromDto(RecommendationDto goodDto);

    RecommendationDto toDto(Recommendation recommendation);
}