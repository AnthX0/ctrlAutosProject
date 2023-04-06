/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
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

/**
 * @author Victor y Samuel
 */
@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numero_serie", nullable = false, length = 20)
    private String numeroSerie;
    
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;
    
    @Column(name = "linea", nullable = false, length = 50)
    private String linea;
    
    @Column(name = "color", nullable = false, length = 50)
    private String color;
    
    @Column(name = "modelo", nullable = false)
    private Integer modelo;
    
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "placas_usadas", nullable = true)
    private List<Placa> placas;
    
    //CONSTRUCTORES

    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }
    /**
     * Constructor que inicializa los atributos de la clase 
     * sin el identificador ni las placas que ha tenido
     * @param numeroSerie Número de serie del vehículo : ABC-123
     * @param marca Marca del vehículo
     * @param linea Linea del vehículo
     * @param color Color del vehículo
     * @param modelo Año/Modelo del vehículo
     */
    public Vehiculo(String numeroSerie, String marca, String linea,
            String color, Integer modelo) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
    }
    /**
     * Constructor que inicializa los atributos de la clase 
     * sin el identificador
     * @param numeroSerie Número de serie del vehículo : ABC-123
     * @param marca Marca del vehículo
     * @param linea Linea del vehículo
     * @param color Color del vehículo
     * @param modelo Año/Modelo del vehículo
     * @param placas Placas que ha tenido el vehículo
     */
    public Vehiculo(String numeroSerie, String marca, String linea, String color, Integer modelo, List<Placa> placas) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.placas = placas;
    }
    /**
     * Constructor que inicializa TODOS los atributos de la clase
     * @param id Identificador del vehículo
     * @param numeroSerie Número de serie del vehículo : ABC-123
     * @param marca Marca del vehículo
     * @param linea Linea del vehículo
     * @param color Color del vehículo
     * @param modelo Año/Modelo del vehículo
     * @param placas Placas que ha tenido el vehículo
     */
    public Vehiculo(Long id, String numeroSerie, String marca, String linea, String color, Integer modelo, List<Placa> placas) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.placas = placas;
    }

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getLinea() {
        return linea;
    }
    public void setLinea(String linea) {
        this.linea = linea;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getModelo() {
        return modelo;
    }
    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }
    public List<Placa> getPlacas() {
        return placas;
    }
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
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
     * @return True si el objeto es de tipo Vehículo, false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Método toString
     * @return Una cadena con los atributos del vehículo
     */
    @Override
    public String toString() {
        return marca + ", " + linea + ", " + color;
    }
}