FROM openjdk:11

ENTRYPOINT ["sh", "-c", "/usr/bin/java $JAVA_OPTIONS -jar /usr/share/app.jar"]
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/app.jar
