/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package org.itson.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Persona;

/**
 * @author Victor y Samuel
 */
public class Principal extends javax.swing.JFrame {
    
    /**
     * Este método ubica la ventana en el centro de la pantalla
     */
    private void centraVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        Dimension frameSize = getSize();
        
        if(frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        
        if(frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        
        setLocation((screenSize.height - frameSize.height)/2, (screenSize.width - frameSize.width)/2);
    }

    /**
     * Este método inserta 20 personas en una sola interacción
     */
    private void insercionMasiva() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.itson_AgenciaTransito");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Persona p1 = new Persona("GUGE751125MRGRA0PTR25", "Ethan Gutierrez Mallorca", new GregorianCalendar(1975, Calendar.NOVEMBER, 25),"GUGE751125MRGRA0", "6448476525");
        Persona p2 = new Persona("MAPM800508PTMER4MNA1P", "Magdiel Perez Martinez", new GregorianCalendar(1980, Calendar.MAY, 8), "MAPM800508PTMER4", "6444658475");
        Persona p3 = new Persona("ROGP010215JTAE25DAMP3", "Pedro Gonzales Rosales", new GregorianCalendar(2001, Calendar.FEBRUARY, 15), "ROGP010215JTAE25", "6441584798");
        Persona p4 = new Persona("NOQM981020MPEOT15A3DC", "Miguel Angel Quintero Nodal", new GregorianCalendar(1998, Calendar.OCTOBER, 20), "NOQM981020MPEO", "6444896478");
        Persona p5 = new Persona("PAVL701028PMEI04TR51A", "Levi Vega Padilla", new GregorianCalendar(1970, Calendar.OCTOBER, 28), "PAVL701028PMEI04", "6449887441");
        Persona p6 = new Persona("QUSM000105PRTA3TRP11M", "Magda Sevilla Quintanilla", new GregorianCalendar(2000, Calendar.JANUARY, 5), "QUSM000105PRTA3T", "6442547564");
        Persona p7 = new Persona("FIGK020430KITA54MARP2", "Kimberly García Fierro", new GregorianCalendar(2002, Calendar.APRIL, 30), "FIGK020430KITA54", "6446548794");
        Persona p8 = new Persona("LUFM850819MARJA84RPTA", "Manuel Figueroa Luna", new GregorianCalendar(1985, Calendar.AUGUST, 19), "LUFM850819MARJA8", "6444547865");
        Persona p9 = new Persona("ROFB900610LPAR45CPREA", "Brenda Fuentes Rojas", new GregorianCalendar(1990, Calendar.JUNE, 10), "ROFB900610LPAR45", "6442658745");
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

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        centraVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        btnInsercionMasiva = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        lblPersonas = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        tramitesMenu = new javax.swing.JMenu();
        licenciaTramitesMenu = new javax.swing.JMenuItem();
        placasTramitesMenu = new javax.swing.JMenuItem();
        consultasMenu = new javax.swing.JMenu();
        licenciasConsultasMenu = new javax.swing.JMenuItem();
        placasConsultasMenu = new javax.swing.JMenuItem();
        reporteMenu = new javax.swing.JMenu();
        reporteGeneralReporteMenu = new javax.swing.JMenuItem();
        reporteBusquedaReporteMenu = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agencia de Transito");

        btnInsercionMasiva.setText("Inserción Masiva");
        btnInsercionMasiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsercionMasivaActionPerformed(evt);
            }
        });

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre Completo", "Fecha de Nacimiento", "CURP", "RFC", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblPersonas.setText("Personas");

        tramitesMenu.setMnemonic('f');
        tramitesMenu.setText("Trámites");

        licenciaTramitesMenu.setMnemonic('o');
        licenciaTramitesMenu.setText("Licencia");
        licenciaTramitesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenciaTramitesMenuActionPerformed(evt);
            }
        });
        tramitesMenu.add(licenciaTramitesMenu);

        placasTramitesMenu.setMnemonic('s');
        placasTramitesMenu.setText("Placas");
        placasTramitesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasTramitesMenuActionPerformed(evt);
            }
        });
        tramitesMenu.add(placasTramitesMenu);

        menuBar.add(tramitesMenu);

        consultasMenu.setMnemonic('e');
        consultasMenu.setText("Consultas");

        licenciasConsultasMenu.setMnemonic('t');
        licenciasConsultasMenu.setText("Licencias");
        licenciasConsultasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenciasConsultasMenuActionPerformed(evt);
            }
        });
        consultasMenu.add(licenciasConsultasMenu);

        placasConsultasMenu.setMnemonic('y');
        placasConsultasMenu.setText("Placas");
        consultasMenu.add(placasConsultasMenu);

        menuBar.add(consultasMenu);

        reporteMenu.setMnemonic('h');
        reporteMenu.setText("Reporte");

        reporteGeneralReporteMenu.setMnemonic('c');
        reporteGeneralReporteMenu.setText("Reporte de Trámites Realizados");
        reporteMenu.add(reporteGeneralReporteMenu);

        reporteBusquedaReporteMenu.setMnemonic('a');
        reporteBusquedaReporteMenu.setText("Reporte por busqueda");
        reporteMenu.add(reporteBusquedaReporteMenu);

        menuBar.add(reporteMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsercionMasiva))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(lblPersonas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPersonas)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsercionMasiva)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void licenciaTramitesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenciaTramitesMenuActionPerformed
        Tramites tramites = new Tramites("Trámitar licencia");
        tramites.setVisible(true);
    }//GEN-LAST:event_licenciaTramitesMenuActionPerformed

    private void licenciasConsultasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenciasConsultasMenuActionPerformed
        Consultas consultas = new Consultas();
        consultas.setVisible(true);
    }//GEN-LAST:event_licenciasConsultasMenuActionPerformed

    private void placasTramitesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasTramitesMenuActionPerformed
        Tramites tramites = new Tramites("Trámitar placas");
        tramites.setVisible(true);
    }//GEN-LAST:event_placasTramitesMenuActionPerformed

    private void btnInsercionMasivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsercionMasivaActionPerformed
        insercionMasiva();
        btnInsercionMasiva.setVisible(false);
    }//GEN-LAST:event_btnInsercionMasivaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsercionMasiva;
    private javax.swing.JMenu consultasMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPersonas;
    private javax.swing.JMenuItem licenciaTramitesMenu;
    private javax.swing.JMenuItem licenciasConsultasMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem placasConsultasMenu;
    private javax.swing.JMenuItem placasTramitesMenu;
    private javax.swing.JMenuItem reporteBusquedaReporteMenu;
    private javax.swing.JMenuItem reporteGeneralReporteMenu;
    private javax.swing.JMenu reporteMenu;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JMenu tramitesMenu;
    // End of variables declaration//GEN-END:variables

}
