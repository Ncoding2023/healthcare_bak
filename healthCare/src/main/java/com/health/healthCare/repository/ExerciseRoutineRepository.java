package com.health.healthCare.repository;

import com.health.healthCare.entity.ExerciseRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRoutineRepository extends JpaRepository<ExerciseRoutine, Long> {
    List<ExerciseRoutine> findByRoutineNo(Long routineNo);

    List<ExerciseRoutine> findByRoutineCd(String routineCd);

    List<ExerciseRoutine> findByRoutineName(String routineName);

    // 루틴 이름이 포함된 경우 조회
    List<ExerciseRoutine> findByRoutineNameContaining(String routineName);

    void deleteById(Long routineNo);
}
