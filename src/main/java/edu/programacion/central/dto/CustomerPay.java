package edu.programacion.central.dto;


import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;



@Builder
public class CustomerPay {
    private Integer id;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String dni;
    private String email;
    private String password;

}