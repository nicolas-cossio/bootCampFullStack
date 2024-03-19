package com.codigo.builder.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private LocalDate fechaPublicacion;

    private Libro(Builder builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.isbn = builder.isbn;
        this.fechaPublicacion = builder.fechaPublicacion;
    }

    public static class Builder {
        private String titulo;
        private String autor;
        private String isbn;
        private LocalDate fechaPublicacion;

        // Constructores de builder
        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder autor(String autor) {
            this.autor = autor;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder fechaPublicacion(LocalDate fechaPublicacion) {
            this.fechaPublicacion = fechaPublicacion;
            return this;
        }

        // Metodo para construir el objeto
        public Libro build() {
            return new Libro(this);
        }
    }
}
