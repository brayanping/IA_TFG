# PLANTILLA: Memoria del Proyecto - Edu-IA

> **NOTA:** Esta es una plantilla para rellenar. Siga el índice y las normas de Nortempo Formación.
> Convertir a PDF con: LibreOffice, Google Docs, o exportar desde editor Markdown.

---

## PORTADA

**Edu-IA: Plataforma Educativa Inteligente**

Autor/a: [Tu Nombre Apellido]  
Ciclo: 2º DAM (Desarrollo de Aplicaciones Multiplataforma)  
Fecha: Mayo 2026  
Tecnologías principales: Java Spring Boot, React, Python, PostgreSQL

---

## RESUMEN (Abstract)

**[Máximo media página]**

Edu-IA es una plataforma educativa que integra inteligencia artificial para proporcionar tutorías personalizadas, análisis de documentos y chat interactivo con estudiantes. La solución permite que múltiples usuarios accedan simultáneamente sin mezclar sus datos, mediante un backend robusto en Java Spring Boot, un frontend intuitivo en React y un servicio de IA en Python que utiliza embeddings vectoriales. El proyecto demuestra competencias en desarrollo fullstack, gestión de datos concurrentes y seguridad básica.

**Palabras clave:** IA, educación, fullstack, multiusuario, REST API

---

## 1. MOTIVACIÓN E INTRODUCCIÓN

### 1.1 Motivación

¿Por qué se propone este proyecto? ¿Qué necesidad cubre?

**[Escribir aquí]**

Ejemplo:
- Estudiantes necesitan acceso a tutorías personalizadas
- Plataforma centralizada reduce fragmentación de recursos
- IA proporciona disponibilidad 24/7
- Análisis de documentos acelera aprendizaje

### 1.2 Contexto y Problema a Resolver

Qué situación había "antes" y qué aporta esta solución.

**[Escribir aquí]**

Ejemplo:
- **Antes:** Estudiantes reciben tutorías en horarios limitados
- **Problema:** Falta de personalización, esperas largas
- **Solución:** Chat con IA + análisis automático de documentos
- **Beneficio:** Acceso 24/7, respuestas personalizadas, análisis rápido

### 1.3 Objetivos Propuestos

**(1-2 generales y 4-6 específicos)**

**General:**
- Desarrollar una plataforma educativa fullstack con soporte para múltiples usuarios

**Específicos:**
1. Implementar autenticación segura con JWT
2. Crear interfaz intuitiva de chat con IA
3. Gestionar documentos y análisis automático
4. Garantizar multiusuario sin mezcla de datos
5. Implementar persistencia con base de datos relacional
6. Documentar y probar todas las funcionalidades

---

## 2. METODOLOGÍA, RECURSOS Y PLANIFICACIÓN

### 2.1 Metodología Utilizada

**[Describir enfoque de desarrollo]**

Ejemplo:
- **Metodología:** Ágil/Iterativa (sprints de 1-2 semanas)
- **Control de versiones:** Git + GitHub
- **Documentación:** Markdown + README.md

### 2.2 Estimación de Recursos

#### Hardware
- PC con mínimo 8GB RAM
- Servidor local para desarrollo
- Navegador web moderno

#### Software
- **IDE:** IntelliJ IDEA o Eclipse
- **Lenguajes:** Java 17, JavaScript (React), Python 3.9+
- **BD:** PostgreSQL o H2 (embebida)
- **Herramientas:** Maven, npm, Git, Postman, VS Code
- **APIs Externas:** [Si aplica] OpenAI, APIs educativas

### 2.3 Planificación (hitos y cronograma)

| Fase | Duración | Hitos | Estado |
|------|----------|-------|--------|
| Análisis y Diseño | 2 semanas | Diagrama UML, BD | ✅ |
| Backend | 4 semanas | APIs REST, Autenticación | ✅ |
| Frontend | 4 semanas | Interfaz, Integración | ✅ |
| IA Service | 2 semanas | Chat, Embeddings | ✅ |
| Pruebas | 1 semana | Casos de prueba, Evidencias | ✅ |
| Documentación | 1 semana | Memoria, Manuales | ⏳ |
| **TOTAL** | **14 semanas** | | |

---

## 3. TECNOLOGÍAS Y HERRAMIENTAS

