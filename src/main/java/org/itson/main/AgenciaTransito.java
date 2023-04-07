/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.presentacion.Principal;

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
        
        //PANTALLA PRINCIPAL
        Principal p = new Principal();
        p.setVisible(true);
    }
}