package edu.programacion.central.domain;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import java.util.Date;

//import lombok.*;

// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
@Entity
@Table(name = "t_customer")
public class Customer {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private String firstName;
    private String lastName;
    private String documentID;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String gender;
    private String address;
    private String email;
    private String maritalStatus;  
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;   


    public Customer(Integer id, String firstName, String lastName, String documentID, Date birthDate, String gender, String address, String email, String maritalStatus, String phone, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentID = documentID;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.phone = phone;
        this.user = user;
    }

    public Customer() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentID() {
        return this.documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
