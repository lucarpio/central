package edu.programacion.central.dto;

public class Pedido {
    private Integer id;
    private String precioxk;
    private String tiempo_estimado;
    private String ubicacion;

    public Pedido() {
    }

    public Pedido(Integer id, String precioxk, String tiempo_estimado, String ubicacion) {
        this.id = id;
        this.precioxk = precioxk;
        this.tiempo_estimado = tiempo_estimado;
        this.ubicacion = ubicacion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrecioxk() {
        return this.precioxk;
    }

    public void setPrecioxk(String precioxk) {
        this.precioxk = precioxk;
    }

    public String getTiempo_estimado() {
        return this.tiempo_estimado;
    }

    public void setTiempo_estimado(String tiempo_estimado) {
        this.tiempo_estimado = tiempo_estimado;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}
