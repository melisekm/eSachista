package sk.stu.fiit.view.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.Stage;

/**
 *
 * @author Martin Melisek
 */
public class TurnajInfoDialog extends javax.swing.JDialog {
    
    private int BODY_STLPEC = 3;

    public TurnajInfoDialog(java.awt.Frame parent, boolean modal, Turnaj vybratyTurnaj) {
        super(parent, modal);
        initComponents();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableHraci.getModel());
        tableHraci.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(BODY_STLPEC, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        this.showTurnajInfo(vybratyTurnaj);
        this.naplnTabulku(vybratyTurnaj);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JPanel();
        infoPane = new javax.swing.JPanel();
        labelTimeControl = new javax.swing.JLabel();
        labelPocetHracov = new javax.swing.JLabel();
        labelRating = new javax.swing.JLabel();
        labelVekovaKatMax = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        scrollPaneOpis = new javax.swing.JScrollPane();
        textAreaDataOpis = new javax.swing.JTextArea();
        labelOpis = new javax.swing.JLabel();
        labelDataTimeControl = new javax.swing.JLabel();
        labelDataFormat = new javax.swing.JLabel();
        labelDataPocetHracov = new javax.swing.JLabel();
        labelDataRating = new javax.swing.JLabel();
        labelDataVek = new javax.swing.JLabel();
        scrollPaneTabulka = new javax.swing.JScrollPane();
        tableHraci = new javax.swing.JTable();
        labelIcon = new javax.swing.JLabel();
        cbUkonceny = new javax.swing.JCheckBox();
        labelMiestoKonania = new javax.swing.JLabel();
        labelZaciatok = new javax.swing.JLabel();
        labelDataZaciatok = new javax.swing.JLabel();
        labelDataMiesto = new javax.swing.JLabel();
        labelDataNazovTurnaja = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inform·cie o turnaji");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPane.setBackground(new java.awt.Color(240, 243, 247));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoPane.setBackground(new java.awt.Color(255, 255, 255));
        infoPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTimeControl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTimeControl.setForeground(new java.awt.Color(68, 68, 68));
        labelTimeControl.setText("Time control:");
        infoPane.add(labelTimeControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        labelPocetHracov.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPocetHracov.setForeground(new java.awt.Color(68, 68, 68));
        labelPocetHracov.setText("PoËet hr·Ëov");
        infoPane.add(labelPocetHracov, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        labelRating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRating.setForeground(new java.awt.Color(68, 68, 68));
        labelRating.setText("Rating:");
        infoPane.add(labelRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        labelVekovaKatMax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelVekovaKatMax.setForeground(new java.awt.Color(68, 68, 68));
        labelVekovaKatMax.setText("Vekov· kategÛria max:");
        infoPane.add(labelVekovaKatMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        labelFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelFormat.setForeground(new java.awt.Color(68, 68, 68));
        labelFormat.setText("Form·t:");
        infoPane.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        textAreaDataOpis.setColumns(20);
        textAreaDataOpis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAreaDataOpis.setLineWrap(true);
        textAreaDataOpis.setRows(5);
        textAreaDataOpis.setWrapStyleWord(true);
        textAreaDataOpis.setEnabled(false);
        textAreaDataOpis.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        scrollPaneOpis.setViewportView(textAreaDataOpis);

        infoPane.add(scrollPaneOpis, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 270, 150));

        labelOpis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelOpis.setForeground(new java.awt.Color(68, 68, 68));
        labelOpis.setText("Opis:");
        infoPane.add(labelOpis, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        labelDataTimeControl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataTimeControl.setForeground(new java.awt.Color(68, 68, 68));
        labelDataTimeControl.setText("jLabel1");
        infoPane.add(labelDataTimeControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        labelDataFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataFormat.setForeground(new java.awt.Color(68, 68, 68));
        labelDataFormat.setText("jLabel3");
        infoPane.add(labelDataFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        labelDataPocetHracov.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataPocetHracov.setForeground(new java.awt.Color(68, 68, 68));
        labelDataPocetHracov.setText("jLabel12");
        infoPane.add(labelDataPocetHracov, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        labelDataRating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataRating.setForeground(new java.awt.Color(68, 68, 68));
        labelDataRating.setText("jLabel13");
        infoPane.add(labelDataRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        labelDataVek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataVek.setForeground(new java.awt.Color(68, 68, 68));
        labelDataVek.setText("jLabel14");
        infoPane.add(labelDataVek, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        mainPane.add(infoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 700, 230));

        tableHraci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meno hr·Ëa", "ELO", "PoËet z·pasov", "PoËet bodov"
            }
        ));
        scrollPaneTabulka.setViewportView(tableHraci);

        mainPane.add(scrollPaneTabulka, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 350, 160));

        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/chess-chess-board-game-chessboard-icon-wrong.png"))); // NOI18N
        mainPane.add(labelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        cbUkonceny.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbUkonceny.setForeground(new java.awt.Color(255, 255, 255));
        cbUkonceny.setText("UkonËen˝");
        cbUkonceny.setEnabled(false);
        mainPane.add(cbUkonceny, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));

        labelMiestoKonania.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelMiestoKonania.setForeground(new java.awt.Color(238, 176, 18));
        labelMiestoKonania.setText("Miesto konania:");
        mainPane.add(labelMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        labelZaciatok.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelZaciatok.setForeground(new java.awt.Color(238, 176, 18));
        labelZaciatok.setText("ZaËiatok: ");
        mainPane.add(labelZaciatok, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        labelDataZaciatok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataZaciatok.setText("jLabel1");
        mainPane.add(labelDataZaciatok, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 630, -1));

        labelDataMiesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataMiesto.setText("jLabel3");
        mainPane.add(labelDataMiesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 390, -1));

        labelDataNazovTurnaja.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelDataNazovTurnaja.setForeground(new java.awt.Color(54, 107, 172));
        labelDataNazovTurnaja.setText("N·zov turnaja ");
        mainPane.add(labelDataNazovTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        btnClose.setBackground(new java.awt.Color(102, 102, 255));
        btnClose.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Zavrieù");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCloseMouseReleased(evt);
            }
        });
        mainPane.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, -1, -1));

        getContentPane().add(mainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseReleased
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseReleased

    private void showTurnajInfo(Turnaj t) {
        labelDataNazovTurnaja.setText(t.getNazov());
        labelDataZaciatok.setText(t.getDatumKonania().toString());
        labelDataMiesto.setText(t.getMiestoKonania());
        labelDataTimeControl.setText(t.getTempoHry().toString());
        labelDataFormat.setText(t.getFormat().toString());
        labelDataPocetHracov.setText(Integer.toString(t.getHraci().size()));
        labelDataRating.setText(t.getObmedzenia().getRatingObmedzenie());
        labelDataVek.setText(t.getObmedzenia().getVekObmedzenie());
        textAreaDataOpis.setText(t.getPopis());
        cbUkonceny.setSelected(t.isFinished());
    }

    private void naplnTabulku(Turnaj t) {
        if (t.getStage() == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableHraci.getModel();
        model.setRowCount(0);
        Stage stage = t.getStage();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JCheckBox cbUkonceny;
    private javax.swing.JPanel infoPane;
    private javax.swing.JLabel labelDataFormat;
    private javax.swing.JLabel labelDataMiesto;
    private javax.swing.JLabel labelDataNazovTurnaja;
    private javax.swing.JLabel labelDataPocetHracov;
    private javax.swing.JLabel labelDataRating;
    private javax.swing.JLabel labelDataTimeControl;
    private javax.swing.JLabel labelDataVek;
    private javax.swing.JLabel labelDataZaciatok;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JLabel labelMiestoKonania;
    private javax.swing.JLabel labelOpis;
    private javax.swing.JLabel labelPocetHracov;
    private javax.swing.JLabel labelRating;
    private javax.swing.JLabel labelTimeControl;
    private javax.swing.JLabel labelVekovaKatMax;
    private javax.swing.JLabel labelZaciatok;
    private javax.swing.JPanel mainPane;
    private javax.swing.JScrollPane scrollPaneOpis;
    private javax.swing.JScrollPane scrollPaneTabulka;
    private javax.swing.JTable tableHraci;
    private javax.swing.JTextArea textAreaDataOpis;
    // End of variables declaration//GEN-END:variables
}
