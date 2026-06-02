package com.dam.eduia.dto;

public class RespuestaDTO {
    private String respuesta;
    private Long conversacionId;
    private Long mensajeId;

    public RespuestaDTO(String respuesta, Long conversacionId, Long mensajeId) {
        this.respuesta = respuesta;
        this.conversacionId = conversacionId;
        this.mensajeId = mensajeId;
    }

    public String getRespuesta() { return respuesta; }
    public Long getConversacionId() { return conversacionId; }
    public Long getMensajeId() { return mensajeId; }
}