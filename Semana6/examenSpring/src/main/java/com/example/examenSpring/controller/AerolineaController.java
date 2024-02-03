package com.example.examenSpring.controller;

import com.example.examenSpring.model.Aerolinea;
import com.example.examenSpring.response.ResponseBase;
import com.example.examenSpring.service.AerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aerolinea")
public class AerolineaController {
    @Autowired
    AerolineaService aerolineaService;

    @PostMapping("/save")
    public ResponseBase saveAerolinea(@RequestBody Aerolinea aerolinea) {
        return aerolineaService.saveAerolinea(aerolinea);
    }

    @GetMapping("/get/{id}")
    public ResponseBase getAerolinea(@PathVariable Integer id) {
        return aerolineaService.findById(id);
    }
}
