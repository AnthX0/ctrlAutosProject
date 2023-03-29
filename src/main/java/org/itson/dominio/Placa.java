/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Victor y Samuel
 */
@Entity
@Table(name = "placas")
public class Placa extends Tramite implements Serializable {
    //ATRIBUTOS
    
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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vehiculo", nullable = false)
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
     * Constructor que inicializa los atributos de la clase, al igual que
     * los atributos de la clase padre Tramite, exceptuando la id
     * @param identificador Cadena que identifica al vehículo : AAA-111
     * @param fechaEmision Fecha en la que se emitió el trámite. 
     * Generada automáticamente al realizarse
     * @param fechaRecepcion Fecha en la que se cambian las placas del vehículo
     * @param costo Costo del trámite
     * @param vehiculo Vehículo al cual se le pondrán las placas
     * @param persona Persona que realizó el trámite
     * @param pago Pago que pertenece al trámite
     */
    public Placa(String identificador, Calendar fechaEmision, Calendar fechaRecepcion, Integer costo, Vehiculo vehiculo, Persona persona, Pago pago) {
        super(persona, pago);
        this.identificador = identificador;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costo = costo;
        this.vehiculo = vehiculo;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase, incluyendo
     * la clase padre Tramite
     * @param identificador Cadena que identifica al vehículo : AAA-111
     * @param fechaEmision Fecha en la que se emitió el trámite. 
     * Generada automáticamente al realizarse
     * @param fechaRecepcion Fecha en la que se cambian las placas del vehículo
     * @param costo Costo del trámite
     * @param vehiculo Vehículo al cual se le pondrán las placas
     * @param id Identificador de la clase
     * @param persona Persona que realizó el trámite
     * @param pago Pago que pertenece al trámite
     */
    public Placa(String identificador, Calendar fechaEmision, Calendar fechaRecepcion, Integer costo, Vehiculo vehiculo, Long id, Persona persona, Pago pago) {
        super(id, persona, pago);
        this.identificador = identificador;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costo = costo;
        this.vehiculo = vehiculo;
    }
    
    
    //GETTERS Y SETTERS

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
     * Método toString
     * @return Una cadena con los atributos de la placa
     */
    @Override
    public String toString() {
        return "Placa{" + "identificador=" + identificador + ", fechaEmision=" + fechaEmision + ", fechaRecepcion=" + fechaRecepcion + ", costo=" + costo + ", vehiculo=" + vehiculo + '}';
    }
}