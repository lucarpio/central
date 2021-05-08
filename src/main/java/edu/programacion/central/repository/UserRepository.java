package edu.programacion.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.programacion.central.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    
}