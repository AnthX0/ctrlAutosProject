/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Point;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.control.Control;
import org.itson.control.Tabla;

/**
 * @author Victor y Samuel
 */
public class Reporte extends javax.swing.JDialog {
    // ATRIBUTOS
    private javax.swing.JTable tabla;
    private Control c = new Control();

    // CONSTRUCTORES
    
    /**
     * Creates new form Reporte
     * @param frame Ventana padre: Principal.java
     * @param modal Si queremos que se enfoque en esta ventana, quitando la 
     * posibilidad de interactuar con la ventana principal
     */
    public Reporte(java.awt.Frame frame, boolean modal) {
        super(frame, modal);
        initComponents();
        
        Tabla tabla = c.getTablaReporte((JFrame) frame, "", "", "", "");
        despliegaTabla(tabla);
        
        centrarVentana(frame);
        setVisible(true);
    }
    
    // MÉTODOS
    
    /**
     * Método para desplegar las tablas en el frame
     * @param t Tabla a desplegar
     */
    public void despliegaTabla(Tabla t){
        tabla = new javax.swing.JTable(t.getModeloTabla());
        tabla.setAutoResizeMode
        (javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        tabla.setAutoscrolls(false);
        jScrollPane1.setViewportView(tabla);
    }

    /**
     * Método para centrar la ventana en la pantalla
     * @param frame 
     */
    private void centrarVentana(java.awt.Frame frame) {
        Dimension frameSize = frame.getSize();
        Point loc = frame.getLocation();
        Dimension dlgSize = getPreferredSize();
        setLocation((frameSize.width - dlgSize.width) / 2 + loc.x, 
                    (frameSize.height - dlgSize.height) / 2 + loc.y);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCurp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        lbla = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte Por Busqueda");

        lblCurp.setText("Nombre");

        jLabel2.setText("Tipo");

        lblPeriodo.setText("Periodo");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------------", "Licencia", "Placa" }));

        lbla.setText("a");

        btnBuscar.setText("Filtrar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCurp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbxTipo, 0, 157, Short.MAX_VALUE)
                                .addComponent(txtNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(datePicker2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(datePicker1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbla)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRestaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurp)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbla)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPeriodo)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar)
                    .addComponent(btnImprimir)
                    .addComponent(btnRestaurar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre = txtNombre.getText();
        String tipo;
        if(cbxTipo.getSelectedIndex() == 0) {
            tipo = "";
        }else {
            tipo = (String) cbxTipo.getSelectedItem();
        }
        LocalDate date1 = datePicker1.getDate();
        LocalDate date2 = datePicker2.getDate();
        String fechaI, fechaF;
        if(date1 != null) {
            fechaI = date1.toString();
        }else {
            fechaI = "";
        }
        if(date2 != null) {
            fechaF = date2.toString();
        }else {
            fechaF = "";
        }
        Tabla tabla2 = c.getTablaReporte(null, nombre, tipo, fechaI, fechaF);
        despliegaTabla(tabla2);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        txtNombre.setText("");
        cbxTipo.setSelectedIndex(0);
        datePicker1.clear();
        datePicker2.clear();
        Tabla tabla2 = c.getTablaReporte(null, "", "", "", "");
        despliegaTabla(tabla2);
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            JasperReport report = null;
            String path = "src\\main\\java\\org\\itson\\reporte\\TramitesRealizados.jasper";
            report = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(report, null);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JComboBox<String> cbxTipo;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCurp;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lbla;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
