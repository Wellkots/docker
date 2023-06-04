FROM openjdk:18
ADD /target/*.jar PP_3.1.1-0.0.1-SNAPSHOT
ENTRYPOINT ["java", "-jar", "PP_3.1.1-0.0.1-SNAPSHOT"]
