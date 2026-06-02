from fastapi import APIRouter, HTTPException
from pydantic import BaseModel
from gestor_ia import gestor_ia

router = APIRouter()

class PreguntaRequest(BaseModel):
    pregunta: str

class RespuestaResponse(BaseModel):
    respuesta: str

@router.post("/preguntar", response_model=RespuestaResponse)
def preguntar(request: PreguntaRequest):
    try:
        respuesta = gestor_ia.hacer_pregunta(request.pregunta)
        return RespuestaResponse(respuesta=respuesta)
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))