# 

# 📚 Documentación del Proyecto Corral

## 🌟 Descripción del Proyecto

El proyecto **Corral** es una aplicación web diseñada para gestionar información sobre corrales y animales. Utiliza **Spring Boot** para el backend y **Angular 14** para el frontend, ofreciendo una interfaz amigable y funcional para los usuarios.

## 🛠️ Requisitos Previos

Asegúrate de tener instalado lo siguiente en tu máquina local:

- **Node.js** (versión 14 o superior)
- **Angular CLI** (versión 14 o superior)
- **Java JDK** (versión 11 o superior)
- **Maven** (opcional, para construir el backend)
- **Docker** (opcional, para despliegue del backend)

## 🚀 Despliegue

### 🌐 Frontend

El frontend está desplegado en Vercel y está accesible en el siguiente enlace:

- [Frontend en Vercel](https://vercel.com/marulanda921s-projects/frontcorral)

### 🌐 Backend

El backend está desplegado en Render y se puede acceder mediante:

- [Backend en Render](https://corralproyect-latest.onrender.com/)

## 🥇 Repositorios de GitHub

Accede al código fuente de ambos componentes en los siguientes enlaces:

- [Frontend en GitHub](https://github.com/Marulanda921/ApplicationCorralFront)
- [Backend en GitHub](https://github.com/Marulanda921/ApplicationCorralBack)

## 📄 Swagger UI

Para acceder a la documentación de la API generada con Swagger, dirígete a:

- [Swagger UI](http://localhost:9001/swagger-ui/index.html#/)

En Swagger UI, podrás ver todos los endpoints disponibles, realizar pruebas y consultar los detalles de cada uno.

## 🛠️ Despliegue Local

### Backend (Spring Boot)

1. **Clona el repositorio del backend:**
    
    ```bash
    
    git clone https://github.com/Marulanda921/ApplicationCorralBack.git
    cd ApplicationCorralBack
    
    ```
    
2. **Construye y ejecuta la aplicación con Maven (si no usas Docker):**
    
    ```bash
    mvn spring-boot:run
    ```
    
    O ejecuta el archivo JAR:
    
    ```bash
    mvn clean package
    java -jar target/tu-archivo.jar
    ```
    

### Frontend (Angular)

1. **Clona el repositorio del frontend:**
    
    ```bash
    git clone https://github.com/Marulanda921/ApplicationCorralFront.git
    cd ApplicationCorralFront
    ```
    
2. **Instala las dependencias:**
    
    ```bash
    npm install
    ```
    
3. **Ejecuta la aplicación:**
    
    ```bash
    ng serve --port 9001
    ```
    
    Accede a la aplicación en tu navegador en `http://localhost:9001`.
    

### 🐳 Despliegue con Docker

Para ejecutar el backend usando Docker, utiliza el siguiente comando:

```bash
docker pull achner/corralproyect:latest
docker run -p 9001:9001 achner/corralproyect:latest
```

Esto ejecutará el backend en el puerto 9001 de tu máquina local.

## 📞 Conclusión

El proyecto Corral ofrece una solución integral para la gestión de corrales y animales. Para cualquier consulta o sugerencia, no dudes en ponerte en contacto.
