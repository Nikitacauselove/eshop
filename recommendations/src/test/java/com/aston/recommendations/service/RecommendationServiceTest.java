package com.aston.recommendations.service;
        import com.aston.recommendations.dto.RecommendationDto;
        import com.aston.recommendations.entity.Recommendation;
        import com.aston.recommendations.mapper.RecommendationMapper;
        import com.aston.recommendations.repository.RecommendationRepository;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.boot.test.context.SpringBootTest;

        import java.util.List;
        import java.util.Optional;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNotNull;
        import static org.junit.jupiter.api.Assertions.assertTrue;
        import static org.mockito.Mockito.times;
        import static org.mockito.Mockito.verify;
        import static org.mockito.Mockito.when;


@SpringBootTest
public class RecommendationServiceTest {

    @Mock
    private RecommendationRepository recommendationRepository;

    @Mock
    private RecommendationMapper recommendationMapper;

    @InjectMocks
    private RecommendationService recommendationService;

    @Test
    public void testFindAll() {
        when(recommendationRepository.findAll()).thenReturn(List.of(new Recommendation()));
        assertEquals(1, recommendationService.findAll().size());
    }

    @Test
    public void testFindOne() {
        Recommendation recommendation = new Recommendation();
        recommendation.setId(1L);
        when(recommendationRepository.findById(1L)).thenReturn(Optional.of(recommendation));
        when(recommendationMapper.toDto(recommendation)).thenReturn(new RecommendationDto(1L, 1L, 10));
        assertNotNull(recommendationService.findById(1L));
    }

    @Test
    public void testSave() {
        RecommendationDto recommendationDto = new RecommendationDto(1L,1L, 10);
        Recommendation recommendation = new Recommendation();
        when(recommendationMapper.fromDto(recommendationDto)).thenReturn(recommendation);
        when(recommendationRepository.save(recommendation)).thenReturn(recommendation);
        when(recommendationMapper.toDto(recommendation)).thenReturn(recommendationDto);
        assertEquals(recommendationDto, recommendationService.save(recommendationDto));
    }

    @Test
    public void testUpdate() {
        RecommendationDto recommendationDto = new RecommendationDto(1L, 1L, 10);
        Recommendation recommendation = new Recommendation();
        when(recommendationMapper.fromDto(recommendationDto)).thenReturn(recommendation);
        when(recommendationRepository.save(recommendation)).thenReturn(recommendation);
        when(recommendationMapper.toDto(recommendation)).thenReturn(recommendationDto);
        assertEquals(recommendationDto, recommendationService.update(recommendationDto));
    }

    @Test
    public void testDelete() {
        when(recommendationRepository.existsById(1L)).thenReturn(true);
        boolean result = recommendationService.delete(1L);
        assertTrue(result);
        verify(recommendationRepository, times(1)).deleteById(1L);
    }

}