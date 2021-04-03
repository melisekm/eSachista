/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.TurnajController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.view.ViewUtils;
import sk.stu.fiit.view.dialogs.VytvoritTurnajDialog;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class TurnajePane extends javax.swing.JPanel implements IViewRefresh {

    private static final Logger logger = LoggerFactory.getLogger(TurnajePane.class);
    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
    private TurnajController controller;
    private JLabel[] turnajLabels;

    public TurnajePane() {
        initComponents();
        controller = new TurnajController();
        this.turnajLabels = new JLabel[]{
            labelFormatData, labelKapacitaData, labelMiestoKonaniaData, labelNazovData, labelTempoData,
            labelMaxVekData, labelRatingData
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelZiadneTurnaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTurnaje = new javax.swing.JList<>();
        labelTurnaje = new javax.swing.JLabel();
        btnUpravit = new javax.swing.JButton();
        labelNazov = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        labelKapacita = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listHraciNaTurnaji = new javax.swing.JList<>();
        labelMiestoKonania = new javax.swing.JLabel();
        labelTempo = new javax.swing.JLabel();
        btnVytvoritTurnaj = new javax.swing.JButton();
        labelNazovData = new javax.swing.JLabel();
        labelKapacitaData = new javax.swing.JLabel();
        labelFormatData = new javax.swing.JLabel();
        labelMiestoKonaniaData = new javax.swing.JLabel();
        labelTempoData = new javax.swing.JLabel();
        labelRating = new javax.swing.JLabel();
        labelMaxVek = new javax.swing.JLabel();
        labelMaxVekData = new javax.swing.JLabel();
        labelRatingData = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelZiadneTurnaje.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        labelZiadneTurnaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelZiadneTurnaje.setText("Pr�ve nie je napl�novan� �iaden turnaj");
        add(labelZiadneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 340, -1));

        listTurnaje.setModel(new DefaultListModel<Turnaj>());
        listTurnaje.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTurnaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listTurnajeMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listTurnaje);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 380, 410));

        labelTurnaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTurnaje.setText("Zoznam napl�novan�ch turnajov");
        add(labelTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnUpravit.setBackground(new java.awt.Color(204, 204, 204));
        btnUpravit.setForeground(new java.awt.Color(0, 0, 0));
        btnUpravit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        btnUpravit.setText("Upravi� turnaj");
        btnUpravit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpravitMouseReleased(evt);
            }
        });
        add(btnUpravit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 160, 30));

        labelNazov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNazov.setText("N�zov turnaja:");
        add(labelNazov, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        labelFormat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFormat.setText("Form�t turnaja:");
        add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        labelKapacita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelKapacita.setText("Kapacita: ");
        add(labelKapacita, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        listHraciNaTurnaji.setModel(new DefaultListModel<Hrac>());
        jScrollPane2.setViewportView(listHraciNaTurnaji);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 290, 210));

        labelMiestoKonania.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMiestoKonania.setText("Miesto Konania:");
        add(labelMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        labelTempo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTempo.setText("Tempo hry: ");
        add(labelTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        btnVytvoritTurnaj.setBackground(new java.awt.Color(118, 155, 108));
        btnVytvoritTurnaj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVytvoritTurnaj.setForeground(new java.awt.Color(255, 255, 255));
        btnVytvoritTurnaj.setText("VYTVORI� NOV� TURNAJ");
        btnVytvoritTurnaj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVytvoritTurnajMouseReleased(evt);
            }
        });
        add(btnVytvoritTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 380, 40));

        labelNazovData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNazovData.setText("--");
        add(labelNazovData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 210, -1));

        labelKapacitaData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelKapacitaData.setText("0/0");
        add(labelKapacitaData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 70, -1));

        labelFormatData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFormatData.setText("--");
        add(labelFormatData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 210, -1));

        labelMiestoKonaniaData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMiestoKonaniaData.setText("---");
        add(labelMiestoKonaniaData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 210, -1));

        labelTempoData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTempoData.setText("--");
        add(labelTempoData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 210, -1));

        labelRating.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRating.setText("Rating:");
        add(labelRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        labelMaxVek.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMaxVek.setText("Vek:");
        add(labelMaxVek, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        labelMaxVekData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMaxVekData.setText("--");
        add(labelMaxVekData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 210, -1));

        labelRatingData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRatingData.setText("--");
        add(labelRatingData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 210, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVytvoritTurnajMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVytvoritTurnajMouseReleased
        VytvoritTurnajDialog dialog = new VytvoritTurnajDialog(this.parent, true, this.controller, null);
        Turnaj novy = dialog.showDialog();
        if (novy == null) {
            return;
        }
        this.controller.saveTurnaj(novy);
        this.updateList(novy);

    }//GEN-LAST:event_btnVytvoritTurnajMouseReleased

    private void btnUpravitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpravitMouseReleased
        Turnaj povodny = listTurnaje.getSelectedValue();
        boolean turnajUzPrebieha = new Date().after(povodny.getDatumKonania());
        if (turnajUzPrebieha) {
            JOptionPane.showMessageDialog(this, "Tento Turnaj nieje mozne editovat pretoze uz prebieha.", "TURNAJ IN PROGRESS", JOptionPane.ERROR_MESSAGE);
            return;
        }
        VytvoritTurnajDialog dialog = new VytvoritTurnajDialog(this.parent, true, this.controller, povodny);
        Turnaj novy = dialog.showDialog();
        if (novy == null) {
            return;
        }
        this.controller.upravTurnaj(povodny, novy);
        this.updateList(povodny);

    }//GEN-LAST:event_btnUpravitMouseReleased
    private void updateList(Turnaj t) {
        logger.info(t.getNazov() + " bol ulozeny do listu Turnajov");
        this.refresh();
        listTurnaje.setSelectedValue(t, true);
        this.setTurnajInfo();
    }
    
    private void listTurnajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTurnajeMouseReleased
        this.setTurnajInfo();
    }//GEN-LAST:event_listTurnajeMouseReleased

    private void naplnTurnajList() {
        DefaultListModel<Turnaj> model = (DefaultListModel<Turnaj>) listTurnaje.getModel();
        model.setSize(0);
        ArrayList<Turnaj> turnaje = this.controller.getTurnaje();
        for (Turnaj t : turnaje) {
            model.addElement(t);
        }
        listTurnaje.setSelectedIndex(0);
        this.setTurnajInfo();

    }

    private void setTurnajInfo() {
        Turnaj t = listTurnaje.getSelectedValue();
        if (listTurnaje.getModel().getSize() == 0) {
            ViewUtils.clearLabels(turnajLabels);
            labelZiadneTurnaje.setVisible(true);
            return;
        }
        labelZiadneTurnaje.setVisible(false);
        labelFormatData.setText(t.getFormat().toString());
        labelKapacitaData.setText(this.controller.getTurnajKapacita(t));
        labelMiestoKonaniaData.setText(t.getMiestoKonania());
        labelNazovData.setText(t.getNazov());
        labelTempoData.setText(t.getTempoHry().toString());
        labelRatingData.setText(t.getObmedzenia().getRatingObmedzenie());
        String maxVek;
        if (t.getObmedzenia().getMaxVek() == Integer.MAX_VALUE) {
            maxVek = "OPEN";
        } else {
            maxVek = String.valueOf(t.getObmedzenia().getMaxVek());
        }
        labelMaxVekData.setText(maxVek);
        this.naplnHracovTurnaja(t);
    }

    private void naplnHracovTurnaja(Turnaj t) {
        DefaultListModel<Hrac> model = (DefaultListModel<Hrac>) listHraciNaTurnaji.getModel();
        model.setSize(0);
        for (Hrac hrac : t.getHraci()) {
            model.addElement(hrac);
        }
        listHraciNaTurnaji.setSelectedIndex(0);
    }

    public void refresh() {
        this.naplnTurnajList();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpravit;
    private javax.swing.JButton btnVytvoritTurnaj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelFormatData;
    private javax.swing.JLabel labelKapacita;
    private javax.swing.JLabel labelKapacitaData;
    private javax.swing.JLabel labelMaxVek;
    private javax.swing.JLabel labelMaxVekData;
    private javax.swing.JLabel labelMiestoKonania;
    private javax.swing.JLabel labelMiestoKonaniaData;
    private javax.swing.JLabel labelNazov;
    private javax.swing.JLabel labelNazovData;
    private javax.swing.JLabel labelRating;
    private javax.swing.JLabel labelRatingData;
    private javax.swing.JLabel labelTempo;
    private javax.swing.JLabel labelTempoData;
    private javax.swing.JLabel labelTurnaje;
    private javax.swing.JLabel labelZiadneTurnaje;
    private javax.swing.JList<Hrac> listHraciNaTurnaji;
    private javax.swing.JList<Turnaj> listTurnaje;
    // End of variables declaration//GEN-END:variables
}
