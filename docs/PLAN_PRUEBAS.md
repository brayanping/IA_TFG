# Plan de Pruebas - Edu-IA

## Descripción General

Este documento define el plan de pruebas funcionales para validar que el proyecto cumple con los requisitos establecidos.

---

## Casos de Prueba

### 1. Autenticación - Registro
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-001 | Registrar usuario válido | 1. Ir a página registro<br>2. Llenar campos (email, password)<br>3. Hacer clic Registrarse | Usuario creado, redirige a login | Captura pantalla de confirmación |
| CT-002 | Registrar con email duplicado | 1. Intentar registrar con email existente | Mostrar error "Email ya existe" | Captura de error |
| CT-003 | Registrar con password débil | 1. Registrar con password < 8 caracteres | Mostrar error "Password muy corto" | Captura de validación |

### 2. Autenticación - Login
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-004 | Login con credenciales válidas | 1. Ir a login<br>2. Ingresar email y password<br>3. Hacer clic Entrar | Acceso al dashboard | Captura de panel principal |
| CT-005 | Login con credenciales inválidas | 1. Ingresar email/password incorrectos | Mostrar error "Credenciales inválidas" | Captura de error |
| CT-006 | Login sin completar campos | 1. Intentar login sin ingresar datos | Validación de campos obligatorios | Captura de validación |

### 3. Chat - Enviar Mensajes
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-007 | Enviar mensaje simple | 1. Escribir "Hola"<br>2. Hacer clic Enviar | Mensaje aparece en historial, IA responde | Captura de conversación |
| CT-008 | Enviar mensaje largo | 1. Escribir pregunta de 200+ caracteres | Mensaje se procesa correctamente | Captura en chat |
| CT-009 | Obtener historial de chat | 1. Acceder a sección Chat | Mostrar conversaciones anteriores | Captura de historial |

### 4. Documentos - Upload
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-010 | Subir documento PDF válido | 1. Ir a Documentos<br>2. Seleccionar PDF (< 10 MB)<br>3. Hacer clic Subir | Documento guardado en BD | Captura de confirmación |
| CT-011 | Subir archivo muy grande | 1. Intentar subir archivo > 10 MB | Mostrar error "Archivo muy grande" | Captura de error |
| CT-012 | Subir formato no soportado | 1. Intentar subir archivo .exe | Mostrar error "Formato no válido" | Captura de rechazo |

### 5. Documentos - Gestión
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-013 | Listar documentos del usuario | 1. Ir a Documentos | Mostrar solo documentos del usuario actual | Captura de listado |
| CT-014 | Eliminar documento | 1. Seleccionar documento<br>2. Hacer clic Eliminar<br>3. Confirmar | Documento eliminado de BD | Captura de eliminación |
| CT-015 | Descargar documento | 1. Hacer clic Descargar en documento | Archivo descargado correctamente | Verificación de archivo |

### 6. Multiusuario Concurrente
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-016 | Login de 2 usuarios simultáneos | 1. Usuario A login en navegador 1<br>2. Usuario B login en navegador 2 | Ambos acceden sin problemas | 2 Capturas (navegadores) |
| CT-017 | Datos aislados por usuario | 1. Usuario A sube documento<br>2. Usuario B accede a Documentos | Usuario B no ve documentos de A | Capturas comparativas |
| CT-018 | Chat independiente por usuario | 1. Usuario A envía mensaje<br>2. Usuario B revisa historial | Usuario B no ve chat de A | Capturas de chats diferentes |

### 7. Persistencia - Base de Datos
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-019 | Datos se guardan al cerrar | 1. Crear usuario y enviar mensaje<br>2. Cerrar navegador<br>3. Reabrir y login | Datos persisten, mensaje visible | Comparación antes/después |
| CT-020 | Consulta no trivial - Filtro | 1. Ir a Documentos<br>2. Filtrar por fecha | Mostrar solo documentos del rango | Captura de filtro |

### 8. Salida de Información Útil
| ID | Caso de Prueba | Pasos | Resultado Esperado | Evidencia |
|----|----|---|---|---|
| CT-021 | Ver estadísticas de usuario | 1. Acceder a Perfil | Mostrar total mensajes, documentos | Captura de estadísticas |
| CT-022 | Ver logs/historial de actividad | 1. [Según implementación] | Mostrar registro de actividades | Captura de logs |

---

## Resumen de Ejecución

| Categoría | Casos | Pasados | Fallidos | Notas |
|-----------|-------|---------|----------|-------|
| Autenticación | 6 | ? | ? | |
| Chat | 3 | ? | ? | |
| Documentos | 6 | ? | ? | |
| Multiusuario | 3 | ? | ? | |
| Persistencia | 2 | ? | ? | |
| Información Útil | 2 | ? | ? | |
| **TOTAL** | **22** | ? | ? | |

---

## Consideraciones

- ✅ Mínimo 8 casos de prueba (se han definido 22)
- ✅ Incluye multiusuario concurrente
- ✅ Prueba persistencia de datos
- ✅ Valida consultas no triviales
- ✅ Genera evidencias (capturas, logs)

---

## Procedimiento para Evidencias

1. **Capturas**: Presionar Print Screen y guardar en carpeta `/docs/evidencias/`
2. **Logs**: Copiar logs relevantes del navegador (F12) o backend
3. **Nombres**: Usar formato `CT-XXX_[nombre].png`

Ejemplo: `CT-016_dos_usuarios_simultaneos.png`

