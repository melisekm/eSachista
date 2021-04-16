/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.dialogs;

import javax.swing.JFrame;
import sk.stu.fiit.model.organisation.platform.Zapas;

/**
 *
 * @author lucia
 */
public class ZapasDialog extends javax.swing.JDialog {

    public ZapasDialog(JFrame parent, boolean modal, Zapas zapas) {
        super(parent, modal);
        initComponents();
        // TODO
    }

    public ZapasDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AvatarHrac1 = new javax.swing.JLabel();
        AvatarHrac2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labelHrac1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelHrac2 = new javax.swing.JLabel();
        labelCasZaciatku = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        labelTempo = new javax.swing.JLabel();
        labelElo1 = new javax.swing.JLabel();
        labelElo2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Inform�cie o z�pase:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        AvatarHrac1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        jPanel1.add(AvatarHrac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        AvatarHrac2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        jPanel1.add(AvatarHrac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jButton1.setBackground(new java.awt.Color(118, 155, 108));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pripoji� sa do hry");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 140, -1));

        labelHrac1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelHrac1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHrac1.setText("Meno hr��a 1");
        jPanel1.add(labelHrac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 230, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("�as za�iatku:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Form�t:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        labelHrac2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelHrac2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHrac2.setText("Meno hr��a 2");
        jPanel1.add(labelHrac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 230, 170, -1));

        labelCasZaciatku.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelCasZaciatku.setText("jLabel8");
        jPanel1.add(labelCasZaciatku, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Tempo hry:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        labelFormat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelFormat.setText("jLabel10");
        jPanel1.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        labelTempo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelTempo.setText("jLabel11");
        jPanel1.add(labelTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        labelElo1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelElo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelElo1.setText("ELO hr��a 1");
        jPanel1.add(labelElo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 250, 160, -1));

        labelElo2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelElo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelElo2.setText("ELO hr��a 2");
        jPanel1.add(labelElo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 246, 170, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/blackking.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/whiteking.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("vs.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 80, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AvatarHrac1;
    private javax.swing.JLabel AvatarHrac2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCasZaciatku;
    private javax.swing.JLabel labelElo1;
    private javax.swing.JLabel labelElo2;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelHrac1;
    private javax.swing.JLabel labelHrac2;
    private javax.swing.JLabel labelTempo;
    // End of variables declaration//GEN-END:variables
}
