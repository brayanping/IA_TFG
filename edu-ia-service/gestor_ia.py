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
        print(f"Intentando procesar: {ruta_archivo}")
        print(f"Tipo: {tipo}")

        ruta_archivo = ruta_archivo.replace("\\", "/")

        if not os.path.exists(ruta_archivo):
            print(f"Archivo no encontrado en: {ruta_archivo}")
            raise Exception(f"Archivo no encontrado: {ruta_archivo}")

        if tipo == "application/pdf":
            cargador = PyPDFLoader(ruta_archivo)
        else:
            cargador = TextLoader(ruta_archivo, encoding="utf-8")

        documentos = cargador.load()
        divisor = RecursiveCharacterTextSplitter(chunk_size=1000, chunk_overlap=200)
        fragmentos = divisor.split_documents(documentos)
        self.base_vectorial.add_documents(fragmentos)
        print(f"Procesados {len(fragmentos)} fragmentos")
        return len(fragmentos)

    def hacer_pregunta(self, pregunta: str) -> str:
        retriever = self.base_vectorial.as_retriever(search_kwargs={"k": 4})

        prompt = ChatPromptTemplate.from_template("""
Eres un asistente especializado en el ciclo DAM (Desarrollo de Aplicaciones Multiplataforma).
Responde la pregunta usando el contexto de los documentos si está disponible.
Si el contexto no contiene información relevante, responde usando tu conocimiento general sobre programación y DAM.

Contexto de documentos: {context}

Pregunta: {question}
""")

        cadena = (
            {"context": retriever, "question": RunnablePassthrough()}
            | prompt
            | self.llm
            | StrOutputParser()
        )

        return cadena.invoke(pregunta)

gestor_ia = GestorIA()