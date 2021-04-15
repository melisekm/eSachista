/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sk.stu.fiit.controller.HracController;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.utils.ViewUtils;
import sk.stu.fiit.view.dialogs.TurnajInfoDialog;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class AktivneTurnajePane extends javax.swing.JPanel implements IViewRefresh {

    private HracController controller;
    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

    public AktivneTurnajePane(HracController controller) {
        this.controller = controller;
        initComponents();
    }

    public AktivneTurnajePane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        turnajPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labelPrebiehajuciTurnaj = new javax.swing.JLabel();
        mainPane = new javax.swing.JPanel();
        labelNaplanovaneTurnaje = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JCalendar();
        labelNadchadzaujceTurnaje = new javax.swing.JLabel();
        scrollPaneTurnaje = new javax.swing.JScrollPane();
        listTurnaje = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        turnajPane.setBackground(new java.awt.Color(0, 0, 0));
        turnajPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("8");
        turnajPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Pr·ve prebieha turnaj:");
        turnajPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Dekanov");
        turnajPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("15.3.2021");
        turnajPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("FIIT STu");
        turnajPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("N·zov turnaja:");
        turnajPane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("ZaËiatok:");
        turnajPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("SINGLE ELIMINATION");
        turnajPane.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("PoËet hr·Ëov:");
        turnajPane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hr·Ë 1", "Hr·Ë 2", "»as", "V˝herca"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        turnajPane.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 400, 190));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Miesto konania:");
        turnajPane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Form·t:");
        turnajPane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Prevziaù harmonogram");
        turnajPane.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        add(turnajPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, 510));

        labelPrebiehajuciTurnaj.setText("Moment·lne neprebieha ûiadny turnaj...");
        add(labelPrebiehajuciTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        mainPane.setBackground(new java.awt.Color(204, 204, 204));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNaplanovaneTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelNaplanovaneTurnaje.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelNaplanovaneTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        labelNaplanovaneTurnaje.setText("Nem·te napl·novan˝ ûiadny turnaj...");
        mainPane.add(labelNaplanovaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        calendar.setBackground(new java.awt.Color(153, 153, 153));
        calendar.setForeground(new java.awt.Color(51, 51, 51));
        mainPane.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 370, 230));

        labelNadchadzaujceTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelNadchadzaujceTurnaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNadchadzaujceTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        labelNadchadzaujceTurnaje.setText("Nadch·dzaj˙ce turnaje");
        mainPane.add(labelNadchadzaujceTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        listTurnaje.setBackground(new java.awt.Color(153, 153, 153));
        listTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        listTurnaje.setModel(new DefaultListModel<Turnaj>());
        listTurnaje.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTurnaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listTurnajeMouseReleased(evt);
            }
        });
        scrollPaneTurnaje.setViewportView(listTurnaje);

        mainPane.add(scrollPaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 370, 230));

        add(mainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 370, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void listTurnajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTurnajeMouseReleased
        Turnaj t = (Turnaj) listTurnaje.getSelectedValue();
        if (t == null) {
            return;
        }
        ViewUtils.showDialog(new TurnajInfoDialog(parent, true, t));
    }//GEN-LAST:event_listTurnajeMouseReleased

    private void naplnListTurnajov() {
        this.controller.loadOrg();
        DefaultListModel<Turnaj> model = (DefaultListModel<Turnaj>) listTurnaje.getModel();
        model.setSize(0);
        ArrayList<Turnaj> turnaje = this.controller.getPrihlasenyHrac().getTurnaje();
        for (Turnaj t : turnaje) {
            if (!t.isFinished()) {
                model.addElement(t);
            }
        }
        if (model.getSize() == 0) {
            labelNaplanovaneTurnaje.setVisible(true);
        } else {
            labelNaplanovaneTurnaje.setVisible(false);
        }
    }

    private void zobrazPrebiehajuciTurnaj() {
        // TODO
        
    }

    @Override
    public void refresh() {
        this.naplnListTurnajov();
        this.zobrazPrebiehajuciTurnaj();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar calendar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelNadchadzaujceTurnaje;
    private javax.swing.JLabel labelNaplanovaneTurnaje;
    private javax.swing.JLabel labelPrebiehajuciTurnaj;
    private javax.swing.JList<Turnaj> listTurnaje;
    private javax.swing.JPanel mainPane;
    private javax.swing.JScrollPane scrollPaneTurnaje;
    private javax.swing.JPanel turnajPane;
    // End of variables declaration//GEN-END:variables
}
