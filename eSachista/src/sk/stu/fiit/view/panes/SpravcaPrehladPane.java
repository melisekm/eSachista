/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import javax.swing.SwingUtilities;
import sk.stu.fiit.controller.SpravcaController;
import sk.stu.fiit.view.EntryFrame;

/**
 *
 * @author lucia
 */
public class SpravcaPrehladPane extends javax.swing.JPanel {

    SpravcaController controller;
    
    public SpravcaPrehladPane(SpravcaController controller) {
        this.controller = controller;
        initComponents();
    }

    public SpravcaPrehladPane() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLogoOrgPrehlad = new javax.swing.JLabel();
        labelNazovOrgPrehlad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnUpravitOrgPrehlad = new javax.swing.JButton();
        labelDatumRegOrg = new javax.swing.JLabel();
        labelPocetClenovOrg = new javax.swing.JLabel();
        btnOdhlasitSpravcu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogoOrgPrehlad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        add(labelLogoOrgPrehlad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 160));

        labelNazovOrgPrehlad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNazovOrgPrehlad.setText("N�zov organiz�cie");
        add(labelNazovOrgPrehlad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jLabel3.setText("D�tum registr�cie:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jLabel4.setText("Po�et �lenov: ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Nadch�dzaj�ce udalosti");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        btnUpravitOrgPrehlad.setBackground(new java.awt.Color(204, 204, 204));
        btnUpravitOrgPrehlad.setForeground(new java.awt.Color(0, 0, 0));
        btnUpravitOrgPrehlad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        btnUpravitOrgPrehlad.setText("Upravi�");
        add(btnUpravitOrgPrehlad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        labelDatumRegOrg.setText("jLabel5");
        add(labelDatumRegOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        labelPocetClenovOrg.setText("jLabel6");
        add(labelPocetClenovOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        btnOdhlasitSpravcu.setBackground(new java.awt.Color(204, 204, 204));
        btnOdhlasitSpravcu.setForeground(new java.awt.Color(0, 0, 0));
        btnOdhlasitSpravcu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/logout.png"))); // NOI18N
        btnOdhlasitSpravcu.setText("Odhl�si� sa");
        btnOdhlasitSpravcu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOdhlasitSpravcuMouseReleased(evt);
            }
        });
        add(btnOdhlasitSpravcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 530, -1, -1));

        jLabel1.setText("tu budu informacie o org a informacie o spravcovi");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdhlasitSpravcuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOdhlasitSpravcuMouseReleased
        this.controller.logOut();
        SwingUtilities.getWindowAncestor(this).dispose();
        EntryFrame.main();
    }//GEN-LAST:event_btnOdhlasitSpravcuMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdhlasitSpravcu;
    private javax.swing.JButton btnUpravitOrgPrehlad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelDatumRegOrg;
    private javax.swing.JLabel labelLogoOrgPrehlad;
    private javax.swing.JLabel labelNazovOrgPrehlad;
    private javax.swing.JLabel labelPocetClenovOrg;
    // End of variables declaration//GEN-END:variables
}
