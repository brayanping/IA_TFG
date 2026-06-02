from pydantic_settings import BaseSettings

class Configuracion(BaseSettings):
    openai_api_key: str = "tu-api-key-aqui"
    chroma_directorio: str = "./chroma_db"
    modelo: str = "gpt-3.5-turbo"
    
    class Config:
        env_file = ".env"

configuracion = Configuracion()