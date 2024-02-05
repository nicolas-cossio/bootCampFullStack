package com.example.examenSpring.controller;

import com.example.examenSpring.model.Vuelo;
import com.example.examenSpring.response.ResponseBase;
import com.example.examenSpring.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vuelo")
public class VueloController {
    @Autowired
    private VueloService vueloService;

    @PostMapping("/save")
    public ResponseBase saveVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.saveVuelo(vuelo);
    }

    @GetMapping("/get/{id}")
    public ResponseBase getVuelo(@PathVariable Integer id) {
        return vueloService.getVueloById(id);
    }
}
