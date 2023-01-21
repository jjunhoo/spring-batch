## spring-batch 의존성 추가 - pom.xml 설정

````xml
<!-- spring-batch -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-batch</artifactId>
</dependency>
````

## MySQL 설치

> Docker 설치 및 MySQL 이미지 다운/실행

![img1.png](image/img1.png)

![img2.png](image/img2.png)

![img3.png](image/img3.png)

- MySQL - RUN
    - 옵션 셋팅
    - Container name, Environment variables (이미지명, MySQL 패스워드, MySQL 유저, MySQL DB)

![img4.png](image/img4.png)

- 위에서 생성한 MySQL 이미지 재사용
    - spring-batch-mysql 이미지 체크 후 Actions 의 실행 버튼 클릭

- 설치 : https://www.docker.com/get-started
    - Download for Mac - Apple Chip

