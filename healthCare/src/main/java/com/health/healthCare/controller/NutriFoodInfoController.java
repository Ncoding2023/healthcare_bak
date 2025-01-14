package com.health.healthCare.controller;
import com.health.healthCare.Domain.ExerciseDTO;
import com.health.healthCare.entity.Nutrition;
import com.health.healthCare.service.NutriFoodInfoService;
//import com.health.healthCare.utility.JavaInXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // React 앱의 주소
@RequestMapping("/food/nutrition")
public class NutriFoodInfoController {

    private static final Logger log = LoggerFactory.getLogger(NutriFoodInfoController.class);
    @Autowired
    private final NutriFoodInfoService nutriFoodInfoService;

    public NutriFoodInfoController(NutriFoodInfoService nutriFoodInfoService) {
        this.nutriFoodInfoService = nutriFoodInfoService;
    }

    // 모든 데이터 조회
    @GetMapping
    public List<Nutrition> getAllNutrition() {
        return nutriFoodInfoService.getAllNutrition();
    }

    // 카테고리별 데이터 조회
    @GetMapping("/category/{category}")
    public List<Nutrition> getNutritionByCategory(@PathVariable(name = "category") String category) {
        log.info("category {}",category);
        return nutriFoodInfoService.getNutritionByCategory(category);
    }


}
