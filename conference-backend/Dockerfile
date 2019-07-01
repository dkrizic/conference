FROM openjdk:11-slim

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTIONS -jar /usr/share/app.jar"]
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/app.jar
