/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Victor y Samuel
 */
@Entity
@Table(name = "licencias")
public class Licencia implements Serializable {
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaExpedicion;
    
    @Column(name = "años_vigencia", nullable = false)
    private Integer añosVigencia;
    
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
     * Constructor que inicializa los atributos de la clase sin identificador
     * @param fechaExpedicion Fecha en la que se expidió el trámite
     * @param añosVigencia Años vigentes de la licencia
     * @param costo Costo equivalente a los años y el tipo de licencia
     * @param tipoLicencia Tipo de licencia, sea normal o para discapacitados
     */
    public Licencia(Calendar fechaExpedicion, Integer añosVigencia, 
            Integer costo, String tipoLicencia) {
        this.fechaExpedicion = fechaExpedicion;
        this.añosVigencia = añosVigencia;
        this.costo = costo;
        this.tipoLicencia = tipoLicencia;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id
     * @param fechaExpedicion
     * @param añosVigencia
     * @param costo
     * @param tipoLicencia
     */
    public Licencia(Long id, Calendar fechaExpedicion, Integer añosVigencia, 
            Integer costo, String tipoLicencia) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.añosVigencia = añosVigencia;
        this.costo = costo;
        this.tipoLicencia = tipoLicencia;
    }
    
    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    public Integer getAñosVigencia() {
        return añosVigencia;
    }
    public void setAñosVigencia(Integer añosVigencia) {
        this.añosVigencia = añosVigencia;
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
     * Método hashCode
     * @return Un hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    /**
     * Método equals
     * @param object Objeto a comparar
     * @return True si el objeto es de tipo Licencia, false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Método toString
     * @return Una cadena con los atributos de la licencia
     */ 
    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", fechaExpedicion=" + fechaExpedicion + ", a\u00f1osVigencia=" + añosVigencia + ", costo=" + costo + ", tipoLicencia=" + tipoLicencia + '}';
    }
}