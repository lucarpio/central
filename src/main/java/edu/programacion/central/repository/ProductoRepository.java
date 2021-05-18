package edu.programacion.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.programacion.central.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
