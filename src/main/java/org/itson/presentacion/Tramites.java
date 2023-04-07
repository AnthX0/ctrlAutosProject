/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import org.itson.control.Control;
import org.itson.dominio.Licencia;
import org.itson.dominio.Pago;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.dominio.Vehiculo_Usado;


/**
 * @author Victor y Samuel
 */
public class Tramites extends javax.swing.JDialog {
    // ATRIBUTOS
    EntityManagerFactory emFactory = 
        Persistence.createEntityManagerFactory
                ("org.itson_AgenciaTransito");
    EntityManager em = emFactory.createEntityManager();
    private DefaultComboBoxModel personas;
    private int tipo;
    private Control c = new Control();
    private StringBuffer respuesta;
    private String serie;
    private List<Vehiculo> vehiculos;
    
    // CONSTRUCTORES

    /**
     * Creates new form Tramite
     */
    public Tramites(java.awt.Frame frame, String title, boolean modal, 
            int tipo, DefaultComboBoxModel personas, StringBuffer respuesta) {
        super(frame, title, modal);
        this.tipo = tipo;
        this.personas = personas;
        this.respuesta = respuesta;
        initComponents();
        if(tipo == ConstantesGUI.LICENCIA) {
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
        }
        if(tipo == ConstantesGUI.PLACA) {
            lblVigencia.setVisible(false);
            cbxVigencia.setVisible(false);
            lblTipo.setVisible(false);
            cbxTipo.setVisible(false);
            lblPrecio.setVisible(false);
            txtPrecio.setVisible(false);
            btnTramitar.setText("Buscar");
            setSize(new Dimension(300, 296));
        }
        respuesta.append(ConstantesGUI.CANCELAR);
        centrarVentana(frame);
        setVisible(true);
    }
    
    // MÉTODOS

    /**
     * Método para definir el precio de las Licencias y las Placas
     */
    private void definirPrecio() {
        // LICENCIA NADA SELECCIONADO
        if(cbxVigencia.getSelectedIndex() == 0 || 
                cbxTipo.getSelectedIndex() == 0) {
            txtPrecio.setText("");
        }
        // LICENCIA NORMAL 1 AÑO
        if(cbxVigencia.getSelectedIndex() == 1  && 
                cbxTipo.getSelectedIndex() == 1) {
            txtPrecio.setText("600");
        // LICENCIA NORMAL 2 AÑOS
        }else if(cbxVigencia.getSelectedIndex() == 2 && 
                cbxTipo.getSelectedIndex() == 1) {
            txtPrecio.setText("900");
        // LICENCIA NORMAL 3 AÑOS
        }else if(cbxVigencia.getSelectedIndex() == 3 && 
                cbxTipo.getSelectedIndex() == 1) {
            txtPrecio.setText("1100");
        }
        // LICENCIA DISCAPACITADOS 1 AÑO
        if(cbxVigencia.getSelectedIndex() == 1  && 
                cbxTipo.getSelectedIndex() == 2) {
            txtPrecio.setText("200");
        // LICENCIA DISCAPACITADOS 2 AÑOS
        }else if(cbxVigencia.getSelectedIndex() == 2 && 
                cbxTipo.getSelectedIndex() == 2) {
            txtPrecio.setText("500");
        // LICENCIA DISCAPACITADOS 3 AÑOS
        }else if(cbxVigencia.getSelectedIndex() == 3 && 
                cbxTipo.getSelectedIndex() == 2) {
            txtPrecio.setText("700");
        }
        // PLACA AUTO NUEVO
        if(tipo == ConstantesGUI.PLACA_NUEVO) {
            txtCosto.setText("1500");
        // PLACA AUTO USADO
        }else if(tipo == ConstantesGUI.PLACA_USADO) {
            txtCosto.setText("1000");
        }
    }

    /**
     * Método para centrar la ventana en el frame
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
     * Método para setear el tipo de Trámite a realizar
     * @param tipo 
     */
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

