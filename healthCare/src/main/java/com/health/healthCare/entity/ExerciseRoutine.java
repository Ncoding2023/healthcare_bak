package com.health.healthCare.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//맵퍼파일역할
@Entity
@Table(name = "EXERCISE_ROUTINE")
@EntityListeners(AuditingEntityListener.class)//생성및 수정 날짜 사용
public class ExerciseRoutine {

    @Id
    @Column(name = "ROUTINE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routineNo;//exerciseNo
    @Column(name = "ROUTINE_CD")
    private String routineCd;
//    @Column(name = "EXERCISE_CD")
//    private String exerciseCd;
    @Column(name = "ROUTINE_NAME")
    private String routineName;
    @Column(name = "EXERCISE_NAME")
    private String exerciseName;
    @Column(name = "ROUTINE_DESCRIPTION")
    private String routineDescription;
    @Column(name = "EXERCISE_SET")
    private int exerciseSet;
    @Column(name = "EXERCISE_NUM")
    private int exerciseNum;

    @CreatedDate
    @Column(name = "REGDATE", columnDefinition = "DATETIME(0)", updatable = false)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 입력 시 포맷 지정
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  regdate;

    @LastModifiedDate
    @Column(name = "UPDATEDATE", columnDefinition = "DATETIME(0)")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")z
    private LocalDateTime updatedate;
    // 기본 생성자
    public ExerciseRoutine() {
    }
    @PrePersist
    protected void onCreate() {
        regdate = LocalDateTime.now().withNano(0); // 현재 날짜 및 시간으로 설정
//        exerciseUpdatedate = LocalDateTime.now().withNano(0); // 수정 날짜
    }

    @PreUpdate
    protected void onUpdate() {
        updatedate = LocalDateTime.now().withNano(0); // 수정 날짜
    }

    public ExerciseRoutine(Long routineNo, String routineCd, String routineName, String exerciseName, String routineDescription, int exerciseSet, int exerciseNum, LocalDateTime regdate, LocalDateTime updatedate) {
        this.routineNo = routineNo;
        this.routineCd = routineCd;
        this.routineName = routineName;
        this.exerciseName = exerciseName;
        this.routineDescription = routineDescription;
        this.exerciseSet = exerciseSet;
        this.exerciseNum = exerciseNum;
        this.regdate = regdate;
        this.updatedate = updatedate;
    }

    public Long getRoutineNo() {
        return routineNo;
    }

    public void setRoutineNo(Long routineNo) {
        this.routineNo = routineNo;
    }

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

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getRoutineDescription() {
        return routineDescription;
    }

    public void setRoutineDescription(String routineDescription) {
        this.routineDescription = routineDescription;
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

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }

    public LocalDateTime getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(LocalDateTime updatedate) {
        this.updatedate = updatedate;
    }
}
