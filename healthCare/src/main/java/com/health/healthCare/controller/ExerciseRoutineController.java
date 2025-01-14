package com.health.healthCare.controller;

import com.health.healthCare.Domain.ExerciseRoutineRequest;
import com.health.healthCare.entity.ExerciseData;
import com.health.healthCare.entity.ExerciseRoutine;
import com.health.healthCare.service.ExerciseDataService;
import com.health.healthCare.service.ExerciseRoutineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exerciseRoutines")
@CrossOrigin(origins = "http://localhost:5173") // React 앱의 주소
public class ExerciseRoutineController {

    @Autowired
    private ExerciseRoutineService exerciseRoutineService;

    @PostMapping
    public ResponseEntity<List<ExerciseRoutine>> createRoutine(@RequestBody ExerciseRoutineRequest request) {
        List<ExerciseRoutine> createdRoutine = exerciseRoutineService.createRoutine(request);
        return ResponseEntity.ok(createdRoutine);
    }

    @PutMapping("No/{routineNo}")
    public ResponseEntity<List<ExerciseRoutine>> updateRoutine(
            @PathVariable("routineNo") Long routineNo,
//            @RequestBody ExerciseRoutine request) {
            @RequestBody ExerciseRoutineRequest request) {
        List<ExerciseRoutine> updatedRoutines = exerciseRoutineService.updateRoutine(routineNo, request);
        return ResponseEntity.ok(updatedRoutines);
    }

    @DeleteMapping("Del/{routineName}")
    public ResponseEntity<Void> deleteRoutine(@PathVariable("routineName") String routineName) {
        System.out.println("삭제 ::: " + routineName);
        exerciseRoutineService.deleteRoutine(routineName);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/no/{routineNo}")
//    public ResponseEntity<List<ExerciseRoutine>> getRoutines(@PathVariable String routineCd) {
//        List<ExerciseRoutine> routines = exerciseRoutineService.getRoutines(routineCd);
//        return ResponseEntity.ok(routines);
//    }
    // Read - All
    @GetMapping
    public ResponseEntity<List<ExerciseRoutine>> getAllRoutines() {
        List<ExerciseRoutine> routines = exerciseRoutineService.getAllRoutines();
        return new ResponseEntity<>(routines, HttpStatus.OK);
    }
//    @GetMapping("/name/{routineName}")
//    public ResponseEntity<List<ExerciseRoutine>> getNameRoutines(@PathVariable String routineName) {
//        List<ExerciseRoutine> routines = exerciseRoutineService.getNameRoutines(routineName);
//        return ResponseEntity.ok(routines);
//    }
//    @GetMapping("/name/{routineName}")
//    public List<ExerciseRoutine> getRoutinesByName(@PathVariable String routineName) {
//        return exerciseRoutineService.getNameRoutines(routineName);
//    }

    @GetMapping("/name/{routineName}")
    public List<ExerciseRoutine> getRoutinesByName(@PathVariable("routineName") String routineName) {
        return exerciseRoutineService.getRoutinesByName(routineName);
    }
}


