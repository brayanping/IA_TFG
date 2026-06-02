# GUÍA RÁPIDA DE INICIO - EDU-IA
# Para usuarios sin experiencia técnica

## 🚀 FORMA MÁS FÁCIL (Recomendado)

### Windows
1. **Doble clic** en el archivo `arrancar.bat`
2. Espera a que se abra la ventana del navegador
3. ¡Listo! El proyecto estará corriendo

### macOS / Linux
1. Abre Terminal
2. Copia y pega:
   ```bash
   cd /ruta/a/edu-ia-backend
   chmod +x arrancar.sh
   ./arrancar.sh
   ```
3. Espera a que se abra el navegador
4. ¡Listo!

---

## 🔧 SI EL SCRIPT NO FUNCIONA

### Paso 1: Verificar Requisitos Previos

**Windows:**
1. Descargar Java 17:
   - https://www.oracle.com/java/technologies/downloads/
   - Instalar normalmente
   
2. Descargar Maven:
   - https://maven.apache.org/download.cgi
   - Extraer en `C:\Program Files\`
   - Reiniciar la computadora

3. Descargar Node.js (opcional, para el frontend):
   - https://nodejs.org/
   - Versión LTS (recomendada)

**macOS / Linux:**
```bash
# Instalar con gestor de paquetes
brew install java maven node  # En macOS
# O en Linux:
sudo apt-get install openjdk-17-jdk maven nodejs npm
```

### Paso 2: Arranque Manual

Si el script no funciona, ejecuta manualmente en **3 terminales diferentes**:

**Terminal 1 - Backend:**
```bash
cd edu-ia-backend
mvn spring-boot:run
```

**Terminal 2 - Frontend:**
```bash
cd edu-ia-frontend
npm install  # Solo primera vez
npm start
```

**Terminal 3 - IA Service (opcional):**
```bash
cd edu-ia-service
pip install -r requirements.txt  # Solo primera vez
python main.py
```

---

## 📍 Verificar que Todo Funciona

| Servicio | URL | Esperado |
|----------|-----|----------|
| Backend | http://localhost:8080/api | JSON con error 401 (OK) |
| Frontend | http://localhost:3000 | Página de login |
| IA Service | http://localhost:8000 | JSON con status |

---

## 🆘 Problemas Comunes

### "Java no está instalado"
✅ Descargar desde: https://www.oracle.com/java/technologies/downloads/

### "Maven no está instalado"
✅ Descargar desde: https://maven.apache.org/download.cgi

### "Puerto 8080 en uso"
```bash
# Windows: Cambiar en application.properties
server.port=8081

# Luego: mvn spring-boot:run
```

### "Node.js no encontrado"
✅ Descargar desde: https://nodejs.org/ (versión LTS)

### "El navegador no abre automáticamente"
Abre manualmente: http://localhost:3000

---

## 📋 Checklist de Requisitos

- [ ] Java 17+ instalado
- [ ] Maven instalado
- [ ] Node.js instalado (opcional, para frontend)
- [ ] Script `arrancar.bat` (Windows) o `arrancar.sh` (Linux/Mac) ejecutable
- [ ] Primer arranque completado exitosamente

---

## ✅ Primera Vez Arrancando

1. **Espera 1-2 minutos** - Primera descarga de dependencias
2. **Verás 2-3 ventanas** - Backend, Frontend, Terminal
3. **Se abre navegador** - http://localhost:3000
4. **Login de prueba:**
   - Email: `estudiante1@example.com`
   - Contraseña: `password123`

---

## 🛑 Detener el Proyecto

- **Windows:** Cierra las ventanas de Terminal
- **macOS/Linux:** Presiona `Ctrl + C` en cada terminal

---

**¿Preguntas?** Consulta el manual en `/docs/MANUAL_USUARIO.md`

