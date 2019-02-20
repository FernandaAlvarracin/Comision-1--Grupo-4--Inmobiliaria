/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria.modelo;

/**
 *
 * @author naldo
 */
public class Inmueble {
    private int idInmueble= -1;
    private String direccion;
    private int cantAmbientes;
    private double costo;
    private boolean disponible;
    private int idPersona;

    public Inmueble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Inmueble(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }
    

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public String ToString (){
        return idInmueble+"-"+direccion;
    }
    
    
    public Inmueble (int idInmueble, String direccion, int cantidAmbientes, float costo, boolean disponible, int idPersona) {
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.cantAmbientes = cantAmbientes;
        this.costo = costo;
        this.disponible = disponible;
        this.idPersona = idPersona;
    }
    public Inmueble ( String direccion, int cantidAmbientes, float costo, boolean disponible, int idPersona) {
        this.idInmueble = -1;
        this.direccion = direccion;
        this.cantAmbientes = cantAmbientes;
        this.costo = costo;
        this.disponible = disponible;
        this.idPersona = idPersona;
    }
}
