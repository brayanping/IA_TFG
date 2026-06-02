package com.dam.eduia.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import java.util.Map;

@Service
public class ServicioIACliente {

    private final WebClient webClient;

    public ServicioIACliente() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8000")
                .build();
    }

    // Envía una pregunta al servicio de IA Python
    public String hacerPregunta(String pregunta) {
        try {
            Map respuesta = webClient.post()
                    .uri("/ia/preguntar")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(Map.of("pregunta", pregunta))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            return respuesta != null ? (String) respuesta.get("respuesta") : "Sin respuesta";
        } catch (Exception e) {
            return "Error al conectar con el servicio de IA: " + e.getMessage();
        }
    }

    // Envía un documento al servicio de IA para procesarlo
    public void procesarDocumento(String rutaArchivo, String tipo) {
        try {
            webClient.post()
                    .uri("/ia/procesar-documento")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(Map.of("ruta_archivo", rutaArchivo, "tipo", tipo))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch (Exception e) {
            System.out.println("Error al procesar documento: " + e.getMessage());
        }
    }
}