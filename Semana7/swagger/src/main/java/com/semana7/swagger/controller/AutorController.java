package com.semana7.swagger.controller;

import com.semana7.swagger.model.Autor;
import com.semana7.swagger.request.AutorRequest;
import com.semana7.swagger.response.AutorResponse;
import com.semana7.swagger.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public AutorResponse crearAutor(@RequestBody AutorRequest autorReq) {
        return autorService.createAutor(autorReq);
    }

    @GetMapping("/findAll")
    public List<Autor> listarAutores() {
        return autorService.getAll();
    }

    @GetMapping("/{id}")
    public Autor obtenerAutor(@PathVariable Integer id) {
        return autorService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Autor actualizarActor(@PathVariable Integer id, @RequestBody Autor autor) {
        return autorService.update(id, autor);
    }

    @DeleteMapping("/{id}")
    public Autor delete(@PathVariable Integer id) {
        return autorService.delete(id);
    }

}
