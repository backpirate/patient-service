From openjdk:8
copy target/PatientService-0.0.1-SNAPSHOT.jar PatientService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","PatientService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8096
