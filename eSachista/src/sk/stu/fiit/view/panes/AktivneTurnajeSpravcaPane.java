/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.AktivneTurnajeSpravcaController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.RoundRobinStage;
import sk.stu.fiit.utils.ViewUtils;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class AktivneTurnajeSpravcaPane extends javax.swing.JPanel implements IViewRefresh {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeSpravcaPane.class);

    int VYHERCA_COLUMN = 4;

    private AktivneTurnajeSpravcaController controller;

    public AktivneTurnajeSpravcaPane() {
        initComponents();
        this.controller = new AktivneTurnajeSpravcaController();
        tableHarmonogram.getColumnModel().getColumn(0).setResizable(false);
        tableHarmonogram.getColumnModel().getColumn(0).setMinWidth(0);
        tableHarmonogram.getColumnModel().getColumn(0).setMaxWidth(0);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableHraci.getModel());
        tableHraci.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        btnArchivovat.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogZadatVysledok = new javax.swing.JDialog();
        dialogMainPane = new javax.swing.JPanel();
        labelZadatVysledok = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        cbVitaz = new javax.swing.JComboBox<>();
        labelVybratVitaza = new javax.swing.JLabel();
        labelNeprebiehaTurnaj = new javax.swing.JLabel();
        prebiehajuciTurnajPane = new javax.swing.JPanel();
        labelPravePrebiehaTurnaj = new javax.swing.JLabel();
        labelZaciatok = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        labelPocetHracov = new javax.swing.JLabel();
        labelDataNazovTurnaja = new javax.swing.JLabel();
        labelDataZaciatokTurnaja = new javax.swing.JLabel();
        scrollPaneHarmonogram = new javax.swing.JScrollPane();
        tableHarmonogram = new javax.swing.JTable();
        labelHaromonogram = new javax.swing.JLabel();
        btnZapisatVysledok = new javax.swing.JButton();
        scrollPaneTabulka = new javax.swing.JScrollPane();
        tableHraci = new javax.swing.JTable();
        labelHraci = new javax.swing.JLabel();
        btnArchivovat = new javax.swing.JButton();
        labelDataFormat = new javax.swing.JLabel();
        labelDataPocetHracov = new javax.swing.JLabel();
        btnGenerujHarmnogram = new javax.swing.JButton();
        labelMiestoKonania = new javax.swing.JLabel();
        labelDataMiestoKonania = new javax.swing.JLabel();

        dialogZadatVysledok.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dialogMainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelZadatVysledok.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelZadatVysledok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelZadatVysledok.setText("Zadaù v˝sledok");
        dialogMainPane.add(labelZadatVysledok, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 180, -1));

        btnOK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOK.setText("Potvrdiù");
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOKMouseReleased(evt);
            }
        });
        dialogMainPane.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 180, -1));

        cbVitaz.setModel(new DefaultComboBoxModel<Hrac>());
        dialogMainPane.add(cbVitaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 180, -1));

        labelVybratVitaza.setText("Vybraù vÌùaza z·pasu:");
        dialogMainPane.add(labelVybratVitaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        dialogZadatVysledok.getContentPane().add(dialogMainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 210));

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(860, 590));
        setPreferredSize(new java.awt.Dimension(860, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNeprebiehaTurnaj.setText("Moment·lne neprebieha ûiadny turnaj...");
        add(labelNeprebiehaTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        prebiehajuciTurnajPane.setBackground(new java.awt.Color(255, 255, 255));
        prebiehajuciTurnajPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPravePrebiehaTurnaj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPravePrebiehaTurnaj.setText("Pr·ve prebieha turnaj:");
        prebiehajuciTurnajPane.add(labelPravePrebiehaTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        labelZaciatok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelZaciatok.setText("ZaËiatok:");
        prebiehajuciTurnajPane.add(labelZaciatok, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        labelFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelFormat.setText("Form·t:");
        prebiehajuciTurnajPane.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        labelPocetHracov.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPocetHracov.setText("PoËet hr·Ëov:");
        prebiehajuciTurnajPane.add(labelPocetHracov, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        labelDataNazovTurnaja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataNazovTurnaja.setText("Nazov");
        prebiehajuciTurnajPane.add(labelDataNazovTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        labelDataZaciatokTurnaja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataZaciatokTurnaja.setText("Zaciatok");
        prebiehajuciTurnajPane.add(labelDataZaciatokTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        tableHarmonogram.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zapas", "Hr·Ë 1", "Hr·Ë 2", "»as", "V˝herca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneHarmonogram.setViewportView(tableHarmonogram);

        prebiehajuciTurnajPane.add(scrollPaneHarmonogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 340, 280));

        labelHaromonogram.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHaromonogram.setForeground(new java.awt.Color(1, 42, 74));
        labelHaromonogram.setText("Harmonogram");
        prebiehajuciTurnajPane.add(labelHaromonogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        btnZapisatVysledok.setBackground(new java.awt.Color(118, 155, 108));
        btnZapisatVysledok.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnZapisatVysledok.setForeground(new java.awt.Color(255, 255, 255));
        btnZapisatVysledok.setText("ZapÌsaù v˝sledok");
        btnZapisatVysledok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnZapisatVysledokMouseReleased(evt);
            }
        });
        prebiehajuciTurnajPane.add(btnZapisatVysledok, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 170, -1));

        tableHraci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meno hr·Ëa", "ELO", "PoËet z·pasov", "PoËet bodov"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPaneTabulka.setViewportView(tableHraci);

        prebiehajuciTurnajPane.add(scrollPaneTabulka, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 350, 280));

        labelHraci.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHraci.setForeground(new java.awt.Color(1, 42, 74));
        labelHraci.setText("Hr·Ëi");
        prebiehajuciTurnajPane.add(labelHraci, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        btnArchivovat.setBackground(new java.awt.Color(118, 155, 108));
        btnArchivovat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnArchivovat.setForeground(new java.awt.Color(255, 255, 255));
        btnArchivovat.setText("Archivovat/if/ukonecny");
        btnArchivovat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnArchivovatMouseReleased(evt);
            }
        });
        prebiehajuciTurnajPane.add(btnArchivovat, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 190, -1));

        labelDataFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataFormat.setText("Format");
        prebiehajuciTurnajPane.add(labelDataFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        labelDataPocetHracov.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataPocetHracov.setText("8");
        prebiehajuciTurnajPane.add(labelDataPocetHracov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        btnGenerujHarmnogram.setBackground(new java.awt.Color(102, 102, 255));
        btnGenerujHarmnogram.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerujHarmnogram.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerujHarmnogram.setText("Vygeneruj harmonogram");
        btnGenerujHarmnogram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGenerujHarmnogramMouseReleased(evt);
            }
        });
        prebiehajuciTurnajPane.add(btnGenerujHarmnogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 240, 40));

        labelMiestoKonania.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMiestoKonania.setText("Miesto konania:");
        prebiehajuciTurnajPane.add(labelMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        labelDataMiestoKonania.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataMiestoKonania.setText("FIIT STu");
        prebiehajuciTurnajPane.add(labelDataMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        add(prebiehajuciTurnajPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerujHarmnogramMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerujHarmnogramMouseReleased
        if (this.controller.getPrebiehajuciTurnaj().getDatumKonania().after(new Date())) {
            long diff = ChronoUnit.MINUTES.between(new Date().toInstant(), this.controller.getPrebiehajuciTurnaj().getDatumKonania().toInstant());
            if (diff > 10) {
                ((DefaultTableModel) tableHarmonogram.getModel()).setRowCount(0);
                ((DefaultTableModel) tableHraci.getModel()).setRowCount(0);
                JOptionPane.showMessageDialog(this, "Rozpis k turnaju sa da vygenerovat az 10 min pred zaciatkom");
                return;
            }
        }
        boolean turnajNeZacal = this.controller.getPrebiehajuciTurnaj().getStage() != null;
        boolean vysledkyNeboliZadane = this.controller.skontrolujZadanePocetVysledkov();

        if (vysledkyNeboliZadane && turnajNeZacal) {
            JOptionPane.showMessageDialog(this, "prosim zadajte vsetky vysledky.");
            return;
        }
        this.controller.vygenerujHarmonogram();
        if (this.controller.getPrebiehajuciTurnaj().isFinished()) {
            logger.info("Turnaj je dohrany.");
            JOptionPane.showMessageDialog(this, "Turnaj je dohrany");
            btnArchivovat.setVisible(true);
            return;
        }
        btnArchivovat.setVisible(false);
        this.updateHarmonogramTable();
        JOptionPane.showMessageDialog(this, "Harmonogram vygenerovany.");
        this.controller.saveOrg();
        this.refresh();
    }//GEN-LAST:event_btnGenerujHarmnogramMouseReleased

    private void btnZapisatVysledokMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZapisatVysledokMouseReleased
        int row = tableHarmonogram.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Prosim vyberte zapas.");
            return;
        }
        Zapas zapas = (Zapas) tableHarmonogram.getValueAt(row, 0);
        if (zapas.getVyherca() != null) {
            JOptionPane.showMessageDialog(this, "Vysledok uz bol zapisany.");
            return;
        }
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbVitaz.getModel();
        model.removeAllElements();
        model.addElement(zapas.getHrac1());
        model.addElement(zapas.getHrac2());

        ViewUtils.showDialog(dialogZadatVysledok);
    }//GEN-LAST:event_btnZapisatVysledokMouseReleased

    private void btnArchivovatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArchivovatMouseReleased
        this.refresh();
    }//GEN-LAST:event_btnArchivovatMouseReleased

    private void btnOKMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseReleased
        Hrac vyherca = (Hrac) cbVitaz.getSelectedItem();
        int row = tableHarmonogram.getSelectedRow();
        Zapas zapas = (Zapas) tableHarmonogram.getValueAt(row, 0);
        this.controller.zadajVysledok(zapas, vyherca);
        dialogZadatVysledok.setVisible(false);
        this.naplnTabulkuHracov();
        (tableHarmonogram.getModel()).setValueAt(zapas.getVyherca().getMeno(), row, this.VYHERCA_COLUMN);
    }//GEN-LAST:event_btnOKMouseReleased

    private void updateHarmonogramTable() {
        if (this.controller.getPrebiehajuciTurnaj().getStage() == null) {
            logger.info("Harmonogram este nebol vygenerovany.");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableHarmonogram.getModel();
        model.setRowCount(0);
        for (Map.Entry<Zapas, Integer> entry : this.controller.getPrebiehajuciTurnaj().getZapasy().entrySet()) {
            Zapas zapas = entry.getKey();
            Integer kolo = entry.getValue();
            if (kolo != this.controller.getPrebiehajuciTurnaj().getStage().getKolo() - 1) {
                continue;
            }
            String vyherca = "-";
            if (zapas.getVyherca() != null) {
                vyherca = zapas.getVyherca().getMeno();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            model.addRow(new Object[]{
                zapas,
                zapas.getHrac1().getMeno(),
                zapas.getHrac2().getMeno(),
                sdf.format(zapas.getCasZaciatku()),
                vyherca
            });

        }
    }

    private void zobrazPrebiehajuciTurnaj() {
        this.controller.setPrebiehajuciTurnaj(this.controller.getNadchadzajuciTurnaj());
        if (this.controller.getPrebiehajuciTurnaj() == null) {
            prebiehajuciTurnajPane.setVisible(false);
            labelNeprebiehaTurnaj.setVisible(true);
            return;
        }
        this.controller.aktualizujTurnajUdaje();
        this.naplnTurnajPane();
        prebiehajuciTurnajPane.setVisible(true);
        labelNeprebiehaTurnaj.setVisible(false);
    }

    private void naplnTurnajPane() {
        Turnaj turnaj = this.controller.getPrebiehajuciTurnaj();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        labelDataNazovTurnaja.setText(turnaj.getNazov());
        labelDataZaciatokTurnaja.setText(sdf.format(turnaj.getDatumKonania()));
        labelDataFormat.setText(turnaj.getFormat().toString());
        labelDataMiestoKonania.setText(turnaj.getMiestoKonania());
        labelDataPocetHracov.setText(String.valueOf(turnaj.getHraci().size()));

        this.naplnTabulkuHracov(); // Precitaj Tabulku zo stage
        this.updateHarmonogramTable();

    }

    private void naplnTabulkuHracov() {
        if (this.controller.getPrebiehajuciTurnaj().getStage() == null) {
            logger.info("Harmonogram este nebol vygenerovany.");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableHraci.getModel();
        model.setRowCount(0);
        switch (this.controller.getPrebiehajuciTurnaj().getFormat()) { // TODO zjednotit pre vsetky stage
            case ROUND_ROBIN:
                RoundRobinStage stage = ((RoundRobinStage) this.controller.getPrebiehajuciTurnaj().getStage());
                for (Map.Entry<Hrac, int[]> en : stage.getTabulka().entrySet()) {
                    Hrac hrac = en.getKey();
                    int[] tab = en.getValue();
                    model.addRow(new Object[]{
                        hrac,
                        hrac.getELO(),
                        tab[0],
                        tab[1]
                    });
                }
                break;
            default:
                throw new AssertionError();
        }

    }

    @Override
    public void refresh() {
        this.controller.setPrebiehajuciTurnaj(null);
        this.zobrazPrebiehajuciTurnaj();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivovat;
    private javax.swing.JButton btnGenerujHarmnogram;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnZapisatVysledok;
    private javax.swing.JComboBox<Hrac> cbVitaz;
    private javax.swing.JPanel dialogMainPane;
    private javax.swing.JDialog dialogZadatVysledok;
    private javax.swing.JLabel labelDataFormat;
    private javax.swing.JLabel labelDataMiestoKonania;
    private javax.swing.JLabel labelDataNazovTurnaja;
    private javax.swing.JLabel labelDataPocetHracov;
    private javax.swing.JLabel labelDataZaciatokTurnaja;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelHaromonogram;
    private javax.swing.JLabel labelHraci;
    private javax.swing.JLabel labelMiestoKonania;
    private javax.swing.JLabel labelNeprebiehaTurnaj;
    private javax.swing.JLabel labelPocetHracov;
    private javax.swing.JLabel labelPravePrebiehaTurnaj;
    private javax.swing.JLabel labelVybratVitaza;
    private javax.swing.JLabel labelZaciatok;
    private javax.swing.JLabel labelZadatVysledok;
    private javax.swing.JPanel prebiehajuciTurnajPane;
    private javax.swing.JScrollPane scrollPaneHarmonogram;
    private javax.swing.JScrollPane scrollPaneTabulka;
    private javax.swing.JTable tableHarmonogram;
    private javax.swing.JTable tableHraci;
    // End of variables declaration//GEN-END:variables

}
