package sk.stu.fiit.view.panes;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import sk.stu.fiit.controller.HracController;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.utils.PlatformConstants;
import sk.stu.fiit.utils.ViewUtils;
import sk.stu.fiit.view.dialogs.TurnajInfoDialog;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class ZoznamTurnajovPane extends javax.swing.JPanel implements IViewRefresh {

    private HracController controller;
    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

    public ZoznamTurnajovPane(HracController controller) {
        this.controller = controller;
        initComponents();
        this.refresh();
    }

    public ZoznamTurnajovPane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTurnaje = new javax.swing.JScrollPane();
        tableTurnaje = new javax.swing.JTable();
        btnPrihlasitSa = new javax.swing.JButton();
        btnDetaily = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 243, 247));
        setMinimumSize(new java.awt.Dimension(900, 610));
        setPreferredSize(new java.awt.Dimension(900, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableTurnaje.setBackground(new java.awt.Color(255, 255, 255));
        tableTurnaje.setForeground(new java.awt.Color(51, 51, 51));
        tableTurnaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Poh·r dekana", "Swiss 10+5", "FIIT STU, Bratislava", "Open", "Open", "10/100"}
            },
            new String [] {
                "N·zov a termÌn", "Form·t", "Miesto konania", "Rating", "Max Vek", "Kapacita"
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
        tableTurnaje.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableTurnaje.getTableHeader().setBackground(new java.awt.Color(59, 166, 235));
        scrollPaneTurnaje.setViewportView(tableTurnaje);

        add(scrollPaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 770, 450));

        btnPrihlasitSa.setBackground(new java.awt.Color(118, 155, 108));
        btnPrihlasitSa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrihlasitSa.setForeground(new java.awt.Color(255, 255, 255));
        btnPrihlasitSa.setText("Prihl·siù sa na turnaj");
        btnPrihlasitSa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrihlasitSaMouseReleased(evt);
            }
        });
        add(btnPrihlasitSa, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 220, 30));

        btnDetaily.setBackground(new java.awt.Color(59, 166, 235));
        btnDetaily.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDetaily.setForeground(new java.awt.Color(255, 255, 255));
        btnDetaily.setText("Detaily");
        btnDetaily.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDetailyMouseReleased(evt);
            }
        });
        add(btnDetaily, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 220, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrihlasitSaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrihlasitSaMouseReleased
        int index = tableTurnaje.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "ProsÌm vyberte turnaj.");
            return;
        }
        Turnaj t = (Turnaj) tableTurnaje.getValueAt(index, 0);
        int prihlasenieStatus = this.controller.prihlasHracaNaTurnaj(t);
        switch (prihlasenieStatus) {
            case PlatformConstants.HRAC_PRILIS_STARY:
                JOptionPane.showMessageDialog(this, "Tento turnaj je len pre hr·Ëov mladöÌch ako " + t.getObmedzenia().getMaxVek() + " rokov.", "AGE ISSUE", JOptionPane.ERROR_MESSAGE);
                break;
            case PlatformConstants.RATING_JE_MIMO_ROZSAH:
                JOptionPane.showMessageDialog(this, "Vas rating je mimo povolen˝ turnajov˝ rozash.", "INVALID RATING", JOptionPane.ERROR_MESSAGE);
                break;
            case PlatformConstants.KAPACITA_TURNAJA_PREKROCENA:
                JOptionPane.showMessageDialog(this, "Turnaj je pln˝.", "TURNAJ FULL", JOptionPane.ERROR_MESSAGE);
                break;
            case PlatformConstants.INA_CHYBA:
                JOptionPane.showConfirmDialog(this, "Nastala neoËak·van· chyba, prosÌm sk˙ste to znovu.");
                break;
            case PlatformConstants.TURNAJ_PRIHLASENIE_OK:
                JOptionPane.showMessageDialog(this, "Prihlasovanie prebehlo v poriadku", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                ((DefaultTableModel) tableTurnaje.getModel()).removeRow(index);
                break;
            default:
                throw new AssertionError();
        }
        this.refresh();
    }//GEN-LAST:event_btnPrihlasitSaMouseReleased

    private void btnDetailyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailyMouseReleased
        int index = tableTurnaje.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(parent, "ProsÌm vyberte turnaj.", "CHOOSE TURNAJ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Turnaj t = (Turnaj) tableTurnaje.getValueAt(index, 0);
        ViewUtils.showDialog(new TurnajInfoDialog(parent, true, t));
    }//GEN-LAST:event_btnDetailyMouseReleased

    private void vyplnTabulkuTurnajov() {
        DefaultTableModel model = (DefaultTableModel) tableTurnaje.getModel();
        model.setRowCount(0);
        ArrayList<Turnaj> turnaje = this.controller.getTurnaje();
        for (Turnaj t : turnaje) {
            if (this.controller.nezobrazitTurnaj(t)) {
                continue;
            }
            model.addRow(new Object[]{
                t, // samotny objekt turnja ako prvy column, zapise sa .tostring()
                t.getFormat().toString() + " " + t.getTempoHry().getLimitMins() + "+" + t.getTempoHry().getIncrement(), //format
                t.getMiestoKonania(),
                t.getObmedzenia().getRatingObmedzenie(),
                t.getObmedzenia().getVekObmedzenie(),
                this.controller.getTurnajKapacita(t)
            });
        }
    }

    @Override
    public void refresh() {
        this.controller.loadOrg();
        this.vyplnTabulkuTurnajov();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetaily;
    private javax.swing.JButton btnPrihlasitSa;
    private javax.swing.JScrollPane scrollPaneTurnaje;
    private javax.swing.JTable tableTurnaje;
    // End of variables declaration//GEN-END:variables

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

}
