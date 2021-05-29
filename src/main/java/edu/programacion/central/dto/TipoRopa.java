package edu.programacion.central.dto;

public class TipoRopa {
    private Integer id;
    private String nombre;   


    public TipoRopa(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoRopa() {
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

}
