# healthcare_bak
# Spring Boot + MariaDB

# 프로젝트 개요

healthcare는 Spring Boot를 사용하여 백엔드 애플리케이션을 개발하고, 데이터베이스로 MariaDB를 활용하여 데이터를 관리합니다.
개발 환경으로는 IntelliJ IDEA를 사용하였습니다. 주요 목표는 새로운 language를 학습 및 안전하게 운동을 하고 건강하게 식단을
하자는 취재로 healthcare 프로젝트를 구현하며 백엔드부분으로는 Spring Boot와 MariaDB와 연동하여 CRUD 작업을 수행하는 것입니다.

# 주요 기술 스택

백엔드 프레임워크: Spring Boot
데이터베이스: MariaDB
개발 도구: IntelliJ IDEA

```javascript
console.log("This is a long code block that might overflow and need scrolling!");
// More lines of code...

src/
├── main/
│   ├── java/com/health/healthcare/
│   │   ├── controller/    # REST 컨트롤러
│   │   ├── domain/        # DTO 클래스
│   │   ├── entity/        # 엔티티 클래스
│   │   ├── repository/    # 데이터베이스 접근 레이어
│   │   ├── service/       # 비즈니스 로직
│   │   └── utility/       # 데이터 처리 및 외부 서비스와의 통신
|   |
│   └── resources/
│       ├── application.properties # 데이터베이스 및 Spring 설정
│       └── static/         # 정적 리소스 (필요한 경우)
└── test/
    └── java/com/health/healthcare/   # 테스트 코드
)

#  주요 기능
운동 및 식품 데이터를 확인하며 운동 루틴을 커스텀할 수 있습니다.

#  테이블별 기능 
myinch  생성(Create)
:  회원 가입없이 사용하는 웹으로 처음 방문자의 신체수치를 기록하여 저장
exercise_data   조회(Read)
:  웨이트 운동 위주로 저장되있는 운동 정보를 조회
nutrition  조회(Read)
:  exercise_data와 동일하며 식품 위주로 정보를 조회
exercise_routine  생성(Create), 조회(Read), 수정(Update), 삭제(Delete) 
:  기본적인 운동 루틴도 있으며 나만의 루틴을 따로 만들어서 작성하며,
저장되있는 루틴을 조회하여 수정 및 삭제도 가능

MariaDB 연동:
Spring Data JPA를 통해 MariaDB와 데이터 통신

# 개발 환경
운영체제: Windows10
Java 버전: 17
Gradle(spring boot) 버전: 3.3.4
MariaDB 버전: 11.5.2

문의
개발자: [남상원]
이메일: [ncoding1@gmail.com]
tel : 010 2900 6103

피드백로 알려주시면 주의 깊게 새겨듣겠습니다.

#  감사합니다.

