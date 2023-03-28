/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Persona;

/**
 * @author Victor y Samuel
 */
public class AgenciaTransito {
    public static void main(String[] args) {
        //ENTITY MANAGER
        EntityManagerFactory emFactory = 
                Persistence.createEntityManagerFactory
                    ("org.itson_AgenciaTransito");
        EntityManager em = emFactory.createEntityManager();
        //CREACIÓN OBJETO PERSONA
        Persona persona = new Persona(
                "ABC 680524 P-76", 
                "Manuel Pereira Ortiz", 
                new GregorianCalendar(2013, 
                        Calendar.SEPTEMBER,31), 
                "6442356743");
        //INICIO DE LA TRANSACCIÓN
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }
}