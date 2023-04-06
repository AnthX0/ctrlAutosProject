/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "vehiculos_usados")
public class Vehiculo_Usado extends Vehiculo implements Serializable {   

    public Vehiculo_Usado() {}

    public Vehiculo_Usado(String numeroSerie, String marca, String linea, String color, Integer modelo) {
        super(numeroSerie, marca, linea, color, modelo);
    }

    public Vehiculo_Usado(Vehiculo vehiculo) {
        super(vehiculo.getNumeroSerie(), vehiculo.getMarca(), vehiculo.getLinea(), vehiculo.getColor(), vehiculo.getModelo());
    }

}
