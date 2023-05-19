FROM openjdk:11
VOLUME /tmp
ADD ./target/students-0.0.1-SNAPSHOT.jar students.jar
ENTRYPOINT ["java","-jar","/students.jar"]