Documentación del Proyecto API de Tareas Multiusuario
Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar una lista de tareas (TO-DO list) para múltiples usuarios. Cada usuario puede tener varias tareas asociadas, y la API permite crear, consultar, actualizar y eliminar tanto usuarios como tareas. Además, incluye documentación interactiva con Swagger para facilitar el desarrollo y las pruebas.

Características principales
Gestión de usuarios: crear, consultar, actualizar y eliminar.
Gestión de tareas: crear, consultar, actualizar, completar y eliminar tareas asociadas a cada usuario.
Validaciones para evitar operaciones sobre entidades inexistentes.
Documentación automática con Swagger.
Configuración
Base de datos:
Configura la conexión a PostgreSQL en el archivo application.properties usando variables de entorno para mayor seguridad:

Dependencias:
Instala las dependencias con Maven. Asegúrate de incluir la dependencia de Swagger en el pom.xml:

Ejecución:
Inicia la aplicación con:

La API estará disponible en http://localhost:8081.

Documentación Swagger:
Accede a la documentación interactiva en:

o

Uso
Utiliza herramientas como Postman, curl o la interfaz Swagger para interactuar con los endpoints REST y gestionar usuarios y tareas de manera sencilla.