package com.health.healthCare.service;

//import com.health.healthCare.Domain.ExerciseDTO;
import com.health.healthCare.Domain.ExerciseDTO;
import com.health.healthCare.entity.ExerciseRoutine;
import com.health.healthCare.repository.ExerciseRoutineRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import com.health.healthCare.Domain.ExerciseRoutineRequest;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExerciseRoutineService {

    private static final Logger log = LoggerFactory.getLogger(ExerciseRoutineService.class);
    @Autowired
    private ExerciseRoutineRepository exerciseRoutineRepository;

    // 루틴 생성
    @Transactional
    public List<ExerciseRoutine> createRoutine(ExerciseRoutineRequest request) {
        List<ExerciseRoutine> routines = new ArrayList<>();

        for (ExerciseDTO exercise : request.getExercises()) {
            ExerciseRoutine routine = new ExerciseRoutine();
            routine.setRoutineCd(request.getRoutineCd());
            routine.setRoutineName(request.getRoutineName());
            routine.setRoutineDescription(request.getRoutineDescription());
            routine.setExerciseName(exercise.getExerciseName().trim()); // 여백 제거
            routine.setExerciseSet(exercise.getExerciseSet());
            routine.setExerciseNum(exercise.getExerciseNum());
            routines.add(routine);
        }

        // 여러 루틴을 한 번에 저장
        return exerciseRoutineRepository.saveAll(routines);
    }
    @Transactional
    public List<ExerciseRoutine> updateRoutine(Long routineNo, ExerciseRoutineRequest request) {
        log.info("routineNo 루틴: " + routineNo);
        log.info("request 루틴 request:  " + request.getRoutineName());
        log.info("request 루틴 getExercises:  " + request.getExercises());
//    ExerciseRoutineRequest. request.getExercises());





//        Set<Long> uniqueIds = new HashSet<>();
        // 전달받은 데이터를 새로운 루틴으로 추가
        List<ExerciseRoutine> updateRoutines = new ArrayList<>();
        for (ExerciseDTO exercise : request.getExercises()) {
//            if (!uniqueIds.add(routineNo)) {
//                throw new IllegalArgumentException("중복된 routineNo: " + routineNo);
//            }
            // 1. 데이터베이스에서 기존 루틴 조회
            log.info("request 루틴 getExerciseNo:  " + exercise.getExerciseNo());
            List<ExerciseRoutine> existingRoutines = exerciseRoutineRepository.findByRoutineNameContaining(request.getRoutineName());

// 2. 요청 데이터에서 전달받은 ExerciseNo 리스트 생성
            Set<Long> incomingExerciseNos = request.getExercises().stream()
                    .map(ExerciseDTO::getExerciseNo)
                    .collect(Collectors.toSet());

// 3. 기존 데이터와 비교하여 삭제할 데이터 식별
            List<ExerciseRoutine> routinesToDelete = existingRoutines.stream()
                    .filter(existingRoutine -> !incomingExerciseNos.contains(existingRoutine.getRoutineNo()))
                    .collect(Collectors.toList());

// 4. 삭제할 데이터 제거
            exerciseRoutineRepository.deleteAll(routinesToDelete);


            ExerciseRoutine updateRoutine = exerciseRoutineRepository.findById(exercise.getExerciseNo())
                    .orElse(new ExerciseRoutine()); // 기존 루틴이 없으면 새로운 루틴 생성
            updateRoutine.setRoutineCd(request.getRoutineCd());
            updateRoutine.setRoutineName(request.getRoutineName());
            updateRoutine.setRoutineDescription(request.getRoutineDescription());
            updateRoutine.setRoutineNo(exercise.getExerciseNo());  // 기존 루틴 번호 와 비교
            updateRoutine.setExerciseName(exercise.getExerciseName().trim());
            updateRoutine.setExerciseSet(exercise.getExerciseSet());
            updateRoutine.setExerciseNum(exercise.getExerciseNum());
            updateRoutines.add(updateRoutine);

            //        // 기존 루틴 전체 삭제
//            exerciseRoutineRepository.deleteById(exercise.getExerciseNo());
//            log.info("기존 루틴 삭제 완료");

        }

        // 기존 루틴 데이터를 조회하고 삭제
        List<ExerciseRoutine> existingRoutines = exerciseRoutineRepository.findByRoutineName(request.getRoutineName());
        log.info("기존 루틴 조회 결과: " + existingRoutines);

        return exerciseRoutineRepository.saveAll(updateRoutines);
    }


    // 루틴 삭제
    public void deleteRoutine(String routineName) {
        List<ExerciseRoutine> existingRoutines = exerciseRoutineRepository.findByRoutineName(routineName);
        exerciseRoutineRepository.deleteAll(existingRoutines);
    }

    // 루틴 조회
    public List<ExerciseRoutine> getRoutines(String routineCd) {
        return exerciseRoutineRepository.findByRoutineCd(routineCd);
    }

    // Read - All
    public List<ExerciseRoutine> getAllRoutines() {
        return exerciseRoutineRepository.findAll();
    }

    // 루틴 조회
    public List<ExerciseRoutine> getNameRoutines(String routineName) {
        return exerciseRoutineRepository.findByRoutineName(routineName);
    }

    public List<ExerciseRoutine> getRoutinesByName(String routineName) {
        return exerciseRoutineRepository.findByRoutineNameContaining(routineName);
    }
}


