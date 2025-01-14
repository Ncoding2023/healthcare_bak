package com.health.healthCare.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//맵퍼파일역할
@Entity
@Table(name = "EXERCISE_DATA")
@EntityListeners(AuditingEntityListener.class)//생성및 수정 날짜 사용
public class ExerciseData {

    @Id
    @Column(name = "EXERCISE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseNo;//exerciseNo
    @Column(name = "EXERCISE_IMG")
    private String exerciseImg;
    @Column(name = "EXERCISE_CD")
    private String exerciseCd;
    @Column(name = "EXERCISE_NAME")
    private String exerciseName;
    @Column(name = "EXERCISE_MAIN_AREA")
    private String exerciseMainArea;
    @Column(name = "EXERCISE_SUV_AREA")
    private String exerciseSuvArea;
    @Column(name = "EXERCISE_DESCRIPTION")
    private String exerciseDescription;

    @CreatedDate
    @Column(name = "REGDATE", columnDefinition = "DATETIME(0)", updatable = false)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 입력 시 포맷 지정
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  exerciseRegdate;

    @LastModifiedDate
    @Column(name = "UPDATEDATE", columnDefinition = "DATETIME(0)")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime exerciseUpdatedate;
    // 기본 생성자
    public ExerciseData() {
    }
    @PrePersist
    protected void onCreate() {
        exerciseRegdate = LocalDateTime.now().withNano(0); // 현재 날짜 및 시간으로 설정
//        exerciseUpdatedate = LocalDateTime.now().withNano(0); // 수정 날짜
    }

    @PreUpdate
    protected void onUpdate() {
        exerciseUpdatedate = LocalDateTime.now().withNano(0); // 수정 날짜
    }

    public ExerciseData(Long exerciseNo, String exerciseImg, String exerciseCd, String exerciseName, String exerciseMainArea, String exerciseSuvArea, String exerciseDescription, LocalDateTime exerciseRegdate, LocalDateTime exerciseUpdatedate) {
        this.exerciseNo = exerciseNo;
        this.exerciseImg = exerciseImg;
        this.exerciseCd = exerciseCd;
        this.exerciseName = exerciseName;
        this.exerciseMainArea = exerciseMainArea;
        this.exerciseSuvArea = exerciseSuvArea;
        this.exerciseDescription = exerciseDescription;
        this.exerciseRegdate = exerciseRegdate;
        this.exerciseUpdatedate = exerciseUpdatedate;
    }

    public Long getExerciseNo() {
        return exerciseNo;
    }

    public void setExerciseNo(Long exerciseNo) {
        this.exerciseNo = exerciseNo;
    }

    public String getExerciseImg() {
        return exerciseImg;
    }

    public void setExerciseImg(String exerciseImg) {
        this.exerciseImg = exerciseImg;
    }

    public String getExerciseCd() {
        return exerciseCd;
    }

    public void setExerciseCd(String exerciseCd) {
        this.exerciseCd = exerciseCd;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseMainArea() {
        return exerciseMainArea;
    }

    public void setExerciseMainArea(String exerciseMainArea) {
        this.exerciseMainArea = exerciseMainArea;
    }

    public String getExerciseSuvArea() {
        return exerciseSuvArea;
    }

    public void setExerciseSuvArea(String exerciseSuvArea) {
        this.exerciseSuvArea = exerciseSuvArea;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public LocalDateTime getExerciseRegdate() {
        return exerciseRegdate;
    }

    public void setExerciseRegdate(LocalDateTime exerciseRegdate) {
        this.exerciseRegdate = exerciseRegdate;
    }

    public LocalDateTime getExerciseUpdatedate() {
        return exerciseUpdatedate;
    }

    public void setExerciseUpdatedate(LocalDateTime exerciseUpdatedate) {
        this.exerciseUpdatedate = exerciseUpdatedate;
    }
}
