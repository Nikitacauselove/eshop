package com.aston.recommendations.dto;

import jakarta.persistence.*;
import lombok.*;

    @Getter
    @Setter

    public class RecommendationDto {

        private Long id;
        private Long goodId;
        private int viewCount;

        public RecommendationDto(long l, long l1, int i) {
        }

        public RecommendationDto() {

        }
    }


