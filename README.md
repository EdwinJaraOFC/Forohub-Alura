# 🗨️ Forohub - API REST para Foros

**Forohub** es una **API REST** construida con **Java y Spring Boot** diseñada para gestionar un sistema de foros. Este proyecto fue desarrollado como parte del desafío **Alura Challenge - Oracle Next Education**, enfocado en la creación de aplicaciones backend sólidas y con una arquitectura limpia.

## 🚀 Funcionalidades Principales

-   **Gestión de Usuarios**: Permite el registro de nuevos usuarios con validaciones de datos, encriptación de contraseñas y prevención de duplicados por email.
-   **Gestión de Tópicos**: Facilita la creación, listado, búsqueda, actualización y eliminación de tópicos. Incluye funcionalidades como el listado de los 10 tópicos más recientes y filtrado por curso y año.
-   **Gestión de Respuestas**: Permite crear, listar y eliminar respuestas asociadas a tópicos y usuarios, con paginación para una mejor experiencia.

## 🛠️ Tecnologías Utilizadas

-   **Java 17+**
-   **Spring Boot**: Framework principal para el desarrollo de la API.
-   **Spring Data JPA**: Para la persistencia de datos.
-   **Spring Security**: Para la encriptación de contraseñas.
-   **Hibernate**: Implementación de JPA.
-   **Jakarta Validation**: Para la validación de datos en la entrada.
-   **Lombok**: Para reducir el código repetitivo (getters, setters, etc.).
-   **Base de datos**: Soporte para MySQL, PostgreSQL, o H2 para desarrollo.

## 📂 Estructura del Proyecto
```
src/
└── com.forohub
├── controller    # Lógica de la API REST
├── domain        # Entidades y DTOs
│   ├── topico
│   ├── usuario
│   └── respuesta
├── repository    # Interfaces JPA para acceso a datos
└── ForohubApplication.java
```

## ⚙️ Configuración y Ejecución

Sigue estos pasos para poner en marcha el proyecto:

1.  **Clona el repositorio:**

```
    bash
    git clone [https://github.com/tu-usuario/forohub.git](https://github.com/tu-usuario/forohub.git)
    cd forohub
```

2.  **Configura la base de datos:**
    Abre el archivo `src/main/resources/application.properties` y configura la conexión a tu base de datos. Ejemplo para MySQL:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forohub
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Compila y ejecuta la aplicación:**

    ```bash
    mvn spring-boot:run
    ```

## 🔑 Endpoints de la API

| Categoría | Método | Endpoint                                    | Descripción                                  |
| :-------- | :----- | :------------------------------------------ | :------------------------------------------- |
| Usuarios  | `POST` | `/register`                                 | Registra un nuevo usuario                    |
| Tópicos   | `POST` | `/topicos`                                  | Crea un nuevo tópico                         |
|           | `GET`  | `/topicos`                                  | Lista todos los tópicos                      |
|           | `GET`  | `/topicos/ultimos-10`                       | Lista los 10 tópicos más recientes            |
|           | `GET`  | `/topicos/buscar`                           | Busca por `curso` y `año` (`/buscar?curso=...&anio=...`) |
|           | `GET`  | `/topicos/{id}`                             | Obtiene los detalles de un tópico por su ID  |
|           | `PUT`  | `/topicos/{id}`                             | Actualiza un tópico existente                |
|           | `DELETE`|`/topicos/{id}`                             | Elimina un tópico                            |
| Respuestas| `POST` | `/respuestas`                               | Crea una nueva respuesta                     |
|           | `GET`  | `/respuestas`                               | Lista las respuestas (paginadas)             |
|           | `DELETE`|`/respuestas/{id}`                          | Elimina una respuesta por su ID              |

---

## ✨ Posibles Mejoras Futuras

-   Implementar autenticación y autorización completa con **JWT**.
-   Añadir documentación interactiva de la API con **Swagger/OpenAPI**.
-   Implementar un sistema de votos y reacciones para tópicos y respuestas.
-   Optimizar las búsquedas con filtros más flexibles (por texto, tags, etc.).

---

## 📚 Créditos y Licencia

Este proyecto fue desarrollado por **Edwin Junior** como parte del programa **Oracle + Alura LATAM**.

Este proyecto es de código abierto y puede ser adaptado libremente con fines educativos.