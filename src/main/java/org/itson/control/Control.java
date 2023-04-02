/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.presentacion.ConstantesGUI;
import org.itson.presentacion.Tramites;

/**
 * @author Victor y Samuel
 */
public class Control {
    //ATRIBUTOS
    
    Conversiones c = new Conversiones();
    EntityManagerFactory emFactory = 
        Persistence.createEntityManagerFactory
                ("org.itson_AgenciaTransito");
    EntityManager em = emFactory.createEntityManager();
    
    //MÉTODOS
    
//    public void solicitarLicencia(Persona persona){
//        Licencia licencia = new Licencia();
//        licencia.setId(1L);
//        String op;
//        System.out.println("¿Desea tramitar una licencia? y/n");
//        op = tec.nextLine();
//        while (op.equals("y")){
//            System.out.println("Indique el tipo de licencia");
//            String tipo = tec.nextLine();
//            if (tipo.equals("normal")){
//                licencia.setTipoLicencia(tipo);
//                licencia.setFechaExpedicion(new GregorianCalendar());
//                System.out.println("Indique la vigencia");
//                int vigN = tec.nextInt();
//                licencia.setAñosVigencia(vigN);
//                switch(vigN){
//                    case 1 : licencia.setCosto(600);
//                    case 2 : licencia.setCosto(900);
//                    case 3 : licencia.setCosto(1100);
//                }
//            } else if (tipo.equals("discapacitado")){
//                licencia.setTipoLicencia(tipo);
//                licencia.setFechaExpedicion(new GregorianCalendar());
//                System.out.println("Indique la vigencia");
//                int vigD = tec.nextInt();
//                licencia.setAñosVigencia(vigD);
//                switch(vigD){
//                    case 1 : licencia.setCosto(200);
//                    case 2 : licencia.setCosto(500);
//                    case 3 : licencia.setCosto(700);
//                }
//            }
//            em.getTransaction().begin();
//            em.persist(licencia);
//            em.getTransaction().commit();
//        }
//    }

