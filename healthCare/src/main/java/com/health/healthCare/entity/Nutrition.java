package com.health.healthCare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Setter
@Immutable // 엔터티를 읽기 전용으로 설정
@Table(name = "NUTRITION")
public class Nutrition {
//@OrderBy("foodName ASC") // foodName 기준으로 기본 정렬


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_NO") // DB의 컬럼명과 매핑
    private Long foodNo;

    @Column(name = "FOOD_NAME")
    private String foodName;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "SERVING_SIZE")
    private String servingSize;

    @Column(name = "ENERGY")
    private Double energy;

    @Column(name = "MOISTURE")
    private Double moisture;

    @Column(name = "PROTEIN")
    private Double protein;

    @Column(name = "FAT")
    private Double fat;

    @Column(name = "CARBOHYDRATE")
    private Double carbohydrate;

    @Column(name = "SUGAR")
    private Double sugar;

    @Column(name = "FIBER")
    private Double fiber;

    @Column(name = "CALCIUM")
    private Double calcium;

    @Column(name = "POTASSIUM")
    private Double potassium;

    @Column(name = "SODIUM")
    private Double sodium;

    @Column(name = "VITAMIN_D")
    private Double vitaminD;

    @Column(name = "CHOLESTEROL")
    private Double cholesterol;

    @Column(name = "SATURATED_FAT")
    private Double saturatedFat;

    @Column(name = "TRANS_FAT")
    private Double transFat;

    @Column(name = "REGDATE", insertable = false, updatable = false)
    private String regDate;

    @Column(name = "UPDATEDATE", insertable = false, updatable = false)
    private String updateDate;

}

