package com.health.healthCare.repository;

import com.health.healthCare.entity.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {

    // 추가적인 조회 메서드 예시
    List<Nutrition> findAll();

    List<Nutrition> findByCategory(String category); // 카테고리별 조회
}