package com.health.healthCare.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//맵퍼파일역할
@Entity
@Table(name = "MYINCH")
@EntityListeners(AuditingEntityListener.class)//생성및 수정 날짜 사용
public class MyInch {
    @Id
    @Column(name = "INCHNO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inchNo;//exerciseNo

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "HEIGHT")
    private int height;

    @Column(name = "WEIGHT")
    private int weight;

    @Column(name = "AGE")
    private int age;

    @Column(name = "BMR")
    private int bmr;

    @Column(name = "CARBS")
    private int carbs;

    @Column(name = "PROTEIN")
    private int protein;

    @Column(name = "FAT")
    private int fat;


    @CreatedDate
    @Column(name = "EXERCISEREGDATE", columnDefinition = "DATETIME(0)", updatable = false)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 입력 시 포맷 지정
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  regdate;

    @LastModifiedDate
    @Column(name = "EXERCISEUPDATEDATE", columnDefinition = "DATETIME(0)")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedate;
    // 기본 생성자
    public MyInch() {
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

    public MyInch(Long inchNo, String gender, int height, int weight, int age, int bmr, int carbs, int protein, int fat, LocalDateTime regdate, LocalDateTime updatedate) {
        this.inchNo = inchNo;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.bmr = bmr;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.regdate = regdate;
        this.updatedate = updatedate;
    }

    public Long getInchNo() {
        return inchNo;
    }

    public void setInchNo(Long inchNo) {
        this.inchNo = inchNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBmr() {
        return bmr;
    }

    public void setBmr(int bmr) {
        this.bmr = bmr;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
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
