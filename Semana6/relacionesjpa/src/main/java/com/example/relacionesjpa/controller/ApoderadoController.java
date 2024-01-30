package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.model.Apoderado;
import com.example.relacionesjpa.service.ApoderadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/apoderado")
public class ApoderadoController {
    @Autowired
    private ApoderadoService apoderadoService;

    @PostMapping("/save")
    public ResponseEntity<?> saveApoderado(@RequestBody Apoderado apoderado) {
        Apoderado apoderadoNew = apoderadoService.saveApoderado(apoderado);
        return ResponseEntity.ok(apoderadoNew);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Apoderado> apoderadoBD = apoderadoService.findById(id);
        if(apoderadoBD.isPresent()) {
            return  ResponseEntity.ok(apoderadoBD.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
