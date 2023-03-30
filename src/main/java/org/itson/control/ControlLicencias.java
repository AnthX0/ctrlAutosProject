/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;

/**
 * @author Victor y Samuel
 */
public class ControlLicencias {
    //ATRIBUTOS
    Scanner tec = new Scanner(System.in);
    EntityManagerFactory emFactory = 
        Persistence.createEntityManagerFactory
                ("org.itson_AgenciaTransito");
    EntityManager em = emFactory.createEntityManager();
    
    //MÉTODOS
    
    public void solicitarLicencia(Persona persona){
        Licencia licencia = new Licencia();
        licencia.setId(1L);
        String op;
        System.out.println("¿Desea tramitar una licencia? y/n");
        op = tec.nextLine();
        while (op.equals("y")){
            System.out.println("Indique el tipo de licencia");
            String tipo = tec.nextLine();
            if (tipo.equals("normal")){
                licencia.setTipoLicencia(tipo);
                licencia.setFechaExpedicion(new GregorianCalendar());
                System.out.println("Indique la vigencia");
                int vigN = tec.nextInt();
                licencia.setAñosVigencia(vigN);
                switch(vigN){
                    case 1 : licencia.setCosto(600);
                    case 2 : licencia.setCosto(900);
                    case 3 : licencia.setCosto(1100);
                }
            } else if (tipo.equals("discapacitado")){
                licencia.setTipoLicencia(tipo);
                licencia.setFechaExpedicion(new GregorianCalendar());
                System.out.println("Indique la vigencia");
                int vigD = tec.nextInt();
                licencia.setAñosVigencia(vigD);
                switch(vigD){
                    case 1 : licencia.setCosto(200);
                    case 2 : licencia.setCosto(500);
                    case 3 : licencia.setCosto(700);
                }
            }
            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
        }
    }
}
