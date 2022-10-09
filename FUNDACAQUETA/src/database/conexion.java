/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author clockwork
 */
public class conexion {
    
    private String usuario = "servidor";
    private String url = "jdbc:mysql://localhost:3306/FUNDACAQUETA";  
    private String Contraseña ="";
    
    public Connection Conectar(){
        Connection link = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.usuario, this.Contraseña);
            JOptionPane.showMessageDialog(null, "Conexion abierta");
            
                      
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());    
           
        }
        
        return link;
    }
    
}
