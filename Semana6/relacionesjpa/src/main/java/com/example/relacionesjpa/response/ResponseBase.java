package com.example.relacionesjpa.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
@AllArgsConstructor
@Getter
@Setter
public class ResponseBase {
    private int codigo;
    private String mensaje;
    private boolean succes;
    private Optional data;
}