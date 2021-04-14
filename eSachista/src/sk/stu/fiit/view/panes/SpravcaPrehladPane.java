/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import sk.stu.fiit.controller.SpravcaController;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Spravca;

/**
 *
 * @author lucia
 */
public class SpravcaPrehladPane extends javax.swing.JPanel implements IViewRefresh {

    private SpravcaController controller;

    public SpravcaPrehladPane(SpravcaController controller) {
        this.controller = controller;
        initComponents();
    }

    public SpravcaPrehladPane() {
        initComponents();
    }

    private void setSpravcaInfo() {
        Spravca s = this.controller.getPrihlasenySpravca();
        Organizacia o = this.controller.getOrgLoggedIn();
        labelNazovOrgPrehlad.setText(o.getNazov());

    }

    public void refresh() {
        this.setSpravcaInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EditovatSpravcuDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        btnUlozitSpravcaDialog = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        labelLogoOrgPrehlad = new javax.swing.JLabel();
        labelNazovOrgPrehlad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpravitOrgPrehlad = new javax.swing.JButton();
        labelDatumRegOrg = new javax.swing.JLabel();
        labelPocetClenovOrg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        EditovatSpravcuDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUlozitSpravcaDialog.setBackground(new java.awt.Color(118, 155, 108));
        btnUlozitSpravcaDialog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUlozitSpravcaDialog.setForeground(new java.awt.Color(255, 255, 255));
        btnUlozitSpravcaDialog.setText("Uloûiù");
        btnUlozitSpravcaDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUlozitSpravcaDialogMouseClicked(evt);
            }
        });
        jPanel1.add(btnUlozitSpravcaDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 140, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("N·zov organiz·cie:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Meno spr·vcu:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 155, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Upraviù ˙daje");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Vybraù avatar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 160, 140));

        EditovatSpravcuDialog.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 310));

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogoOrgPrehlad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        add(labelLogoOrgPrehlad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 160));

        labelNazovOrgPrehlad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNazovOrgPrehlad.setText("N·zov organiz·cie");
        add(labelNazovOrgPrehlad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jLabel3.setText("D·tum registr·cie:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jLabel4.setText("PoËet Ëlenov: ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        btnUpravitOrgPrehlad.setBackground(new java.awt.Color(204, 204, 204));
        btnUpravitOrgPrehlad.setForeground(new java.awt.Color(0, 0, 0));
        btnUpravitOrgPrehlad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        btnUpravitOrgPrehlad.setText("Upraviù");
        btnUpravitOrgPrehlad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpravitOrgPrehladMouseClicked(evt);
            }
        });
        add(btnUpravitOrgPrehlad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        labelDatumRegOrg.setText("jLabel5");
        add(labelDatumRegOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        labelPocetClenovOrg.setText("jLabel6");
        add(labelPocetClenovOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel2.setText("Vitajte, ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel5.setText("jLabel5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpravitOrgPrehladMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpravitOrgPrehladMouseClicked
        EditovatSpravcuDialog.pack();
        EditovatSpravcuDialog.setLocationRelativeTo(this);
        EditovatSpravcuDialog.setVisible(true);
    }//GEN-LAST:event_btnUpravitOrgPrehladMouseClicked

    private void btnUlozitSpravcaDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUlozitSpravcaDialogMouseClicked
        Spravca s = this.controller.getPrihlasenySpravca();
        Organizacia o = this.controller.getOrgLoggedIn();

    }//GEN-LAST:event_btnUlozitSpravcaDialogMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog EditovatSpravcuDialog;
    private javax.swing.JButton btnUlozitSpravcaDialog;
    private javax.swing.JButton btnUpravitOrgPrehlad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelDatumRegOrg;
    private javax.swing.JLabel labelLogoOrgPrehlad;
    private javax.swing.JLabel labelNazovOrgPrehlad;
    private javax.swing.JLabel labelPocetClenovOrg;
    // End of variables declaration//GEN-END:variables
}
