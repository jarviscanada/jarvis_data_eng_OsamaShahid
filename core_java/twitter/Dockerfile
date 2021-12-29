FROM openjdk:8-alpine
COPY target/java_apps*.jar /usr/local/app/twitter/lib/twitter_app.jar
ENTRYPOINT ["java", "-jar", "/usr/local/app/twitter/lib/twitter_app.jar"]
