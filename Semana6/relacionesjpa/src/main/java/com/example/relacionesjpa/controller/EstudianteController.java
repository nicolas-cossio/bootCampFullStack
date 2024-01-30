package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.model.Estudiante;
import com.example.relacionesjpa.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante estudianteNew = estudianteService.saveEstudiante(estudiante);
        return ResponseEntity.ok(estudianteNew);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Estudiante> estudianteBD = estudianteService.findById(id);
        if(estudianteBD.isPresent()) {
            return ResponseEntity.ok(estudianteBD.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
