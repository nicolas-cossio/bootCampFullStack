package com.codigo.practicasonar.repository;

import com.codigo.practicasonar.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByNumDocumento(String numDoc);
    Optional<Usuario> findByNumDocumento(String numDoc);
}
