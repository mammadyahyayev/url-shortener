FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /url-shortener
EXPOSE 8088
ARG JAR_FILE=target/url-shortener-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]