        cbxCliente.setMaximumRowCount(personas.getSize());
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

        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieKeyPressed(evt);
            }
        });

        txtMarca.setEditable(false);

        txtLinea.setEditable(false);

        txtColor.setEditable(false);

        txtModelo.setEditable(false);

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
        if(txtSerie.isEditable()) {
            dispose();
        }else{
            setTipo(ConstantesGUI.PLACA);
            txtSerie.setEditable(true);
            txtSerie.setText("");
            txtMarca.setText("");
            txtLinea.setText("");
            txtColor.setText("");
            txtModelo.setText("");
            txtCosto.setText("");
            txtMarca.setEditable(false);
            txtLinea.setEditable(false);
            txtColor.setEditable(false);
            txtModelo.setEditable(false);
            cbxCliente.setSelectedIndex(0);
            btnCancelar.setText("Cancelar");
            btnTramitar.setText("Buscar");
            btnRestaurar.setVisible(true);
        }
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
        // TRAMITAR LICENCIAS
        if(tipo == ConstantesGUI.LICENCIA && !(cbxVigencia.getSelectedIndex() 
                == 0 && cbxTipo.getSelectedIndex() == 0)){
            Persona persona = (Persona) cbxCliente.getSelectedItem();
            if(c.verificarLicenciaPersona(persona)) {
                Calendar fechaExpedicion = new GregorianCalendar();
                Integer aniosVigencia = 
                        (Integer) cbxVigencia.getSelectedIndex();
                Integer costo = Integer.parseInt(txtPrecio.getText());
                String tipoLicencia = (String) cbxTipo.getSelectedItem();
                Pago pago = new Pago("Tarjeta", 
                        "Compra de una licencia", costo, 
                        fechaExpedicion, persona);
                em.getTransaction().begin();
                em.persist(pago);
                em.persist(new Licencia(fechaExpedicion, aniosVigencia, costo, 
                        tipoLicencia, persona, pago));
                em.getTransaction().commit();
                respuesta.delete(0, respuesta.length());
                respuesta.append(ConstantesGUI.ACEPTAR);
                dispose(); 
            }else{}
        }
        // TRAMITAR PLACAS PARA AUTOS NUEVOS
        if(tipo == ConstantesGUI.PLACA_NUEVO) {
            String identificador = c.generarIdentificadorPlaca();
            Calendar fechaEmision = new GregorianCalendar();
            String numeroSerie = txtSerie.getText().toUpperCase();
            String marca = txtMarca.getText();
            String linea = txtLinea.getText();
            String color = txtColor.getText();
            Integer modelo = Integer.parseInt(txtModelo.getText());
            Integer costo = Integer.parseInt(txtCosto.getText());
            Persona persona = (Persona) cbxCliente.getSelectedItem();
            Vehiculo vehiculo = new Vehiculo(numeroSerie, marca, linea, color, 
                    modelo);
            Pago pago = new Pago("Tarjeta", 
                    "Compra de una placa para auto nuevo", 
                    costo, new GregorianCalendar(), persona);
            em.getTransaction().begin();
            em.persist(vehiculo);
            em.persist(pago);
            em.persist(new Placa(identificador, fechaEmision, costo, vehiculo, 
                    persona, pago));
            em.getTransaction().commit();
            respuesta.delete(0, respuesta.length());
            respuesta.append(ConstantesGUI.ACEPTAR);
            dispose();
        }
        // TRAMITAR PLACAS PARA AUTOS USADOS
        if(tipo == ConstantesGUI.PLACA_USADO) {
            String identificador = c.generarIdentificadorPlaca();
            Calendar fechaEmision = new GregorianCalendar();
            Calendar fechaRecepcion = new GregorianCalendar();
            String numeroSerie = txtSerie.getText().toUpperCase();
            String marca = txtMarca.getText();
            String linea = txtLinea.getText();
            String color = txtColor.getText();
            Integer modelo = Integer.parseInt(txtModelo.getText());
            Integer costo = Integer.parseInt(txtCosto.getText());
            Persona persona = (Persona) cbxCliente.getSelectedItem();
            Vehiculo_Usado vehiculo = new Vehiculo_Usado(numeroSerie, marca, 
                    linea, color, modelo);
            Pago pago = new Pago("Tarjeta", 
                    "Compra de una nueva placa para auto usado", 
                    costo, new GregorianCalendar(), persona);
            em.getTransaction().begin();
            em.persist(vehiculo);
            em.persist(pago);
            em.persist(new Placa(identificador, fechaEmision, fechaRecepcion, 
                    costo, vehiculo, persona, pago));
            em.getTransaction().commit();
            respuesta.delete(0, respuesta.length());
            respuesta.append(ConstantesGUI.ACEPTAR);
            dispose();
        }
        if(tipo == ConstantesGUI.PLACA) {
            serie = txtSerie.getText().toUpperCase();
            if(!"".equals(serie)) {
                vehiculos = c.buscarVehiculo(serie, (Persona) cbxCliente.getSelectedItem());
                if(vehiculos == null) { 
                }else{
                    if(vehiculos.isEmpty()){
                        setTipo(ConstantesGUI.PLACA_NUEVO);
                        txtSerie.setText(serie);
                        txtMarca.setEditable(true);
                        txtLinea.setEditable(true);
                        txtColor.setEditable(true);
                        txtModelo.setEditable(true);
                        txtSerie.setEditable(false);
                        btnCancelar.setText("Volver");
                        definirPrecio();
                    }else{
                        setTipo(ConstantesGUI.PLACA_USADO);
                        txtSerie.setText(serie);
                        txtSerie.setEditable(false);
                        btnCancelar.setText("Volver");
                        definirPrecio();
                    }
                    btnTramitar.setText("Trámitar");
                }
            }
        }
        // ELIMINAR VEHICULO CON PLACA EN USO
        if(tipo == ConstantesGUI.PLACA_USADO) {
            Vehiculo v = vehiculos.get(vehiculos.size()-1);
            txtMarca.setText(v.getMarca());
            txtMarca.setEditable(false);
            txtLinea.setText(v.getLinea());
            txtLinea.setEditable(false);
            txtColor.setText(v.getColor());
            txtColor.setEditable(false);
            txtModelo.setText(String.valueOf(v.getModelo()));
            txtModelo.setEditable(false);
            btnRestaurar.setVisible(false);
        }
    }//GEN-LAST:event_btnTramitarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        if(tipo == ConstantesGUI.LICENCIA) {
            cbxCliente.setSelectedIndex(0);
            cbxVigencia.setSelectedIndex(0);
            cbxTipo.setSelectedIndex(0);
        }
        if(tipo == ConstantesGUI.PLACA) {
            cbxCliente.setSelectedIndex(0);
            txtSerie.setText("");
            txtMarca.setText("");
            txtLinea.setText("");
            txtColor.setText("");
            txtModelo.setText("");
            txtCosto.setText("");
        }
        if(tipo == ConstantesGUI.PLACA_NUEVO) {
            txtMarca.setText("");
            txtLinea.setText("");
            txtColor.setText("");
            txtModelo.setText("");
        }
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent av = null;
            btnTramitarActionPerformed(av);
        }
    }//GEN-LAST:event_txtSerieKeyPressed

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
