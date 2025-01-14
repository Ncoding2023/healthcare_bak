package com.health.healthCare.repository;

import com.health.healthCare.entity.ExerciseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseDataRepository extends JpaRepository<ExerciseData, Long> {
    // 추가적인 쿼리 메서드를 정의할 수 있습니다.
}

