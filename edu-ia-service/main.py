from fastapi import FastAPI
from routers import chat, documentos
from config import configuracion

app = FastAPI(title="EduIA - Servicio de Inteligencia Artificial")

# Registrar los routers
app.include_router(chat.router, prefix="/ia", tags=["Chat"])
app.include_router(documentos.router, prefix="/ia", tags=["Documentos"])

@app.get("/")
def inicio():
    return {"mensaje": "Servicio de IA funcionando correctamente"}