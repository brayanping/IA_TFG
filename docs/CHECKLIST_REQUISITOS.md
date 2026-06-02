# Checklist de Requisitos - Proyecto Intermodular 2º DAM

Documento para verificar que el proyecto cumple con todos los requisitos establecidos.

---

## 1. Producto Funcional ✓

- [ ] La aplicación tiene funcionalidad principal completa
- [ ] Se ejecuta sin errores graves
- [ ] Incluye instrucciones claras para arranque
- [ ] Todos los módulos principales funcionan
- [ ] Usuario puede completar flujo básico (login → chat → logout)

**Notas:**
```
_____________________________________________
_____________________________________________
```

---

## 2. Interfaz de Usuario ✓

- [ ] Interfaz adecuada al tipo de aplicación
- [ ] Navegación clara y coherente
- [ ] Mensajes de error comprensibles
- [ ] Mensajes de confirmación claros
- [ ] Responsive / adaptable a diferentes pantallas
- [ ] Componentes visuales intuitivos

**Notas:**
```
_____________________________________________
_____________________________________________
```

---

## 3. Persistencia de Datos + Justificación ✓

### Gestión de Datos
- [ ] ✅ Creación/guardado de información
- [ ] ✅ Consulta/carga de información
- [ ] ✅ Modificación/actualización de información
- [ ] ✅ Eliminación de datos cuando proceda

### Consultas No Triviales (mínimo 2)
- [ ] Consulta 1: _________________ (ej: filtrado de documentos)
- [ ] Consulta 2: _________________ (ej: búsqueda en chat)
- [ ] Consulta 3: _________________ (ej: ordenación por fecha)

### Datos de Ejemplo
- [ ] Script para cargar datos iniciales
- [ ] Datos reproducibles
- [ ] Mecanismo automático o manual

### Justificación en Memoria
- [ ] Incluye justificación de 8-12 líneas
- [ ] Explica por qué la BD elegida es adecuada
- [ ] Menciona alternativas consideradas

**Tecnología elegida:** ________________________
**Justificación:** 
```
_____________________________________________
_____________________________________________
_____________________________________________
_____________________________________________
```

---

## 4. Concurrencia de Usuarios ✓

- [ ] Mínimo 2 usuarios pueden usar simultáneamente
- [ ] Datos aislados por usuario
- [ ] Información de sesión separada
- [ ] Existe componente servidor/servicio
- [ ] Mecanismo de identificación (login/sesión/token)
- [ ] Contempla fallos básicos de comunicación
- [ ] Errores de respuesta manejados
- [ ] Desconexiones contempladas

**Mecanismo de identificación:** ________________________
**Prueba realizada:** 
```
_____________________________________________
_____________________________________________
```

---

## 5. Salida de Información Útil ✓

Proyecto genera/muestra información útil:

- [ ] Registros de errores o actividad
- [ ] Informes (TXT, CSV, JSON, PDF, HTML)
- [ ] Estadísticas o resúmenes
- [ ] Rankings o listados filtrados
- [ ] Logs de sistema
- [ ] Mensajes de confirmación/error

**Ejemplos implementados:**
1. ________________________
2. ________________________
3. ________________________

---

## 6. Pruebas Mínimas ✓

- [ ] Mínimo **8 pruebas funcionales** documentadas
- [ ] Tabla de casos de prueba completa
- [ ] Evidencias de pruebas (capturas/logs)
- [ ] Todas las pruebas pasadas ✅

**Total de pruebas:** _____ 
**Pasadas:** _____ 
**Fallidas:** _____

**Ubicación:** `/docs/PLAN_PRUEBAS.md`

---

## 7. Instalación / Ejecución ✓

### Requisitos Previos
- [ ] Listados en README.md
- [ ] Claros y específicos
- [ ] Incluye versiones de software

### Pasos para Arrancar
- [ ] Documentados en README.md
- [ ] Claros y en orden
- [ ] Probados y verificados

### Configuración Necesaria
- [ ] Variables de entorno documentadas
- [ ] Archivos config explicados
- [ ] Ejemplos proporcionados

### Carga de Datos de Ejemplo
- [ ] Script incluido
- [ ] Instrucciones documentadas
- [ ] Datos reproducibles
- [ ] Ejecutable sin errores

**Ubicación:** `README.md` en cada proyecto

---

## 8. GitHub, Seguimiento y Entrega ✓

- [ ] Repositorio en GitHub
- [ ] Trabajo progresivo visible (commits regulares)
- [ ] README.md con:
  - [ ] Descripción del proyecto
  - [ ] Instrucciones de ejecución
  - [ ] Configuración necesaria
  - [ ] Forma de cargar datos de ejemplo
- [ ] Memoria PDF en `/docs/Memoria_ApellidoNombre.pdf`
- [ ] Commits frecuentes durante desarrollo

**URL repositorio:** ________________________

---

## 9. Seguridad Básica ✓

- [ ] No usa datos personales reales
- [ ] Información ficticia
- [ ] Contraseñas no en repositorio
- [ ] Tokens/credenciales en variables de entorno
- [ ] Configuración externa para datos sensibles
- [ ] .gitignore incluye archivos sensibles

**Mecanismos de seguridad:**
1. ________________________
2. ________________________
3. ________________________

---

## 10. Calidad Mínima del Desarrollo ✓

- [ ] Código organizado coherentemente
- [ ] Nivel mínimo de claridad
- [ ] Mantenible y comprensible
- [ ] No hay código ajeno/incompleto
- [ ] Todas las funcionalidades demostrable
- [ ] Estructura de carpetas clara
- [ ] Nombres de variables/funciones descriptivos

**Estructura de carpetas:** 
```
Ver README.md → Sección "Estructura del Proyecto"
```

---

## RESUMEN FINAL

| Requisito | Estado | Evidencia |
|-----------|--------|-----------|
| 1. Producto Funcional | ☐ ✅ | __________ |
| 2. Interfaz Usuario | ☐ ✅ | __________ |
| 3. Persistencia + BD | ☐ ✅ | __________ |
| 4. Multiusuario | ☐ ✅ | __________ |
| 5. Salida Información | ☐ ✅ | __________ |
| 6. Pruebas (8+) | ☐ ✅ | __________ |
| 7. Instalación | ☐ ✅ | __________ |
| 8. GitHub + README | ☐ ✅ | __________ |
| 9. Seguridad | ☐ ✅ | __________ |
| 10. Calidad Código | ☐ ✅ | __________ |

**Proyecto Completo:** ☐ SÍ ☐ NO

**Observaciones:**
```
_____________________________________________
_____________________________________________
_____________________________________________
```

---

Última actualización: ________________________
Evaluador: ________________________

