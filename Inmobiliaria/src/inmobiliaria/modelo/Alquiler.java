/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria.modelo;

import java.time.LocalDate;

/**
 *
 * @author naldo
 */
public class Alquiler {

    
    private int id=-1;
    private double costo;
    private LocalDate fechaInicio;
    private LocalDate finContrato;
    private Persona persona;
    private Inmueble inmueble;

    public Alquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

   

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public LocalDate getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(LocalDate finContrato) {
        this.finContrato = finContrato;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     *
    
     */
    public Alquiler (int id, LocalDate fechaInicio, double costo, Persona persona, Inmueble inmueble, LocalDate finContrato) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.costo = costo;
        this.persona = persona;
        this.inmueble = inmueble;
        this.finContrato = finContrato;
    }
     public Alquiler (LocalDate fechaInicio, double costo, Persona persona, Inmueble inmueble, LocalDate finContrato) {
        this.fechaInicio = fechaInicio;
        this.costo = costo;
        this.persona = persona;
        this.inmueble = inmueble;
        this.finContrato = finContrato;
    }
   }

