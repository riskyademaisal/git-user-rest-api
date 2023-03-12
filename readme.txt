How To Install and Test?
1. Download/clone the project from github.
2. Make sure your docker is already run.
3. Use you CLI and go to project root directory. 
   > cd git-user-rest-api
4. Build, Create Image, and Docker Up with this command:
   [With build docker]:
   git-user-rest-api% ./mvnw clean package -DskipTests && cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker && cd src/main/docker &&  docker compose build --no-cache && docker-compose down && docker rmi docker-spring-boot-postgres:latest && docker compose up -d &&  cd ../../../
   [Without build docker]
   ./mvnw clean package -DskipTests && cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker && cd src/main/docker &&  docker-compose down && docker rmi docker-spring-boot-postgres:latest && docker compose up -d &&  cd ../../../
5. You can test using postman collection file (import to postman): 
   GitSearchUser.postman_collection.json

Technology Stack:
1. Springboot 2.6.4
2. Java 17
3. Database: Postgresql 42.5.4
4. API Client: Openfeign
5. PDF Maker: ItextPdf
6. Circuit Breaker: resilience4j
