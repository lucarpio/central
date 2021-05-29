package edu.programacion.central.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;


// import java.math.BigDecimal;
// import java.util.Date;




@Entity
@Table(name = "t_product")
public class Product {
    
    

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String nombre;
    private double precio;
    private String descripción;


    public Product(Integer id, String nombre, double precio, String descripción) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripción = descripción;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripción() {
        return this.descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    
}