from fastapi import APIRouter, HTTPException
from pydantic import BaseModel
from typing import List, Optional
from gestor_ia import gestor_ia

router = APIRouter()

class Mensaje(BaseModel):
    rol: str
    contenido: str

class PreguntaRequest(BaseModel):
    pregunta: str
    historial: Optional[List[Mensaje]] = []

class RespuestaResponse(BaseModel):
    respuesta: str

@router.post("/preguntar", response_model=RespuestaResponse)
def preguntar(request: PreguntaRequest):
    try:
        respuesta = gestor_ia.hacer_pregunta(request.pregunta, request.historial)
        return RespuestaResponse(respuesta=respuesta)
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

class ImagenRequest(BaseModel):
    descripcion: str

@router.post("/generar-imagen")
def generar_imagen(request: ImagenRequest):
    try:
        from openai import OpenAI
        from config import configuracion
        
        client = OpenAI(api_key=configuracion.openai_api_key)
        
        respuesta = client.images.generate(
            model="dall-e-3",
            prompt=request.descripcion,
            size="1024x1024",
            quality="standard",
            n=1
        )
        
        return {"url_imagen": respuesta.data[0].url}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))