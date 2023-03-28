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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @Column(name = "curp", nullable = true, length = 20)
    private String curp;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, 
        CascadeType.REMOVE})
    @Column(name = "licencias", nullable = true)
    private List<Licencia> licencias;
    
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
     * Constructor que inicializa los atributos de la Persona, incluyendo
     * la curp y las licencias
     * @param rfc RFC de la persona
     * @param nombreCompleto Nombre completo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona 
     * en formato dd/mm/yy
     * @param curp CURP de la persona
     * @param telefono Teléfono de la persona
     * @param licencias Lista de las licencias que tiene la persona
     */
    public Persona(String rfc, String nombreCompleto, Calendar fechaNacimiento, 
            String curp, String telefono, List<Licencia> licencias) {
        this.rfc = rfc;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.telefono = telefono;
        this.licencias = licencias;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id Identificador de la persona
     * @param rfc RFC de la persona
     * @param nombreCompleto Nombre completo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona 
     * en formato dd/mm/yy
     * @param curp CURP de la persona
     * @param telefono Teléfono de la persona
     * @param licencias Lista de las licencias que tiene la persona
     */
    public Persona(Long id, String rfc, String nombreCompleto, Calendar fechaNacimiento, String curp, String telefono, List<Licencia> licencias) {    
        this.id = id;
        this.rfc = rfc;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.telefono = telefono;
        this.licencias = licencias;
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
    public List<Licencia> getLicencias() {
        return licencias;
    }
    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
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
        return "Persona{" + "id=" + id + ", rfc=" + rfc + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", curp=" + curp + ", telefono=" + telefono + ", licencias=" + licencias + '}';
    }
}