# jwt-springboot-sso
jwt+springboot实现的单点登录
# Single Sign On (SSO) Example with JSON Web Token (JWT), Spring Boot - Authentication Service

# What you'll need
- JDK 1.7+
- Maven 3+

# Stack
- Java
- Spring Boot
- FreeMarker

# Run
- Run Authentication Service: `mvn spring-boot:run`
- Run Resource Service 1: `mvn spring-boot:run -Dserver.port=8180`
- Run Resource Service 2: `mvn spring-boot:run -Dserver.port=8280`