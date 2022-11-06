/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import database.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author clockwork
 */
public class usuario extends profesional{
    private String tipo;
    private String password;
    private String user_name;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
