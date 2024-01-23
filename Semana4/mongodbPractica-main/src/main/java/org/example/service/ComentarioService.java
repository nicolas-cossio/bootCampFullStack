package org.example.service;

import org.example.documents.Comentario;
import org.example.repository.ComentarioRepository;

public class ComentarioService {
    ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public String agregarComentario(Comentario comentario) {
        // Logica de negocio
        try {
            return comentarioRepository.save(comentario);
        } catch (Exception e) {
            // Logica de manejo de errores
            System.out.println(e.getMessage());
            return null;
        }
    }

}
