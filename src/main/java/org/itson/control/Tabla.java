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
    //ATRIBUTOS
    
    private DefaultTableModel modeloTabla;
    
    //CONSTRUCTORES
    
    /**
     * Constructor por default
     */
    public Tabla() {}

    /**
     * Constructor que inicializa los atributos de la clase
     * @param tabla Modelo de la tabla
     */
    public Tabla(DefaultTableModel tabla) {
        this.modeloTabla = tabla;
    }
    
    //GETTERS Y SETTERS

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    public void setModeloTabla(DefaultTableModel tabla) {
        this.modeloTabla = tabla;
    }
}