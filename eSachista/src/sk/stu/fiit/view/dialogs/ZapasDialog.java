/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.dialogs;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.FarbaFiguriek;
import sk.stu.fiit.model.organisation.platform.Zapas;

/**
 *
 * @author lucia
 */
public class ZapasDialog extends javax.swing.JDialog {

    private static final Logger logger = LoggerFactory.getLogger(ZapasDialog.class);
    private Zapas zapas;

    public ZapasDialog(JFrame parent, boolean modal, Zapas zapas) {
        super(parent, modal);
        initComponents();
        this.zapas = zapas;
        this.vyplnLabely();
    }

    public ZapasDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelInformacie = new javax.swing.JLabel();
        AvatarHrac1 = new javax.swing.JLabel();
        AvatarHrac2 = new javax.swing.JLabel();
        btnPripojitSa = new javax.swing.JButton();
        labelDataMenoHraca = new javax.swing.JLabel();
        labelCasZacaitku = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        labelDataMenoHraca2 = new javax.swing.JLabel();
        labelDataCasZaciatku = new javax.swing.JLabel();
        labelTempoHry = new javax.swing.JLabel();
        labelDataFormat = new javax.swing.JLabel();
        labelDataTempoHry = new javax.swing.JLabel();
        labelDataElo1 = new javax.swing.JLabel();
        labelDataElo2 = new javax.swing.JLabel();
        iconHrac1Figurky = new javax.swing.JLabel();
        iconHrac2Figurky = new javax.swing.JLabel();
        labelVS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelInformacie.setText("Inform·cie o z·pase:");
        jPanel1.add(labelInformacie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        AvatarHrac1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        jPanel1.add(AvatarHrac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        AvatarHrac2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        jPanel1.add(AvatarHrac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        btnPripojitSa.setBackground(new java.awt.Color(118, 155, 108));
        btnPripojitSa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPripojitSa.setForeground(new java.awt.Color(255, 255, 255));
        btnPripojitSa.setText("Pripojiù sa do hry");
        btnPripojitSa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPripojitSaMouseReleased(evt);
            }
        });
        jPanel1.add(btnPripojitSa, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 140, -1));

        labelDataMenoHraca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataMenoHraca.setText("Meno hr·Ëa 1");
        jPanel1.add(labelDataMenoHraca, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 230, 170, -1));

        labelCasZacaitku.setText("»as zaËiatku:");
        jPanel1.add(labelCasZacaitku, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        labelFormat.setText("Form·t:");
        jPanel1.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        labelDataMenoHraca2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataMenoHraca2.setText("Meno hr·Ëa 2");
        jPanel1.add(labelDataMenoHraca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 230, 170, -1));

        labelDataCasZaciatku.setText("jLabel8");
        jPanel1.add(labelDataCasZaciatku, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        labelTempoHry.setText("Tempo hry:");
        jPanel1.add(labelTempoHry, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        labelDataFormat.setText("jLabel10");
        jPanel1.add(labelDataFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        labelDataTempoHry.setText("jLabel11");
        jPanel1.add(labelDataTempoHry, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        labelDataElo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataElo1.setText("ELO hr·Ëa 1");
        jPanel1.add(labelDataElo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 250, 160, -1));

        labelDataElo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataElo2.setText("ELO hr·Ëa 2");
        jPanel1.add(labelDataElo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 246, 170, 20));

        iconHrac1Figurky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/blackking.png"))); // NOI18N
        jPanel1.add(iconHrac1Figurky, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        iconHrac2Figurky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/whiteking.png"))); // NOI18N
        jPanel1.add(iconHrac2Figurky, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        labelVS.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelVS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVS.setText("vs.");
        jPanel1.add(labelVS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 80, 60));

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

    private void btnPripojitSaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPripojitSaMouseReleased
        try {
            Desktop.getDesktop().browse(new URI("http://www.chess.com"));
        } catch (URISyntaxException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnPripojitSaMouseReleased

    private void vyplnLabely() {
        Hrac hrac1 = this.zapas.getHrac1();
        Hrac hrac2 = this.zapas.getHrac2();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        labelDataCasZaciatku.setText(sdf.format(this.zapas.getCasZaciatku()));
        labelDataElo1.setText(String.valueOf(hrac1.getELO()));
        labelDataElo2.setText(String.valueOf(hrac2.getELO()));
        labelDataFormat.setText(this.zapas.getTurnaj().getFormat().toString());
        labelDataMenoHraca.setText(hrac1.getMeno());
        labelDataMenoHraca2.setText(hrac2.getMeno());
        labelDataTempoHry.setText(this.zapas.getTurnaj().getTempoHry().toString());
        AvatarHrac1.setIcon(hrac1.getAvatar().getImage());
        AvatarHrac2.setIcon(hrac2.getAvatar().getImage());
        if (zapas.getHrac1Figurky() == FarbaFiguriek.BIELA) {
            iconHrac1Figurky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/whiteking.png")));
            iconHrac2Figurky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/blackking.png")));
        } else {
            iconHrac1Figurky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/blackking.png")));
            iconHrac2Figurky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/whiteking.png")));
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AvatarHrac1;
    private javax.swing.JLabel AvatarHrac2;
    private javax.swing.JButton btnPripojitSa;
    private javax.swing.JLabel iconHrac1Figurky;
    private javax.swing.JLabel iconHrac2Figurky;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCasZacaitku;
    private javax.swing.JLabel labelDataCasZaciatku;
    private javax.swing.JLabel labelDataElo1;
    private javax.swing.JLabel labelDataElo2;
    private javax.swing.JLabel labelDataFormat;
    private javax.swing.JLabel labelDataMenoHraca;
    private javax.swing.JLabel labelDataMenoHraca2;
    private javax.swing.JLabel labelDataTempoHry;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelInformacie;
    private javax.swing.JLabel labelTempoHry;
    private javax.swing.JLabel labelVS;
    // End of variables declaration//GEN-END:variables
}
