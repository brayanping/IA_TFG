from fastapi import APIRouter, UploadFile, File, HTTPException
from pydantic import BaseModel
from gestor_ia import gestor_ia
import shutil
import os

router = APIRouter()

class DocumentoRequest(BaseModel):
    ruta_archivo: str
    tipo: str

@router.post("/subir-documento")
async def subir_documento(archivo: UploadFile = File(...)):
    try:
        carpeta = "documentos_temp"
        os.makedirs(carpeta, exist_ok=True)
        ruta = f"{carpeta}/{archivo.filename}"
        
        with open(ruta, "wb") as buffer:
            shutil.copyfileobj(archivo.file, buffer)

        fragmentos = gestor_ia.procesar_documento(ruta, archivo.content_type)

        return {
            "mensaje": "Documento procesado correctamente",
            "fragmentos": fragmentos,
            "archivo": archivo.filename
        }
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@router.post("/procesar-documento")
async def procesar_documento(request: DocumentoRequest):
    try:
        fragmentos = gestor_ia.procesar_documento(request.ruta_archivo, request.tipo)
        return {
            "mensaje": "Documento procesado correctamente",
            "fragmentos": fragmentos
        }
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))