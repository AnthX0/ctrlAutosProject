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
@Table(name = "placas")
public class Placa implements Serializable {
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "identificador", nullable = false)
    private String identificador;
    
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaEmision;
    
    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaRecepcion;
    
    @Column(name = "costo", nullable = false)
    private Integer costo;
    
    @Column(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;
    
    //CONSTRUCTORES
    
    /**
     * Constructor por defecto
     */
    public Placa() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando
     * la id
     * @param identificador Cadena que identifica al vehículo : AAA-111
     * @param fechaEmision Fecha en la que se emitió el trámite. 
     * Generada automáticamente al realizarse
     * @param fechaRecepcion Fecha en la que se cambian las placas del vehículo
     * @param costo Costo del trámite
     * @param vehiculo Vehículo al cual se le pondrán las placas
     */
    public Placa(String identificador, Calendar fechaEmision, 
            Calendar fechaRecepcion, Integer costo, Vehiculo vehiculo) {
        this.identificador = identificador;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costo = costo;
        this.vehiculo = vehiculo;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id Identificador de la clase
     * @param identificador Cadena que identifica al vehículo : AAA-111
     * @param fechaEmision Fecha en la que se emitió el trámite. 
     * Generada automáticamente al realizarse
     * @param fechaRecepcion Fecha en la que se cambian las placas del vehículo
     * @param costo Costo del trámite
     * @param vehiculo Vehículo al cual se le pondrán las placas
     */
    public Placa(Long id, String identificador, Calendar fechaEmision, 
            Calendar fechaRecepcion, Integer costo, Vehiculo vehiculo) {
        this.id = id;
        this.identificador = identificador;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costo = costo;
        this.vehiculo = vehiculo;
    }
    
    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public Calendar getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
    public Integer getCosto() {
        return costo;
    }
    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
     * @return True si el objeto es de tipo Placa, false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Método toString
     * @return Una cadena con los atributos de la placa
     */
    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", identificador=" + identificador + ", fechaEmision=" + fechaEmision + ", fechaRecepcion=" + fechaRecepcion + ", costo=" + costo + ", vehiculo=" + vehiculo + '}';
    }
}