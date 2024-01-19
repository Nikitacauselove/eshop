package com.aston.recommendations.repository;

import com.aston.recommendations.dto.RecommendationDto;
import com.aston.recommendations.entity.Recommendation;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    Optional<Recommendation> findRecommendationByGoodId(Long goodId);

}