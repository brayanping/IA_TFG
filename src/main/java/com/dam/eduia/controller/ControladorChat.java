package com.dam.eduia.controller;

import com.dam.eduia.dto.PreguntaDTO;
import com.dam.eduia.dto.RespuestaDTO;
import com.dam.eduia.model.Conversacion;
import com.dam.eduia.model.Mensaje;
import com.dam.eduia.repository.ConversacionRepositorio;
import com.dam.eduia.service.ServicioChat;
import com.dam.eduia.service.ServicioIACliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chat")
public class ControladorChat {

    @Autowired
    private ServicioChat servicioChat;

    @Autowired
    private ServicioIACliente servicioIACliente;

    @Autowired
    private ConversacionRepositorio conversacionRepositorio;

    @PostMapping("/conversacion")
    public ResponseEntity<Conversacion> nuevaConversacion(Authentication auth) {
        Conversacion conversacion = servicioChat.crearConversacion(auth.getName());
        return ResponseEntity.ok(conversacion);
    }

    @GetMapping("/conversaciones")
    public ResponseEntity<List<Conversacion>> obtenerConversaciones(Authentication auth) {
        List<Conversacion> conversaciones = servicioChat.obtenerConversaciones(auth.getName());
        return ResponseEntity.ok(conversaciones);
    }

    @GetMapping("/conversacion/{id}/mensajes")
    public ResponseEntity<List<Mensaje>> obtenerMensajes(@PathVariable Long id) {
        List<Mensaje> mensajes = servicioChat.obtenerMensajes(id);
        return ResponseEntity.ok(mensajes);
    }

    @PostMapping(value = "/preguntar", produces = "application/json")
    public ResponseEntity<RespuestaDTO> preguntar(
            @RequestBody PreguntaDTO dto,
            Authentication auth) {

        Long conversacionId = dto.getConversacionId();
        if (conversacionId == null) {
            Conversacion nueva = servicioChat.crearConversacion(auth.getName());
            conversacionId = nueva.getId();
        }

        List<Mensaje> mensajesAnteriores = servicioChat.obtenerMensajes(conversacionId);
        List<Map<String, String>> historial = mensajesAnteriores.stream()
                .map(m -> {
                    Map<String, String> msg = new HashMap<>();
                    msg.put("rol", m.getRol());
                    msg.put("contenido", m.getContenido());
                    return msg;
                })
                .collect(Collectors.toList());

        servicioChat.guardarMensaje(conversacionId, dto.getPregunta(), "usuario");

        String respuestaIA = servicioIACliente.hacerPregunta(dto.getPregunta(), historial);

        Mensaje mensajeRespuesta = servicioChat.guardarMensaje(
                conversacionId, respuestaIA, "asistente");

        return ResponseEntity.ok(new RespuestaDTO(
                respuestaIA, conversacionId, mensajeRespuesta.getId()));
    }

    @DeleteMapping("/conversacion/{id}")
    public ResponseEntity<Void> eliminarConversacion(@PathVariable Long id) {
        conversacionRepositorio.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/conversacion/{id}/titulo", produces = "application/json")
    public ResponseEntity<Conversacion> renombrarConversacion(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        Conversacion conversacion = conversacionRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversación no encontrada"));
        conversacion.setTitle(body.get("titulo"));
        conversacionRepositorio.save(conversacion);
        return ResponseEntity.ok(conversacion);
    }

    @GetMapping(value = "/conversacion/{id}/exportar", produces = "application/json")
    public ResponseEntity<Map<String, Object>> exportarConversacion(
            @PathVariable Long id, Authentication auth) {

        List<Mensaje> mensajes = servicioChat.obtenerMensajes(id);
        Conversacion conversacion = conversacionRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversación no encontrada"));

        Map<String, Object> exportacion = new HashMap<>();
        exportacion.put("titulo", conversacion.getTitle());
        exportacion.put("fecha", conversacion.getCreatedAt());
        exportacion.put("usuario", auth.getName());
        exportacion.put("mensajes", mensajes.stream().map(m -> {
            Map<String, String> msg = new HashMap<>();
            msg.put("rol", m.getRol());
            msg.put("contenido", m.getContenido());
            return msg;
        }).toList());

        return ResponseEntity.ok(exportacion);
    }

    @PostMapping(value = "/generar-imagen", produces = "application/json")
    public ResponseEntity<Map<String, String>> generarImagen(
            @RequestBody Map<String, String> body,
            Authentication auth) {

        String descripcion = body.get("descripcion");
        String urlImagen = servicioIACliente.generarImagen(descripcion);

        Map<String, String> respuesta = new HashMap<>();
        if (urlImagen == null) {
            respuesta.put("error", "No se pudo generar la imagen");
            return ResponseEntity.status(500).body(respuesta);
        }

        respuesta.put("url_imagen", urlImagen);
        return ResponseEntity.ok(respuesta);
    }
}