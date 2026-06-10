package com.dam.eduia.controller;

import com.dam.eduia.model.Documento;
import com.dam.eduia.model.User;
import com.dam.eduia.repository.DocumentoRepositorio;
import com.dam.eduia.repository.UsuarioRepositorio;
import com.dam.eduia.service.ServicioIACliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class ControladorDocumento {

    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ServicioIACliente servicioIACliente;

    @PostMapping(value = "/subir", produces = "application/json")
    public ResponseEntity<Documento> subirDocumento(
            @RequestParam("archivo") MultipartFile archivo,
            Authentication auth) throws IOException {

        User usuario = usuarioRepositorio.findByEmail(auth.getName())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Ruta relativa desde donde se ejecuta el backend
        String carpeta = "../edu-ia-service/documentos/";
        Files.createDirectories(Paths.get(carpeta));
        Path ruta = Paths.get(carpeta + archivo.getOriginalFilename());
        Files.write(ruta, archivo.getBytes());

        // Registra el documento en la base de datos
        Documento documento = new Documento();
        documento.setNombre(archivo.getOriginalFilename());
        documento.setTipo(archivo.getContentType());
        documento.setRutaArchivo(ruta.toAbsolutePath().toString());
        documento.setUsuario(usuario);

        documentoRepositorio.save(documento);

        // Envía el documento al servicio de IA para procesarlo
        servicioIACliente.procesarDocumento(ruta.toAbsolutePath().toString(), archivo.getContentType());
        documento.setProcesado(true);
        documentoRepositorio.save(documento);

        return ResponseEntity.ok(documento);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Documento>> obtenerDocumentos(Authentication auth) {
        User usuario = usuarioRepositorio.findByEmail(auth.getName())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        List<Documento> documentos = documentoRepositorio.findByUsuarioId(usuario.getId());
        return ResponseEntity.ok(documentos);
    }
}