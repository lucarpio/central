package edu.programacion.central.dto;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;



@Builder
public class Complaint {
    private Integer id;
    private String subject;
    private String explanation;
    @Temporal(TemporalType.TIMESTAMP)
    private String date;


    public Complaint() {
    }

    public Complaint(Integer id, String subject, String explanation, String date) {
        this.id = id;
        this.subject = subject;
        this.explanation = explanation;
        this.date = date;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
  
}
