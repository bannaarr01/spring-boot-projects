FROM maven:3.6.3-openjdk-11-slim as BUILD_STAGE
#THIS DOCKERFILE WILL ONLY OUTPUT BUILD JAR FILE
# WHICH WILL ONLY NEEDS JRE TO RUN (VERY LIGHTWEIGHT)
ARG VERSION=0.0.1-SNAPSHOT
#ARG VERSION=2.7.1-SNAPSHOT

WORKDIR /build/

COPY pom.xml /build/

COPY src /build/src/

RUN mvn clean package

#that's the pattern 'that maven based spring boot  \
#artifacts build in, copy back to same loc n rename to application.jar
COPY target/booting-web-${VERSION}.jar target/application.jar

FROM openjdk:11.0.8-jre-slim
WORKDIR /app/

COPY --from=BUILD_STAGE /build/target/application.jar /app/
CMD java -jar /app/application.jar

#CMD ls target/*.jar I USED THIS TO FIND THE JAR FILE