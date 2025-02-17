FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

RUN apk update && apk add --no-cache \
    bash \
    maven \
    && rm -rf /var/cache/apk/*

# maven dependency
COPY pom.xml .
RUN mvn dependency:go-offline

# jar 파일 생성
COPY src ./src
RUN mvn clean package spring-boot:repackage -DskipTests

# ================== 2 ================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]