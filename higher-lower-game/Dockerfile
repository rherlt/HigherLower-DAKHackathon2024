FROM amazoncorretto:17-alpine-jdk as build
VOLUME /tmp
COPY . .
RUN ./gradlew build

FROM amazoncorretto:17-alpine-jdk as run
ARG JAR_FILE='build/libs/*.jar'
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]