# 🗂️ ÍNDICE COMPLETO - ARRANQUE FÁCIL

## 📍 ESTRUCTURA DE ARCHIVOS

```
📁 edu-ia-backend/
│
├─ 🔴 EMPEZAR_AQUI.md ........................... PUNTO DE ENTRADA
│                                               (Lee esto primero)
│
├─ ⚡ QUICK_START.txt .......................... GUÍA VISUAL ULTRA RÁPIDA
│                                               (2 min para elegir opción)
│
├─ 📋 GUIA_ARRANQUE_SENCILLA.md ............... 4 OPCIONES DETALLADAS
│                                               (Script, Docker, Manual, IDE)
│
├─ 🔧 INICIO_RAPIDO.md ........................ TROUBLESHOOTING
│                                               (Solución de problemas)
│
├─ 📊 ARRANQUE_FACIL_RESUMEN.md .............. RESUMEN TÉCNICO
│                                               (Todas las herramientas)
│
├─ 📄 README.md .............................. DOCUMENTACIÓN PRINCIPAL
│                                               (Técnica completa)
│
├─ ⚙️ 🎯 SCRIPTS DE ARRANQUE
│  ├─ arrancar.bat ........................... Windows (doble clic)
│  └─ arrancar.sh ........................... macOS/Linux (chmod + ./
│
├─ 🐳 DOCKER (Sin instalar nada)
│  ├─ docker-compose.yml .................... Orquestación completa
│  └─ Dockerfile ............................ Imagen backend
│
├─ ⚙️ CONFIGURACIÓN (copiar y usar)
│  ├─ .env.example .......................... Variables de entorno
│  └─ src/main/resources/
│     └─ application.properties.example .... Config Spring Boot
│
└─ 📚 docs/
   ├─ README.md ............................ Índice documentación
   ├─ MANUAL_USUARIO.md ................... Guía para usuarios
   ├─ API_ENDPOINTS.md .................... Referencia API REST
   ├─ PLAN_PRUEBAS.md ..................... 22 casos de prueba
   ├─ CHECKLIST_REQUISITOS.md ............ Validación requisitos
   ├─ PLANTILLA_MEMORIA.md ............... Memoria del proyecto
   └─ RESUMEN_APLICACION.md .............. Normas aplicadas
│
└─ 📁 evidencias/ .......................... (Carpeta para capturas)
   └─ diagramas/ .......................... (Carpeta para UML)

│
📁 edu-ia-frontend/
│
├─ 📄 EMPEZAR_AQUI.md ...................... Instrucciones rápidas
├─ 📄 README.md ........................... Documentación técnica
├─ 🐳 Dockerfile .......................... Imagen frontend
├─ nginx.conf ............................ Config para Docker
│
└─ 📚 docs/
   ├─ README.md .......................... Índice documentación
   └─ MANUAL_USUARIO.md ................. Guía para usuarios
```

---

## 🚀 PUNTO DE ENTRADA SEGÚN PERFIL

### 👶 Nuevo Usuario (Sin Experiencia)
```
1. Lee:     EMPEZAR_AQUI.md (backend)
   ↓
2. Lee:     QUICK_START.txt (2 min)
   ↓
3. Elige:   Script / Docker / Manual
   ↓
4. Lee:     GUIA_ARRANQUE_SENCILLA.md (detalles)
   ↓
5. Ejecuta: Tu opción elegida
   ↓
6. Accede:  http://localhost:3000
```

### 👨‍💻 Desarrollador (Con Experiencia)
```
1. Lee:     README.md (backend)
   ↓
2. Lee:     API_ENDPOINTS.md
   ↓
3. Elige:   Script / Docker / Manual / IDE
   ↓
4. Ejecuta: Tu opción
   ↓
5. Debugging: Con IDE si lo prefieres
```

### 🏛️ Evaluador/Profesor
```
1. Lee:     EMPEZAR_AQUI.md
   ↓
2. Ejecuta: arrancar.bat o docker-compose up
   ↓
3. Verifica: http://localhost:3000
   ↓
4. Consulta: docs/PLAN_PRUEBAS.md (22 casos)
   ↓
5. Revisa:  docs/CHECKLIST_REQUISITOS.md
```

---

## 📋 4 OPCIONES DE ARRANQUE

### Opción 1: SCRIPT AUTOMÁTICO ⭐ Recomendado

**Para:** Todos (primera opción a intentar)

**Windows:**
```
Archivo:  arrancar.bat
Acción:   Doble clic
Tiempo:   2 minutos
```

**macOS/Linux:**
```bash
Archivo:  arrancar.sh
Comando:  chmod +x arrancar.sh && ./arrancar.sh
Tiempo:   2 minutos
```

**Requisitos:**
- ✅ Java 17+
- ✅ Maven 3.8+
- ✅ Node.js 18+ (opcional)

---

### Opción 2: DOCKER 🐳 Más Simple

**Para:** Quien quiere algo ultra simple

**Comando:**
```bash
cd edu-ia-backend
docker-compose up --build
```

**Tiempo:** 3 minutos

**Requisitos:**
- ✅ Solo Docker Desktop

**Ventajas:**
- No necesita instalar nada más
- Funciona igual en cualquier PC
- Incluye BD preconfigurada

---

### Opción 3: MANUAL 🔧 Control Total

**Para:** Debugging o si otras opciones no funcionan

**Terminal 1:**
```bash
cd edu-ia-backend
mvn spring-boot:run
```

