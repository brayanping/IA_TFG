# API Endpoints - Edu-IA Backend

## Autenticación

### Registrar nuevo usuario
```
POST /auth/register
Content-Type: application/json

{
  "email": "usuario@example.com",
  "password": "password123",
  "nombre": "Juan Pérez"
}

Response: 201 Created
{
  "id": 1,
  "email": "usuario@example.com",
  "nombre": "Juan Pérez",
  "fechaRegistro": "2026-05-28"
}
```

### Iniciar sesión
```
POST /auth/login
Content-Type: application/json

{
  "email": "usuario@example.com",
  "password": "password123"
}

Response: 200 OK
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "usuario": {
    "id": 1,
    "email": "usuario@example.com",
    "nombre": "Juan Pérez"
  }
}
```

### Validar token
```
GET /auth/validate
Authorization: Bearer {token}

Response: 200 OK
{
  "valido": true,
  "usuario": { ... }
}
```

---

## Chat / Mensajes

### Obtener historial de chat
```
GET /chat
Authorization: Bearer {token}

Response: 200 OK
[
  {
    "id": 1,
    "usuario": "usuario@example.com",
    "mensaje": "¿Cuál es la fórmula de la relatividad?",
    "respuesta": "E=mc² es la ecuación de equivalencia...",
    "fecha": "2026-05-28T10:30:00"
  },
  ...
]
```

### Enviar mensaje
```
POST /chat/send
Authorization: Bearer {token}
Content-Type: application/json

{
  "mensaje": "¿Cuál es el ciclo del agua?",
  "documentoId": 5  // opcional
}

Response: 201 Created
{
  "id": 2,
  "usuario": "usuario@example.com",
  "mensaje": "¿Cuál es el ciclo del agua?",
  "respuesta": "El ciclo del agua consta de...",
  "fecha": "2026-05-28T10:35:00"
}
```

### Buscar en historial de chat
```
GET /chat/buscar?termino=agua&ordenar=fecha
Authorization: Bearer {token}

Response: 200 OK
[
  {
    "id": 2,
    "mensaje": "¿Cuál es el ciclo del agua?",
    ...
  }
]
```

---

## Documentos

### Subir documento
```
POST /documentos/upload
Authorization: Bearer {token}
Content-Type: multipart/form-data

FormData:
  - archivo: [archivo.pdf]
  - titulo: "Apuntes de Matemáticas"
  - descripcion: "Tema 1-5"

Response: 201 Created
{
  "id": 5,
  "nombreArchivo": "apuntes_matematicas.pdf",
  "titulo": "Apuntes de Matemáticas",
  "tamaño": 2048576,
  "fechaSubida": "2026-05-28T10:40:00",
  "url": "/documentos/5"
}
```

### Obtener lista de documentos del usuario
```
GET /documentos
Authorization: Bearer {token}

Response: 200 OK
[
  {
    "id": 5,
    "nombreArchivo": "apuntes_matematicas.pdf",
    "titulo": "Apuntes de Matemáticas",
    "tamaño": 2048576,
    "fechaSubida": "2026-05-28T10:40:00"
  },
  ...
]
```

### Descargar documento
```
GET /documentos/5/descargar
Authorization: Bearer {token}

Response: 200 OK
[Contenido del archivo binario]
```

### Obtener detalles de un documento
```
GET /documentos/5
Authorization: Bearer {token}

Response: 200 OK
{
  "id": 5,
  "nombreArchivo": "apuntes_matematicas.pdf",
  "titulo": "Apuntes de Matemáticas",
  "descripcion": "Tema 1-5",
  "tamaño": 2048576,
  "fechaSubida": "2026-05-28T10:40:00",
  "contenidoResumido": "Este documento contiene..."
}
```

### Eliminar documento
```
DELETE /documentos/5
Authorization: Bearer {token}

Response: 200 OK
{
  "mensaje": "Documento eliminado correctamente"
}
```

### Buscar documentos
```
GET /documentos/buscar?titulo=Matemáticas&ordenar=fecha
Authorization: Bearer {token}

Response: 200 OK
[
  {
    "id": 5,
    "titulo": "Apuntes de Matemáticas",
    ...
  }
]
```

---

## Usuarios

### Obtener perfil del usuario
```
GET /usuarios/perfil
Authorization: Bearer {token}

Response: 200 OK
{
  "id": 1,
  "email": "usuario@example.com",
  "nombre": "Juan Pérez",
  "fechaRegistro": "2026-05-28",
  "totalDocumentos": 3,
  "totalMensajes": 15
}
```

### Actualizar perfil
```
PUT /usuarios/perfil
Authorization: Bearer {token}
Content-Type: application/json

{
  "nombre": "Juan Carlos Pérez",
  "password": "nuevaPassword123"
}

Response: 200 OK
{
  "id": 1,
  "email": "usuario@example.com",
  "nombre": "Juan Carlos Pérez",
  "fechaRegistro": "2026-05-28"
}
```

---

## Estadísticas

### Obtener estadísticas del usuario
```
GET /estadisticas
Authorization: Bearer {token}

Response: 200 OK
{
  "totalMensajes": 15,
  "totalDocumentos": 3,
  "ultimoAcceso": "2026-05-28T10:40:00",
  "documentosFrecuentes": [
    { "id": 5, "titulo": "Apuntes Matemáticas", "consultas": 8 }
  ],
  "temasConsultados": ["Matemáticas", "Ciencias", "Historia"]
}
```

---

## Manejo de Errores

Todos los errores siguen este formato:

```json
{
  "status": 400,
  "error": "BadRequest",
  "mensaje": "Descripción detallada del error",
  "timestamp": "2026-05-28T10:40:00"
}
```

### Códigos comunes

| Código | Significado |
|--------|-------------|
| 200 | OK - Solicitud exitosa |
| 201 | Created - Recurso creado |
| 400 | Bad Request - Solicitud inválida |
| 401 | Unauthorized - Token inválido o expirado |
| 403 | Forbidden - Acceso denegado |
| 404 | Not Found - Recurso no encontrado |
| 500 | Internal Server Error - Error del servidor |

---

## Autenticación

Todos los endpoints protegidos requieren el header:
```
Authorization: Bearer {token_jwt}
```

El token se obtiene al hacer login y expira en **24 horas**.

