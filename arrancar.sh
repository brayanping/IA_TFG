#!/bin/bash

# ============================================
# SCRIPT DE ARRANQUE AUTOMATICO - Edu-IA
# Para Linux y macOS
# ============================================
# Uso: chmod +x arrancar.sh && ./arrancar.sh
# ============================================

clear

echo ""
echo "╔═══════════════════════════════════════════════╗"
echo "║   INICIADOR AUTOMATICO - Edu-IA             ║"
echo "║   Plataforma Educativa con IA               ║"
echo "╚═══════════════════════════════════════════════╝"
echo ""

# 1. VALIDAR INSTALACIONES
echo "[*] Verificando dependencias..."
echo ""

# Verificar Java
echo "Buscando Java..."
if ! command -v java &> /dev/null; then
    echo "[ERROR] Java no está instalado"
    echo "        Instala Java 17+ y reinicia"
    exit 1
else
    echo "[OK] Java encontrado: $(java -version 2>&1 | head -1)"
fi

# Verificar Maven
echo "Buscando Maven..."
if ! command -v mvn &> /dev/null; then
    echo "[ERROR] Maven no está instalado"
    echo "        En macOS: brew install maven"
    echo "        En Linux: sudo apt-get install maven"
    exit 1
else
    echo "[OK] Maven encontrado"
fi

# Verificar Node.js
echo "Buscando Node.js..."
if ! command -v node &> /dev/null; then
    echo "[ADVERTENCIA] Node.js no está instalado"
    echo "              El frontend no funcionará"
    SKIP_FRONTEND=1
else
    echo "[OK] Node.js encontrado: $(node -v)"
fi

echo ""
echo "[OK] Dependencias verificadas"
echo ""
echo "============================================"
echo "     INICIANDO PROYECTO EDU-IA"
echo "============================================"
echo ""

# 2. OBTENER RUTA DEL PROYECTO
cd "$(dirname "$0")"
echo "Ubicación del proyecto: $(pwd)"
echo ""

# 3. CREAR PROCESOS SEPARADOS

# Backend
echo "[1/3] Iniciando Backend (Spring Boot en puerto 8080)..."
echo "      Esto puede tomar 30-60 segundos..."
echo ""
mvn spring-boot:run &
BACKEND_PID=$!
sleep 5

# Frontend
if [ -z "$SKIP_FRONTEND" ]; then
    echo "[2/3] Iniciando Frontend (React en puerto 3000)..."
    echo "      Esto puede tomar 20-30 segundos..."
    echo ""
    
    cd frontend
    if [ ! -d "node_modules" ]; then
        echo "Instalando dependencias de npm (primera vez)..."
        npm install
    fi
    cd ..
    
    npm start --prefix frontend &
    FRONTEND_PID=$!
    sleep 5
else
    echo "[2/3] OMITIDO: Frontend requiere Node.js"
fi

# Servicio IA (opcional)
echo "[3/3] Servicio IA (OPCIONAL - requiere Python)"
if [ -f "edu-ia-service/main.py" ]; then
    echo "      Python service detectado"
    echo "      Para iniciarlo: python edu-ia-service/main.py (en terminal separada)"
fi
echo ""

echo ""
echo "╔═══════════════════════════════════════════════╗"
echo "║   ✓ SERVICIOS INICIADOS CORRECTAMENTE        ║"
echo "╚═══════════════════════════════════════════════╝"
echo ""
echo "URLS DE ACCESO:"
echo "  Backend:  http://localhost:8080/api"
echo "  Frontend: http://localhost:3000"
echo ""
echo "IMPORTANTE:"
echo " - Presiona Ctrl+C para detener todos los servicios"
echo " - El primer arranque toma más tiempo (descargas)"
echo ""
echo "PROXIMOS PASOS:"
echo " 1. Abre http://localhost:3000 en tu navegador"
echo " 2. Si no se abre automáticamente, cópialo manualmente"
echo " 3. La primera carga puede tardar 20-30 segundos"
echo ""

# Esperar a que se presione Ctrl+C
wait

