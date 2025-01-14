package com.health.healthCare.Domain;

import java.util.List;

public class ExerciseRoutineRequest {
    private String routineCd;
    private String routineName;
    private String routineDescription;
    private List<ExerciseDTO> exercises;

    // Getters and Setters
    public String getRoutineCd() {
        return routineCd;
    }

    public void setRoutineCd(String routineCd) {
        this.routineCd = routineCd;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getRoutineDescription() {
        return routineDescription;
    }

    public void setRoutineDescription(String routineDescription) {
        this.routineDescription = routineDescription;
    }

    public List<ExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDTO> exercises) {
        this.exercises = exercises;
    }
}
