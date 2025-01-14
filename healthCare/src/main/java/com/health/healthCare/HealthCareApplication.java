package com.health.healthCare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:5173") // React 앱의 주소
public class HealthCareApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthCareApplication.class, args);
//        SpringApplication.run(FatSecretApiController.class, args);
    }
//public static void main(String[] args) {
//    NutriFoodInfoService nutriFoodInfoService = new NutriFoodInfoService();
//
//    String searchExpression = "apple";  // 검색할 식품 이름
//    int pageNumber = 0;  // 페이지 번호 (0부터 시작)
//    int maxResults = 20;  // 최대 검색 결과 수
//
//    // 식품 검색 요청
//    String foodSearchResults = nutriFoodInfoService.searchFoods(searchExpression);
//
//    // 결과 출력
//    System.out.println(foodSearchResults);
//}
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//    @Bean
//    public WebClient.Builder webClientBuilder() {
//        return WebClient.builder();
//    }
//    @Bean
//    public WebClient webClient() {
//        return WebClient.builder().baseUrl("https://platform.fatsecret.com").build();  // 기본 URL 설정
//    }
//
//    @Bean
//    public WebClient webClient() {
//        return WebClient.builder();
//    }
}
