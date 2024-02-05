package com.example.examenSpring.controller;

import com.example.examenSpring.model.Reserva;
import com.example.examenSpring.response.ResponseBase;
import com.example.examenSpring.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/save")
    public ResponseBase saveReserva(@RequestBody Reserva reserva) {
        return reservaService.saveReserva(reserva);
    }

    @GetMapping("/get/{id}")
    public ResponseBase getReserva(@PathVariable Integer id) {
        return reservaService.getReservaById(id);
    }
}
