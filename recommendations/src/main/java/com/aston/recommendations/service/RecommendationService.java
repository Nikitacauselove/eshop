package com.aston.recommendations.service;

        import com.aston.recommendations.dto.RecommendationDto;
        import com.aston.recommendations.entity.Recommendation;
        import com.aston.recommendations.mapper.RecommendationMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.http.HttpStatus;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import org.springframework.web.server.ResponseStatusException;
        import com.aston.recommendations.repository.RecommendationRepository;

        import java.util.Comparator;
        import java.util.List;
        import java.util.Optional;
        import java.util.stream.Collectors;

        import static java.util.Collections.reverseOrder;
        import static org.springframework.data.relational.core.query.Query.query;

@Service
@Transactional(readOnly = true)
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository, RecommendationMapper recommendationMapper) {
        this.recommendationRepository = recommendationRepository;
        this.recommendationMapper = recommendationMapper;
    }

    public List<RecommendationDto> findAll() {
        List<Recommendation> goods = recommendationRepository.findAll();
        return goods.stream()
                .map(recommendationMapper::toDto)
                .collect(Collectors.toList());
    }

    public RecommendationDto findById(Long id) {
        Optional<Recommendation> existingRecommendation = recommendationRepository.findById(id);
        if (existingRecommendation.isPresent()) {
            Recommendation good = existingRecommendation.get();
            return recommendationMapper.toDto(good);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recomendation not found");
        }
    }

    public RecommendationDto findRecommendationByGoodId(Long id) {
        Optional<Recommendation> existingRecommendation = recommendationRepository.findRecommendationByGoodId(id);
        if (existingRecommendation.isPresent()) {
            Recommendation good = existingRecommendation.get();
            return recommendationMapper.toDto(good);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recomendation not found");
        }
    }

    @Transactional
    public RecommendationDto save(RecommendationDto recommendationDto) {
        Optional<Recommendation> existingRecommendation = recommendationRepository.findRecommendationByGoodId(recommendationDto.getGoodId());
        if (existingRecommendation.isPresent()) {
            Recommendation recommendation = existingRecommendation.get();

            recommendation.setViewCount(recommendation.getViewCount() + recommendationDto.getViewCount());
            Recommendation savedRecommendation = recommendationRepository.save(recommendation);
            return recommendationMapper.toDto(savedRecommendation);
        } else {
            Recommendation recommendation = recommendationMapper.fromDto(recommendationDto);
            Recommendation savedRecommendation = recommendationRepository.save(recommendation);
            return recommendationMapper.toDto(savedRecommendation);
        }
    }

    @Transactional
    public RecommendationDto update(RecommendationDto updatedRecommendationDto) {

       return
               save(updatedRecommendationDto);

    }

    @Transactional
    public boolean delete(Long id) {
        if (recommendationRepository.existsById(id)) {
            recommendationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    @Transactional
    public List<RecommendationDto> findTopRecomendations(int howMany){
        List<RecommendationDto> recommendationDtos = findAll();
        recommendationDtos.sort(Comparator.comparing(RecommendationDto::getViewCount).reversed());
        recommendationDtos = recommendationDtos.stream().limit(howMany).collect(Collectors.toList());

        return recommendationDtos;

    }

}
