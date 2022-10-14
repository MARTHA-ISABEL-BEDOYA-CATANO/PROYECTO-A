/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.conexion;
/**
 *
 * @author clockwork
 */
public class profesional extends Persona{   
    
    private int valor_contrato;
    private double  duraccion;

    public int getValor_contrato() {
        return valor_contrato;
    }

    public void setValor_contrato(int valor_contrato) {
        this.valor_contrato = valor_contrato;
    }

    public double getDuraccion() {
        return duraccion;
    }

    public void setDuraccion(double duraccion) {
        this.duraccion = duraccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean CreateFactory(String Consulta) {
        boolean estado = true;
         PreparedStatement ps; 
         try {
              conexion sql = new conexion();             
             Connection  con = null;
             con = sql.Conectar();
            ps = con.prepareStatement(Consulta);
            ps.executeUpdate();
            estado = true;          
             
             
         } catch (SQLException ex) {
              System.out.println(ex.toString());
              estado = false;
             
         }
        return estado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateFactory(String Consulta, String column, String txt) {
        String Query = Consulta + " where "+ column + " = '" + txt + "'";
        
        boolean estado = true;
         PreparedStatement ps; 
         try {
             conexion sql = new conexion(); 
             Connection  con = null;
             con = sql.Conectar();
            ps = con.prepareStatement(Query);
            ps.executeUpdate();
            estado = true;           
             
             
         } catch (SQLException ex) {
              System.out.println(ex.toString());
              estado = false;
             
         }
        return estado;
    }

    @Override
    public boolean deleteFactory(String table, String column, String text) {
        //To change body of generated methods, choose Tools | Templates.
         boolean estado = false;
          String Consulta= "delete from " + table +" where " + column +" = " + "'" + text + "'";
        PreparedStatement ps;
        try {
           conexion sql = new conexion();
            Connection con = null;
            con = sql.Conectar();
            ps = con.prepareStatement(Consulta);
            ps.executeUpdate();
            estado = true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            estado=false;
        }
        return estado;
    }
    
    
    
}
