/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria.data;

import inmobiliaria.modelo.Alquiler;
import inmobiliaria.modelo.Inmueble;
import inmobiliaria.modelo.Persona;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 @version Naldo
 */
public class AlquilerData {
    private Connection connection = null;
    private Conexion conexion;
    private Persona persona;
    
    public AlquilerData(Conexion conexion)
    {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
           
        }
    }
        
    public void guardarAlquiler(Alquiler alquiler)
    {
        try
        {
            
            String sql = "INSERT INTO alquiler (id, idPersona, idInmueble, fechaInicio, finContrato, costo) VALUES ( ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, alquiler.getPersona().getId());
            statement.setInt (2, alquiler.getInmueble().getIdInmueble());
            statement.setDate(3, Date.valueOf (alquiler.getFechaInicio()));
            statement.setDate(4, Date.valueOf (alquiler.getFinContrato()));
            statement.setDouble(5, alquiler.getCosto());
            
            statement.executeUpdate();
             ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                alquiler.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
    }
    
    public List<Alquiler> obtenerAlquileres()
    {
        List<Alquiler> alquileres = new ArrayList<Alquiler>();
            
        try
        {
            String sql = "SELECT * FROM alquiler;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Alquiler alquiler;
            
            while(resultSet.next())
            {
                alquiler = new Alquiler();
                alquiler.setPersona(persona);
                
                
                Persona persona=buscarPersona(resultSet.getInt("idPersona"));
                alquiler.setPersona(persona);
                
                Inmueble inmueble=buscarInmueble(resultSet.getInt ("idInmueble"));
                alquiler.setInmueble (inmueble); 
                
                alquiler.setFechaInicio(resultSet.getDate("fechaInicio").toLocalDate());
                alquiler.setFinContrato(resultSet.getDate("finContrato").toLocalDate());
                alquiler.setCosto(resultSet.getDouble("costo"));

                alquileres.add(alquiler);
            }      
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error al obtener los alquileres: " + ex.getMessage());
        }
 
        return alquileres;
    }

    public List<Alquiler> obtenerAlquilerXPersona(int id){
        List<Alquiler> alquileres = new ArrayList<Alquiler>();
            

        try {
            String sql = "SELECT * FROM alquiler WHERE idPersona = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Alquiler alquiler;
            while(resultSet.next()){
                alquiler = new Alquiler();
                alquiler.setId(resultSet.getInt("id"));
                
                Persona a=buscarPersona(resultSet.getInt("idPersona"));
                alquiler.setPersona(persona);
                
                Inmueble m=buscarInmueble(resultSet.getInt("idInmueble"));
                
                alquiler.setFinContrato(resultSet.getDate("FinContrato").toLocalDate());
               

                alquileres.add(alquiler);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return alquileres;
    }

    
    
    public void borrarAlquiler(int idPersona, int idInmueble)
    {
        try{
            
            String sql = "DELETE FROM alquiler WHERE idPersona =? AND idInmueble =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idPersona);
            statement.setInt(2, idInmueble);
  
            statement.executeUpdate();                       
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }       
    }
    
    public void actualizarAlquiler(Alquiler alquiler)
    {
        try 
        {
            
            //String sql = "UPDATE alquiler SET  fechaInicio = ? , finContrato = ? , costo = ? WHERE idInmueble = ? and idPersona = ?;";

            String sql = "UPDATE alquiler SET idInmueble = ?, idPersona = ?, fechaInicio = ? , finContrato = ? , costo = ? WHERE id = ?;";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, alquiler.getInmueble().getIdInmueble());
            statement.setInt(2, alquiler.getPersona().getId()); 
            statement.setDate(3, Date.valueOf (alquiler.getFechaInicio()));
            statement.setDate(4, Date.valueOf (alquiler.getFinContrato()));
            statement.setDouble(5, alquiler.getCosto());
            statement.setInt(6, alquiler.getId());
          
            
            statement.executeUpdate();
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
    
    }
    
    public Alquiler buscarAlquiler(int id)
    {
      Alquiler alquiler=null;
        try
        {
            
            String sql = "SELECT * FROM alquiler WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, alquiler.getId());
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                alquiler = new Alquiler();
                alquiler.setId(alquiler.getId());
                alquiler.setInmueble(alquiler.getInmueble());
                alquiler.setPersona(alquiler.getPersona());
                /*
                persona= new Persona(resultSet.getInt("persona"));
                alquiler.setPersona(persona);
                inmueble  = new Inmueble(resultSet.getInt("inmueble"));
                alquiler.setInmueble (inmueble); 
                */
              
                alquiler.setFechaInicio(resultSet.getDate("fechaInicio").toLocalDate());
                alquiler.setFinContrato(resultSet.getDate("finContrato").toLocalDate());
                alquiler.setCosto(resultSet.getDouble("costo"));
     
            }      
            statement.close();        
        }catch (SQLException ex){
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
        
        return alquiler;
    }

    private Inmueble buscarInmueble(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Persona buscarPersona(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}