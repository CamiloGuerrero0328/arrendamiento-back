FROM openjdk:8
VOLUME /tmp
EXPOSE 9090
COPY arrendamiento-1.0.0.jar /arrendamiento-1.0.0.jar
ENTRYPOINT ["java","-jar","arrendamiento-1.0.0.jar"]