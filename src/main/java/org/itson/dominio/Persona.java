/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Victor y Samuel
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "rfc", nullable = false, length = 20)
    private String rfc;
    
    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaNacimiento;
    
    @Column(name = "curp", nullable = true, length = 20)
    private String curp;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pagos_realizados", nullable = true)
    private List<Pago> pagos;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tramites_realizados", nullable = true)
    private List<Tramite> tramites;
    
    //CONSTRUCTORES
    
    /**
     * Constructor por defecto
     */
    public Persona() {
    }
    /**
     * Constructor que inicializa los atributos requeridos para
     * realizar el trámite de una licencia
     * @param rfc RFC de la persona
     * @param nombreCompleto Nombre completo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona 
     * en formato dd/mm/yy
     * @param telefono Teléfono de la persona
     */
    public Persona(String rfc, String nombreCompleto, Calendar fechaNacimiento, 
            String telefono) {
        this.rfc = rfc;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }
    /**
     * Constructor que inicializa los atributos de la Persona, incluyendo
     * la curp
     * @param rfc RFC de la persona
     * @param nombreCompleto Nombre completo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona 
     * en formato dd/mm/yy
     * @param curp CURP de la persona
     * @param telefono Teléfono de la persona
     */
    public Persona(String rfc, String nombreCompleto, Calendar fechaNacimiento, 
            String curp, String telefono) {
        this.rfc = rfc;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.telefono = telefono;
    }
    /**
     * Consturctor que inicializa los atributos de la clase, exceptuando la id
     * @param rfc RFC de la persona
     * @param nombreCompleto Nombre completo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona 
     * en formato dd/mm/yy
     * @param curp CURP de la persona
     * @param telefono Teléfono de la persona
     * @param pagos Pagos realizados por la persona
     * @param tramites Lista de tramites realizados por la persona
     */
    public Persona(String rfc, String nombreCompleto, Calendar fechaNacimiento, String curp, String telefono, List<Pago> pagos, List<Tramite> tramites) {    
        this.rfc = rfc;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.telefono = telefono;
        this.pagos = pagos;
        this.tramites = tramites;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id Identificador de la clase
     * @param rfc RFC de la persona
     * @param nombreCompleto Nombre completo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona 
     * en formato dd/mm/yy
     * @param curp CURP de la persona
     * @param telefono Teléfono de la persona
     * @param pagos Pagos realizados por la persona
     * @param tramites Lista de tramites realizados por la persona
     */
    public Persona(Long id, String rfc, String nombreCompleto, Calendar fechaNacimiento, String curp, String telefono, List<Pago> pagos, List<Tramite> tramites) {
        this.id = id;
        this.rfc = rfc;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.telefono = telefono;
        this.pagos = pagos;
        this.tramites = tramites;
    }

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getCurp() {
        return curp;
    }
    public void setCurp(String curp) {
        this.curp = curp;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public List<Pago> getPagos() {
        return pagos;
    }
    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
    public List<Tramite> getTramites() {
        return tramites;
    }
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
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
     * @return True si el objeto es de tipo Persona, false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Método toString
     * @return Una cadena con los atributos de la persona
     */
    @Override
    public String toString() {
        return nombreCompleto;
    }
}