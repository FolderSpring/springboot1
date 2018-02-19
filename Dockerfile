FROM openjdk:8
ADD springboot.war springboot.war
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "springboot.war"]