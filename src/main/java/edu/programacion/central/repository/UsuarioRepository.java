package edu.programacion.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.programacion.central.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
