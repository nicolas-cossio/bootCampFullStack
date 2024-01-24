package com.example.springBasico.controller;

import com.example.springBasico.entity.Producto;
import com.example.springBasico.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/crearProducto")
    public Producto crearProducto(@RequestBody Producto producto) {
        Producto productoNew = new Producto();
        try {
            productoNew = productoService.crearProducto(producto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productoNew;
    }
}
