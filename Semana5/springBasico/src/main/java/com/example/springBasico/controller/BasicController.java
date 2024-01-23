package com.example.springBasico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    // Si me quiero contectar a mi servidor de spring
    @GetMapping()
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/saludar")
    public String saludar(){
        return "Hola soy el servidor.";
    }
}
