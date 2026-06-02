# 🚀 GUÍA DE ARRANQUE - EDU-IA
## Para Usuarios Sin Experiencia Técnica

Elige la opción que mejor se adapte a tu situación 👇

---

## 📊 COMPARATIVA DE OPCIONES

| Opción | Dificultad | Tiempo | Requisitos | Recomendado Para |
|--------|-----------|--------|-----------|------------------|
| **1. Script Automático** | ⭐ Muy Fácil | 2 min | Java, Maven, Node | Todos (primero intenta esto) |
| **2. Docker** | ⭐⭐ Fácil | 3 min | Solo Docker | Usuarios que no quieren instalar nada |
| **3. Manual** | ⭐⭐⭐ Intermedio | 5 min | Java, Maven, Node | Si los otros no funcionan |
| **4. IDE** | ⭐⭐⭐⭐ Avanzado | 5 min | IntelliJ/Eclipse/VS Code | Desarrolladores |

---

## ✅ OPCIÓN 1: SCRIPT AUTOMÁTICO (RECOMENDADO)

### Para Windows

**Paso 1:** Abrir el Explorador de Archivos

**Paso 2:** Navegar a la carpeta del proyecto:
```
C:\Users\BRAYAN\eclipse-workspace\edu-ia-backend
```

**Paso 3:** Buscar el archivo `arrancar.bat`

**Paso 4:** Doble clic en `arrancar.bat`

**Resultado esperado:**
- Se abrirán 2-3 ventanas negras (terminales)
- Se abrirá tu navegador en http://localhost:3000
- Verás la página de login

### Para macOS / Linux

**Paso 1:** Abrir Terminal

**Paso 2:** Copiar y pegar:
```bash
cd ~/eclipse-workspace/edu-ia-backend
chmod +x arrancar.sh
./arrancar.sh
```

**Paso 3:** Presiona Enter

**Resultado esperado:**
- Se verán mensajes en Terminal
- Se abrirá tu navegador en http://localhost:3000
- Verás la página de login

### ⚠️ Si algo no funciona

El script te mostrará mensajes como:
```
[ERROR] Java no está instalado
[ERROR] Maven no está instalado
```

**Solución:** Descargar los requisitos (ver abajo)

---

## ✅ OPCIÓN 2: DOCKER (MÁS SENCILLO SIN INSTALAR NADA)

### Requisito: Solo Docker

Descargar desde: https://www.docker.com/products/docker-desktop

### Instrucciones

**Paso 1:** Abrir Terminal (o PowerShell en Windows)

**Paso 2:** Copiar y pegar:
```bash
cd C:\Users\BRAYAN\eclipse-workspace\edu-ia-backend
docker-compose up --build
```

**Paso 3:** Espera 2-3 minutos

**Resultado esperado:**
- Se descargarán imágenes (primera vez)
- Verás muchos mensajes en Terminal
- Se abrirá http://localhost:3000

**Ventajas de Docker:**
- ✅ No necesita Java, Maven, Node instalados
- ✅ Todo funciona igual en cualquier computadora
- ✅ Más fácil de desplegar

---

## ✅ OPCIÓN 3: MANUAL (SI LOS OTROS NO FUNCIONAN)

### Paso 1: Instalar Requisitos

**Windows:**
1. Descargar Java 17: https://www.oracle.com/java/technologies/downloads/
   - Instalar normalmente
   
2. Descargar Maven: https://maven.apache.org/download.cgi
   - Extraer en `C:\Program Files\`
   
3. Descargar Node.js: https://nodejs.org/
   - Versión LTS

4. Reiniciar la computadora

**macOS:**
```bash
brew install java maven node
```

**Linux:**
```bash
sudo apt-get update
sudo apt-get install openjdk-17-jdk maven nodejs npm
```

### Paso 2: Arrancar Backend

**Abrir Terminal 1:**
```bash
cd C:\Users\BRAYAN\eclipse-workspace\edu-ia-backend
mvn spring-boot:run
```

Esperar a ver:
```
Started EduIaBackendApplication in X.XXX seconds
```

### Paso 3: Arrancar Frontend

**Abrir Terminal 2 (NUEVA):**
```bash
cd C:\Users\BRAYAN\eclipse-workspace\edu-ia-frontend
npm install  # Solo primera vez
npm start
```

Esperar a que se abra http://localhost:3000

### Paso 4: (Opcional) Arrancar IA Service

**Abrir Terminal 3 (NUEVA):**
```bash
cd C:\Users\BRAYAN\eclipse-workspace\edu-ia-service
pip install -r requirements.txt  # Solo primera vez
python main.py
```

---

## ✅ OPCIÓN 4: IDE (PARA DESARROLLADORES)

### IntelliJ IDEA

1. Abrir proyecto: `File → Open → edu-ia-backend`
2. Esperar a que se indexe
3. Hacer clic en el botón ▶️ Run (verde)
4. Abrir segundo proyecto: `edu-ia-frontend`
5. Terminal: `npm install && npm start`

### VS Code

1. Abrir carpeta: `File → Open Folder → edu-ia-backend`
2. Terminal: `mvn spring-boot:run`
3. Nueva carpeta: `File → Open Folder → edu-ia-frontend`
4. Terminal: `npm install && npm start`

---

## 🔍 VERIFICAR QUE FUNCIONA

Después de arrancar, verifica:

| URL | Esperado | Error |
|-----|----------|-------|
| http://localhost:8080/api | JSON (error 401) | Puertos en uso |
| http://localhost:3000 | Página login | Frontend no arrancó |

---

## 📝 PRIMER LOGIN

Después de arrancar, usa:

```
Email: estudiante1@example.com
Contraseña: password123
```

---

## 🆘 PROBLEMAS COMUNES

### "Puerto 8080 en uso"
```
Otro programa está usando el puerto 8080
Solución: Cambiar puerto en application.properties:
server.port=8081
```

### "Java no encontrado"
```
Descargar desde: https://www.oracle.com/java/technologies/downloads/
Instalar y reiniciar computadora
```

### "npm: command not found"
```
Descargar Node.js desde: https://nodejs.org/
Instalar versión LTS
Reiniciar Terminal
```

### "El navegador no abre"
```
Abrir manualmente: http://localhost:3000
```

### "Aparece error de CORS"
```
Es normal si el backend tarda en arrancar
Esperar 10 segundos y recargar página (F5)
```

---

## 🛑 DETENER EL PROYECTO

**Windows:**
- Cerrar todas las ventanas negras (terminales)

**macOS / Linux:**
- Presionar `Ctrl + C` en cada Terminal

**Docker:**
```bash
docker-compose down
```

---

## 📚 MÁS INFORMACIÓN

- **Manual de usuario:** Ver `/docs/MANUAL_USUARIO.md`
- **Instalación avanzada:** Ver `README.md` principal
- **Solución problemas:** Ver `INICIO_RAPIDO.md`

---

## ✨ RECOMENDACIÓN FINAL

1. **Si tienes computadora potente:** Opción 1 (Script)
2. **Si quieres algo súper fácil:** Opción 2 (Docker)
3. **Si nada funciona:** Opción 3 (Manual) o contactar soporte

**¡Lo más probable es que Opción 1 funcione a la primera! 🎉**

