package com.aston.recommendations.mapper;

import com.aston.recommendations.dto.RecommendationDto;
import com.aston.recommendations.entity.Recommendation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    Recommendation fromDto(RecommendationDto goodDto);

    RecommendationDto toDto(Recommendation recommendation);
}