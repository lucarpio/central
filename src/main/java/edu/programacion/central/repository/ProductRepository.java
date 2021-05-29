package edu.programacion.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.programacion.central.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}