### Lenguajes
- **Backend:** Java 17
- **Frontend:** JavaScript (React 19)
- **IA:** Python 3.9+

### Frameworks
- **Backend:** Spring Boot 3.2.5
- **Frontend:** React 19.2.6
- **Routing:** React Router DOM 7.15.1

### Base de Datos
- **Producción:** PostgreSQL 14+
- **Desarrollo:** H2 Database (embebida)

### Herramientas
- **IDE:** IntelliJ IDEA / Eclipse / VS Code
- **Build:** Maven (backend), npm (frontend)
- **Control versiones:** Git + GitHub
- **Testing:** JUnit 5 (backend), Jest/React Testing Library (frontend)
- **Postman:** Pruebas de API
- **Docker:** [Opcional] Containerización

### APIs Externas
- [Si aplica] OpenAI API / Hugging Face
- Base de datos vectorial: Chroma DB

---

## 4. ANÁLISIS

### 4.1 Definición de Requisitos

#### Requisitos Funcionales
1. **Autenticación:** Login/registro con validación de email
2. **Chat:** Envío de mensajes y respuestas de IA
3. **Documentos:** Upload, listado, eliminación
4. **Multiusuario:** Sesiones independientes por usuario
5. **Búsqueda:** Filtrado en chat y documentos
6. **Estadísticas:** Resumen de actividad del usuario

#### Requisitos No Funcionales
1. **Rendimiento:** Respuesta < 2 segundos
2. **Disponibilidad:** 24/7
3. **Seguridad:** Contraseñas hasheadas, CORS configurado
4. **Escalabilidad:** Soporte para 100+ usuarios simultáneos
5. **Usabilidad:** Interfaz intuitiva (sin training requerido)

### 4.2 Modelo de Datos

#### Diagrama Entidad-Relación

```
[USUARIO]
  ├─ id (PK)
  ├─ email (UNIQUE)
  ├─ password (encrypted)
  ├─ nombre
  ├─ fechaRegistro
  └─ activo

[DOCUMENTO]
  ├─ id (PK)
  ├─ usuarioId (FK → USUARIO)
  ├─ nombreArchivo
  ├─ titulo
  ├─ rutaArchivo
  ├─ tamaño
  └─ fechaSubida

[MENSAJE]
  ├─ id (PK)
  ├─ usuarioId (FK → USUARIO)
  ├─ contenido
  ├─ respuesto (string - IA)
  ├─ documentoId (FK → DOCUMENTO, nullable)
  └─ fecha
```

#### Justificación de la BD Elegida

**[Escribir 8-12 líneas]**

Ejemplo:
> Se ha elegido PostgreSQL para la versión de producción por su robustez, soporte ACID completo, excelente rendimiento con índices, y capacidad de manejo de concurrencia. Para desarrollo, se utiliza H2 (embebida) para facilitar pruebas sin instalación. Esta combinación permite desarrollo ágil sin sacrificar confiabilidad en producción. Las relaciones entre usuarios, documentos y mensajes requieren integridad referencial, que PostgreSQL garantiza. Las consultas complejas (filtrados, búsquedas) se optimizan mejor en SQL relacional que en documental. H2 es compatible con Spring Boot sin configuración adicional.

---

## 5. DISEÑO

### 5.1 Diseño General / Arquitectura

```
┌─────────────────────────────────────────────────────────┐
│                    CLIENTE (React)                       │
│  [Login] [Chat] [Documentos] [Perfil]                   │
└──────────────────────┬──────────────────────────────────┘
                       │ HTTP/REST
┌──────────────────────▼──────────────────────────────────┐
│              BACKEND (Spring Boot)                       │
│  ┌──────────┬───────────┬──────────┬──────────┐         │
│  │Controllers│ Services │Repos     │Security  │         │
│  └──────────┴───────────┴──────────┴──────────┘         │
└──────────────────────┬──────────────────────────────────┘
                       │ JDBC
         ┌─────────────┼─────────────┐
         │             │             │
    ┌────▼──┐  ┌──────▼─────┐  ┌───▼─────┐
    │ USUARIOS│ │ DOCUMENTOS│  │ MENSAJES│
    └────────┘  └────────────┘  └─────────┘
              [PostgreSQL BD]

    Servicio IA (Python)
    [Chroma DB + Embeddings]
```

