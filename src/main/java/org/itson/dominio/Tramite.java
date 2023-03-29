/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Victor y Samuel
 */
@Entity
@Table(name = "tramites")
public class Tramite implements Serializable {
    //ATRIBUTOS 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;
    
    //CONSTRUCTORES

    /**
     * Constructor por default
     */
    public Tramite() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando
     * el identificador
     * @param persona Persona que realizó el trámite
     * @param pago Pago que pertenece al trámite
     */
    public Tramite(Persona persona, Pago pago) {
        this.persona = persona;
        this.pago = pago;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id Identificador de la clase
     * @param persona Persona que realizó el trámite
     * @param pago Pago que pertenece al trámite
     */
    public Tramite(Long id, Persona persona, Pago pago) {
        this.id = id;
        this.persona = persona;
        this.pago = pago;
    }
    
    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Pago getPago() {
        return pago;
    }
    public void setPago(Pago pago) {
        this.pago = pago;
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
     * @return True si el objeto es de tipo Trámite, false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Método toString
     * @return Una cadena con los atributos del trámite
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", persona=" + persona + ", pago=" + pago + '}';
    }   
}