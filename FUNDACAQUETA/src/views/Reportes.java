/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import database.Query;

/**
 *
 * @author clockwork
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    String consulta = "select id_contracto, fecha_inico, fecha_finalizacion, lugar_ejecucion, actividades_proyectadas, actividad.nombre_actividad from proyecto inner join actividad on proyecto.actividad_proyecto =  actividad.id_actividad";
    public Reportes() {
        initComponents();
        this.cargar_tabla();
    }
    
      private void cargar_tabla(){
          
        try {            
            DefaultTableModel modelo = new DefaultTableModel();
            jTable1.setModel(modelo);
            ResultSet load = Query.read(consulta);
            ResultSetMetaData rmsd = load.getMetaData();
            int cantidad = rmsd.getColumnCount();
            String [] Columnas = {"id_contracto", "fecha_inico","fecha_finalizacion","lugar_ejecucion" ,"actividades_proyectadas", "nombre_actividad"};
            for (int i = 0; i < Columnas.length; i++) {
                modelo.addColumn(Columnas[i]);               
            }
            while(load.next())
            {
                 Object[] filas = new Object[cantidad];
                 for (int i = 0; i < cantidad; i++) {
                     filas[i] = load.getObject(i + 1);
                 }
                 modelo.addRow(filas);
                
            }
            
        } catch (Exception e) {
        }
        
    }
    
    public void filtrar(String text){
        String [] Columnas =   {"id_contracto", "fecha_inico","fecha_finalizacion","lugar_ejecucion" ,"actividades_proyectadas", "nombre_actividad"};
        Query.buscar(jTable1, text, Columnas,  consulta);
    }
    
    private void generar_reporte(){
        try {
             ResultSet ms = Query.Factura(consulta);
             while (ms.next()) {                
                 String id_reporte = ms.getString(1);
                 String fecha_primera_dosis = ms.getString(2);
                 String fecha_segunda_dosis = ms.getString(3);
                 String nombre_paciente = ms.getString(4);                  
                 String paciente_apellido = ms.getString(5);
                 String edad = ms.getString(6);
                 String nombre_vacuna = ms.getString(7);
                 String factura = "############## La secretar??a  depatamental caqueta ###########\n"
						+ "########## centro de salud  ########\n\n"
						+ " Lo\n" +" informacion de usuario  \n\n"
						+ "  municipal  Florencia \n"
						+ "\n=============== R E P O R T E ==============\n\n"                                                
                                                + "id reporte  : " + id_reporte + "\n"                                                
                                                + "Fecha de primea dosis  : " + fecha_primera_dosis + "\n"
						+ "Fecha de segunda dosis : " + fecha_segunda_dosis + "\n"
                                                + "nombre del usuario : " + nombre_paciente + "\n"
                                                + "apellido del usuario : " + paciente_apellido + "\n"
						+ "edad: " + edad + "\n"						                                                
                                               	+ "\n============== DETALLES =============\n\n"
                                                + "nombre de la vacuna : " + nombre_vacuna ;
                 JOptionPane.showMessageDialog(null, factura, " Reporte " , JOptionPane.INFORMATION_MESSAGE);
                         
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TxtBuscar1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_contracto", "fecha_inico", "fecha_finalizacion", "lugar_ejecucion", "actividades_proyectadas", "nombre_actividad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Buscar : ");

        TxtBuscar1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TxtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscar1ActionPerformed(evt);
            }
        });
        TxtBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscar1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(TxtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscar1ActionPerformed

    private void TxtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscar1KeyReleased
        // TODO add your handling code here:
        this.filtrar(TxtBuscar1.getText());
    }//GEN-LAST:event_TxtBuscar1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtBuscar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
