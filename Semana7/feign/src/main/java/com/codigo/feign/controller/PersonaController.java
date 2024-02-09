package com.codigo.feign.controller;

import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.service.PersonaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/crear")
    public void crearPersona() {
        personaService.crearPersona(null);
    }

    @GetMapping("/{numero}")
    public BaseResponse getInfoReniec(@PathVariable String numero) {
        return personaService.getInfoReniec(numero);
    }
}
