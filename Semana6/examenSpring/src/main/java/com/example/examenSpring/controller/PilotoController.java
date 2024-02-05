package com.example.examenSpring.controller;

import com.example.examenSpring.model.Piloto;
import com.example.examenSpring.response.ResponseBase;
import com.example.examenSpring.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/piloto")
public class PilotoController {
    @Autowired
    private PilotoService pilotoService;

    @PostMapping("/save")
    public ResponseBase savePiloto(@RequestBody Piloto piloto) {
        return pilotoService.savePiloto(piloto);
    }

    @GetMapping("/get/{id}")
    public ResponseBase getPiloto(@PathVariable Integer id) {
        return pilotoService.getPilotoById(id);
    }

}