**Descripción de bloques:**
- **Cliente React:** Interfaz web responsiva
- **Controladores:** Endpoints REST de Spring
- **Servicios:** Lógica de negocio
- **Repositorios:** Acceso a datos (JPA)
- **Base de Datos:** PostgreSQL para persistencia
- **IA Service:** Python para procesamiento de IA

### 5.2 Diagrama de Clases (UML) — OBLIGATORIO

**[Incluir diagrama legible con clases principales y relaciones]**

```
┌──────────────────┐
│ <<Entity>>       │
│ Usuario          │
├──────────────────┤
│ - id: Long       │
│ - email: String  │
│ - password: String
│ - nombre: String │
├──────────────────┤
│ + login()        │
│ + logout()       │
│ + getPerfil()    │
└──────────────────┘
        △
        │ 1..*
        │ crea
        │
┌──────────────────┐       ┌──────────────────┐
│ <<Entity>>       │       │ <<Entity>>       │
│ Mensaje          │◄──────┤ Documento        │
├──────────────────┤  usa  ├──────────────────┤
│ - id: Long       │       │ - id: Long       │
│ - contenido      │       │ - nombreArch     │
│ - respuesta      │       │ - rutaArchivo    │
│ - fecha          │       │ - tamaño         │
└──────────────────┘       └──────────────────┘
```

### 5.3 Mockups / Capturas de Interfaz

**[Incluir 2-6 capturas o mockups]**

#### Mapa de Pantallas
```
Login
  ├─ Registro
  └─→ Dashboard
        ├─ Chat
        ├─ Documentos
        └─ Perfil
```

#### Capturas (insertar imágenes aquí)
- Captura 1: Página de Login
- Captura 2: Panel de Chat
- Captura 3: Gestión de Documentos
- Captura 4: Perfil de Usuario

### 5.4 Decisiones de Diseño Importantes

1. **JWT para autenticación:** Elegido por su seguridad y compatibilidad con REST stateless

2. **React con hooks:** Permite componentes funcionales reutilizables y estado global con Context

3. **Separación de capas (MVC):** Facilita mantenimiento y testing

4. **Chroma DB para vectores:** Integración sencilla con Python, sin overhead de MongoDB

---

## 6. IMPLEMENTACIÓN

### 6.1 Estructura del Proyecto

**Backend (Spring Boot):**
```
edu-ia-backend/
├── src/main/java/com/dam/eduia/
│   ├── controller/          # Endpoints REST
│   ├── service/             # Lógica de negocio
│   ├── repository/          # JPA Repositories
│   ├── model/               # Entidades @Entity
│   ├── dto/                 # DTOs (Data Transfer)
│   ├── config/              # Configuración (CORS, etc)
│   └── security/            # JWT, autenticación
├── src/main/resources/
│   ├── application.properties
│   └── data.sql            # Datos iniciales
└── pom.xml
```

**Frontend (React):**
```
edu-ia-frontend/
├── src/
│   ├── pages/              # Páginas principales
│   ├── components/         # Componentes reutilizables
│   ├── api/                # Llamadas a API
│   ├── App.js              # Componente raíz
│   └── index.js            # Punto de entrada
├── public/                 # HTML estático
└── package.json
```

### 6.2 Componentes Principales

#### 1. **Autenticación (AuthService)**
- Maneja login/registro
- Genera y valida tokens JWT
- Almacena sesiones

#### 2. **Chat (ChatService)**
- Envía mensajes a IA
- Almacena en BD
- Realiza búsquedas complejas

#### 3. **Documentos (DocumentService)**
- Upload/descarga de archivos
- Validación de tamaño y tipo
- Almacenamiento en servidor

#### 4. **IA Service (Python)**
- Procesa embeddings
- Responde consultas
- Integra Chroma DB

#### 5. **Frontend (React Components)**
- Login component
- Chat component
- Documents component
- Profile component

#### 6. **Seguridad**
- JWT tokens
- CORS configurado
- Password hashing (BCrypt)

### 6.3 Dificultades Encontradas y Soluciones

**Problema 1:** CORS error entre frontend y backend
- **Solución:** Configurar CorsConfig en Spring permitiendo origen localhost:3000

