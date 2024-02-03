package com.example.examenSpring.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
public class ResponseBase {
    private int code;
    private String message;
    private Boolean status;
    private Optional data;
}