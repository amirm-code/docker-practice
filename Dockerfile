# ── STAGE 1 : BUILD ──────────────────────
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

COPY . .
RUN ./mvnw clean package -DskipTests

# ── STAGE 2 : RUN ─────────────────────────
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Seul le jar est copié — image finale légère
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]