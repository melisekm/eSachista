/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import sk.stu.fiit.controller.HracController;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.utils.PlatformConstants;
import sk.stu.fiit.view.ViewUtils;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class ZoznamTurnajovPane extends javax.swing.JPanel implements IViewRefresh {

    private HracController controller;

    public ZoznamTurnajovPane(HracController controller) {
        this.controller = controller;
        initComponents();
    }

    public ZoznamTurnajovPane() {
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

        dialogTurnaj = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        scrollPaneTurnaje = new javax.swing.JScrollPane();
        tableTurnaje = new javax.swing.JTable();
        labelPopis = new javax.swing.JLabel();
        btnPrihlasitSa = new javax.swing.JButton();

        dialogTurnaj.setBackground(new java.awt.Color(255, 255, 255));
        dialogTurnaj.setMinimumSize(new java.awt.Dimension(660, 560));
        dialogTurnaj.setModal(true);
        dialogTurnaj.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/chess-chess-board-game-chessboard-icon-wrong.png"))); // NOI18N
        dialogTurnaj.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("N�zov turnaja ");
        dialogTurnaj.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabel4.setText("Za�iatok: ");
        dialogTurnaj.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Time control");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setText("Kapacita");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel8.setText("Rating");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel9.setText("Vekov� kateg�ria");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel10.setText("Form�t");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, 150));

        jLabel11.setText("Opis");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        dialogTurnaj.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 590, 220));

        jLabel7.setText("Miesto konania:");
        dialogTurnaj.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 610));
        setPreferredSize(new java.awt.Dimension(900, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableTurnaje.setBackground(new java.awt.Color(204, 204, 204));
        tableTurnaje.setForeground(new java.awt.Color(51, 51, 51));
        tableTurnaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Poh�r dekana", "Swiss 10+5", "FIIT STU, Bratislava", "Open", "Open", "10/100"}
            },
            new String [] {
                "N�zov a term�n", "Form�t", "Miesto konania", "Rating", "Max Vek", "Kapacita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTurnaje.setGridColor(new java.awt.Color(51, 51, 51));
        tableTurnaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTurnajeMouseClicked(evt);
            }
        });
        scrollPaneTurnaje.setViewportView(tableTurnaje);

        add(scrollPaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 770, 450));

        labelPopis.setForeground(new java.awt.Color(0, 0, 0));
        labelPopis.setText("Kliknut�m na turnaj zobraz�te mo�nosti a podrobn� inform�cie");
        add(labelPopis, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, -1));

        btnPrihlasitSa.setBackground(new java.awt.Color(118, 155, 108));
        btnPrihlasitSa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnPrihlasitSa.setForeground(new java.awt.Color(255, 255, 255));
        btnPrihlasitSa.setText("Prihl�si� sa na turnaj");
        btnPrihlasitSa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrihlasitSaMouseReleased(evt);
            }
        });
        add(btnPrihlasitSa, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 170, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void tableTurnajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTurnajeMouseClicked
        int indexRow = tableTurnaje.getSelectedRow();
        ViewUtils.showDialog(dialogTurnaj);
    }//GEN-LAST:event_tableTurnajeMouseClicked

    private void btnPrihlasitSaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrihlasitSaMouseReleased
        int index = tableTurnaje.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Pros�m vyberte turnaj.");
            return;
        }
        Turnaj t = (Turnaj) tableTurnaje.getValueAt(index, 0);
        int prihlasenieStatus = this.controller.prihlasHracaNaTurnaj(t);
        switch (prihlasenieStatus) {
            case PlatformConstants.HRAC_PRILIS_STARY:
                JOptionPane.showMessageDialog(this, "Tento turnaj je len pre hr��ov mlad��ch ako " + t.getObmedzenia().getMaxVek() + " rokov.", "AGE ISSUE", JOptionPane.ERROR_MESSAGE);
                break;
            case PlatformConstants.RATING_JE_MIMO_ROZSAH:
                JOptionPane.showMessageDialog(this, "Vas rating je mimo povolen� turnajov� rozash.", "INVALID RATING", JOptionPane.ERROR_MESSAGE);
                break;
            case PlatformConstants.KAPACITA_TURNAJA_PREKROCENA:
                JOptionPane.showMessageDialog(this, "Turnaj je pln�.", "TURNAJ FULL", JOptionPane.ERROR_MESSAGE);
                break;
            case PlatformConstants.TURNAJ_PRIHLASENIE_OK:
                JOptionPane.showMessageDialog(this, "Prihlasovanie prebehlo v poriadku", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                ((DefaultTableModel) tableTurnaje.getModel()).removeRow(index);
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_btnPrihlasitSaMouseReleased

    private void vyplnTabulkuTurnajov() {
        DefaultTableModel model = (DefaultTableModel) tableTurnaje.getModel();
        model.setRowCount(0);
        ArrayList<Turnaj> turnaje = this.controller.getTurnaje();
        for (Turnaj t : turnaje) {
            boolean turnajJeDohraty = t.isFinished();
            boolean turnajPrebieha = new Date().after(t.getDatumKonania());
            boolean hracJePrihlaseny = this.controller.getPrihlasenyHrac().getTurnaje().contains(t);
            if (turnajJeDohraty || turnajPrebieha || hracJePrihlaseny) {
                continue;
            }
            String maxVek;
            if (t.getObmedzenia().getMaxVek() == Integer.MAX_VALUE) {
                maxVek = "OPEN";
            } else {
                maxVek = String.valueOf(t.getObmedzenia().getMaxVek());
            }
            model.addRow(new Object[]{
                t, // samotny objekt turnja ako prvy column, zapise sa .tostring()
                t.getFormat().toString() + " " + t.getTempoHry().getLimitMins() + "+" + t.getTempoHry().getIncrement(), //format
                t.getMiestoKonania(),
                t.getObmedzenia().getRatingObmedzenie(),
                maxVek,
                this.controller.getTurnajKapacita(t)
            });
        }

    }

    private void nastavTabulkuTurnajov() {
        TableColumnModel columnModel = tableTurnaje.getColumnModel();
        ((DefaultTableCellRenderer) tableTurnaje.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // algin na stred column headery
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); // align na stred values
        tableTurnaje.getTableHeader().setResizingAllowed(true);
        columnModel.getColumn(0).setPreferredWidth(300);
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        int long_column_width = 150;
        int small_column_width = 80;
        int column_width;
        for (int i = 1; i < 6; i++) {
            if (i < 2) {
                column_width = long_column_width;
            } else {
                column_width = small_column_width;
            }
            columnModel.getColumn(i).setPreferredWidth(column_width);
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @Override
    public void refresh() {
        this.nastavTabulkuTurnajov();
        this.vyplnTabulkuTurnajov();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrihlasitSa;
    private javax.swing.JDialog dialogTurnaj;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelPopis;
    private javax.swing.JScrollPane scrollPaneTurnaje;
    private javax.swing.JTable tableTurnaje;
    // End of variables declaration//GEN-END:variables
}
