# Dockerfile para Backend - Java Spring Boot

FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

# Copiar archivos de configuración
COPY pom.xml .
COPY src ./src

# Compilar
RUN mvn clean package -DskipTests

# Stage final
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar JAR compilado
COPY --from=builder /app/target/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Comando para ejecutar
ENTRYPOINT ["java", "-jar", "app.jar"]

