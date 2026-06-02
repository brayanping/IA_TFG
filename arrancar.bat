@echo off
REM ============================================
REM SCRIPT DE ARRANQUE AUTOMATICO - Edu-IA
REM ============================================
REM Uso: Doble clic en este archivo para arrancar todo
REM ============================================

setlocal enabledelayedexpansion
cls
color 0A

echo.
echo ╔═══════════════════════════════════════════════╗
echo ║   INICIADOR AUTOMATICO - Edu-IA             ║
echo ║   Platform Educativa con IA                 ║
echo ╚═══════════════════════════════════════════════╝
echo.

REM Variables de color y estilos
set ERROR_COLOR=0C
set SUCCESS_COLOR=0A
set INFO_COLOR=0B

REM 1. VALIDAR INSTALACIONES
echo [*] Verificando dependencias...
echo.

REM Verificar Java
echo Buscando Java...
java -version >nul 2>&1
if errorlevel 1 (
    color 0C
    echo [ERROR] Java no está instalado o no está en PATH
    echo         Descargar desde: https://www.oracle.com/java/technologies/downloads/
    echo.
    pause
    exit /b 1
) else (
    echo [OK] Java encontrado
)

REM Verificar Maven
echo Buscando Maven...
mvn -version >nul 2>&1
if errorlevel 1 (
    color 0C
    echo [ERROR] Maven no está instalado o no está en PATH
    echo         Descargar desde: https://maven.apache.org/download.cgi
    echo.
    pause
    exit /b 1
) else (
    echo [OK] Maven encontrado
)

REM Verificar Node.js
echo Buscando Node.js...
node -v >nul 2>&1
if errorlevel 1 (
    color 0C
    echo [ADVERTENCIA] Node.js no está instalado
    echo              Solo el frontend no funcionará
    echo              Descargar desde: https://nodejs.org/
    echo.
    set SKIP_FRONTEND=1
) else (
    echo [OK] Node.js encontrado
)

echo.
color 0A
echo [OK] Todas las dependencias requeridas están instaladas
echo.
echo ============================================
echo     INICIANDO PROYECTO EDU-IA
echo ============================================
echo.

REM 2. OBTENER RUTA DEL PROYECTO
cd /d "%~dp0"
echo Ubicación del proyecto: %CD%
echo.

REM 3. CREAR VENTANAS PARA CADA SERVICIO

REM Backend
echo [1/3] Iniciando Backend (Spring Boot en puerto 8080)...
echo       Esto puede tomar 30-60 segundos...
echo.
start "Edu-IA Backend" cmd /k "cd /d "%~dp0" && mvn spring-boot:run"
timeout /t 3 /nobreak

REM Frontend (si Node.js está disponible)
if NOT "%SKIP_FRONTEND%"=="1" (
    echo [2/3] Iniciando Frontend (React en puerto 3000)...
    echo       Esto puede tomar 20-30 segundos...
    echo.
    cd frontend
    if not exist node_modules (
        echo Instalando dependencias de npm (primera vez)...
        call npm install
    )
    cd ..
    start "Edu-IA Frontend" cmd /k "cd /d "%~dp0\frontend" && npm start"
    timeout /t 3 /nobreak
) else (
    echo [2/3] OMITIDO: Frontend requiere Node.js
)

REM Servicio IA (opcional)
echo [3/3] Servicio IA (OPCIONAL - requiere Python)...
cd edu-ia-service
if exist main.py (
    echo     Python service detectado
    echo     Para iniciarlo: python main.py (en terminal separada)
)
cd ..
echo.

echo.
color 0B
echo ╔═══════════════════════════════════════════════╗
echo ║   ✓ SERVICIOS INICIADOS CORRECTAMENTE        ║
echo ╚═══════════════════════════════════════════════╝
echo.
echo URLS DE ACCESO:
echo   Backend:  http://localhost:8080/api
echo   Frontend: http://localhost:3000
echo.
echo IMPORTANTE:
echo  - Las ventanas de terminal deben permanecer abiertas
echo  - El primer arranque toma más tiempo (descargas)
echo  - Para detener: cierra las ventanas de terminal
echo.
echo PROXIMOS PASOS:
echo  1. Espera a que se abra http://localhost:3000
echo  2. Si no se abre, haz clic en tu navegador y ve a http://localhost:3000
echo  3. La primera carga puede tardar 20-30 segundos
echo.
pause

