# Usar una imagen base de OpenJDK
FROM amazoncorretto:21

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/BackendApp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9001

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
