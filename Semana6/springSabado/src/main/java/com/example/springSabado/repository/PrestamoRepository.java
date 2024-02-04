package com.example.springSabado.repository;

import com.example.springSabado.model.Prestamo;
import com.example.springSabado.model.PrestamoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, PrestamoId> {
}
