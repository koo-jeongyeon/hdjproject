# 에이치디정션 백엔드 채용 과제
## 소개
* 환자와 환자의 병원진료 기록을 관리하는 API서비스
* [에이치디정션 과제](https://hdjunction.notion.site/2b1b494f9ad140668438f26c1de5379f)

## 개발환경
* OS
  * MacOS Ventura 13.0 (M2)
* 개발툴
  * IntelliJ IDEA
* 언어
  * JAVA 17 (openjdk-17)
* 프레임워크, 라이브러리
  * Spring Boot 3.0.7
    * Spring Web
    * Spring Data JPA
    * Lombok
    * querydsl
      * `Annotation processor`를 사용해 Gradle Plugin 설정 없이 적용
      * `./gradlew compilejava` 자바컴파일시 `src/main/generated` 아래 경로에 Q클래스 생성
      * `./gradlew clean` 클린시 Q클래스 삭제
* 데이터베이스
  * H2 Database
    * 다운로드 & 실행
      * [h2database.com](http://h2database.com/html/main.html)
      * 위 링크의 All Platforms로 다운로드
      * permission error 발생시 `chmod 755 ./bin/h2.sh` 로 권한 부여  후 `./bin/h2.sh` 실행
    * application.yml 설정
      * `localhost:8080/h2-console` 로 접속하면 웹 상에서 관리 가능
      * JDBC url 은 `jdbc:h2:~/hdjproject` 사용자명은 `sa` 비밀번호는 `sa`
      * Run 실행시 `resources` 밑의 `data.sql` 쿼리문 실행되도록 설정

## 구현내용
* 엔드포인트 `RESTful API`를 사용해 기본적인 CRUD API 구현
* 미구현 : 환자목록조회 API 확장 - 페이징 기능
### 환자 정보 API
* 환자등록 `POST` (`localhost:8080/api/v1/patient`)
  ~~~
  {
    "hospitalId":1,
    "name":"테스트",
    "genderCode":"F",
    "birthday":"1990-02-13",
    "phone":"01032347987"
  }
  ~~~
* 환자 정보 수정 `PUT` (`localhost:8080/api/v1/patient`)
  ~~~
  {
    "id":1,
    "hospitalId":1,
    "name":"테스트",
    "genderCode":"F",
    "birthday":"1990-02-13",
    "phone":"01032347987"
  }
  ~~~
* 환자 삭제 `DELETE` (`localhost:8080/api/v1/patient?id=1`)
* 환자 조회 `GET` (`localhost:8080/api/v1/patient?id=1`)
  * 조회 성공시 반환값 예시 (환자 정보와 전체 내원정보목록 조회됨)
  ~~~
  {
    "name": "테스트",
    "regNo": "1686818426355",
    "gender": "여",
    "birthday": "1990-12-06",
    "phone": "01023427863",
    "visits": [
        {
            "hospitalName": "하나병원",
            "createDate": "2023-06-15T17:40:27.880296",
            "state": "종료"
        },
        {
            "hospitalName": "마음병원",
            "createDate": "2023-06-15T17:41:20.78002",
            "state": "방문중"
        }
    ]
  }
  ~~~
* 환자 목록 조회 `GET` (`localhost:8080/api/v1/patients?name=테스트&reqNo=&birthday=`)
  * 조회 성공시 반환값 예시 (동적 검색 조건 적용됨)
  ~~~
  [
    {
        "name": "테스트",
        "regNo": "1686844387527",
        "gender": "여",
        "birthday": "1996-02-06",
        "phone": "",
        "createDate": "1970-01-01T00:00:00"
    },
    {
        "name": "테스트",
        "regNo": "1686844400679",
        "gender": "여",
        "birthday": "1990-12-13",
        "phone": "",
        "createDate": "2023-06-16T00:54:25.7328"
    }
  ]
  ~~~

### 환자방문 정보 API
* 환자방문 등록 `POST` (`localhost:8080/api/v1/visit`)
  ~~~
  {
    "hospitalId":1,
    "patientId":3,
    "stateCode":"1"
  }
  ~~~
* 환자방문 수정 `PUT` (`localhost:8080/api/v1/visit`)
  ~~~
  {
    "id":1,
    "stateCode":"2"
  }
  ~~~
* 환자방문 삭제 `DELETE` (`localhost:8080/api/v1/visit?id=1`)