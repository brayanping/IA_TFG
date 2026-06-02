# Edu-IA Backend

## Descripción del Proyecto

**Edu-IA** es una plataforma educativa inteligente que integra IA para proporcionar tutorías personalizadas, análisis de documentos y chat interactivo con estudiantes.

### Funcionalidades principales
- **Autenticación y gestión de usuarios** con sesiones seguras
- **Chat educativo** impulsado por IA (Python + Chroma DB)
- **Gestión de documentos** para análisis y consulta
- **Soporte multiusuario concurrente** con sincronización de sesiones
- **API REST** completa para integración con frontend

---

## Requisitos Previos

### Software necesario
- **Java 17+** (JDK)
- **Maven 3.8+**
- **Python 3.9+** (para servicio de IA)
- **Base de datos**: H2 (embebida) o PostgreSQL (producción)
- **Node.js 18+** (solo si necesitas ejecutar el frontend simultáneamente)

### Herramientas recomendadas
- IDE: IntelliJ IDEA, Eclipse o VS Code
- Cliente HTTP: Postman, Insomnia o Thunder Client
- Control de versiones: Git

---

## Instalación y Arranque

### 1. Clonar y configurar el proyecto

```bash
cd c:\Users\BRAYAN\eclipse-workspace\edu-ia-backend
```

### 2. Instalar dependencias

```bash
mvn clean install
```

### 3. Configurar variables de entorno (opcional)

Crear archivo `.env` en la raíz del proyecto (o usar `application.properties`):

```properties
# Base de datos
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Servidor
server.port=8080
server.servlet.context-path=/api

# Servicio IA
ia.service.url=http://localhost:8000
```

### 4. Ejecutar el servidor

```bash
mvn spring-boot:run
```

El servidor estará disponible en: **http://localhost:8080/api**

---

## Datos de Ejemplo

### Cargar datos iniciales

1. **Mediante script SQL** (en `src/main/resources/data.sql`):
   - Se ejecuta automáticamente al iniciar si está configurado

2. **Mediante API REST** después del arranque:

```bash
# Crear usuario de prueba
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "estudiante1",
    "email": "estudiante1@example.com",
    "password": "password123"
  }'

# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "estudiante1",
    "password": "password123"
  }'
```

### Servicio de IA (Python)

```bash
cd edu-ia-service
pip install -r requirements.txt
python main.py
```

El servicio se ejecutará en **http://localhost:8000**

---

## Arquitectura

```
Backend REST (Spring Boot - Puerto 8080)
        ↓
   [Controladores]
        ↓
   [Servicios]
        ↓
   [Repositorios - JPA]
        ↓
   [Base de Datos H2/PostgreSQL]

Comunicación con Servicio IA:
Backend → [WebClient/RestTemplate] → Servicio Python (Puerto 8000)
                                    ↓
                                [Chroma DB - Vectores]
```

---

## Estructura del Proyecto

```
edu-ia-backend/
├── src/main/java/com/dam/eduia/
│   ├── controller/       # Controladores REST
│   ├── service/          # Lógica de negocio
│   ├── repository/       # Acceso a datos (JPA)
│   ├── model/            # Entidades JPA
│   ├── dto/              # Objetos de transferencia
│   ├── config/           # Configuración (CORS, Security)
│   └── security/         # JWT, autenticación
├── src/main/resources/
│   ├── application.properties
│   └── data.sql          # Datos iniciales
├── edu-ia-service/       # Servicio IA en Python
│   ├── main.py
│   ├── config.py
│   ├── gestor_ia.py
│   ├── routers/
│   └── chroma_db/        # Base de datos vectorial
├── pom.xml               # Dependencias Maven
└── docs/                 # Documentación del proyecto
```

---

## Multiusuario Concurrente

### Autenticación
- **Login**: Genera token JWT válido por 24 horas
- **Sesiones**: Cada usuario tiene sesión independiente
- **Token**: Se envía en header `Authorization: Bearer <token>`

### Prueba de 2 usuarios simultáneos

**Terminal 1 - Usuario 1:**
```bash
curl -X GET http://localhost:8080/api/chat \
  -H "Authorization: Bearer TOKEN_USER1"
```

**Terminal 2 - Usuario 2:**
```bash
curl -X GET http://localhost:8080/api/chat \
  -H "Authorization: Bearer TOKEN_USER2"
```

Cada usuario verá solo su historial de chat (datos aislados).

---

## Configuración Avanzada

### Cambiar base de datos a PostgreSQL

En `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/eduia_db
spring.datasource.username=postgres
spring.datasource.password=tu_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL10Dialect
```

### CORS (comunicación con frontend)

En `config/CorsConfig.java`:

```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true);
    }
}
```

---

## Endpoints Principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/auth/register` | Registrar nuevo usuario |
| POST | `/auth/login` | Login y obtener token JWT |
| GET | `/chat` | Obtener historial de chat del usuario |
| POST | `/chat/send` | Enviar mensaje al IA |
| POST | `/documentos/upload` | Subir documento |
| GET | `/documentos` | Listar documentos del usuario |
| DELETE | `/documentos/{id}` | Eliminar documento |

---

## Pruebas

### Ejecutar tests unitarios

```bash
mvn test
```

### Casos de prueba importantes

1. **Autenticación**: Login/logout correcto
2. **Multiusuario**: Datos aislados por usuario
3. **Chat**: Enviar mensaje y recibir respuesta del IA
4. **Documentos**: Upload, listado, eliminación
5. **Persistencia**: Datos se guardan en BD

---

## Seguridad

⚠️ **Importante:**
- ✅ Contraseñas se hashean con BCrypt
- ✅ Tokens JWT con expiración
- ✅ CORS configurado para origen específico
- ✅ No se almacenan datos personales reales en desarrollo
- ✅ Credenciales en variables de entorno (no en código)

---

## Solución de Problemas

| Problema | Solución |
|----------|----------|
| Puerto 8080 en uso | Cambiar en `application.properties`: `server.port=8081` |
| No conecta con BD H2 | Verificar ruta y permisos |
| Servicio IA no responde | Asegurar Python service en puerto 8000 |
| CORS error | Verificar origen en `CorsConfig.java` |

---

## Documentación Adicional

- Memoria completa: `/docs/Memoria_ProyectoEduIA.pdf`
- Diagrama de clases: `/docs/diagrama_clases.png`
- Manual de usuario: `/docs/MANUAL_USUARIO.md`

---

## Contribución

1. Crear rama: `git checkout -b feature/mi-feature`
2. Commit: `git commit -am 'Añadir feature'`
3. Push: `git push origin feature/mi-feature`
4. Pull Request

---

## Licencia

Este proyecto es para fines educativos. Ciclo 2º DAM - Nortempo Formación.

---

## Contacto

Para preguntas técnicas o issues, consultar la documentación en `/docs/`.

