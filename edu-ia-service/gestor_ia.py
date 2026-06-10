from langchain_openai import ChatOpenAI, OpenAIEmbeddings
from langchain_chroma import Chroma
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_community.document_loaders import PyPDFLoader, TextLoader
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_core.runnables import RunnablePassthrough
from config import configuracion
import os

class GestorIA:
    def __init__(self):
        self.embeddings = OpenAIEmbeddings(
            openai_api_key=configuracion.openai_api_key
        )
        self.llm = ChatOpenAI(
            openai_api_key=configuracion.openai_api_key,
            model=configuracion.modelo,
            temperature=0.7
        )
        self.base_vectorial = Chroma(
            persist_directory=configuracion.chroma_directorio,
            embedding_function=self.embeddings
        )

    def procesar_documento(self, ruta_archivo: str, tipo: str):
        try:
            print(f"Intentando procesar: {ruta_archivo}")
            ruta_archivo = ruta_archivo.replace("\\", "/")

            if not os.path.exists(ruta_archivo):
                print(f"ERROR: Archivo no encontrado en: {ruta_archivo}")
                raise Exception(f"Archivo no encontrado: {ruta_archivo}")

            print(f"Tipo de archivo: {tipo}")

            if tipo == "application/pdf":
                cargador = PyPDFLoader(ruta_archivo)
            else:
                cargador = TextLoader(ruta_archivo, encoding="utf-8")

            documentos = cargador.load()
            print(f"Documentos cargados: {len(documentos)}")

            divisor = RecursiveCharacterTextSplitter(chunk_size=1000, chunk_overlap=200)
            fragmentos = divisor.split_documents(documentos)
            print(f"Fragmentos generados: {len(fragmentos)}")

            if len(fragmentos) == 0:
                print("AVISO: Sin fragmentos, usando documentos completos")
                fragmentos = documentos

            if len(fragmentos) == 0:
                raise Exception("El documento está vacío o no tiene texto extraíble")

            self.base_vectorial.add_documents(fragmentos)
            print(f"OK: Procesados {len(fragmentos)} fragmentos correctamente")
            return len(fragmentos)

        except Exception as ex:
            print(f"ERROR DETALLADO: {type(ex).__name__}: {str(ex)}")
            raise ex

    def hacer_pregunta(self, pregunta: str, historial: list = []) -> str:
        retriever = self.base_vectorial.as_retriever(search_kwargs={"k": 4})

        historial_texto = ""
        if historial:
            for msg in historial[-6:]:
                try:
                    if hasattr(msg, 'rol'):
                        rol_valor = msg.rol
                        contenido_valor = msg.contenido
                    else:
                        rol_valor = msg.get("rol", "usuario")
                        contenido_valor = msg.get("contenido", "")
                    rol = "Usuario" if rol_valor == "usuario" else "Asistente"
                    historial_texto += f"{rol}: {contenido_valor}\n"
                except Exception:
                    continue

        prompt = ChatPromptTemplate.from_template("""
Eres un asistente especializado en el ciclo DAM (Desarrollo de Aplicaciones Multiplataforma).
Responde usando el contexto de los documentos si está disponible.
Si el contexto no contiene información relevante, responde usando tu conocimiento general sobre programación y DAM.
Ten en cuenta el historial de la conversación para dar respuestas coherentes.

Contexto de documentos: {context}

Historial de conversación:
{historial}

Pregunta actual: {question}
        """)

        cadena = (
            {
                "context": retriever,
                "question": RunnablePassthrough(),
                "historial": lambda _: historial_texto
            }
            | prompt
            | self.llm
            | StrOutputParser()
        )

        return cadena.invoke(pregunta)

gestor_ia = GestorIA()