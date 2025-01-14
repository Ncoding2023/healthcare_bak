package com.health.healthCare.service;

import com.health.healthCare.entity.ExerciseData;
import com.health.healthCare.repository.ExerciseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseDataService {

    @Autowired
    private ExerciseDataRepository exerciseDataRepository;

//  Read
    public List<ExerciseData> getAllExercisesData() {
        return exerciseDataRepository.findAll();
    }

    public Optional<ExerciseData> getExerciseDataById(Long id) {
        return exerciseDataRepository.findById(id);
    }

}

