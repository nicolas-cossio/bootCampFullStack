package com.example.springSabado.controller;

import com.example.springSabado.model.Prestamo;
import com.example.springSabado.response.ResponseBase;
import com.example.springSabado.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prestamo")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/registrar")
    public ResponseBase registrarPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.registrarPrestamo(prestamo);
    }
}
