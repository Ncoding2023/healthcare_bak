package com.health.healthCare.Domain;

public class ExerciseDTO {
    private long exerciseNo;
    private String exerciseName;
    private int exerciseSet;
    private int exerciseNum;

    public long getExerciseNo() {
        return exerciseNo;
    }

    public void setExerciseNo(int exerciseNo) {
        this.exerciseNo = exerciseNo;
    }

    // Getters and Setters
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getExerciseSet() {
        return exerciseSet;
    }

    public void setExerciseSet(int exerciseSet) {
        this.exerciseSet = exerciseSet;
    }

    public int getExerciseNum() {
        return exerciseNum;
    }

    public void setExerciseNum(int exerciseNum) {
        this.exerciseNum = exerciseNum;
    }
}
