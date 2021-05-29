package edu.programacion.central.dto;

import javax.persistence.JoinColumn;

import lombok.*;
@Builder
public class Ropa {
    private Integer id;
    private String nombre;
    private float precio;
    private String marca;
    private int stock;
    private String descripcion;
    private float puntuacion;

    public Ropa(Integer id, String nombre, float precio, String marca, int stock, String descripcion, float puntuacion) {
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

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
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

    public float getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }
}
