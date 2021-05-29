package edu.programacion.central.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.programacion.central.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{
    
}
