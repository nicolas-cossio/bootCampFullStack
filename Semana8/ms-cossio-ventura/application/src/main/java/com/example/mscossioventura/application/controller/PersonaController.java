package com.example.mscossioventura.application.controller;

import com.example.mscossioventura.domain.aggregates.request.RequestPersona;
import com.example.mscossioventura.domain.aggregates.response.ResponseBase;
import com.example.mscossioventura.domain.ports.in.PersonaServiceIn;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
    info = @Info(
            title = "API-Persona",
            version = "1.0",
            description = "Mantenimiento de una persona"
    )
)
@RestController
@RequestMapping("/v2/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaServiceIn personaServiceIn;

    @Operation(summary = "Crea una persona")
    @PostMapping
    public ResponseBase crear(@RequestBody RequestPersona requestPersona) {
        return personaServiceIn.crearPersonaIn(requestPersona);
    }

    @Operation(summary = "Obtiene una Persona por id")
    @GetMapping("/{numero}")
    public ResponseBase consulta(@PathVariable String numero) {
        return personaServiceIn.consultaPersonaIn(numero);
    }

    @Operation(summary = "Obtiene todas las Personas")
    @GetMapping
    public ResponseBase consultaTodos() {
        return personaServiceIn.consultaPersonasIn();
    }

    @Operation(summary = "Actualizar una Persona")
    @PutMapping("/{id}")
    public ResponseBase actualizar(@PathVariable Long id,
                                   @RequestBody RequestPersona requestPersona) {
        return personaServiceIn.actualizarPersonaIn(id, requestPersona);
    }

    @Operation(summary = "Eliminar una persona")
    @DeleteMapping("/{id}")
    public ResponseBase eliminar(@PathVariable Long id) {
        return personaServiceIn.eliminarPersonaIn(id);
    }

}
