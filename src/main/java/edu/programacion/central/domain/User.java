package com.deploy.deploy.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_user")
public class User {
    
    @Id
    private String Username;
    private String Password;

    public User(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }


    public User() {
    }


    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
