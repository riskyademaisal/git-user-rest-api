# Springboot Search User Github API

## How To Install and Test?
- Download/clone the project from github.
- Make sure your docker is already run.
- Use you CLI and go to project root directory. 
``` 
cd git-user-rest-api
```
- Build, Create Image, and Docker Up with this command:
   #### [With build docker]
   ```
   git-user-rest-api% ./mvnw clean package -DskipTests && cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker && cd src/main/docker &&  docker compose build --no-cache && docker-compose down && docker rmi docker-spring-boot-postgres:latest && docker compose up -d &&  cd ../../../
   ```
   #### [Without build docker]
   ```
   ./mvnw clean package -DskipTests && cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker && cd src/main/docker &&  docker-compose down && docker rmi docker-spring-boot-postgres:latest && docker compose up -d &&  cd ../../../
   ```
- You can test using postman collection file (import to postman): 
   GitSearchUser.postman_collection.json

## Technology Stack:
- Springboot 2.6.4
- Java 17
- Database: Postgresql 42.5.4
- API Client: Openfeign
- PDF Maker: ItextPdf
- Circuit Breaker: resilience4j