**Problema 2:** Tokens JWT expiraban demasiado rápido
- **Solución:** Aumentar expiración a 24 horas en configuración

**Problema 3:** Servicio IA no respondía en tiempo
- **Solución:** Implementar timeout y reintentos en WebClient

---

## 7. MULTIUSUARIO CONCURRENTE (OBLIGATORIO)

### Identificación de Usuarios

- **Método:** Login + JWT Token
- **Token:** Se genera en `/auth/login`
- **Validación:** Header `Authorization: Bearer {token}`
- **Expiración:** 24 horas

### Demostración de 2 Usuarios Simultáneos

**Escenario:**
1. Usuario A abre Chrome e inicia sesión: token_A
2. Usuario B abre Firefox e inicia sesión: token_B
3. Usuario A envía mensaje: "Hola"
4. Usuario B intenta ver chat de A: error 403 (forbidden)

**Evidencia (captura de pantallas):**
[Insertar captura 1: Chrome con Usuario A]
[Insertar captura 2: Firefox con Usuario B]
[Insertar captura 3: Chats independientes]

### Fallos de Comunicación

- **Error 500:** Reintento automático (máx 3 intentos)
- **Timeout:** Mensaje "Servicio no disponible"
- **Desconexión:** Sesión se mantiene por 5 minutos
- **Reconexión:** Automática al recuperar conexión

**Log de ejemplo:**
```
[ERROR] 2026-05-28 10:30:45 - Usuario A: Error de conexión
[RETRY] 2026-05-28 10:30:46 - Reintentando...
[SUCCESS] 2026-05-28 10:30:47 - Conexión restaurada
```

---

## 8. DESPLIEGUE E INSTALACIÓN

### 8.1 Manual de Instalación

#### Requisitos
- Java 17+
- Maven 3.8+
- Node.js 18+
- PostgreSQL 14+ (producción)
- Python 3.9+ (IA service)

#### Pasos

**1. Backend:**
```bash
cd edu-ia-backend
mvn clean install
mvn spring-boot:run
# Backend disponible en http://localhost:8080
```

**2. Frontend:**
```bash
cd edu-ia-frontend
npm install
npm start
# Frontend abierto en http://localhost:3000
```

**3. Servicio IA:**
```bash
cd edu-ia-service
pip install -r requirements.txt
python main.py
# IA disponible en http://localhost:8000
```

### 8.2 Configuración

**Archivo: `src/main/resources/application.properties`**
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
server.port=8080
server.servlet.context-path=/api

