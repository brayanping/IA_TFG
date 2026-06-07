package com.dam.eduia.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.http.MediaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class ServicioIACliente {

    private final WebClient webClient;

    public ServicioIACliente() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8000")
                .build();
    }

    public String hacerPregunta(String pregunta, List<Map<String, String>> historial) {
        try {
            Map<String, Object> body = new HashMap<>();
            body.put("pregunta", pregunta);
            body.put("historial", historial);

            Map respuesta = webClient.post()
                    .uri("/ia/preguntar")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            return respuesta != null ? (String) respuesta.get("respuesta") : "Sin respuesta";

        } catch (WebClientRequestException e) {
            return "El servicio de IA no está disponible en este momento.";
        } catch (Exception e) {
            return "Error al procesar tu pregunta. Por favor, inténtalo de nuevo.";
        }
    }

    public void procesarDocumento(String rutaArchivo, String tipo) {
        try {
            webClient.post()
                    .uri("/ia/procesar-documento")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(Map.of("ruta_archivo", rutaArchivo, "tipo", tipo))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch (WebClientRequestException e) {
            throw new RuntimeException("El servicio de IA no está disponible.");
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el documento: " + e.getMessage());
        }
    }
    public String generarImagen(String descripcion) {
    try {
        Map respuesta = webClient.post()
                .uri("/ia/generar-imagen")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("descripcion", descripcion))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return respuesta != null ? (String) respuesta.get("url_imagen") : null;
    } catch (Exception e) {
        return null;
    }
}
}