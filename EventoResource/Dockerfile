FROM gradle:jdk8 as builder
ENV APP_HOME=/usr/app/

USER root

WORKDIR $APP_HOME

COPY . $APP_HOME

RUN chown -R gradle  $APP_HOME

USER gradle

RUN ./gradlew build --stacktrace


FROM openjdk:8-jre-slim
ENV ARTIFACT_NAME=evento-resource-0.1.0.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=builder $APP_HOME/build/libs/$ARTIFACT_NAME ./app.jar

EXPOSE 8080

CMD [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /usr/app/app.jar"]