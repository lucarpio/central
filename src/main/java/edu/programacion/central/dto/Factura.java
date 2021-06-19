package edu.programacion.central.dto;

public class Factura {

    private String date;
    private Integer id;
    private Number montoFactura;
    private String rucContribuyente;
    private String rucEmisor;

    public Factura(String date, Integer id, Number montoFactura, String rucContribuyente, String rucEmisor) {
        this.date = date;
        this.id = id;
        this.montoFactura = montoFactura;
        this.rucContribuyente = rucContribuyente;
        this.rucEmisor = rucEmisor;
    }

    public Factura() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Number getMontoFactura() {
        return montoFactura;
    }

    public void setMontoFactura(Number montoFactura) {
        this.montoFactura = montoFactura;
    }

    public String getRucContribuyente() {
        return rucContribuyente;
    }

    public void setRucContribuyente(String rucContribuyente) {
        this.rucContribuyente = rucContribuyente;
    }

    public String getRucEmisor() {
        return rucEmisor;
    }

    public void setRucEmisor(String rucEmisor) {
        this.rucEmisor = rucEmisor;
    }

}
