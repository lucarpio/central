package edu.programacion.central.dto;

import javax.persistence.JoinColumn;

import lombok.*;
@Builder
public class Ropa {
    private int id;
    private String nombre;
    private double precio;
    private String marca;
    private int stock;
    private String descripcion;
    private double puntuacion;

    public Ropa(int id, String nombre, double precio, String marca, int stock, String descripcion, double puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.stock = stock;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
    }


    public Ropa() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
