package com.example.examenSpring.controller;

import com.example.examenSpring.model.Pasajero;
import com.example.examenSpring.response.ResponseBase;
import com.example.examenSpring.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pasajero")
public class PasajeroController {
    @Autowired
    private PasajeroService pasajeroService;

    @PostMapping("/save")
    public ResponseBase savePasajero(@RequestBody Pasajero pasajero) {
        return pasajeroService.savePasajero(pasajero);
    }

    @GetMapping("/get/{id}")
    public ResponseBase getPasajerro(@PathVariable Integer id) {
        return pasajeroService.findPasajeroById(id);
    }
}
