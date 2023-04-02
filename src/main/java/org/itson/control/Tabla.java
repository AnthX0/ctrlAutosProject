/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import javax.swing.table.DefaultTableModel;

/**
 * @author Victor y Samuel
 */
public class Tabla {
    private DefaultTableModel modeloTabla;

    public Tabla() {}

    public Tabla(DefaultTableModel tabla) {
        this.modeloTabla = tabla;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel tabla) {
        this.modeloTabla = tabla;
    }

}
