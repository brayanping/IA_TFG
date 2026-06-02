# Documentación del Proyecto Edu-IA

Bienvenido a la carpeta de documentación. Aquí encontrarás todos los documentos necesarios para entender, ejecutar y evaluar el proyecto.

---

## 📋 Índice de Documentos

### Guías de Inicio Rápido
- **[README.md](../README.md)** - Instrucciones de instalación y ejecución (Backend)
- **[Frontend README.md](../../edu-ia-frontend/README.md)** - Instrucciones para el frontend

### Documentación de Usuario
- **[MANUAL_USUARIO.md](./MANUAL_USUARIO.md)** - Guía completa para usuarios finales
  - Crear cuenta
  - Usar chat
  - Gestionar documentos
  - Preguntas frecuentes

### Documentación Técnica
- **[API_ENDPOINTS.md](./API_ENDPOINTS.md)** - Referencia de todos los endpoints REST
  - Autenticación
  - Chat/Mensajes
  - Documentos
  - Usuarios
  - Manejo de errores

- **[PLAN_PRUEBAS.md](./PLAN_PRUEBAS.md)** - Plan y casos de prueba
  - 22 casos de prueba definidos
  - Procedimiento para evidencias
  - Tabla de ejecución

- **[CHECKLIST_REQUISITOS.md](./CHECKLIST_REQUISITOS.md)** - Verificación de requisitos
  - 10 requisitos técnicos
  - Checklist para completar
  - Resumen final

### Memoria del Proyecto
- **[PLANTILLA_MEMORIA.md](./PLANTILLA_MEMORIA.md)** - Plantilla completa de la Memoria
  - Estructura según normas Nortempo
  - Secciones a rellenar
  - Instrucciones de conversión a PDF
  
  > **IMPORTANTE:** Convertir esta plantilla a PDF y guardar como:  
  > `/docs/Memoria_ApellidoNombre.pdf`

---

## 📁 Estructura de la Carpeta `/docs`

```
docs/
├── README.md                   # Este archivo
├── MANUAL_USUARIO.md           # Guía para usuarios finales
├── API_ENDPOINTS.md            # Referencia de API REST
├── PLAN_PRUEBAS.md             # Casos de prueba y ejecución
├── CHECKLIST_REQUISITOS.md     # Verificación de requisitos
├── PLANTILLA_MEMORIA.md        # Plantilla de la Memoria PDF
├── evidencias/                 # Capturas y logs de pruebas
│   ├── CT-001_login_valido.png
│   ├── CT-016_dos_usuarios.png
│   └── ...
└── diagramas/                  # Diagramas (UML, ER, arquitectura)
    ├── diagrama_clases.png
    ├── diagrama_er.png
    └── ...
```

---

## 🚀 Cómo Usar Esta Documentación

### Para Desarrolladores
1. **Primero:** Lee [API_ENDPOINTS.md](./API_ENDPOINTS.md)
2. **Luego:** Consulta [PLAN_PRUEBAS.md](./PLAN_PRUEBAS.md) para casos de prueba
3. **Finalmente:** Usa [CHECKLIST_REQUISITOS.md](./CHECKLIST_REQUISITOS.md) para validar

### Para Usuarios Finales
1. **Solo necesitas:** [MANUAL_USUARIO.md](./MANUAL_USUARIO.md)
2. Contiene pasos detallados y pantallas
3. Incluye troubleshooting

### Para Presentación / Evaluación
1. **Memoria PDF:** `Memoria_ApellidoNombre.pdf`
2. **Evidencias:** Carpeta `/docs/evidencias/`
3. **Código:** En repositorio GitHub

---

## ✅ Requisitos del Proyecto (Resumen)

El proyecto Edu-IA debe cumplir con 10 requisitos técnicos:

| # | Requisito | Ubicación | Estado |
|---|-----------|-----------|--------|
| 1 | Producto funcional | Código | ✅ |
| 2 | Interfaz de usuario | Frontend | ✅ |
| 3 | Persistencia de datos + 2 consultas no triviales | BD | ✅ |
| 4 | Multiusuario concurrente (2+ simultáneos) | Backend | ✅ |
| 5 | Salida de información útil | Logs/Reportes | ✅ |
| 6 | Mínimo 8 pruebas funcionales | PLAN_PRUEBAS.md | ✅ |
| 7 | Instalación / Ejecución clara | README.md | ✅ |
| 8 | GitHub + commits regulares + README | Repo | ✅ |
| 9 | Seguridad básica (sin datos reales) | Código | ✅ |
| 10 | Calidad mínima de desarrollo | Código | ✅ |

