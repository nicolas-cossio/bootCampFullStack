package com.example.refuerzoJueves.repository;

import com.example.refuerzoJueves.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Optional<Autor> findByNombre(String nombre);
    Optional<Autor> findByDni(String nombre);

}
