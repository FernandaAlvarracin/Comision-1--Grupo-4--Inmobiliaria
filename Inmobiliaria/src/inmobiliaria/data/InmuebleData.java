/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria.data;

import inmobiliaria.modelo.Inmueble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Naldo
 */
public class InmuebleData {
    private Connection connection = null;
    private Conexion conexion;
    public InmuebleData(Conexion conexion)
    {
       try { 
        connection = conexion.getConexion();
      } catch (SQLException ex) {
       System.out.println("Error al obtener conexion");
    }
    }
    
    public void guardarInmueble(Inmueble inmueble)
    {
        try
        {
            
            String sql = "INSERT INTO inmueble (direccion, cantAmbientes, costo, disponible, idPersona) VALUES ( ? , ? , ? , ? , ?,? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, inmueble.getDireccion());
            statement.setInt(2, inmueble.getCantAmbientes());
            statement.setDouble(3, (double) inmueble.getCosto());
            statement.setBoolean(4, inmueble.isDisponible());
            statement.setInt(5, inmueble.getIdPersona());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) 
            {
                inmueble.setIdInmueble(rs.getInt(1));
            }
            else 
            {
                System.out.println("No se pudo obtener el id luego de insertar un cliente");
            }
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }
    }
    
    public List<Inmueble> obtenerInmuebles()
    {
        List<Inmueble> inmuebles = new ArrayList<Inmueble>();
            
        try
        {
            String sql = "SELECT * FROM inmueble;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Inmueble inmueble;
            
            while(resultSet.next())
            {
                inmueble = new Inmueble();
                
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setCantAmbientes(resultSet.getInt("cantAmbientes"));
                inmueble.setCosto(resultSet.getInt("costo"));
                inmueble.setDisponible(resultSet.getBoolean("disponible"));
                inmueble.setIdPersona(resultSet.getInt("idPersona"));

                inmuebles.add(inmueble);
                 ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                inmueble.setIdInmueble(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id");
            }
            }      
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error al obtener los inmuebles: " + ex.getMessage());
        }
 
        return inmuebles;
    }

    public void borrarInmueble(int idInmueble)
    {
        try{
            
            String sql = "DELETE FROM inmueble WHERE idInmueble =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idInmueble);
  
            statement.executeUpdate();  
            
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }       
    }
    
    public void actualizarInmueble(Inmueble inmueble)
    {
        try 
        {
            
            String sql = "UPDATE inmueble SET direccion = ?, cantAmbientes = ? ,costo = ?, idInmueble = ?, disponible = ?, idPersona = ? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, inmueble.getDireccion());
            statement.setInt(2, inmueble.getCantAmbientes());    
            statement.setDouble(3, (double) inmueble.getCosto());
            statement.setInt(4, inmueble.getIdInmueble());
            statement.setBoolean(5, inmueble.isDisponible());
            statement.setInt(6, inmueble.getIdPersona());
            
            statement.executeUpdate();
             ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                inmueble.setIdInmueble(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una persona");
            }
            
            statement.close();
            
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }
    
    }
    
    public Inmueble buscarInmueble(int idInmueble) {
      Inmueble inmueble = null;
        try
        {
            
            String sql = "SELECT * FROM inmueble WHERE idInmueble =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idInmueble);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                inmueble = new Inmueble();
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setCantAmbientes(resultSet.getInt("cantAmbientes"));             
                inmueble.setCosto(resultSet.getFloat("costo"));
                inmueble.setDisponible(resultSet.getBoolean("disponible"));
                inmueble.setIdPersona(resultSet.getInt("idPersona"));
            }  
             ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                inmueble.setIdInmueble(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id ");
            }
            statement.close();        
            
        }
        catch (SQLException ex){
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }
        
        return inmueble;
    }
    
}