    /**
     * Este método solicita una licencia
     * @param frame Ventana
     */
    public void solicitarLicencia(JFrame frame) {
        Tramites tramites;
        StringBuffer respuesta = new StringBuffer("");
        Licencia licencia = null;
        DefaultComboBoxModel<Persona> personas = c.ComboBoxPersonas(getPersonas());
        
        tramites = new Tramites(frame, "Trámitar licencia", personas, licencia, ConstantesGUI.LICENCIA, respuesta);
        
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    
    public void solicitarPlacas(JFrame frame) {
        Tramites tramites;
        StringBuffer respuesta = new StringBuffer("");
        Licencia licencia = null;
        DefaultComboBoxModel<Persona> personas = c.ComboBoxPersonas(getPersonas());
        
        tramites = new Tramites(frame, "Trámitar placas", personas, licencia, ConstantesGUI.PLACA, respuesta);
    }
    
    /**
     * Este método inserta 20 personas en una sola interacción
     */
    public void insercionMasiva() {
        List<Persona> personas = getPersonas();
        
        if(personas == null) {
            em.getTransaction().begin();
            Persona p1 = new Persona("GUGE751125MRGRA0PTR2", "Ethan Gutierrez Mallorca", new GregorianCalendar(1975, Calendar.NOVEMBER, 25),"GUGE751125MRGRA0", "6448476525");
            Persona p2 = new Persona("MAPM800508PTMER4MNA1", "Magdiel Perez Martinez", new GregorianCalendar(1980, Calendar.MAY, 8), "MAPM800508PTMER4", "6444658475");
            Persona p3 = new Persona("ROGP010215JTAE25DAMP", "Pedro Gonzales Rosales", new GregorianCalendar(2001, Calendar.FEBRUARY, 15), "ROGP010215JTAE25", "6441584798");
            Persona p4 = new Persona("NOQM981020MPEOT15A3D", "Miguel Angel Quintero Nodal", new GregorianCalendar(1998, Calendar.OCTOBER, 20), "NOQM981020MPEO", "6444896478");
            Persona p5 = new Persona("PAVL701028PMEI04TR51", "Levi Vega Padilla", new GregorianCalendar(1970, Calendar.OCTOBER, 28), "PAVL701028PMEI04", "6449887441");
            Persona p6 = new Persona("QUSM000105PRTA3TRP11", "Magda Sevilla Quintanilla", new GregorianCalendar(2000, Calendar.JANUARY, 5), "QUSM000105PRTA3T", "6442547564");
            Persona p7 = new Persona("FIGK020430KITA54MARP", "Kimberly García Fierro", new GregorianCalendar(2002, Calendar.APRIL, 30), "FIGK020430KITA54", "6446548794");
            Persona p8 = new Persona("LUFM850819MARJA84RPT", "Manuel Figueroa Luna", new GregorianCalendar(1985, Calendar.AUGUST, 19), "LUFM850819MARJA8", "6444547865");
            Persona p9 = new Persona("ROFB900610LPAR45CPRE", "Brenda Fuentes Rojas", new GregorianCalendar(1990, Calendar.JUNE, 10), "ROFB900610LPAR45", "6442658745");
            Persona p10 = new Persona("VIHJ030330PMANU15PRM", "Judith Hernández Villegas", new GregorianCalendar(2003, Calendar.MARCH, 30), "VIHJ030330PMANU1", "6444587611");
            Persona p11 = new Persona("MOML000404LMNERA4578", "Laura María Montes Morales", new GregorianCalendar(2000, Calendar.APRIL, 4), "MOML000404LMNERA", "6442354798");
            Persona p12 = new Persona("MOVA040316PRGA78PO54", "Arturo Vega Morales", new GregorianCalendar(2004, Calendar.MARCH, 16), "MOVA040316PRGA78", "6442354798");
            Persona p13 = new Persona("ISMA010728MNRA8G45PA", "Andrea Minjarez Isordia", new GregorianCalendar(2001, Calendar.JULY, 28), "ISMA010728MNRA8G", "6444569874");
            Persona p14 = new Persona("FUMO920224YPJH78PRT0", "Oscar Meza Fuentes", new GregorianCalendar(1992, Calendar.FEBRUARY, 24), "FUMO920224YPJH78", "6444847624");
            Persona p15 = new Persona("MEGP950317LAKEM87MNR", "Paola García Mendes", new GregorianCalendar(1995, Calendar.MARCH, 17), "MEGP950317LAKEM8", "6442847654");
            Persona p16 = new Persona("GOVV001020MNTU876FDA", "Viviana Villegas Gomez", new GregorianCalendar(2000, Calendar.OCTOBER, 20), "GOVV001020MNTU87", "6441356478");
            Persona p17 = new Persona("FEMA970115PTREA84VD5", "Alan Montes Fernandez", new GregorianCalendar(1997, Calendar.JANUARY, 15), "FEMA970115PTREA", "6442894765");
            Persona p18 = new Persona("COHS031225DLVE84D5TA", "Samara Herrera Cota", new GregorianCalendar(2003, Calendar.DECEMBER, 25), "COHS031225DLVE8", "6441236584");
            Persona p19 = new Persona("PADL040113NHLEAS98CA", "Luis Durán Padilla", new GregorianCalendar(2004, Calendar.JANUARY, 13), "PADL040113NHLEA", "6442398751");
            Persona p20 = new Persona("MUPM891120BVHRT87DA0", "Maritza Carla Portillo Muñoz", new GregorianCalendar(1989, Calendar.NOVEMBER, 20), "MUPM891120BVHRT", "6444596120");
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);
            em.persist(p6);
            em.persist(p7);
            em.persist(p8);
            em.persist(p9);
            em.persist(p10);
            em.persist(p11);
            em.persist(p12);
            em.persist(p13);
            em.persist(p14);
            em.persist(p15);
            em.persist(p16);
            em.persist(p17);
            em.persist(p18);
            em.persist(p19);
            em.persist(p20);
            em.getTransaction().commit();
        }
    }

    /**
     * Este método regresa una lista de personas
     * @return Regresa una lista de personas
     */
    public List<Persona> getPersonas() {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> r = cq.from(Persona.class);
        cq.select(r);
        
        TypedQuery<Persona> query = em.createQuery(cq);
        List<Persona> personas = query.getResultList();
        em.getTransaction().commit();
        
        return personas;
    }

    /**
     * Esta página regresa la tabla de personas
     * @param frame Ventana
     * @return Una tabla de personas
     */
    public Tabla getTablaPersonas(JFrame frame) {
        List<Persona> personas = getPersonas();
        
        return new Tabla(c.personasTableModel(personas));
    }
}
