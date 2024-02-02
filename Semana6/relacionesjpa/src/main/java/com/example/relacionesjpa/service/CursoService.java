package com.example.relacionesjpa.service;

import com.example.relacionesjpa.model.Curso;
import com.example.relacionesjpa.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }
}
