package com.eshop.recommendationservice.mapper;

import com.eshop.recommendationservice.dto.RecommendationDto;
import com.eshop.recommendationservice.entity.Recommendation;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class RecommendationMapperTest {

        private final RecommendationMapper recommendationMapper = Mappers.getMapper(RecommendationMapper.class);

        @Test
        public void testFromDto() {
            RecommendationDto recommendationDto = new RecommendationDto();
            recommendationDto.setId(1l);
            recommendationDto.setGoodId(1l);
            recommendationDto.setViewCount(10);
            Recommendation recommendation = recommendationMapper.fromDto(recommendationDto);
            assertEquals(recommendationDto.getId(), recommendation.getId());
            assertEquals(recommendationDto.getGoodId(), recommendation.getGoodId());
            assertEquals(recommendationDto.getViewCount(), recommendation.getViewCount());
        }

        @Test
        public void testToDto() {
            Recommendation recommendation = new Recommendation();
            recommendation.setId(1l);
            recommendation.setGoodId(1l);
            recommendation.setViewCount(10);
            RecommendationDto recommendationDto = recommendationMapper.toDto(recommendation);
            assertEquals(recommendation.getId(), recommendationDto.getId());
            assertEquals(recommendation.getGoodId(), recommendationDto.getGoodId());
            assertEquals(recommendation.getViewCount(), recommendationDto.getViewCount());
         }
    }
