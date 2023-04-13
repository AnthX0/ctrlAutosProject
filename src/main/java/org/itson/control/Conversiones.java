/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;

/**
 * @author Victor y Samuel
 */
public class Conversiones {
    //ATRIBUTOS
    
    private String nombresColumTablasPersonas[] = {"Id", "Nombre Completo", 
        "Fecha de Nacimiento", "CURP", "RFC", "Teléfono"};
    
    private String nombresColumTablasLicencias[] = {"Id", "Nombre Completo", 
        "Tipo de Licencia", "Fecha de Expedición", 
        "Años de Vigencia", "Costo"};
    
    private String nombresColumTablasPlacas[] = {"Id", "Nombre Completo", 
        "Id del Vehículo", "Identificador", "Fecha de Emisión", 
        "Fecha de Recepción", "Costo"};
    
    private String nombresColumTablasHistorial[] = {"Id", "Tipo de trámite", 
        "Fecha de trámite", "Costo"};
    
    private String nombresColumTablasReporte[] = {"Id", "Nombre completo", 
        "Tipo de trámite", "Fecha de trámite", "Costo"};
    
    //MÉTODOS
    
    /**
     * Método que le da formato a la tabla con la lista de personas
     * @param personas
     * @return Una tabla con formato
     */
    public DefaultTableModel personasTableModel(List<Persona> personas) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
            return new DefaultTableModel(tabla, 
                    nombresColumTablasPersonas);
        }
        return null;
    }
    
    /**
     * Método que le da formato al combobox de Cliente
     * @param personas Lista de personas a escoger
     * @return Un combobox con la lista de personas
     */
    public DefaultComboBoxModel<Persona> 
        ComboBoxPersonas(List<Persona> personas) {
        DefaultComboBoxModel<Persona> cbx = new DefaultComboBoxModel<>();
        if(personas != null) {
            for(int i=0; i < personas.size(); i++) {
                cbx.addElement(personas.get(i));
            }
            return cbx;
        }
        return null;
    }
    
    /**
     * Método que le da formato a una tabla de Licencias
     * @param licencias La lista de las licencias a formatear
     * @return Una tabla con columnas correspondientes a los datos de la cadena
     */
    public DefaultTableModel licenciasTableModel(List<Licencia> licencias) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Object tabla[][];
        if(licencias != null) {
            tabla = new Object[licencias.size()][5];
            for(int i=0; i < licencias.size(); i++) {
                Licencia l = licencias.get(i);
                tabla[i][0] = l.getPersona().getId();
                tabla[i][1] = l.getPersona().getNombreCompleto();
                tabla[i][2] = l.getTipoLicencia();
                tabla[i][3] = sdf.format(l.getFechaExpedicion().getTime());
                tabla[i][4] = l.getAniosVigencia();
                tabla[i][5] = l.getCosto();
            }
            return new DefaultTableModel(tabla, 
                    nombresColumTablasLicencias);
        }
        return null;
    }
    
    /**
     * Método que le da formato a una tabla de Placas
     * @param placas La lista de las placas a formatear
     * @return Una tabla con columnas correspondientes a los datos de la cadena
     */
    public DefaultTableModel placasTableModel(List<Placa> placas) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Object tabla[][];
        if(placas != null) {
            tabla = new Object[placas.size()][6];
            for(int i=0; i < placas.size(); i++) {
                Placa p = placas.get(i);
                tabla[i][0] = p.getPersona().getId();
                tabla[i][1] = p.getPersona().getNombreCompleto();
                tabla[i][2] = p.getVehiculo().toString();
                tabla[i][3] = p.getIdentificador();
                tabla[i][4] = sdf.format(p.getFechaEmision().getTime());
                if(p.getFechaRecepcion() != null) {
                    tabla[i][5] = sdf.format(p.getFechaRecepcion().getTime());
                }else{
                    tabla[i][5] = "";
                }
                tabla[i][6] = p.getCosto();
            }
            return new DefaultTableModel(tabla, 
                    nombresColumTablasPlacas);
        }
        return null;
    }

    /**
     * Método que le da formato a la tabla del historial
     * @param tramites La lista de los trámites a formatear
     * @return Una tabla del historial de alguna persona
     */
    public DefaultTableModel historialTableModel(List<Tramite> tramites) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String licencia = "Licencia";
        String placa = "Placa";
        Object tabla[][];
        if(tramites != null) {
            tabla = new Object[tramites.size()][5];
            for(int i=0; i < tramites.size(); i++) {
                Tramite t = tramites.get(i);
                tabla[i][0] = t.getId();
                if("Compra de una licencia".equals(t.getPago().getDescripcion())) {
                    tabla[i][1] = licencia;
                }else if("Compra de una placa para auto nuevo".equals(t.getPago().getDescripcion()) 
                        || "Compra de una nueva placa para auto usado".equals(t.getPago().getDescripcion())) {
                    tabla[i][1] = placa;
                }
                tabla[i][2] = sdf.format(t.getPago().getFechaPago().getTime());
                tabla[i][3] = t.getPago().getCostoTotal();
            }
            return new DefaultTableModel(tabla, 
                    nombresColumTablasHistorial);
        }
        return null;
    }
    
    public DefaultTableModel reporteTableModel(List<Tramite> tramites) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String licencia = "Licencia";
        String placa = "Placa";
        Object tabla[][];
        if(tramites != null) {
            tabla = new Object[tramites.size()][5];
            for(int i=0; i < tramites.size(); i++) {
                Tramite t = tramites.get(i);
                tabla[i][0] = t.getId();
                tabla[i][1] = t.getPersona().getNombreCompleto();
                if("Compra de una licencia".equals(t.getPago().getDescripcion())) {
                    tabla[i][2] = licencia;
                }else if("Compra de una placa para auto nuevo".equals(t.getPago().getDescripcion()) 
                        || "Compra de una nueva placa para auto usado".equals(t.getPago().getDescripcion())) {
                    tabla[i][2] = placa;
                }
                tabla[i][3] = sdf.format(t.getPago().getFechaPago().getTime());
                tabla[i][4] = t.getPago().getCostoTotal();
            }
            return new DefaultTableModel(tabla, 
                    nombresColumTablasReporte);
        }
        return null;
    }
}