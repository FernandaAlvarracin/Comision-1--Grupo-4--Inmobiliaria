/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria.modelo;

import inmobiliaria.data.Conexion;
import inmobiliaria.data.PersonaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author naldo
 */
public class Inmobiliaria {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     
    public static void main(String[] args, Persona persona1) throws SQLException {
        // TODO code application logic here
        Persona Persona1 = new Persona ("Maria Antonieta", "23562356", "1664123124");
        Conexion con = new Conexion ();
        PersonaData ad = new PersonaData (con);
        
        ad.guardarPersona (persona1);
        System.out.println ("Nueva Persona id: " + persona1.getId());
        
          
    }
    */
    /*
     public static void main(String[] args) throws SQLException {
  
 //
    Alumno alumno1 = new Alumno ("Juan Lopez", LocalDate.of(2010, Month.DECEMBER, 12), true);
    Conexion con = new Conexion ();
    AlumnoData ad = new AlumnoData (con);
        
    ad.guardarAlumno(alumno1);
        
    System.out.println("Nuevo alumnno id: "+ alumno1.getId());
 //
    }
    
    {Conexion con = new Conexion();
        
        AlumnoData alumnoData = new AlumnoData (con);
        
        Alumno alumno1 = new Alumno("Lopez Karina", LocalDate.of(1976,01, 20), true); 
        
        alumnoData.guardarAlumno(alumno1);
        for(Alumno it: alumnoData.obtenerAlumnos()){
            System.out.println("ID: "+it.getId());
            System.out.println("Nombre: "+it.getNombre());
        }

     alumnoData.borrarAlumno(alumno1.getId());
     
     for(Alumno it: alumnoData.obtenerAlumnos()){
            System.out.println("ID: "+it.getId());
            System.out.println("Nombre: "+it.getNombre());
    }
     
     alumnoData.actualizarAlumno(alumno1);
               for(Alumno it:alumnoData.obtenerAlumnos()){
                    System.out.println("ID: "+it.getId());
            System.out.println("Nombre: "+it.getNombre());
               }
}
}
    */
    
    
}
