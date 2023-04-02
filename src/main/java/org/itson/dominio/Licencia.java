/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Victor y Samuel
 */
@Entity
@Table(name = "licencias")
public class Licencia extends Tramite implements Serializable {
    //ATRIBUTOS
    
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaExpedicion;
    
    @Column(name = "años_vigencia", nullable = false)
    private Integer aniosVigencia;
    
    @Column(name = "costo", nullable = false)
    private Integer costo;
    
    @Column(name = "tipo_licencia", nullable = false)
    private String tipoLicencia;
    
    //CONSTRUCTORES

    /**
     * Constructor por defecto
     */
    public Licencia() {
    }
    /**
     * Constructor que inicializa los atributos de la clase sin id
     * @param fechaExpedicion Fecha en la que se expidió el trámite
     * @param aniosVigencia Años vigentes de la licencia
     * @param costo Costo equivalente a los años y el tipo de licencia
     * @param tipoLicencia Tipo de licencia, sea normal o para discapacitados
     */
    public Licencia(Calendar fechaExpedicion, Integer aniosVigencia, 
            Integer costo, String tipoLicencia) {
        this.fechaExpedicion = fechaExpedicion;
        this.aniosVigencia = aniosVigencia;
        this.costo = costo;
        this.tipoLicencia = tipoLicencia;
    }
    /**
     * Constructor que inicializa los atributos de la clase, al igual que
     * los atributos de la clase padre Tramite, exceptuando la id
     * @param fechaExpedicion Fecha en la que se expidió el trámite
     * @param aniosVigencia Años vigentes de la licencia
     * @param costo Costo equivalente a los años y el tipo de licencia
     * @param tipoLicencia Tipo de licencia, sea normal o para discapacitados
     * @param persona Persona que realizó el trámite
     * @param pago Pago que pertenece al trámite
     */
    public Licencia(Calendar fechaExpedicion, Integer aniosVigencia, 
            Integer costo, String tipoLicencia, Persona persona, Pago pago) {
        super(persona, pago);
        this.fechaExpedicion = fechaExpedicion;
        this.aniosVigencia = aniosVigencia;
        this.costo = costo;
        this.tipoLicencia = tipoLicencia;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase, incluyendo
     * la clase padre Tramite
     * @param fechaExpedicion Fecha en la que se expidió el trámite
     * @param aniosVigencia Años vigentes de la licencia
     * @param costo Costo equivalente a los años y el tipo de licencia
     * @param tipoLicencia Tipo de licencia, sea normal o para discapacitados
     * @param id Identificador de la clase
     * @param persona Persona que realizó el trámite
     * @param pago Pago que pertenece al trámite
     */
    public Licencia(Calendar fechaExpedicion, Integer aniosVigencia, 
            Integer costo, String tipoLicencia, Long id, Persona persona, 
            Pago pago) {
        super(id, persona, pago);
        this.fechaExpedicion = fechaExpedicion;
        this.aniosVigencia = aniosVigencia;
        this.costo = costo;
        this.tipoLicencia = tipoLicencia;
    }

    //GETTERS Y SETTERS

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    public Integer getAñosVigencia() {
        return aniosVigencia;
    }
    public void setAñosVigencia(Integer aniosVigencia) {
        this.aniosVigencia = aniosVigencia;
    }
    public Integer getCosto() {
        return costo;
    }
    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    public String getTipoLicencia() {
        return tipoLicencia;
    }
    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }
    
    //MÉTODOS DE CONSTRUCCIÓN
    
    /**
     * Método toString
     * @return Una cadena con los atributos del trámite de licencia
     */
    @Override
    public String toString() {
        return "Licencia{" + "fechaExpedicion=" + fechaExpedicion + ", aniosVigencia=" + aniosVigencia + ", costo=" + costo + ", tipoLicencia=" + tipoLicencia + '}';
    } 
}