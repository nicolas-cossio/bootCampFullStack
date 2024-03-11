package com.codigo.examen.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String email;
    private String telefono;
    private String password;
    private List<Long> roles;
}