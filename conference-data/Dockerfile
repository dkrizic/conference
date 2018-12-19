FROM neo4j:3.5.0

ENTRYPOINT ["sh", "-c", "/usr/bin/java --add-modules java.se.ee $JAVA_OPTIONS -jar /usr/share/app.jar"]
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/app.jar
