package com.dam.eduia.dto;

public class RespuestaAuthDTO {
    private String token;
    private String username;
    private String email;

    public RespuestaAuthDTO(String token, String username, String email) {
        this.token = token;
        this.username = username;
        this.email = email;
    }

    public String getToken() { return token; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
}