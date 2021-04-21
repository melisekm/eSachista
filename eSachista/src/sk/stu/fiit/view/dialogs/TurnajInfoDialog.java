package sk.stu.fiit.view.dialogs;

import java.util.ArrayList;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class TurnajInfoDialog extends javax.swing.JDialog {

    public TurnajInfoDialog(java.awt.Frame parent, boolean modal, Turnaj vybratyTurnaj) {
        super(parent, modal);
        initComponents();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableHraci.getModel());
        tableHraci.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        this.showTurnajInfo(vybratyTurnaj);
        // TODO naplnit tabulku
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taOpis = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        labelTimeC = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        labelKap = new javax.swing.JLabel();
        labelRating = new javax.swing.JLabel();
        labelVek = new javax.swing.JLabel();
        scrollPaneTabulka = new javax.swing.JScrollPane();
        tableHraci = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelZaciatok = new javax.swing.JLabel();
        labelMiesto = new javax.swing.JLabel();
        labelNazovTurnaja = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inform�cie o turnaji");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(240, 243, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 68, 68));
        jLabel5.setText("Time control:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(68, 68, 68));
        jLabel6.setText("Po�et hr��ov");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(68, 68, 68));
        jLabel8.setText("Rating:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(68, 68, 68));
        jLabel9.setText("Vekov� kateg�ria max:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(68, 68, 68));
        jLabel10.setText("Form�t:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        taOpis.setColumns(20);
        taOpis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taOpis.setLineWrap(true);
        taOpis.setRows(5);
        taOpis.setWrapStyleWord(true);
        taOpis.setEnabled(false);
        taOpis.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(taOpis);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 270, 150));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(68, 68, 68));
        jLabel11.setText("Opis:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        labelTimeC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTimeC.setForeground(new java.awt.Color(68, 68, 68));
        labelTimeC.setText("jLabel1");
        jPanel1.add(labelTimeC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        labelFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelFormat.setForeground(new java.awt.Color(68, 68, 68));
        labelFormat.setText("jLabel3");
        jPanel1.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        labelKap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelKap.setForeground(new java.awt.Color(68, 68, 68));
        labelKap.setText("jLabel12");
        jPanel1.add(labelKap, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        labelRating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRating.setForeground(new java.awt.Color(68, 68, 68));
        labelRating.setText("jLabel13");
        jPanel1.add(labelRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        labelVek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelVek.setForeground(new java.awt.Color(68, 68, 68));
        labelVek.setText("jLabel14");
        jPanel1.add(labelVek, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 700, 230));

        tableHraci.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableHraci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meno hr��a", "ELO", "Po�et z�pasov", "Po�et bodov"
            }
        ));
        scrollPaneTabulka.setViewportView(tableHraci);

        jPanel2.add(scrollPaneTabulka, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 350, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/chess-chess-board-game-chessboard-icon-wrong.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Ukon�en�");
        jCheckBox1.setEnabled(false);
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(238, 176, 18));
        jLabel7.setText("Miesto konania:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 176, 18));
        jLabel4.setText("Za�iatok: ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        labelZaciatok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelZaciatok.setText("jLabel1");
        jPanel2.add(labelZaciatok, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 640, -1));

        labelMiesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMiesto.setText("jLabel3");
        jPanel2.add(labelMiesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 160, -1));

        labelNazovTurnaja.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelNazovTurnaja.setForeground(new java.awt.Color(54, 107, 172));
        labelNazovTurnaja.setText("N�zov turnaja ");
        jPanel2.add(labelNazovTurnaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showTurnajInfo(Turnaj t) {
        labelNazovTurnaja.setText(t.getNazov());
        labelZaciatok.setText(t.getDatumKonania().toString());
        labelMiesto.setText(t.getMiestoKonania());
        labelTimeC.setText(t.getTempoHry().toString());
        labelFormat.setText(t.getFormat().toString());
        labelKap.setText(Integer.toString(t.getHraci().size()));
        labelRating.setText(t.getObmedzenia().getRatingObmedzenie());
        labelVek.setText(Integer.toString(t.getObmedzenia().getMaxVek()));
        taOpis.setText(t.getPopis());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelKap;
    private javax.swing.JLabel labelMiesto;
    private javax.swing.JLabel labelNazovTurnaja;
    private javax.swing.JLabel labelRating;
    private javax.swing.JLabel labelTimeC;
    private javax.swing.JLabel labelVek;
    private javax.swing.JLabel labelZaciatok;
    private javax.swing.JScrollPane scrollPaneTabulka;
    private javax.swing.JTextArea taOpis;
    private javax.swing.JTable tableHraci;
    // End of variables declaration//GEN-END:variables
}
