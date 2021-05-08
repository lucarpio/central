package com.deploy.deploy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deploy.deploy.domain.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
