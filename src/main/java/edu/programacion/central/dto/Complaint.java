package edu.programacion.central.dto;



import java.time.ZonedDateTime;


import lombok.*;



@Builder
public class Complaint {
    private Integer id;
    private String subject;
    private String explanation;
    private ZonedDateTime date;


    public Complaint() {
    }

    public Complaint(Integer id, String subject, String explanation, ZonedDateTime date) {
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

    public ZonedDateTime getDate() {
        return this.date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    
  
}
