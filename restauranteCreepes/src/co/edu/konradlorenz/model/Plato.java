package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class Plato {
    private String nombrePlato;
    private String bebida;
    private List<String> adiciones;
    private int precio;
    private static final int PRECIO_ADICION = 2000; 

    public Plato(String nombrePlato, String bebida, List<String> adiciones, int precio) {
        this.nombrePlato = nombrePlato;
        this.bebida = bebida;
        this.adiciones = adiciones != null ? adiciones : new ArrayList<>();
        this.precio = precio;
    }

    public Plato() {
        this.nombrePlato = "";
        this.bebida = "";
        this.adiciones = new ArrayList<>();
        this.precio = 0;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public List<String> getAdiciones() {
        return adiciones;
    }

    public void setAdiciones(List<String> adiciones) {
        this.adiciones = adiciones;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecioConAdiciones() {
        return precio + (adiciones.size() * PRECIO_ADICION);
    }

    @Override
    public String toString() {
        return "Plato: " + nombrePlato + ", Bebida: " + bebida + ", Adiciones: " + adiciones + ", Precio: $" + getPrecioConAdiciones();
    }
}