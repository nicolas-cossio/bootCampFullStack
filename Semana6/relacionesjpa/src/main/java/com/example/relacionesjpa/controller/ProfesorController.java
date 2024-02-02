package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.model.Profesor;
import com.example.relacionesjpa.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Profesor> profesorBD = profesorService.findById(id);
        if (profesorBD.isPresent()) {
            return ResponseEntity.ok(profesorBD.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProfesor(Profesor profesor) {
        Profesor profesorNew = profesorService.saveProfesor(profesor);
        return ResponseEntity.ok(profesorNew);
    }
}
