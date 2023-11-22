FROM eclipse-temurin

COPY /build/libs/recursoshumanos-0.0.1-SNAPSHOT.jar .

CMD ["java","-jar","recursoshumanos-0.0.1-SNAPSHOT.jar"]