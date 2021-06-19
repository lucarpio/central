package edu.programacion.central.dto;

public class Delivery {
    private String cat;

    private Number costoenvio;
    private String destino;
    private String estado;
    private String fecha_fin;
    private String fecha_ini;
    private Boolean fragil;
    private Integer id_tracking;
    private String origen;

    public Delivery() {
    }

    public Delivery(String cat, Number costoenvio, String destino, String estado, String fecha_fin, String fecha_ini,
            Boolean fragil, Integer id_tracking, String origen) {
        this.cat = cat;
        this.costoenvio = costoenvio;
        this.destino = destino;
        this.estado = estado;
        this.fecha_fin = fecha_fin;
        this.fecha_ini = fecha_ini;
        this.fragil = fragil;
        this.id_tracking = id_tracking;
        this.origen = origen;
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Number getCostoenvio() {
        return this.costoenvio;
    }

    public void setCostoenvio(Number costoenvio) {
        this.costoenvio = costoenvio;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_fin() {
        return this.fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_ini() {
        return this.fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Boolean getFragil() {
        return this.fragil;
    }

    public void setFragil(Boolean fragil) {
        this.fragil = fragil;
    }

    public Integer getId_tracking() {
        return this.id_tracking;
    }

    public void setId_tracking(Integer id_tracking) {
        this.id_tracking = id_tracking;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

}
