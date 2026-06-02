# Plantilla: Manual de Usuario - Edu-IA

## Descripción General

Este manual proporciona instrucciones paso a paso para utilizar la plataforma Edu-IA.

---

## 1. Acceso al Sistema

### Requisitos
- Navegador web moderno (Chrome, Firefox, Edge, Safari)
- Conexión a Internet
- URL: http://localhost:3000

### Crear cuenta

1. Acceder a la página de **Registro**
2. Completar los siguientes campos:
   - **Email**: Tu correo electrónico
   - **Contraseña**: Mínimo 8 caracteres
   - **Confirmar contraseña**: Repetir la misma contraseña
3. Hacer clic en **Registrarse**
4. Se redirigirá automáticamente a la página de login

### Iniciar sesión

1. Ingresar **Email** y **Contraseña**
2. Hacer clic en **Entrar**
3. Si las credenciales son correctas, irá al **Dashboard** (Chat principal)

---

## 2. Panel Principal - Chat

### Interfaz
```
┌────────────────────────────────────────┐
│         Historial de Chat              │
│ ┌──────────────────────────────────┐   │
│ │ [Tus mensajes] [Respuestas IA]   │   │
│ │                                  │   │
│ └──────────────────────────────────┘   │
│ ┌────────────────────┐  [Enviar]       │
│ │ Escribe aquí...    │                 │
│ └────────────────────┘                 │
└────────────────────────────────────────┘
```

### Funciones principales

#### Enviar mensaje
1. Escribir el mensaje en el campo de texto
2. Presionar **Enter** o hacer clic en **Enviar**
3. Esperar la respuesta de la IA

#### Adjuntar documento
1. Hacer clic en el ícono de **📎 Adjuntar** (si está disponible)
2. Seleccionar un archivo PDF o TXT
3. El documento se enviará junto con tu pregunta

---

## 3. Gestión de Documentos

### Subir documento

1. Ir a la sección **Documentos** (si existe en el menú)
2. Hacer clic en **Subir documento**
3. Seleccionar archivo (PDF, TXT o Word)
4. Hacer clic en **Subir**
5. Esperar confirmación

### Ver documentos subidos

1. En la sección **Documentos**, verá la lista de todos sus archivos
2. Información mostrada:
   - **Nombre del archivo**
   - **Fecha de subida**
   - **Tamaño**

### Eliminar documento

1. Hacer clic en el ícono **🗑️ Eliminar** del documento
2. Confirmar la eliminación
3. El documento se eliminará permanentemente

---

## 4. Perfil de Usuario

### Acceder al perfil

1. Hacer clic en tu **nombre/avatar** (esquina superior derecha)
2. Seleccionar **Mi Perfil**

### Información visible

- **Email**
- **Fecha de registro**
- **Número de documentos subidos**
- **Últimas conversaciones**

### Cerrar sesión

1. Hacer clic en tu **nombre/avatar**
2. Seleccionar **Cerrar sesión**
3. Serás redirigido a la página de login

---

## 5. Preguntas Frecuentes (FAQ)

### ¿Olvidé mi contraseña?
Actualmente no hay opción de recuperación. Contacte con el administrador.

### ¿Cuál es el tamaño máximo de archivo?
El límite es **10 MB** por documento.

### ¿Puedo tener varias conversaciones simultáneas?
No. Cada usuario tiene un único historial de chat.

### ¿Mis datos son privados?
Sí. Cada usuario solo puede ver sus propios documentos y mensajes.

### ¿Se guardan mis conversaciones?
Sí, se guardan automáticamente. Puede volver a acceder posteriormente.

---

## 6. Solución de Problemas

### No puedo entrar a la aplicación
- Verificar que la URL sea correcta: http://localhost:3000
- Borrar caché del navegador (Ctrl+Shift+Delete)
- Intentar en otro navegador

### El chat no responde
- Verificar conexión a Internet
- Recargar la página (F5)
- Comprobar que el backend esté activo (http://localhost:8080)

### Error al subir documento
- Verificar el tamaño del archivo (máximo 10 MB)
- Usar formato compatible (PDF, TXT)
- Intentar con otro navegador

### El token expiró
- Hacer logout y volver a iniciar sesión
- Los tokens expiran cada 24 horas

---

## 7. Consejos de Uso

✅ **Buenas prácticas:**
- Usar preguntas claras y específicas
- Documentos bien organizados facilitan análisis
- Revisar el historial antes de hacer nuevas preguntas

❌ **Evitar:**
- Subir documentos muy grandes
- Perder la conexión a Internet durante operaciones
- Datos sensibles o personales reales

---

## 8. Contacto y Soporte

Para problemas técnicos o sugerencias:
- Consultar documentación en `/docs/`
- Revisar logs del navegador (F12)
- Contactar con el equipo de desarrollo

