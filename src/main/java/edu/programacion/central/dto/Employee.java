package edu.programacion.central.dto;

import lombok.*;



@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;   
    
}
