package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.model.Curso;
import com.example.relacionesjpa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCurso(Curso curso) {
        Curso cursoNew = cursoService.saveCurso(curso);
        return ResponseEntity.ok(cursoNew);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Curso> cursoBD = cursoService.findById(id);
        if (cursoBD.isPresent()) {
            return ResponseEntity.ok(cursoBD.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
