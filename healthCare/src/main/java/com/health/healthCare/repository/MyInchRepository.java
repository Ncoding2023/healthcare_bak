package com.health.healthCare.repository;
//package com.health.healthCare.repository;

import com.health.healthCare.entity.MyInch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyInchRepository extends JpaRepository<MyInch, Long> {
    // 추가적인 쿼리 메서드를 정의할 수 있습니다.
}

