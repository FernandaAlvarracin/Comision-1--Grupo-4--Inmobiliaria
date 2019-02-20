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
public class Persona {
    private int id=-1;
    private String nombreCompleto;
    private String dni;
    private String celular;
    
    
 
    
    public Persona (int id, String nombreCompleto, String dni, String celular) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.celular = celular;

    }
     public Persona (String nombreCompleto, String dni, String celular) {
        this.id = -1;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.celular = celular;

    }

    public Persona() {
        this.id =-1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
        public String ToString (){
        return id+"-"+nombreCompleto;
    }
    
}
