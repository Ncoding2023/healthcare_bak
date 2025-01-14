package com.health.healthCare.controller;

import com.health.healthCare.entity.ExerciseData;
import com.health.healthCare.entity.MyInch;
import com.health.healthCare.service.ExerciseDataService;
import com.health.healthCare.service.MyInchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exerciseData")
@CrossOrigin(origins = "http://localhost:5173") // React 앱의 주소
public class ExerciseDataController {

    @Autowired
    private ExerciseDataService exerciseDataService;


    // Read
    @GetMapping
    public ResponseEntity<List<ExerciseData>> getAllMyInches() {
        List<ExerciseData> exerciseData = exerciseDataService.getAllExercisesData();
        return new ResponseEntity<>(exerciseData, HttpStatus.OK);
    }

    @GetMapping("/{exerciseNo}")
    public ResponseEntity<ExerciseData> getMyInchById(@PathVariable Long exerciseNo) {
        return exerciseDataService.getExerciseDataById(exerciseNo)
                .map(exerciseData -> new ResponseEntity<>(exerciseData, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

