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
@Table(name = "pagos")
public class Pago implements Serializable {
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "tipo_pago", nullable = false)
    private String tipoPago;
    
    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;
    
    @Column(name = "costo_total", nullable = false)
    private Integer costoTotal;
    
    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaPago;
    
    @Column(name = "id_persona", nullable = false)
    private Persona persona;
    
    //CONSTRUCTORES

    /**
     * Constructor por defecto
     */
    public Pago() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando el
     * identificador
     * @param tipoPago Tipo de pago que se desea realizar
     * @param descripcion Descripción a detalle del pago realizado
     * @param costoTotal Costo total del pago a realizar
     * @param fechaPago Fecha en la que se realizó el pago
     * @param persona Persona que realizó el pago
     */
    public Pago(String tipoPago, String descripcion, Integer costoTotal, 
            Calendar fechaPago, Persona persona) {
        this.tipoPago = tipoPago;
        this.descripcion = descripcion;
        this.costoTotal = costoTotal;
        this.fechaPago = fechaPago;
        this.persona = persona;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id Identificador de la clase
     * @param tipoPago Tipo de pago que se desea realizar
     * @param descripcion Descripción a detalle del pago realizado
     * @param costoTotal Costo total del pago a realizar
     * @param fechaPago Fecha en la que se realizó el pago
     * @param persona Persona que realizó el pago
     */
    public Pago(Long id, String tipoPago, String descripcion, 
            Integer costoTotal, Calendar fechaPago, Persona persona) {
        this.id = id;
        this.tipoPago = tipoPago;
        this.descripcion = descripcion;
        this.costoTotal = costoTotal;
        this.fechaPago = fechaPago;
        this.persona = persona;
    }
    
    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipoPago() {
        return tipoPago;
    }
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getCostoTotal() {
        return costoTotal;
    }
    public void setCostoTotal(Integer costoTotal) {
        this.costoTotal = costoTotal;
    }
    public Calendar getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(Calendar fechaPago) {
        this.fechaPago = fechaPago;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
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
     * @return True si el objeto es de tipo Pago, false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Método toString
     * @return Una cadena con los atributos del pago
     */ 
    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", tipoPago=" + tipoPago + ", descripcion=" + descripcion + ", costoTotal=" + costoTotal + ", fechaPago=" + fechaPago + ", persona=" + persona + '}';
    }    
}