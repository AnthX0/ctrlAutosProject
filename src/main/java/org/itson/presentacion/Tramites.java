/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import org.itson.dominio.Licencia;
import org.itson.dominio.Pago;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;


/**
 * @author Victor y Samuel
 */
public class Tramites extends javax.swing.JFrame {
    private DefaultComboBoxModel personas;
    private Licencia licencia;
    private Placa placa;
    private int tipo;

    /**
     * Creates new form Tramite
     */
    public Tramites(java.awt.Frame frame, String title, DefaultComboBoxModel personas, Licencia licencia) {
        super(title);
        this.personas = personas;
        this.licencia = licencia;
        
        initComponents();
        
        lblRegistro.setVisible(false);
        lblSerie.setVisible(false);
        txtSerie.setVisible(false);
        lblMarca.setVisible(false);
        txtMarca.setVisible(false);
        lblLinea.setVisible(false);
        txtLinea.setVisible(false);
        lblColor.setVisible(false);
        txtColor.setVisible(false);
        lblModelo.setVisible(false);
        txtModelo.setVisible(false);
        lblCosto.setVisible(false);
        txtCosto.setVisible(false);
            
        setSize(new Dimension(300, 205));
        
        centrarVentana(frame);
        setVisible(true);
    }

    public Tramites(java.awt.Frame frame, String title, DefaultComboBoxModel personas, Placa placa) {
        super(title);
        this.personas = personas;
        this.placa = placa;
        
        initComponents();
        
        lblVigencia.setVisible(false);
        cbxVigencia.setVisible(false);
        lblTipo.setVisible(false);
        cbxTipo.setVisible(false);
        lblPrecio.setVisible(false);
        txtPrecio.setVisible(false);
        
        btnTramitar.setText("Buscar");
        
        setSize(new Dimension(300, 296));
        
        centrarVentana(frame);
        setVisible(true);
    }

    private void definirPrecio() {
        if(cbxVigencia.getSelectedIndex() == 0 || cbxTipo.getSelectedIndex() == 0) {
            txtPrecio.setText("");
        }
        
        if(cbxVigencia.getSelectedIndex() == 1  && cbxTipo.getSelectedIndex() == 1) {
            txtPrecio.setText("600");
        }else if(cbxVigencia.getSelectedIndex() == 2 && cbxTipo.getSelectedIndex() == 1) {
            txtPrecio.setText("900");
        }else if(cbxVigencia.getSelectedIndex() == 3 && cbxTipo.getSelectedIndex() == 1) {
            txtPrecio.setText("1100");
        }
        
        if(cbxVigencia.getSelectedIndex() == 1  && cbxTipo.getSelectedIndex() == 2) {
            txtPrecio.setText("200");
        }else if(cbxVigencia.getSelectedIndex() == 2 && cbxTipo.getSelectedIndex() == 2) {
            txtPrecio.setText("500");
        }else if(cbxVigencia.getSelectedIndex() == 3 && cbxTipo.getSelectedIndex() == 2) {
            txtPrecio.setText("700");
        }
        
        if(tipo == ConstantesGUI.PLACA_NUEVO) {
            txtCosto.setText("1500");
        }else if(tipo == ConstantesGUI.PLACA_USADO) {
            txtCosto.setText("1000");
        }
    }

    private void centrarVentana(java.awt.Frame frame) {
        Dimension frameSize = frame.getSize();
        Point loc = frame.getLocation();
        
        Dimension dlgSize = getPreferredSize();
        
        setLocation((frameSize.width - dlgSize.width) / 2 + loc.x, 
                    (frameSize.height - dlgSize.height) / 2 + loc.y);
    }

    private Licencia obtenerDatosLicencia() {
        Calendar fechaExpedicion = new GregorianCalendar();
        Integer aniosVigencia = (Integer) cbxVigencia.getSelectedIndex();
        Integer costo = Integer.parseInt(txtPrecio.getText());
        String tipoLicencia = (String) cbxTipo.getSelectedItem();
        Persona persona = (Persona) cbxCliente.getSelectedItem();
        Pago pago = new Pago("Tarjeta", "Compra de una licencia", costo, fechaExpedicion, persona);
        
        return new Licencia(fechaExpedicion, aniosVigencia, costo, tipoLicencia, persona, pago);
    }
    
    private Placa obtenerDatosPlaca() {
        return new Placa();
    }

    private void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPrecio = new javax.swing.JTextField();
        btnTramitar = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        cbxCliente = new javax.swing.JComboBox<>();
        lblVigencia = new javax.swing.JLabel();
        cbxVigencia = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblPrecio = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblLinea = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        btnRestaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txtPrecio.setEditable(false);

        btnTramitar.setText("Tramitar");
        btnTramitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTramitarActionPerformed(evt);
            }
        });

        lblCliente.setText("Cliente");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbxCliente.setMaximumRowCount(20);
        cbxCliente.setModel(personas);

        lblVigencia.setText("Vigencia");

        cbxVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------", "1", "2", "3" }));
        cbxVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVigenciaActionPerformed(evt);
            }
        });

        lblTipo.setText("Tipo de licencia");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------", "Normal", "Discapacitados" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        lblPrecio.setText("Precio");

        lblRegistro.setText("Registro de Vehículo");

        lblSerie.setText("N. Serie");

        lblMarca.setText("Marca");

        lblLinea.setText("Línea");

        lblColor.setText("Color");

        lblModelo.setText("Modelo");

        lblCosto.setText("Costo");

        txtCosto.setEditable(false);

        btnRestaurar.setText("Restaurar");
        btnRestaurar.setToolTipText("");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRestaurar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTramitar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(21, 21, 21)
                                .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVigencia)
                                .addGap(12, 12, 12)
                                .addComponent(cbxVigencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblTipo))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecio)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtColor, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(txtModelo)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSerie))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSerie)
                            .addComponent(txtMarca)
                            .addComponent(txtLinea)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(lblRegistro))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblCliente))
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblVigencia))
                    .addComponent(cbxVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblTipo))
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblPrecio))
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegistro)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSerie)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinea)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCosto)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTramitar)
                        .addComponent(btnRestaurar))
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVigenciaActionPerformed
        if(cbxTipo.getSelectedIndex() != 0) {
            definirPrecio();
        }
    }//GEN-LAST:event_cbxVigenciaActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        if(cbxVigencia.getSelectedIndex() != 0) {
            definirPrecio();
        }
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnTramitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitarActionPerformed
        if(tipo == ConstantesGUI.LICENCIA) {
            licencia = obtenerDatosLicencia();
        }
        
        if(tipo == ConstantesGUI.PLACA) {
            
        }
        
        if(tipo == ConstantesGUI.PLACA && !txtSerie.getText().equals("")) {
            
        }
        
        dispose();
    }//GEN-LAST:event_btnTramitarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        if(tipo == ConstantesGUI.LICENCIA) {
            cbxCliente.setSelectedIndex(0);
            cbxVigencia.setSelectedIndex(0);
            cbxTipo.setSelectedIndex(0);
        }
        
        if(tipo == ConstantesGUI.PLACA) {
            txtSerie.setText("");
            txtMarca.setText("");
            txtLinea.setText("");
            txtColor.setText("");
            txtModelo.setText("");
            txtCosto.setText("");
        }
    }//GEN-LAST:event_btnRestaurarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnTramitar;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JComboBox<String> cbxVigencia;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblVigencia;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
