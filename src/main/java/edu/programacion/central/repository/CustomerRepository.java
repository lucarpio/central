package edu.programacion.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.programacion.central.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}