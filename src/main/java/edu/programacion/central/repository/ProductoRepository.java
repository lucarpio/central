package edu.programacion.central.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.programacion.central.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
}
