/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clockwork
 */
public class Query {
    
      public static ResultSet read(String Query) {              
         ResultSet res =null;
         try {
           PreparedStatement ps;
         conexion sql = new  conexion();      
         Connection con = null;
         con = sql.Conectar();
         ps = con.prepareStatement(Query);
         res = ps.executeQuery();
        } catch (SQLException e) {
             System.out.println(e.toString());
        }
        
         return res;       
      
    }
      
       public static void buscar(JTable tabla, String id,  String [] Columnas, String extend_query ){
         String Search = extend_query + " where " + Columnas[0] +  " like" + "'%" + id + "%'";
        try {
            DefaultTableModel modelo = new DefaultTableModel();
             tabla.setModel(modelo);
             conexion sql = new  conexion();      
            Connection con = sql.Conectar();
            PreparedStatement ps = con.prepareStatement(Search);
            ResultSet ms = ps.executeQuery();
            ResultSetMetaData rmsd = ms.getMetaData();
            int cantidad = rmsd.getColumnCount();            
              for (int i = 0; i < Columnas.length; i++) {
                 modelo.addColumn(Columnas[i]);                 
             }
              while (ms.next())
             {                 
                 Object[] filas = new Object[cantidad];
                 for (int i = 0; i < cantidad; i++) {
                     filas[i] = ms.getObject(i + 1);
                 }
                 modelo.addRow(filas);
             }
            
        } catch (Exception e) {
        }
        
    }
    
}