# JWT
jwt.secret=tu_clave_secreta_aqui
jwt.expiration=86400000  # 24 horas
```

### 8.3 Datos de Ejemplo

**Script: `src/main/resources/data.sql`**
```sql
INSERT INTO usuario VALUES (1, 'estudiante1@example.com', '$2a$10$...', 'Juan Pérez');
INSERT INTO usuario VALUES (2, 'docente1@example.com', '$2a$10$...', 'María García');
```

**Ejecutar automáticamente:**
- Spring carga `data.sql` en cada arranque (configurado)
- O importar manualmente desde cliente API

### 8.4 Manual de Usuario

Ver documento separado: `MANUAL_USUARIO.md`

---

## 9. PRUEBAS

### 9.1 Plan de Pruebas

**Objetivo:** Validar que todas las funcionalidades operan correctamente

**Áreas probadas:**
- ✅ Autenticación (6 casos)
- ✅ Chat (3 casos)
- ✅ Documentos (6 casos)
- ✅ Multiusuario (3 casos)
- ✅ Persistencia (2 casos)
- ✅ Salida información (2 casos)

**Total: 22 casos de prueba**

### 9.2 Tabla de Casos de Prueba (mínimo 8) + Evidencias

| ID | Caso | Pasos | Resultado | Evidencia | Estado |
|----|------|-------|-----------|-----------|--------|
| CT-001 | Login válido | 1. Email<br>2. Password<br>3. Enviar | Acceso a dashboard | [Captura] | ✅ |
| CT-004 | Login inválido | 1. Datos falsos<br>2. Enviar | Error 401 | [Captura] | ✅ |
| CT-007 | Enviar mensaje | 1. "Hola"<br>2. Enviar | Respuesta IA | [Captura] | ✅ |
| CT-010 | Subir documento | 1. PDF<br>2. Upload | Guardado | [Captura] | ✅ |
| CT-016 | 2 usuarios | 1. User A login<br>2. User B login | Independencia | [2 Capturas] | ✅ |
| CT-019 | Persistencia | 1. Crear<br>2. Cerrar<br>3. Reabrir | Datos permanecen | [Captura] | ✅ |
| CT-020 | Filtro documentos | 1. Filtrar<br>2. Buscar | Resultados correctos | [Captura] | ✅ |
| CT-021 | Ver estadísticas | 1. Perfil | Muestra totales | [Captura] | ✅ |

**Ubicación de evidencias:** `/docs/evidencias/`

---

## 10. RESULTADOS, CONCLUSIONES Y VÍAS FUTURAS

### 10.1 Objetivos Alcanzados

| Objetivo | Cumplido | Observación |
|----------|----------|------------|
| 1. Autenticación segura | ✅ SÍ | Implementado con JWT |
| 2. Chat con IA | ✅ SÍ | Funcional, respuestas en < 2s |
| 3. Gestión documentos | ✅ SÍ | Upload, listado, eliminación |
| 4. Multiusuario | ✅ SÍ | Probado con 2+ usuarios simultáneamente |
| 5. Persistencia | ✅ SÍ | Base de datos relacional funcional |
| 6. Documentación | ✅ SÍ | Memoria, manuales, código comentado |

**Resultado:** **100% de objetivos cumplidos**

### 10.2 Conclusiones

**[Escribir aquí]**

Este proyecto ha demostrado ser una solución educativa viable que integra múltiples tecnologías (backend Java, frontend React, IA en Python) en un sistema coherente y funcional. La implementación de multiusuario con aislamiento de datos, persistencia en base de datos relacional, y seguridad básica (JWT, BCrypt) cumple con todos los requisitos técnicos establecidos. 

El desarrollo iterativo permitió identificar y resolver problemas de CORS, timeouts, y concurrencia. La documentación exhaustiva facilita tanto el mantenimiento como la evaluación. El proyecto sienta las bases para una plataforma educativa escalable.

### 10.3 Vías Futuras / Mejoras

1. **Autenticación OAuth2** con Google/Microsoft
2. **Videoconferencias** integradas (Jitsi, Zoom API)
3. **Notificaciones en tiempo real** con WebSockets
4. **Análisis de sentimiento** en chat
5. **Gamificación** con puntos y badges
6. **Exportar estadísticas** a PDF/Excel

---

## 11. Glosario (opcional)

- **JWT:** JSON Web Token - Token de autenticación stateless
- **API REST:** Interfaz de programación basada en HTTP
- **CORS:** Cross-Origin Resource Sharing - Política de seguridad web
- **Embedding:** Representación vectorial de texto/documento
- **Chroma DB:** Base de datos vectorial para búsquedas semánticas
- **BCrypt:** Algoritmo de hash de contraseñas
- **DAO:** Data Access Object - Patrón de acceso a datos

---

## 12. Bibliografía / Webgrafía

### Documentación Oficial
- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [React Documentation](https://react.dev)
- [PostgreSQL Docs](https://www.postgresql.org/docs/)
- [Python Docs](https://docs.python.org/3/)

### APIs y Librerías
- Chroma: https://www.trychroma.com/
- Axios: https://axios-http.com/
- Spring Security: https://spring.io/projects/spring-security

### Tutoriales
- [Spring Boot REST API](https://www.baeldung.com/)
- [React Hooks Guide](https://react.dev/reference/react)
- [JWT en Spring Boot](https://www.toptal.com/spring-boot/spring-boot-jwt)

### Normas del Proyecto
- Nortempo Formación - 2º DAM Curso 2025/26
- Requisitos Proyecto Intermodular

---

**FIN DE LA MEMORIA**

---

> **INSTRUCCIONES PARA CONVERTIR A PDF:**
> 1. Copiar este contenido Markdown
> 2. Usar Google Docs o LibreOffice Writer
> 3. Aplicar formato (Calibri, tamaño 11, márgenes 2.5cm)
> 4. Exportar a PDF como `Memoria_ApellidoNombre.pdf`
> 5. Guardar en carpeta `/docs/`

