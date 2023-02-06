# 1 - Imagen necesaria para compilar Spring boot
FROM eclipse-temurin:11-jdk-alpine as build
WORKDIR /build/app

COPY mvnw .

COPY .mvn .mvn

COPY pom.xml .

COPY src src

RUN chmod +x mvnw
RUN ./mvnw install
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM eclipse-temurin:11-jre-alpine
VOLUME /temp
ARG DEPENDENCY=/build/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY --from=build /build/app/target/*.jar /usr/share/app.jar

ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.personalapicicd.PersonalApiCicdApplication"]