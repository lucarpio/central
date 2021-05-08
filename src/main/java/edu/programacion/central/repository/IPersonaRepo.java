package com.deploy.deploy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.deploy.deploy.domain.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{
    
}
