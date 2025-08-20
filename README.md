📋 Documentación del Proyecto API de Tareas Multiusuario
[IMPORTANT]
Esta API REST desarrollada con Spring Boot permite gestionar usuarios y sus listas de tareas (TO-DO list) de forma sencilla y segura. Incluye documentación interactiva con Swagger para facilitar el desarrollo y las pruebas.

🚀 Características principales
Gestión de usuarios:
Crear, consultar, actualizar y eliminar usuarios.

Gestión de tareas:
Crear, consultar, actualizar, completar y eliminar tareas asociadas a cada usuario.

Validaciones:
Evita operaciones sobre entidades inexistentes.

Documentación automática:
Swagger UI para probar y explorar la API.

⚙️ Configuración
Base de datos:
Configura la conexión a PostgreSQL en application.properties usando variables de entorno para mayor seguridad:
```
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8081
```

Dependencias:
Instala las dependencias con Maven.
Incluye Swagger en tu pom.xml:
```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

Ejecución:
Inicia la aplicación con:
```
mvn spring-boot:run
```

La API estará disponible en http://localhost:8081.

Documentación Swagger:
Accede a la documentación interactiva en:
http://localhost:8081/swagger-ui.html
o
http://localhost:8081/swagger-ui/index.html

🧑‍💻 Ejemplos de uso
➕ Crear usuario
````markdown
POST /usuarios
Content-Type: application/json

{
  "nombre": "Juan"
}
````
📋 Listar usuarios
````markdown
GET /usuarios
````

➕ Crear tarea para usuario
````markdown
POST /usuarios/1/tareas
Content-Type: application/json

{
  "descripcion": "Comprar pan",
  "completada": false
}
````

📋 Listar tareas de usuario
````markdown
GET /usuarios/1/tareas
````
✅ Marcar tarea como completada
````markdown
PUT /usuarios/1/tareas/1/completar
````

✏️ Actualizar usuario
````markdown
PUT /usuarios/1
Content-Type: application/json

{
  "nombre": "Juan Pérez"
}
````

✏️ Actualizar tarea
````markdown
PUT /usuarios/1/tareas/1
Content-Type: application/json

{
  "descripcion": "Comprar leche",
  "completada": true
}
````
🗑️ Eliminar usuario
````markdown
DELETE /usuarios/1
````

🗑️ Eliminar tarea
````markdown
DELETE /usuarios/1/tareas/1
````

[TIP]
Utiliza Swagger UI para probar todos los endpoints de forma interactiva y visualizar la documentación generada automáticamente.