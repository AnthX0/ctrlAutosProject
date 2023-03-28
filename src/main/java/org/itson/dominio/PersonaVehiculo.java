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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Victor y Samuel
 */
@Entity
@Table(name = "persona_vehiculo")
public class PersonaVehiculo implements Serializable {
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne()
    @Column(name = "id_persona", nullable = false) //LLAVE FORÁNEA
    private Persona persona;
    
    @ManyToOne()
    @Column(name = "id_vehiculo", nullable = false) //LLAVE FORÁNEA
    private Vehiculo vehiculo;
    
    @Column(name = "fecha_adquisicion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaAdquisicion;

    //CONSTRUCTORES

    /**
     * Constructor por defecto
     */
    public PersonaVehiculo() {
    }
    /**
     * Constructor que inicializa los atributos de la clase sin identificador
     * @param persona Persona a la que pertenece el vehículo
     * @param vehiculo Vehículo el cual pertenece a la Persona
     * @param fechaAdquisicion Fecha en la que se adquirió el vehículo
     */
    public PersonaVehiculo(Persona persona, Vehiculo vehiculo, 
            Calendar fechaAdquisicion) {
        this.persona = persona;
        this.vehiculo = vehiculo;
        this.fechaAdquisicion = fechaAdquisicion;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id Identificador de la clase
     * @param persona Persona a la que pertenece el vehículo
     * @param vehiculo Vehículo el cual pertenece a la Persona
     * @param fechaAdquisicion Fecha en la que se adquirió el vehículo
     */
    public PersonaVehiculo(Long id, Persona persona, Vehiculo vehiculo, 
            Calendar fechaAdquisicion) {
        this.id = id;
        this.persona = persona;
        this.vehiculo = vehiculo;
        this.fechaAdquisicion = fechaAdquisicion;
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
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Calendar getFechaAdquisicion() {
        return fechaAdquisicion;
    }
    public void setFechaAdquisicion(Calendar fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
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
     * @return True si el objeto es de tipo Persona_Vehículo, 
     * false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaVehiculo)) {
            return false;
        }
        PersonaVehiculo other = (PersonaVehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Método toString
     * @return Una cadena con los atributos de la persona y el vehículo
     */
    @Override
    public String toString() {
        return "PersonaVehiculo{" + "id=" + id + ", persona=" + persona + ", vehiculo=" + vehiculo + ", fechaAdquisicion=" + fechaAdquisicion + '}';
    } 
}