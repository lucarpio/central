package edu.programacion.central.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;



@Entity
@Table(name = "t_user")
public class User implements Serializable {
    
    @Id
    @Column(name = "user_id")
    private String Username;
    private String Password;
    private String tipoUsuario;


    public User(String Username, String Password, String tipoUsuario) {
        this.Username = Username;
        this.Password = Password;
        this.tipoUsuario = tipoUsuario;
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

    public String getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    

}
