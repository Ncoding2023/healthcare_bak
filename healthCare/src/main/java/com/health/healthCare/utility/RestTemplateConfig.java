package com.health.healthCare.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // JAXB 컨버터 추가
//        restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
        return restTemplate;
    }
}