**Terminal 2:**
```bash
cd edu-ia-frontend
npm install  # primera vez
npm start
```

**Terminal 3 (opcional):**
```bash
cd edu-ia-service
python main.py
```

**Tiempo:** 5 minutos

**Requisitos:**
- ✅ Java 17+
- ✅ Maven 3.8+
- ✅ Node.js 18+
- ✅ Python 3.9+ (para IA)

---

### Opción 4: IDE 💻 Para Programadores

**Para:** Desarrollo y debugging

**IntelliJ IDEA:**
1. File → Open → edu-ia-backend
2. Click ▶️ Run
3. Abrir segundo proyecto frontend
4. npm start

**VS Code:**
1. Abrir carpeta: edu-ia-backend
2. Terminal: mvn spring-boot:run
3. Nueva instancia: edu-ia-frontend
4. Terminal: npm start

**Tiempo:** 5 minutos

**Requisitos:**
- ✅ IDE instalado
- ✅ Java + Maven
- ✅ Node.js

---

## 🎯 FLUJO RECOMENDADO

```
START
  │
  ├─→ ¿Primera vez?
  │    │
  │    ├─ SÍ → Lee EMPEZAR_AQUI.md
  │    │       │
  │    │       ├─→ ¿Tienes Docker?
  │    │       │    │
  │    │       │    ├─ SÍ → docker-compose up
  │    │       │    └─ NO → Intenta arrancar.bat
  │    │       │
  │    │       ├─→ ¿Funcionó?
  │    │       │    │
  │    │       │    ├─ SÍ → ¡SUCCESS! 🎉
  │    │       │    └─ NO → Lee GUIA_ARRANQUE_SENCILLA.md
  │    │       │           → Prueba otra opción
  │    │
  │    └─ NO → Ve directo a tu opción favorita
  │
  └─→ Accede a http://localhost:3000
      │
      └─→ Login: estudiante1@example.com / password123
          │
          └─→ ¡Disfruta! 🚀

END
```

---

## ✅ CHECKLIST DE REQUISITOS

### Para Script
```
[ ] Java 17+ instalado (java -version)
[ ] Maven 3.8+ instalado (mvn -version)
[ ] Node.js 18+ instalado (node -v)
[ ] Git instalado (git --version)
```

### Para Docker
```
[ ] Docker Desktop instalado (docker --version)
[ ] Docker corriendo
[ ] Al menos 4GB RAM disponibles
```

### Para Manual
```
[ ] Todos los requisitos de "Script"
[ ] Capacidad de abrir múltiples terminales
[ ] Paciencia para ver los logs
```

### Para IDE
```
[ ] IDE instalado (IntelliJ/VS Code)
[ ] Todos los requisitos de "Script"
[ ] Familiaridad con el IDE
```

---

## 🆘 PROBLEMAS Y SOLUCIONES

| Problema | Lee Esto |
|----------|----------|
| "Java no encontrado" | GUIA_ARRANQUE_SENCILLA.md → Sec. Problemas |
| "Puerto en uso" | INICIO_RAPIDO.md → Sec. Problemas |
| "npm no encontrado" | GUIA_ARRANQUE_SENCILLA.md → Sec. Problemas |
| "CORS error" | INICIO_RAPIDO.md → Sec. Solución |
| "No me funciona nada" | GUIA_ARRANQUE_SENCILLA.md → Opción 3 Manual |

---

## 📱 ACCESO DESPUÉS DE ARRANCAR

```
Componente         URL                 Esperado
─────────────────────────────────────────────────
Frontend           http://localhost:3000     Página login
Backend API        http://localhost:8080/api JSON (error 401 OK)
IA Service         http://localhost:8000     JSON health
H2 BD Console      http://localhost:8080/h2   (opcional)
```

---

## 📊 ESTADÍSTICAS

```
├─ Guías de arranque:        4 opciones
├─ Documentación:            6 archivos
├─ Scripts automáticos:      2 archivos
├─ Archivos Docker:          2 archivos
├─ Configuraciones:          2 archivos
├─ Casos de prueba:          22 casos
├─ Requisitos técnicos:      10 requisitos
├─ Documentos en /docs:      7 archivos
└─ TOTAL:                    35+ archivos/guías
```

---

## 🎓 ORDEN RECOMENDADO DE LECTURA

### Primeros 5 minutos
1. EMPEZAR_AQUI.md
2. QUICK_START.txt

### Próximos 5-10 minutos
3. GUIA_ARRANQUE_SENCILLA.md (tu opción elegida)
4. Ejecutar arranque

### Cuando funcione
5. MANUAL_USUARIO.md (usar la app)
6. API_ENDPOINTS.md (si es desarrollador)

### Para validación
7. PLAN_PRUEBAS.md
8. CHECKLIST_REQUISITOS.md

---

## 💝 RESUMEN FINAL

```
┌─────────────────────────────────────────────┐
│  Cualquier usuario puede arrancar el        │
│  proyecto Edu-IA en 2-5 minutos sin         │
│  experiencia técnica previa                 │
│                                             │
│  ✅ 4 opciones diferentes                   │
│  ✅ Documentación completa                  │
│  ✅ Scripts automáticos                     │
│  ✅ Docker preconfigurado                   │
│  ✅ Troubleshooting incluido                │
│                                             │
│  👉 Empieza: EMPEZAR_AQUI.md               │
└─────────────────────────────────────────────┘
```

---

**Última actualización:** Mayo 2026  
**Versión:** 1.0  
**Estado:** ✅ Completo y Funcional

