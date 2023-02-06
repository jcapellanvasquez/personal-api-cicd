# 1 - Imagen necesaria para compilar Spring boot
FROM eclipse-temurin:11-alpine as build
WORKDIR /build/app

COPY mvnw .

COPY .mvn .mvn

COPY pom.xml .

COPY src src

RUN ./mvnw clean install
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM eclipse-temurin:11-alpine
VOLUME /temp
ARG DEPENDENCY=/build/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY --from=build /build/app/target/personal-api-cicd-0.0.1.jar /usr/share/app.jar

ENTRYPOINT ["java","-cp","app:app/lib/*","PersonalApiCicd.Application"]