/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.itson.control.Control;
import org.itson.control.Tabla;

/**
 * @author Victor y Samuel
 */
public class Principal extends javax.swing.JFrame {
    private javax.swing.JTable tabla;
    Control control = new Control();


    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        centraVentana();
        
        if(control.insercionMasiva() == false) {
            Tabla tablaPersonas = control.getTablaPersonas(this);
            despliegaTabla(tablaPersonas);
            btnInsercionMasiva.setVisible(false);
        }
    }

    /**
     * Este método ubica la ventana en el centro de la pantalla
     */
    private void centraVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        Dimension frameSize = getSize();
        
        if(frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        
        if(frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        
        setLocation((screenSize.height - frameSize.height)/2, (screenSize.width - frameSize.width)/2);
    }

    public void despliegaTabla(Tabla t) {
        tabla = new javax.swing.JTable(t.getModeloTabla());
        
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        tabla.setAutoscrolls(false);
        
        jScrollPane1.setViewportView(tabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        btnInsercionMasiva = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        lblPersonas = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        tramitesMenu = new javax.swing.JMenu();
        licenciaTramitesMenu = new javax.swing.JMenuItem();
        placasTramitesMenu = new javax.swing.JMenuItem();
        consultasMenu = new javax.swing.JMenu();
        licenciasConsultasMenu = new javax.swing.JMenuItem();
        placasConsultasMenu = new javax.swing.JMenuItem();
        reporteMenu = new javax.swing.JMenu();
        reporteGeneralReporteMenu = new javax.swing.JMenuItem();
        reporteBusquedaReporteMenu = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agencia de Transito");

        btnInsercionMasiva.setText("Inserción Masiva");
        btnInsercionMasiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsercionMasivaActionPerformed(evt);
            }
        });

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Completo", "Fecha de Nacimiento", "CURP", "RFC", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        lblPersonas.setText("Personas");

        tramitesMenu.setMnemonic('f');
        tramitesMenu.setText("Trámites");

        licenciaTramitesMenu.setMnemonic('o');
        licenciaTramitesMenu.setText("Licencia");
        licenciaTramitesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenciaTramitesMenuActionPerformed(evt);
            }
        });
        tramitesMenu.add(licenciaTramitesMenu);

        placasTramitesMenu.setMnemonic('s');
        placasTramitesMenu.setText("Placas");
        placasTramitesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasTramitesMenuActionPerformed(evt);
            }
        });
        tramitesMenu.add(placasTramitesMenu);

        menuBar.add(tramitesMenu);

        consultasMenu.setMnemonic('e');
        consultasMenu.setText("Consultas");

        licenciasConsultasMenu.setMnemonic('t');
        licenciasConsultasMenu.setText("Licencias");
        licenciasConsultasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenciasConsultasMenuActionPerformed(evt);
            }
        });
        consultasMenu.add(licenciasConsultasMenu);

        placasConsultasMenu.setMnemonic('y');
        placasConsultasMenu.setText("Placas");
        placasConsultasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasConsultasMenuActionPerformed(evt);
            }
        });
        consultasMenu.add(placasConsultasMenu);

        menuBar.add(consultasMenu);

        reporteMenu.setMnemonic('h');
        reporteMenu.setText("Reporte");

        reporteGeneralReporteMenu.setMnemonic('c');
        reporteGeneralReporteMenu.setText("Reporte de Trámites Realizados");
        reporteMenu.add(reporteGeneralReporteMenu);

        reporteBusquedaReporteMenu.setMnemonic('a');
        reporteBusquedaReporteMenu.setText("Reporte por busqueda");
        reporteMenu.add(reporteBusquedaReporteMenu);

        menuBar.add(reporteMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsercionMasiva))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(lblPersonas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPersonas)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsercionMasiva)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void licenciaTramitesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenciaTramitesMenuActionPerformed
        control.solicitarLicencia(this);
    }//GEN-LAST:event_licenciaTramitesMenuActionPerformed

    private void licenciasConsultasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenciasConsultasMenuActionPerformed
        Consultas consultas = new Consultas();
        consultas.setVisible(true);
    }//GEN-LAST:event_licenciasConsultasMenuActionPerformed

    private void placasTramitesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasTramitesMenuActionPerformed
        control.solicitarPlacas(this);
    }//GEN-LAST:event_placasTramitesMenuActionPerformed

    private void btnInsercionMasivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsercionMasivaActionPerformed
        control.insercionMasiva();
        Tabla tablaPersonas = control.getTablaPersonas(this);
        despliegaTabla(tablaPersonas);
        btnInsercionMasiva.setVisible(false);
    }//GEN-LAST:event_btnInsercionMasivaActionPerformed

    private void placasConsultasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasConsultasMenuActionPerformed
        Consultas consultas = new Consultas();
        consultas.setVisible(true);
    }//GEN-LAST:event_placasConsultasMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsercionMasiva;
    private javax.swing.JMenu consultasMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPersonas;
    private javax.swing.JMenuItem licenciaTramitesMenu;
    private javax.swing.JMenuItem licenciasConsultasMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem placasConsultasMenu;
    private javax.swing.JMenuItem placasTramitesMenu;
    private javax.swing.JMenuItem reporteBusquedaReporteMenu;
    private javax.swing.JMenuItem reporteGeneralReporteMenu;
    private javax.swing.JMenu reporteMenu;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JMenu tramitesMenu;
    // End of variables declaration//GEN-END:variables

}
