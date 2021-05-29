package edu.programacion.central.dto;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;



@Builder
public class Customer {
    private Integer id;
    private String name;
    private String lastname;
    private String documentID;
    @Temporal(TemporalType.TIMESTAMP)
    private String birthdate;
    private String email;
    private String address;
    

    public Customer(Integer id, String name, String lastname, String documentID, String birthdate, String email, String address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.documentID = documentID;
        this.birthdate = birthdate;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocumentID() {
        return this.documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

}
