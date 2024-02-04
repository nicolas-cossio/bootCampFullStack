package com.example.springSabado.repository;

import com.example.springSabado.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Optional<Autor> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