Ver **[CHECKLIST_REQUISITOS.md](./CHECKLIST_REQUISITOS.md)** para detalles.

---

## 📖 Normas de Entrega (Nortempo Formación)

### Formato de la Memoria PDF
- **Formato:** PDF obligatorio
- **Fuente:** Calibri / Arial
- **Tamaño:** 11 (texto), 16 (Título 1), 13 (Título 2)
- **Interlineado:** 1,15
- **Márgenes:** 2,5 cm
- **Numeración:** Sí
- **Extensión:** 15-25 páginas (sin anexos)

### Secciones Obligatorias
1. Portada
2. Resumen (½ página)
3. Motivación e introducción
4. Metodología, recursos y planificación
5. Tecnologías y herramientas
6. Análisis
7. Diseño (con diagrama UML obligatorio)
8. Implementación
9. **Multiusuario concurrente (OBLIGATORIO)** ⭐
10. Despliegue e instalación
11. Pruebas (mínimo 8 casos)
12. Resultados y conclusiones
13. Vías futuras / mejoras
14. Glosario (opcional)
15. Bibliografía

### Entrega
- Memoria PDF en `/docs/Memoria_ApellidoNombre.pdf`
- README.md con instrucciones de ejecución
- Datos de ejemplo cargables
- Commits regulares en GitHub

---

## 🔍 Documentación por Rol

### 👤 Usuario Final
```
Lee → MANUAL_USUARIO.md
```

### 👨‍💻 Desarrollador Backend
```
1. README.md (instalación)
2. API_ENDPOINTS.md (referencia)
3. PLAN_PRUEBAS.md (validación)
4. Código fuente en src/
```

### 👨‍💻 Desarrollador Frontend
```
1. Frontend README.md
2. API_ENDPOINTS.md (integración)
3. MANUAL_USUARIO.md (diseño UI)
4. Código fuente en src/
```

### 📊 Evaluador/Profesor
```
1. Memoria PDF (visión general)
2. README.md (ejecutar proyecto)
3. PLAN_PRUEBAS.md (validar funcionalidad)
4. CHECKLIST_REQUISITOS.md (verificación)
5. Evidencias en /docs/evidencias/
```

---

## 🛠️ Próximos Pasos

### Paso 1: Rellenar la Plantilla de Memoria
1. Abrir [PLANTILLA_MEMORIA.md](./PLANTILLA_MEMORIA.md)
2. Completar todas las secciones [Escribir aquí]
3. Agregar capturas en secciones de interfaz
4. Exportar a PDF

### Paso 2: Capturar Evidencias de Pruebas
1. Crear carpeta `evidencias/` en `/docs/`
2. Ejecutar casos de [PLAN_PRUEBAS.md](./PLAN_PRUEBAS.md)
3. Guardar capturas y logs
4. Usar nombres: `CT-XXX_descripcion.png`

### Paso 3: Agregar Diagramas
1. Crear carpeta `diagramas/` en `/docs/`
2. Diagrama de clases UML (obligatorio)
3. Diagrama Entidad-Relación
4. Diagrama de arquitectura
5. Mockups de interfaz

### Paso 4: Verificar Requisitos
1. Completar [CHECKLIST_REQUISITOS.md](./CHECKLIST_REQUISITOS.md)
2. Asegurar que todos estan marcados ✅
3. Adjuntar evidencias
4. Entregar

---

## 📞 Soporte y Consultas

### Preguntas sobre:
- **Ejecución:** Ver [README.md](../README.md)
- **Usuario:** Ver [MANUAL_USUARIO.md](./MANUAL_USUARIO.md)
- **API:** Ver [API_ENDPOINTS.md](./API_ENDPOINTS.md)
- **Pruebas:** Ver [PLAN_PRUEBAS.md](./PLAN_PRUEBAS.md)
- **Requisitos:** Ver [CHECKLIST_REQUISITOS.md](./CHECKLIST_REQUISITOS.md)

### Problemas Técnicos
1. Revisar logs: `tail -f logs/application.log`
2. Verificar puertos: `:8080` (backend), `:3000` (frontend), `:8000` (IA)
3. Borrar caché/cookies si es necesario

---

## 📚 Recursos Adicionales

- [Documentación Spring Boot](https://spring.io/projects/spring-boot)
- [Documentación React](https://react.dev)
- [Guía Git/GitHub](https://github.com/git-tips/tips)
- [Normas Nortempo Formación](../HELP.md)

---

**Última actualización:** Mayo 2026  
**Versión:** 1.0  
**Autor:** Equipo Edu-IA

