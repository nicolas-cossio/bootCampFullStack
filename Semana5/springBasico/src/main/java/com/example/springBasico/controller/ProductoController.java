package com.example.springBasico.controller;

import com.example.springBasico.entity.Producto;
import com.example.springBasico.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {
    ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("producto/{id}")
    public ResponseEntity<?> buscarProductoId(@PathVariable Integer id) {
        Optional<Producto> prodOpt = productoService.buscarById(id);
        if (prodOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado.");
        }
        return ResponseEntity.ok(prodOpt.get());
    }

    @PostMapping("producto/new")
    public Producto crearProducto(@RequestBody Producto producto) {
        Producto productoNew = new Producto();
        try {
            productoNew = productoService.crearProducto(producto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productoNew;
    }

    @GetMapping("producto/list")
    public ResponseEntity<?> listarProductos() {
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos vacios.");
        }
        return ResponseEntity.ok(productos);
    }

    @PutMapping("producto/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Optional<Producto> prodOpt = productoService.updateById(id, producto);
        if(prodOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado.");
        }
        return ResponseEntity.ok(prodOpt.get());
    }
}
