/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.itson.dominio.Licencia;
import org.itson.dominio.Pago;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;
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
    CriteriaBuilder cb = em.getCriteriaBuilder();
    JFrame frame;
    String abc = "abcdefghijklmnopqrstuvwxyz";
    public String abc2 = "abcdefghijklmnñopqrstuvwxyzabc ABCDEFGHIJKLMNOPQRSTUVWXYZABCáéíóúáéí";
    public String abc3 = "cbazyxwvutsrqpoñnmlkjihgfedcbaCBA ZYXWVUTSRQPONMLKJIHGFEDCBAúóíéáúóí";
    
    //MÉTODOS
    
    /**
     * Método que cifra un String de texto ingresado
     * @param letra Letra a cambiar de lugar
     * @param texto Texto a cifrar
     * @return El texto cifrado
     */
    public String cifrar(String letra, String texto){
        String textoCifrado = "";
        char car;
        for(int i=0; i<texto.length(); i++){
            car = texto.charAt(i);
            int pos = letra.indexOf(car);
            textoCifrado += letra.charAt(pos+3);
        }
        return textoCifrado;
    }
    
    /**
     * Método que descifra un String de texto cifrado
     * @param letra Letra a cambiar de lugar
     * @param texto Texto a descifrar
     * @return El texto descifrado
     */
    public String descifrar(String letra, String texto){
        String textoDescifrado = "";
        char car;
        for(int i=0; i<texto.length(); i++){
            car = texto.charAt(i);
            int pos = letra.indexOf(car);
            textoDescifrado += letra.charAt(pos+3);
        }
        return textoDescifrado;
    }

    /**
     * Este método solicita una licencia
     * @param frame Ventana
     * @return Una ventana para poder tramitar Licencias
     */
    public boolean solicitarLicencia(JFrame frame) {
        this.frame = frame;
        StringBuffer respuesta = new StringBuffer("");
        DefaultComboBoxModel<Persona> personas = 
                c.ComboBoxPersonas(getPersonas());
        Tramites tramites = new Tramites(frame, 
                "Trámitar licencia", true, 
                ConstantesGUI.LICENCIA, personas, respuesta);
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) 
            return false;
        JOptionPane.showMessageDialog(frame, 
                "Ya se le ha otorgado la licencia", 
                "Trámite exitoso!!", 
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    /**
     * Este método solicita una placa
     * @param frame Ventana
     * @return Una ventana para poder tramitar Placas
     */
    public boolean solicitarPlacas(JFrame frame) {
        this.frame = frame;
        StringBuffer respuesta = new StringBuffer("");
        DefaultComboBoxModel<Persona> personas = 
                c.ComboBoxPersonas(getPersonas());
        Tramites tramites = new Tramites(frame, "Trámitar placas", 
                true, ConstantesGUI.PLACA, personas, respuesta);
        
        if(respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) 
            return false;
        
        JOptionPane.showMessageDialog(frame, 
                "Ya se le ha otorgado las placas", 
                "Trámite exitoso!!", 
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    /**
     * Método para verificar los filtros del panel de Consultas
     * @param curp Curp que se desea consultar
     * @param nombre Nombre que se desea consultar
     * @param fecha Fecha de nacimiento que se desea consultar
     * @param persona Persona que se desea buscar
     * @param tipo Tipo de consulta a realizar
     */
    public void filtroConsultas(String curp, String nombre, 
            Calendar fecha, Persona persona, int tipo){
        if(tipo == ConstantesGUI.LICENCIA){
            getLicencias();
        }
        if(tipo == ConstantesGUI.PLACA){
            getPlacas();
        }
    }
    
    /**
     * Este método inserta 20 personas en una sola interacción
     * @return True si ya se insertarón las personas, false si ya había personas
     */
    public boolean insercionMasiva() {
        List<Persona> personas = getPersonas();
        if(personas.isEmpty()) {
            em.getTransaction().begin();
            Persona p1 = new Persona("GUGE751125MRGRA0PTR2", 
                    "Ethan Gutierrez Mallorca", 
                    new GregorianCalendar(1975, 
                            Calendar.NOVEMBER, 25),
                    "GUGE751125MRGRA0", "6448476525");
            Persona p2 = new Persona("MAPM800508PTMER4MNA1", 
                    "Magdiel Perez Martinez", 
                    new GregorianCalendar(1980, 
                            Calendar.MAY, 8), 
                    "MAPM800508PTMER4", "6444658475");
            Persona p3 = new Persona("ROGP010215JTAE25DAMP", 
                    "Pedro Gonzales Rosales", 
                    new GregorianCalendar(2001, 
                            Calendar.FEBRUARY, 15), 
                    "ROGP010215JTAE25", "6441584798");
            Persona p4 = new Persona("NOQM981020MPEOT15A3D", 
                    "Miguel Angel Quintero Nodal", 
                    new GregorianCalendar(1998, 
                            Calendar.OCTOBER, 20), 
                    "NOQM981020MPEO", "6444896478");
            Persona p5 = new Persona("PAVL701028PMEI04TR51", 
                    "Levi Vega Padilla", 
                    new GregorianCalendar(1970, 
                            Calendar.OCTOBER, 28), 
                    "PAVL701028PMEI04", "6449887441");
            Persona p6 = new Persona("QUSM000105PRTA3TRP11", 
                    "Magda Sevilla Quintanilla", 
                    new GregorianCalendar(2000, 
                            Calendar.JANUARY, 5), 
                    "QUSM000105PRTA3T", "6442547564");
            Persona p7 = new Persona("FIGK020430KITA54MARP", 
                    "Kimberly García Fierro", 
                    new GregorianCalendar(2002, 
                            Calendar.APRIL, 30), 
                    "FIGK020430KITA54", "6446548794");
            Persona p8 = new Persona("LUFM850819MARJA84RPT", 
                    "Manuel Figueroa Luna", 
                    new GregorianCalendar(1985, 
                            Calendar.AUGUST, 19), 
                    "LUFM850819MARJA8", "6444547865");
            Persona p9 = new Persona("ROFB900610LPAR45CPRE", 
                    "Brenda Fuentes Rojas", 
                    new GregorianCalendar(1990, 
                            Calendar.JUNE, 10), 
                    "ROFB900610LPAR45", "6442658745");
            Persona p10 = new Persona("VIHJ030330PMANU15PRM", 
                    "Judith Hernández Villegas", 
                    new GregorianCalendar(2003, 
                            Calendar.MARCH, 30), 
                    "VIHJ030330PMANU1", "6444587611");
            Persona p11 = new Persona("MOML000404LMNERA4578", 
                    "Laura María Montes Morales", 
                    new GregorianCalendar(2000, 
                            Calendar.APRIL, 4), 
                    "MOML000404LMNERA", "6442354798");
            Persona p12 = new Persona("MOVA040316PRGA78PO54", 
                    "Arturo Vega Morales", 
                    new GregorianCalendar(2004, 
                            Calendar.MARCH, 16), 
                    "MOVA040316PRGA78", "6442354798");
            Persona p13 = new Persona("ISMA010728MNRA8G45PA", 
                    "Andrea Minjarez Isordia", 
                    new GregorianCalendar(2001, 
                            Calendar.JULY, 28), 
                    "ISMA010728MNRA8G", "6444569874");
            Persona p14 = new Persona("FUMO920224YPJH78PRT0", 
                    "Oscar Meza Fuentes", 
                    new GregorianCalendar(1992, 
                            Calendar.FEBRUARY, 24), 
                    "FUMO920224YPJH78", "6444847624");
            Persona p15 = new Persona("MEGP950317LAKEM87MNR", 
                    "Paola García Mendes", 
                    new GregorianCalendar(1995, 
                            Calendar.MARCH, 17), 
                    "MEGP950317LAKEM8", "6442847654");
            Persona p16 = new Persona("GOVV001020MNTU876FDA", 
                    "Viviana Villegas Gomez", 
                    new GregorianCalendar(2000, 
                            Calendar.OCTOBER, 20), 
                    "GOVV001020MNTU87", "6441356478");
            Persona p17 = new Persona("FEMA970115PTREA84VD5", 
                    "Alan Montes Fernandez", 
                    new GregorianCalendar(1997, 
                            Calendar.JANUARY, 15), 
                    "FEMA970115PTREA", "6442894765");
            Persona p18 = new Persona("COHS031225DLVE84D5TA", 
                    "Samara Herrera Cota", 
                    new GregorianCalendar(2003, 
                            Calendar.DECEMBER, 25), 
                    "COHS031225DLVE8", "6441236584");
            Persona p19 = new Persona("PADL040113NHLEAS98CA", 
                    "Luis Durán Padilla", 
                    new GregorianCalendar(2004, 
                            Calendar.JANUARY, 13), 
                    "PADL040113NHLEA", "6442398751");
            Persona p20 = new Persona("MUPM891120BVHRT87DA0", 
                    "Maritza Carla Portillo Muñoz", 
                    new GregorianCalendar(1989, 
                            Calendar.NOVEMBER, 20), 
                    "MUPM891120BVHRT", "6444596120");
            String sp1 = cifrar(abc2, p1.getNombreCompleto());
            String sp2 = cifrar(abc2, p2.getNombreCompleto());
            String sp3 = cifrar(abc2, p3.getNombreCompleto());
            String sp4 = cifrar(abc2, p4.getNombreCompleto());
            String sp5 = cifrar(abc2, p5.getNombreCompleto());
            String sp6 = cifrar(abc2, p6.getNombreCompleto());
            String sp7 = cifrar(abc2, p7.getNombreCompleto());
            String sp8 = cifrar(abc2, p8.getNombreCompleto());
            String sp9 = cifrar(abc2, p9.getNombreCompleto());
            String sp10 = cifrar(abc2, p10.getNombreCompleto());
            String sp11 = cifrar(abc2, p11.getNombreCompleto());
            String sp12 = cifrar(abc2, p12.getNombreCompleto());
            String sp13 = cifrar(abc2, p13.getNombreCompleto());
            String sp14 = cifrar(abc2, p14.getNombreCompleto());
            String sp15 = cifrar(abc2, p15.getNombreCompleto());
            String sp16 = cifrar(abc2, p16.getNombreCompleto());
            String sp17 = cifrar(abc2, p17.getNombreCompleto());
            String sp18 = cifrar(abc2, p18.getNombreCompleto());
            String sp19 = cifrar(abc2, p19.getNombreCompleto());
            String sp20 = cifrar(abc2, p20.getNombreCompleto());
            p1.setNombreCompleto(sp1);
            p2.setNombreCompleto(sp2);
            p3.setNombreCompleto(sp3);
            p4.setNombreCompleto(sp4);
            p5.setNombreCompleto(sp5);
            p6.setNombreCompleto(sp6);
            p7.setNombreCompleto(sp7);
            p8.setNombreCompleto(sp8);
            p9.setNombreCompleto(sp9);
            p10.setNombreCompleto(sp10);
            p11.setNombreCompleto(sp11);
            p12.setNombreCompleto(sp12);
            p13.setNombreCompleto(sp13);
            p14.setNombreCompleto(sp14);
            p15.setNombreCompleto(sp15);
            p16.setNombreCompleto(sp16);
            p17.setNombreCompleto(sp17);
            p18.setNombreCompleto(sp18);
            p19.setNombreCompleto(sp19);
            p20.setNombreCompleto(sp20);
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
        }else{
            return false;
        }
        return true;
    }

    /**
     * Este método regresa una lista de personas
     * @return Regresa una lista de personas
     */
    public List<Persona> getPersonas() {
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> p = cq.from(Persona.class);
        cq.select(p);
        TypedQuery<Persona> query = em.createQuery(cq);
        List<Persona> personas = query.getResultList();
        return personas;
    }

    /**
     * Este método regresa una lista de personas
     * @return Regresa una lista de personas
     */
    public List<Persona> getPersonasDescifradas() {
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> p = cq.from(Persona.class);
        cq.select(p);
        TypedQuery<Persona> query = em.createQuery(cq);
        List<Persona> personas = query.getResultList();
        for(int i=0; i < personas.size(); i++) {
            String dc = descifrar(abc3, personas.get(i).getNombreCompleto());
            personas.get(i).setNombreCompleto(dc);
        }
        return personas;
    }

    /**
     * Esté metodo regresa una lista de personas que han hecho tramites
     * @param curp CURP de una persona
     * @param nombre Nombre especifico de una persona
     * @param fecha Fecha de Nacimiento en adelante
     * @return Regresa una lista de personas filtradas por su curp, nombre o fecha
     */
    public List<Persona> getTramitesPersonas(String curp, String nombre, String fecha) {
        List<Persona> personas = new ArrayList<>();
        personas.clear();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Tramite> t = cq.from(Tramite.class);
        Join<Tramite, Persona> p = t.join("persona", JoinType.INNER);
        cq.groupBy(p);
        cq.multiselect(p, cb.count(p.get("id")));
        if(!"".equals(fecha)) {
            cq.where(
                cb.and(
                    cb.and(
                        cb.like(p.get("curp"), "%"+curp+"%"),
                        cb.like(p.get("nombreCompleto"), "%"+nombre+"%")
                    ),
                    cb.greaterThanOrEqualTo(p.get("fechaNacimiento"), fecha)
                )
            );
        }else{
            cq.where(
                cb.and(
                    cb.like(p.get("curp"), "%"+curp+"%"),
                    cb.like(p.get("nombreCompleto"), "%"+nombre+"%")
                )
            );
        }
        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> tramites = query.getResultList();
        tramites.forEach(o -> personas.add((Persona) o[0]));
        for(int i=0; i < personas.size(); i++) {
            String dc = descifrar(abc3, personas.get(i).getNombreCompleto());
            personas.get(i).setNombreCompleto(dc);
        }
        return personas;
    }

    /**
     * Regresa una lista de trámites con filtros
     * @param nombre Nombre de la persona que hizó el trámite
     * @param tipo Tipo de trámite que hizo
     * @param fechaInicial Fecha inicial del periodo
     * @param fechaFinal Fecha final del periodo
     * @return Una lista de trámites que cumplen con los filtros
     */
    public List<Tramite> getTramitesReportes(String nombre, String tipo, String fechaInicial, String fechaFinal) {
        List<Tramite> tramites = new ArrayList<>();
        List<Tramite> tramites3 = new ArrayList<>();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Tramite> t = cq.from(Tramite.class);
        Join<Tramite, Persona> p = t.join("persona", JoinType.INNER);
        Join<Tramite, Pago> pa = t.join("pago", JoinType.INNER);
        cq.groupBy(t.get("id"));
        cq.multiselect(t, p);
        cq.where(
            cb.and(
                cb.like(p.get("nombreCompleto"), "%"+nombre+"%"),
                cb.like(pa.get("descripcion"), "%"+tipo+"%"),
                cb.greaterThanOrEqualTo(pa.get("fechaPago"), fechaInicial),
                cb.lessThanOrEqualTo(pa.get("fechaPago"), fechaFinal)
            )
        );
        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> tramites2 = query.getResultList();
        tramites2.forEach(o -> tramites.add((Tramite) o[0]));
        for(int i=0; i < tramites.size(); i++) {
            tramites3.add(tramites.get(i));
            String dc = descifrar(abc3, tramites.get(i).getPersona().getNombreCompleto());
            tramites3.get(i).getPersona().setNombreCompleto(dc);
        }
        return tramites3;
    }

    /**
     * Obtiene una lista de trámites realizados por la persona del parametro
     * @param persona Persona de quien se desea obtener su historial
     * @return Lista con los trámites que la persona ha hecho
     */
    private List<Tramite> getHistorialTramites(Persona persona) {
        CriteriaQuery<Tramite> cq = cb.createQuery(Tramite.class);
        Root<Tramite> t = cq.from(Tramite.class);
        cq.select(t).where(
            cb.equal(t.get("persona"), persona)
        );
        TypedQuery<Tramite> query = em.createQuery(cq);
        List<Tramite> tramites = query.getResultList();
        return tramites;
    }
    
    /**
     * Este método regresa una lista de licencias
     * @return Regresa una lista de licencias
     */
    private List<Licencia> getLicencias(){
        CriteriaQuery<Licencia> cql = cb.createQuery(Licencia.class);
        Root<Licencia> l = cql.from(Licencia.class);
        cql.select(l);
        TypedQuery<Licencia> query = em.createQuery(cql);
        List<Licencia> licencias = query.getResultList();
        return licencias;
    }
    
    /**
     * Este método regresa una lista de personas
     * @return Regresa una lista de personas
     */
    private List<Placa> getPlacas(){
        CriteriaQuery<Placa> cqpl = cb.createQuery(Placa.class);
        Root<Placa> pl = cqpl.from(Placa.class);
        cqpl.select(pl);
        TypedQuery<Placa> query = em.createQuery(cqpl);
        List<Placa> placas = query.getResultList();
        return placas;
    }
    
    /**
     * Busca un vehiculo dentro de la base de datos
     * @param NSerie Numero de serie del vehiculo a buscar
     * @param persona Dueño del vehiculo
     * @return Un vehiculo con el número de serie a buscar
     */
    public List<Vehiculo> buscarVehiculo(String NSerie, Persona persona) {
        // NO SE CUENTA CON LICENCIA VIGENTE
        if(verificarLicencia(persona)) {
            JOptionPane.showMessageDialog(frame, 
                    "Usted no cuenta con una licencia vigente", 
                    "Sin licencia!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        // NO SE CUENTA CON LICENCIA VIGENTE
        if(verificarVigencia(persona)) {
            JOptionPane.showMessageDialog(frame, 
                    "Usted no cuenta con una licencia vigente", 
                    "Sin licencia!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        CriteriaQuery<Vehiculo> cq = cb.createQuery(Vehiculo.class);
        Root<Vehiculo> v = cq.from(Vehiculo.class);
        cq.select(v).where(
            cb.like(v.get("numeroSerie"), "%"+NSerie+"%")
        );
        TypedQuery<Vehiculo> query = em.createQuery(cq);
        List<Vehiculo> vehiculos = query.getResultList();
        // NO SE ENCUENTRA EL VEHÍCULO
        if(vehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(frame, 
                    "No se encuentra ese vehiculo, registrelo", 
                    "Vehiculo no encontrado!!", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else {
            // ESTE VEHÍCULO NO ES SUYO
            if(verificarPertenenciaAuto(NSerie, persona)) {
                JOptionPane.showMessageDialog(frame, 
                        "Este auto no es suyo", "", 
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // VEHÍCULO ENCONTRADO
            JOptionPane.showMessageDialog(frame, 
                    "Vehiculo encontrado: " + vehiculos.get(0), 
                    "Vehiculo encontrado!!", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
        return vehiculos;
    }
    
    /**
     * Verifica que un vehiculo le pertenezca a la persona
     * @param NSerie Numero de serie del vehiculo a verificar
     * @param persona Persona que dice ser el dueño
     * @return False si no es el dueño, True si es el dueño
     */
    private boolean verificarPertenenciaAuto(String NSerie, Persona persona) {
        CriteriaQuery<Placa> cq = cb.createQuery(Placa.class);
        Root<Placa> p = cq.from(Placa.class);
        Join<Placa, Persona> pe = p.join("persona", JoinType.INNER);
        Join<Placa, Vehiculo> v = p.join("vehiculo", JoinType.INNER);
        cq.where(
            cb.like(v.get("numeroSerie"), "%"+NSerie+"%"),
            cb.equal(pe.get("id"), persona.getId())
        );
        TypedQuery<Placa> query = em.createQuery(cq);
        List<Placa> tramites = query.getResultList();
        return tramites.isEmpty();
    }
    
    /**
     * Verifica si la persona tiene una licencia vigente
     * @param persona Persona que debe tener la licencia
     * @return False si no tiene licencia, True si tiene licencia
     */
    private boolean verificarLicencia(Persona persona) {
        CriteriaQuery<Licencia> cq = cb.createQuery(Licencia.class);
        Root<Licencia> l = cq.from(Licencia.class);
        cq.select(l).where(
            cb.equal(l.get("persona").get("id"), 
                    persona.getId())
        );
        TypedQuery<Licencia> query = em.createQuery(cq);
        List<Licencia> licencias = query.getResultList();
        return licencias.isEmpty();
    }
    
    /**
     * Verifica la vigencia de la licencia de cierta persona
     * @param persona Persona de la cual verificar licencia
     * @return False si su licencia expiro, True si su licencia sigue vigente
     */
    private boolean verificarVigencia(Persona persona) {
        Calendar vigencia = new GregorianCalendar();
        CriteriaQuery<Licencia> cq = cb.createQuery(Licencia.class);
        Root<Licencia> l = cq.from(Licencia.class);
        cq.select(l).where(
            cb.equal(l.get("persona").get("id"), 
                    persona.getId())
        );
        TypedQuery<Licencia> query = em.createQuery(cq);
        List<Licencia> licencias = query.getResultList();
        if(!licencias.isEmpty()) {
            vigencia = licencias.get(licencias.size()-1).getFechaExpedicion();
            vigencia.add(Calendar.YEAR, 
                    licencias.get(licencias.size()-1).getAniosVigencia());
        }
        return vigencia.before(new GregorianCalendar());
    }
    
    /**
     * Verifica que una persona tenga una licencia, en caso de 
     * tenerla no podrá solicitar otra
     * @param persona Persona que quiere solicitar licencia
     * @return False si tiene una licencia, True si no la tiene
     */
    public boolean verificarLicenciaPersona(Persona persona) {
        if(verificarLicencia(persona)) {
            return true;
        }else if(verificarVigencia(persona)) {
            return true;
        }else{
            JOptionPane.showMessageDialog(frame, 
                    "Usted ya cuenta con una licencia vigente", 
                    "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Genera un identificador para las placas de un auto "AAA-111"
     * @return Un identificador para las placas de un auto
     */
    public String generarIdentificadorPlaca() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";
        String identificador = "";
        for(int i = 0; i < 3; i++) {
            int randomIndex = alAzar(0, letras.length() - 1);
            char randomChar = letras.charAt(randomIndex);
            identificador+=randomChar;
        }
        identificador+="-";
        for(int i = 0; i < 3; i++) {
            int randomIndex = alAzar(0, numeros.length() - 1);
            char randomChar = numeros.charAt(randomIndex);
            identificador+=randomChar;
        }
        return identificador;
    }

    /**
     * Saca un número al azar
     * @param minimo El número más pequeño que se puede sacar
     * @param maximo El número más grande que se puede sacar
     * @return Número al azar
     */
    private int alAzar(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    /**
     * Esta página regresa la tabla de personas
     * @param frame Ventana
     * @return Una tabla de personas
     */
    public Tabla getTablaPersonas(JFrame frame) {
        List<Persona> personas = getPersonasDescifradas();
        return new Tabla(c.personasTableModel(personas));
    }
    
    /**
     * Método que obtiene la tabla de los trámites realizados por la persona
     * @param frame Ventana
     * @param curp Curp de la persona
     * @param nombre Nombre de la persona
     * @param fecha Fecha de nacimiento de la persona
     * @return Una tabla con la lista de trámites realizados por la persona
     */
    public Tabla getTablaTramitesPersonas(JFrame frame, String curp, String nombre, String fecha) {
        List<Persona> personas = getTramitesPersonas(curp, nombre, fecha);
        return new Tabla(c.personasTableModel(personas));
    }

    /**
     * Método que obtiene la tabla del reporte
     * @param frame Ventana
     * @param nombre Nombre de la persona que hizó el trámite
     * @param tipo Tipo de trámite que hizo
     * @param fechaInicial Fecha inicial del periodo
     * @param fechaFinal Fecha final del periodo
     * @return Una tabla de trámites
     */
    public Tabla getTablaReporte(JFrame frame, String nombre, String tipo, String fechaInicial, String fechaFinal) {
        List<Tramite> tramites = getTramitesReportes(nombre, tipo, fechaInicial, fechaFinal);
        return new Tabla(c.reporteTableModel(tramites));
    }

    /**
     * Método que obtiene la tabla de licencias
     * @param frame Ventana
     * @return Una tabla con la lista de licencias
     */
    public Tabla getTablaLicencias(JFrame frame){
        List<Licencia> licencias = getLicencias();
        return new Tabla(c.licenciasTableModel(licencias));
    }
    
    /**
     * Método que obtiene la tabla de placas
     * @param frame Ventana
     * @return Una tabla con la lista de placas
     */
    public Tabla getTablaPlacas(JFrame frame){
        List<Placa> placas = getPlacas();
        return new Tabla(c.placasTableModel(placas));
    }
    
    /**
     * Método que obtiene la tabla del historial
     * @param frame Ventana
     * @param persona La persona de la que se quiere saber su historial
     * @return Una tabla con el historial de trámites de la persona
     */
    public Tabla getTablaHistorial(JFrame frame, Persona persona) {
        List<Tramite> tramites = getHistorialTramites(persona);
        return new Tabla(c.historialTableModel(tramites));
    }
}