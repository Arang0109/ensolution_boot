# ENSolution
환경 측정 대행 업체를 위한 대기, 수질, 악취 등 환경 측정 업무의 자동화 및 문서 관리 솔루션

## 기능
- 업체 및 시설 등록, 관리
- 일정 관리 (업데이트 예정)
- 측정 오염 물질 주기 관리
- 용역 이행 능력 평가 점수 계산
- 측정 업체 전반의 통계 분석 및 보고서 관리 시스템 (업데이트 예정)
- 사내 문서 관리 시스템 (추가 예정)
- 품질 문서 관리 시스템 (추가 예정)

## 설치 방법
ensolution_boot 프로젝트를 로컬 환경에 설정하고 실행하려면 아래 단계를 따르세요.
### 준비 사항
1. Java Development Kit (JDK) 21 사용
2. MySQL Database
- 기본 데이터베이스 이름 : ensolution
- git 프로젝트에 ensolution.sql 다운로드

- src/main/resources/application.properties 파일을 열어
아래와 같이 MySQL 데이터 정보를 입력하세요.
```
spring.datasource.url=jdbc:mysql://localhost:3306/ensolution
spring.datasource.username=USER_NAME
spring.datasource.password=USER_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
3. Maven
```
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>mybatis-spring-boot-starter</artifactId>
  <version>3.0.3</version>
</dependency>
```
- src/main/resources/application.properties 파일을 열어 아래와 같이 입력하세요.
```
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.config-location=classpath:mybatis-config.xml
```
4. 실행
- 레포지토리 클론
```
>> git clone https://github.com/Arang0109/ensolution_boot.git
>> cd ensolution_boot
```