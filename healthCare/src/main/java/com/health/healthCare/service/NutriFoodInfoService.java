package com.health.healthCare.service;

import com.health.healthCare.entity.Nutrition;
import com.health.healthCare.repository.NutritionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutriFoodInfoService {

    private static final Logger logger = LoggerFactory.getLogger(NutriFoodInfoService.class);

    private final NutritionRepository nutritionRepository;

    public NutriFoodInfoService(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    // 모든 데이터 조회
    public List<Nutrition> getAllNutrition() {
        return nutritionRepository.findAll();
    }

    // 카테고리로 데이터 조회
    public List<Nutrition> getNutritionByCategory(String category) {
        return nutritionRepository.findByCategory(category);
    }
}
