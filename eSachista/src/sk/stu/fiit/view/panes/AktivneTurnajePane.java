package sk.stu.fiit.view.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.AktivneTurnajeHracController;
import sk.stu.fiit.controller.HracController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.Stage;
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

    private AktivneTurnajeHracController controller;
    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

    private Turnaj prebiehajuciTurnaj;
    private Date harmonogramAktualizacia;
    private Timer timer;

    public AktivneTurnajePane(HracController controller) {
        this.controller = new AktivneTurnajeHracController();
        initComponents();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableHraci.getModel());
        tableHraci.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        labelArrow.setVisible(false);
        labelNovaVerzia.setVisible(false);
    }

    public AktivneTurnajePane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vysledkyPane = new javax.swing.JPanel();
        scrollPaneTabulka = new javax.swing.JScrollPane();
        tableHraci = new javax.swing.JTable();
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
        labelNovaVerzia = new javax.swing.JLabel();
        btnZobrazitVysledky = new javax.swing.JToggleButton();
        labelArrow = new javax.swing.JLabel();
        labelNeprebiehaTurnaj = new javax.swing.JLabel();
        mainPane = new javax.swing.JPanel();
        labelNaplanovaneTurnaje = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JCalendar();
        labelNadchadzaujceTurnaje = new javax.swing.JLabel();
        scrollPaneTurnaje = new javax.swing.JScrollPane();
        listTurnaje = new javax.swing.JList<>();

        setBackground(new java.awt.Color(240, 243, 247));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vysledkyPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        vysledkyPane.add(scrollPaneTabulka, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 280));

        add(vysledkyPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 370, 280));

        turnajPane.setBackground(new java.awt.Color(240, 243, 247));
        turnajPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDataPocetHracov.setBackground(new java.awt.Color(0, 0, 0));
        labelDataPocetHracov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDataPocetHracov.setForeground(new java.awt.Color(0, 0, 0));
        labelDataPocetHracov.setText("8");
        turnajPane.add(labelDataPocetHracov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        labelPravePrebiehaTurnaj.setBackground(new java.awt.Color(0, 0, 0));
        labelPravePrebiehaTurnaj.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelPravePrebiehaTurnaj.setForeground(new java.awt.Color(54, 107, 172));
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
        labelNazovTurnaja.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNazovTurnaja.setForeground(new java.awt.Color(238, 176, 18));
        labelNazovTurnaja.setText("N·zov turnaja:");
        turnajPane.add(labelNazovTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        labelZaciatokTurnaja.setBackground(new java.awt.Color(0, 0, 0));
        labelZaciatokTurnaja.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelZaciatokTurnaja.setForeground(new java.awt.Color(238, 176, 18));
        labelZaciatokTurnaja.setText("ZaËiatok:");
        turnajPane.add(labelZaciatokTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        labelDataFormatTurnaja.setBackground(new java.awt.Color(0, 0, 0));
        labelDataFormatTurnaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDataFormatTurnaja.setForeground(new java.awt.Color(0, 0, 0));
        labelDataFormatTurnaja.setText("SINGLE ELIMINATION");
        turnajPane.add(labelDataFormatTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        labelPocetTurnajov.setBackground(new java.awt.Color(0, 0, 0));
        labelPocetTurnajov.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPocetTurnajov.setForeground(new java.awt.Color(238, 176, 18));
        labelPocetTurnajov.setText("PoËet hr·Ëov:");
        turnajPane.add(labelPocetTurnajov, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        tableHarmonogram.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hr·Ë 1", "Hr·Ë 2", "»as", "V˝herca"
            }
        ));
        scrollPaneHarmonogram.setViewportView(tableHarmonogram);

        turnajPane.add(scrollPaneHarmonogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 400, 190));

        labelMiestoKonania.setBackground(new java.awt.Color(0, 0, 0));
        labelMiestoKonania.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelMiestoKonania.setForeground(new java.awt.Color(238, 176, 18));
        labelMiestoKonania.setText("Miesto konania:");
        turnajPane.add(labelMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        labelFormat.setBackground(new java.awt.Color(0, 0, 0));
        labelFormat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelFormat.setForeground(new java.awt.Color(238, 176, 18));
        labelFormat.setText("Form·t:");
        turnajPane.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnZobrazitZapas.setBackground(new java.awt.Color(118, 155, 108));
        btnZobrazitZapas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnZobrazitZapas.setForeground(new java.awt.Color(255, 255, 255));
        btnZobrazitZapas.setText("Zobraziù mÙj z·pas");
        btnZobrazitZapas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnZobrazitZapasMouseReleased(evt);
            }
        });
        turnajPane.add(btnZobrazitZapas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 220, -1));

        btnPrevziatHarmonogram.setBackground(new java.awt.Color(118, 155, 108));
        btnPrevziatHarmonogram.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrevziatHarmonogram.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevziatHarmonogram.setText("Prevziaù harmonogram");
        btnPrevziatHarmonogram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrevziatHarmonogramMouseReleased(evt);
            }
        });
        turnajPane.add(btnPrevziatHarmonogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        labelNovaVerzia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNovaVerzia.setForeground(new java.awt.Color(51, 51, 255));
        labelNovaVerzia.setText("K dispozÌciÌ je nov· verzia");
        turnajPane.add(labelNovaVerzia, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        btnZobrazitVysledky.setText("Zobraziù v˝sledky");
        btnZobrazitVysledky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnZobrazitVysledkyMouseReleased(evt);
            }
        });
        turnajPane.add(btnZobrazitVysledky, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        labelArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/arrow.png"))); // NOI18N
        turnajPane.add(labelArrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 170, 50));

        add(turnajPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 450, 560));

        labelNeprebiehaTurnaj.setText("Moment·lne neprebieha ûiadny turnaj...");
        add(labelNeprebiehaTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        mainPane.setBackground(new java.awt.Color(238, 176, 18));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNaplanovaneTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelNaplanovaneTurnaje.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelNaplanovaneTurnaje.setForeground(new java.awt.Color(255, 255, 255));
        labelNaplanovaneTurnaje.setText("Nem·te napl·novan˝ ûiadny turnaj...");
        mainPane.add(labelNaplanovaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        calendar.setBackground(new java.awt.Color(70, 143, 175));
        calendar.setForeground(new java.awt.Color(1, 42, 74));
        mainPane.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 230));

        labelNadchadzaujceTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelNadchadzaujceTurnaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNadchadzaujceTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        labelNadchadzaujceTurnaje.setText("Nadch·dzaj˙ce turnaje");
        mainPane.add(labelNadchadzaujceTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 245, -1, -1));

        listTurnaje.setBackground(new java.awt.Color(54, 107, 172));
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
        this.harmonogramAktualizacia = new Date();
        int turnajId = this.controller.getTurnajId(this.prebiehajuciTurnaj);
        if (turnajId != -1) {
            this.naplnTabulkuRozpisov(turnajId);
            JOptionPane.showMessageDialog(this, "Harmonogram uspesne prevzaty.");
        } else {
            logger.info("Harmonogram nebol vygenerovany.");
            JOptionPane.showMessageDialog(this, "Harmonogram este nebol vygenerovany");
        }
        this.refresh();
    }//GEN-LAST:event_btnPrevziatHarmonogramMouseReleased

    private void btnZobrazitZapasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZobrazitZapasMouseReleased
        Zapas zapas = this.controller.najdiZapasHraca();
        if (zapas == null) {
            logger.info("Zapas pre hraca nebol najdeny.");
            JOptionPane.showMessageDialog(this, "Zapas pre vas nebol najdeny");
            return;
        }
        ViewUtils.showDialog(new ZapasDialog(this.parent, true, zapas));
    }//GEN-LAST:event_btnZobrazitZapasMouseReleased

    private void btnZobrazitVysledkyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZobrazitVysledkyMouseReleased
        if (btnZobrazitVysledky.isSelected()) {
            mainPane.setVisible(false);
            vysledkyPane.setVisible(true);
            this.naplnVysledkyTabulku();
        } else {
            mainPane.setVisible(true);
            vysledkyPane.setVisible(false);
        }
        this.refresh();
    }//GEN-LAST:event_btnZobrazitVysledkyMouseReleased

    private void naplnVysledkyTabulku() {
        if (this.prebiehajuciTurnaj == null || this.prebiehajuciTurnaj.getStage() == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableHraci.getModel();
        model.setRowCount(0);
        Stage stage = this.prebiehajuciTurnaj.getStage();
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
    }

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
        this.prebiehajuciTurnaj = this.controller.getZacatyTurnaj(this.controller.getPrihlasenyHrac().getTurnaje());
        this.nastavTimer();
        if (this.prebiehajuciTurnaj == null) {
            turnajPane.setVisible(false);
            labelNeprebiehaTurnaj.setVisible(true);
            mainPane.setVisible(true);
            vysledkyPane.setVisible(false);
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

    private void nastavTimer() {
        if (this.timer != null) {
            this.timer.stop();
        }
        this.timer = new Timer(2000, new TimeActionListener(this.controller.getTurnajId(prebiehajuciTurnaj)));
        this.timer.setInitialDelay(0);
        this.timer.start();
    }

    private class TimeActionListener implements ActionListener {

        private int id;

        public TimeActionListener(int id) {
            this.id = id;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (prebiehajuciTurnaj == null) {
                return;
            }
            int id;
            if (this.id != -1) {
                id = this.id;
            } else if (controller.getIdPrebiehajuciTurnaj() != -1) {
                id = controller.getIdPrebiehajuciTurnaj();
            } else {
                id = controller.getTurnajId(prebiehajuciTurnaj);
            }
            File file = new File("resources/turnaje/" + id + "/harmonogram.xml");
            if (file.exists() && (harmonogramAktualizacia == null || (file.lastModified() > harmonogramAktualizacia.getTime()))) {
                labelArrow.setVisible(true);
                labelNovaVerzia.setVisible(true);
            } else {
                labelArrow.setVisible(false);
                labelNovaVerzia.setVisible(false);
            }
        }
    }

    @Override
    public void refresh() {
        this.naplnListTurnajov();
        this.zobrazPrebiehajuciTurnaj();
        this.naplnVysledkyTabulku();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrevziatHarmonogram;
    private javax.swing.JToggleButton btnZobrazitVysledky;
    private javax.swing.JButton btnZobrazitZapas;
    private com.toedter.calendar.JCalendar calendar;
    private javax.swing.JLabel labelArrow;
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
    private javax.swing.JLabel labelNovaVerzia;
    private javax.swing.JLabel labelPocetTurnajov;
    private javax.swing.JLabel labelPravePrebiehaTurnaj;
    private javax.swing.JLabel labelZaciatokTurnaja;
    private javax.swing.JList<Turnaj> listTurnaje;
    private javax.swing.JPanel mainPane;
    private javax.swing.JScrollPane scrollPaneHarmonogram;
    private javax.swing.JScrollPane scrollPaneTabulka;
    private javax.swing.JScrollPane scrollPaneTurnaje;
    private javax.swing.JTable tableHarmonogram;
    private javax.swing.JTable tableHraci;
    private javax.swing.JPanel turnajPane;
    private javax.swing.JPanel vysledkyPane;
    // End of variables declaration//GEN-END:variables

}
