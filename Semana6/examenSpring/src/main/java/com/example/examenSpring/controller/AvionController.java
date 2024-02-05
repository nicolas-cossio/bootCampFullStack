package com.example.examenSpring.controller;

import com.example.examenSpring.model.Avion;
import com.example.examenSpring.response.ResponseBase;
import com.example.examenSpring.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/avion")
public class AvionController {
    @Autowired
    private AvionService avionService;

    @PostMapping("/save")
    public ResponseBase saveAvion(@RequestBody Avion avion) {
        return avionService.saveAvion(avion);
    }

    @GetMapping("/get/{id}")
    public ResponseBase getAvion(@PathVariable Integer id) {
        return avionService.findAvionById(id);
    }
}
