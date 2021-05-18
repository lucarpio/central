package edu.programacion.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.programacion.central.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
