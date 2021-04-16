/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.AktivneTurnajeController;
import sk.stu.fiit.controller.HracController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.utils.ViewUtils;
import sk.stu.fiit.view.dialogs.TurnajInfoDialog;
import sk.stu.fiit.view.dialogs.ZapasDialog;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class AktivneTurnajePane extends javax.swing.JPanel implements IViewRefresh {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajePane.class);

    private AktivneTurnajeController controller;
    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

    private Turnaj prebiehajuciTurnaj;

    public AktivneTurnajePane(HracController controller) {
        this.controller = new AktivneTurnajeController();
        initComponents();
    }

    public AktivneTurnajePane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        turnajPane = new javax.swing.JPanel();
        labelDataPocetHracov = new javax.swing.JLabel();
        labelPravePrebiehaTurnaj = new javax.swing.JLabel();
        labelDataNazovTurnaju = new javax.swing.JLabel();
        labelDataDatumTurnaja = new javax.swing.JLabel();
        labelDataMiestoKonania = new javax.swing.JLabel();
        labelNazovTurnaja = new javax.swing.JLabel();
        labelZaciatokTurnaja = new javax.swing.JLabel();
        labelDataFormatTurnaja = new javax.swing.JLabel();
        labelPocetTurnajov = new javax.swing.JLabel();
        scrollPaneHarmonogram = new javax.swing.JScrollPane();
        tableHarmonogram = new javax.swing.JTable();
        labelMiestoKonania = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        btnZobrazitZapas = new javax.swing.JButton();
        btnPrevziatHarmonogram = new javax.swing.JButton();
        labelNeprebiehaTurnaj = new javax.swing.JLabel();
        mainPane = new javax.swing.JPanel();
        labelNaplanovaneTurnaje = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JCalendar();
        labelNadchadzaujceTurnaje = new javax.swing.JLabel();
        scrollPaneTurnaje = new javax.swing.JScrollPane();
        listTurnaje = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        turnajPane.setBackground(new java.awt.Color(255, 255, 255));
        turnajPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDataPocetHracov.setBackground(new java.awt.Color(0, 0, 0));
        labelDataPocetHracov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDataPocetHracov.setForeground(new java.awt.Color(0, 0, 0));
        labelDataPocetHracov.setText("8");
        turnajPane.add(labelDataPocetHracov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        labelPravePrebiehaTurnaj.setBackground(new java.awt.Color(0, 0, 0));
        labelPravePrebiehaTurnaj.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelPravePrebiehaTurnaj.setForeground(new java.awt.Color(0, 0, 0));
        labelPravePrebiehaTurnaj.setText("Pr·ve prebieha turnaj:");
        turnajPane.add(labelPravePrebiehaTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        labelDataNazovTurnaju.setBackground(new java.awt.Color(0, 0, 0));
        labelDataNazovTurnaju.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDataNazovTurnaju.setForeground(new java.awt.Color(0, 0, 0));
        labelDataNazovTurnaju.setText("Dekanov");
        turnajPane.add(labelDataNazovTurnaju, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        labelDataDatumTurnaja.setBackground(new java.awt.Color(0, 0, 0));
        labelDataDatumTurnaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDataDatumTurnaja.setForeground(new java.awt.Color(0, 0, 0));
        labelDataDatumTurnaja.setText("15.3.2021");
        turnajPane.add(labelDataDatumTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        labelDataMiestoKonania.setBackground(new java.awt.Color(0, 0, 0));
        labelDataMiestoKonania.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDataMiestoKonania.setForeground(new java.awt.Color(0, 0, 0));
        labelDataMiestoKonania.setText("FIIT STu");
        turnajPane.add(labelDataMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        labelNazovTurnaja.setBackground(new java.awt.Color(0, 0, 0));
        labelNazovTurnaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNazovTurnaja.setForeground(new java.awt.Color(0, 0, 0));
        labelNazovTurnaja.setText("N·zov turnaja:");
        turnajPane.add(labelNazovTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        labelZaciatokTurnaja.setBackground(new java.awt.Color(0, 0, 0));
        labelZaciatokTurnaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelZaciatokTurnaja.setForeground(new java.awt.Color(0, 0, 0));
        labelZaciatokTurnaja.setText("ZaËiatok:");
        turnajPane.add(labelZaciatokTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        labelDataFormatTurnaja.setBackground(new java.awt.Color(0, 0, 0));
        labelDataFormatTurnaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDataFormatTurnaja.setForeground(new java.awt.Color(0, 0, 0));
        labelDataFormatTurnaja.setText("SINGLE ELIMINATION");
        turnajPane.add(labelDataFormatTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        labelPocetTurnajov.setBackground(new java.awt.Color(0, 0, 0));
        labelPocetTurnajov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPocetTurnajov.setForeground(new java.awt.Color(0, 0, 0));
        labelPocetTurnajov.setText("PoËet hr·Ëov:");
        turnajPane.add(labelPocetTurnajov, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        tableHarmonogram.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPaneHarmonogram.setViewportView(tableHarmonogram);

        turnajPane.add(scrollPaneHarmonogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 400, 190));

        labelMiestoKonania.setBackground(new java.awt.Color(0, 0, 0));
        labelMiestoKonania.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMiestoKonania.setForeground(new java.awt.Color(0, 0, 0));
        labelMiestoKonania.setText("Miesto konania:");
        turnajPane.add(labelMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        labelFormat.setBackground(new java.awt.Color(0, 0, 0));
        labelFormat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFormat.setForeground(new java.awt.Color(0, 0, 0));
        labelFormat.setText("Form·t:");
        turnajPane.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnZobrazitZapas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnZobrazitZapas.setText("ZOBRAZIç Z¡PAS");
        btnZobrazitZapas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnZobrazitZapasMouseReleased(evt);
            }
        });
        turnajPane.add(btnZobrazitZapas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        btnPrevziatHarmonogram.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrevziatHarmonogram.setText("Prevziaù harmonogram");
        btnPrevziatHarmonogram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrevziatHarmonogramMouseReleased(evt);
            }
        });
        turnajPane.add(btnPrevziatHarmonogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        add(turnajPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, 550));

        labelNeprebiehaTurnaj.setText("Moment·lne neprebieha ûiadny turnaj...");
        add(labelNeprebiehaTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        mainPane.setBackground(new java.awt.Color(204, 204, 204));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNaplanovaneTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelNaplanovaneTurnaje.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelNaplanovaneTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        labelNaplanovaneTurnaje.setText("Nem·te napl·novan˝ ûiadny turnaj...");
        mainPane.add(labelNaplanovaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        calendar.setBackground(new java.awt.Color(153, 153, 153));
        calendar.setForeground(new java.awt.Color(51, 51, 51));
        mainPane.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 230));

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

        mainPane.add(scrollPaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 370, 270));

        add(mainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 370, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void listTurnajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTurnajeMouseReleased
        Turnaj t = (Turnaj) listTurnaje.getSelectedValue();
        if (t == null) {
            return;
        }
        ViewUtils.showDialog(new TurnajInfoDialog(parent, true, t));
    }//GEN-LAST:event_listTurnajeMouseReleased

    private void btnPrevziatHarmonogramMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevziatHarmonogramMouseReleased
        int turnajId = this.controller.getTurnajId(this.prebiehajuciTurnaj);
        if (turnajId != -1) {
            this.naplnTabulkuRozpisov(turnajId);
            JOptionPane.showMessageDialog(this, "Harmonogram uspesne prevzaty.");
        } else {
            logger.info("Harmonogram nebol vygenerovany.");
            JOptionPane.showMessageDialog(this, "Harmonogram este nebol vygenerovany");
        }
    }//GEN-LAST:event_btnPrevziatHarmonogramMouseReleased

    private void btnZobrazitZapasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZobrazitZapasMouseReleased
        // TODO pridat zapas hracovi do historie. aj turnaj SPRAVI SPRAVCA pri generovani harmonogramu.
        Zapas zapas = this.controller.najdiZapasHraca();
        if (zapas == null) {
            logger.info("Zapas pre hraca nebol najdeny.");
            JOptionPane.showMessageDialog(this, "Zapas pre vas nebol najdeny");
            return;
        }
        ViewUtils.showDialog(new ZapasDialog(this.parent, true, zapas));
    }//GEN-LAST:event_btnZobrazitZapasMouseReleased

    private void naplnTabulkuRozpisov(int turnajId) {
        this.controller.parseTurnaj(turnajId);
        ArrayList<Zapas> harmonogram = this.controller.getHarmonogram();
        DefaultTableModel model = (DefaultTableModel) tableHarmonogram.getModel();
        model.setRowCount(0);
        for (Zapas zapas : harmonogram) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Hrac vyherca = zapas.getVyherca();
            String vyhercaTxt = "-";
            if (vyherca != null) {
                vyhercaTxt = vyherca.toString();
            }
            model.addRow(new Object[]{
                zapas.getHrac1(),
                zapas.getHrac2(),
                sdf.format(zapas.getCasZaciatku()),
                vyhercaTxt
            });
        }
    }

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
        this.prebiehajuciTurnaj = this.controller.isTurnajOn();
        if (this.prebiehajuciTurnaj == null) {
            turnajPane.setVisible(false);
            labelNeprebiehaTurnaj.setVisible(true);
            return;
        }
        this.naplnTurnajPane(this.prebiehajuciTurnaj);
        turnajPane.setVisible(true);
        labelNeprebiehaTurnaj.setVisible(false);

    }

    private void naplnTurnajPane(Turnaj turnaj) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        labelDataNazovTurnaju.setText(turnaj.getNazov());
        labelDataDatumTurnaja.setText(sdf.format(turnaj.getDatumKonania()));
        labelDataFormatTurnaja.setText(turnaj.getFormat().toString());
        labelDataMiestoKonania.setText(turnaj.getMiestoKonania());
        labelDataPocetHracov.setText(String.valueOf(turnaj.getHraci().size()));
    }

    @Override
    public void refresh() {
        this.naplnListTurnajov();
        this.zobrazPrebiehajuciTurnaj();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrevziatHarmonogram;
    private javax.swing.JButton btnZobrazitZapas;
    private com.toedter.calendar.JCalendar calendar;
    private javax.swing.JLabel labelDataDatumTurnaja;
    private javax.swing.JLabel labelDataFormatTurnaja;
    private javax.swing.JLabel labelDataMiestoKonania;
    private javax.swing.JLabel labelDataNazovTurnaju;
    private javax.swing.JLabel labelDataPocetHracov;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelMiestoKonania;
    private javax.swing.JLabel labelNadchadzaujceTurnaje;
    private javax.swing.JLabel labelNaplanovaneTurnaje;
    private javax.swing.JLabel labelNazovTurnaja;
    private javax.swing.JLabel labelNeprebiehaTurnaj;
    private javax.swing.JLabel labelPocetTurnajov;
    private javax.swing.JLabel labelPravePrebiehaTurnaj;
    private javax.swing.JLabel labelZaciatokTurnaja;
    private javax.swing.JList<Turnaj> listTurnaje;
    private javax.swing.JPanel mainPane;
    private javax.swing.JScrollPane scrollPaneHarmonogram;
    private javax.swing.JScrollPane scrollPaneTurnaje;
    private javax.swing.JTable tableHarmonogram;
    private javax.swing.JPanel turnajPane;
    // End of variables declaration//GEN-END:variables

}
