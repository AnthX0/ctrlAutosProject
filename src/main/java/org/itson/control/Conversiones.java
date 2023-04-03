/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Persona;

/**
 * @author Victor y Samuel
 */
public class Conversiones {
    //ATRIBUTOS
    
    private String nombresColumTablasPersonas[] = {"Id", "Nombre Completo", 
        "Fecha de Nacimiento", "CURP", "RFC", "Teléfono"};
    
    //MÉTODOS
    
    /**
     * Método que le da formato a la tabla con la lista de personas
     * @param personas
     * @return Una tabla con formato
     */
    public DefaultTableModel personasTableModel(List<Persona> personas) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        Object tabla[][];
        if(personas != null) {
            tabla = new Object[personas.size()][6];
            for(int i=0; i < personas.size(); i++) {
                Persona p = personas.get(i);
                tabla[i][0] = p.getId();
                tabla[i][1] = p.getNombreCompleto();
                tabla[i][2] = sdf.format(p.getFechaNacimiento().getTime());
                tabla[i][3] = p.getCurp();
                tabla[i][4] = p.getRfc();
                tabla[i][5] = p.getTelefono();
            }
            return new DefaultTableModel(tabla, nombresColumTablasPersonas);
        }
        return null;
    }
    
    /**
     * Método que le da formato al combobox de Cliente
     * @param personas Lista de personas a escoger
     * @return Un combobox con la lista de personas
     */
    public DefaultComboBoxModel<Persona> ComboBoxPersonas(List<Persona> personas) {
        DefaultComboBoxModel<Persona> cbx = new DefaultComboBoxModel<>();
        if(personas != null) {
            for(int i=0; i < personas.size(); i++) {
                cbx.addElement(personas.get(i));
            }
            return cbx;
        }
        return null;
    }
}