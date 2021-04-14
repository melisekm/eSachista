/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sk.stu.fiit.controller.HracController;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.utils.ViewUtils;
import sk.stu.fiit.view.dialogs.TurnajInfoDialog;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class AktivneTurnajePane extends javax.swing.JPanel implements IViewRefresh {

    private HracController controller;
    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

    public AktivneTurnajePane(HracController controller) {
        this.controller = controller;
        initComponents();
    }

    public AktivneTurnajePane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPrebiehajuciTurnaj = new javax.swing.JLabel();
        mainPane = new javax.swing.JPanel();
        labelNaplanovaneTurnaje = new javax.swing.JLabel();
        calendar = new com.toedter.calendar.JCalendar();
        labelNadchadzaujceTurnaje = new javax.swing.JLabel();
        scrollPaneTurnaje = new javax.swing.JScrollPane();
        listTurnaje = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPrebiehajuciTurnaj.setText("Momentálne neprebieha žiadny turnaj...");
        add(labelPrebiehajuciTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        mainPane.setBackground(new java.awt.Color(204, 204, 204));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNaplanovaneTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelNaplanovaneTurnaje.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelNaplanovaneTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        labelNaplanovaneTurnaje.setText("Nemáte naplánovaný žiadny turnaj...");
        mainPane.add(labelNaplanovaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        calendar.setBackground(new java.awt.Color(153, 153, 153));
        calendar.setForeground(new java.awt.Color(51, 51, 51));
        mainPane.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 230));

        labelNadchadzaujceTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelNadchadzaujceTurnaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNadchadzaujceTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        labelNadchadzaujceTurnaje.setText("Nadchádzajúce turnaje");
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

        mainPane.add(scrollPaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 370, 210));

        add(mainPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 370, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void listTurnajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTurnajeMouseReleased
        Turnaj t = (Turnaj) listTurnaje.getSelectedValue();
        if (t == null) {
            return;
        }
        ViewUtils.showDialog(new TurnajInfoDialog(parent, true, t));
    }//GEN-LAST:event_listTurnajeMouseReleased

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
        // TODO
    }

    @Override
    public void refresh() {
        this.naplnListTurnajov();
        this.zobrazPrebiehajuciTurnaj();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar calendar;
    private javax.swing.JLabel labelNadchadzaujceTurnaje;
    private javax.swing.JLabel labelNaplanovaneTurnaje;
    private javax.swing.JLabel labelPrebiehajuciTurnaj;
    private javax.swing.JList<Turnaj> listTurnaje;
    private javax.swing.JPanel mainPane;
    private javax.swing.JScrollPane scrollPaneTurnaje;
    // End of variables declaration//GEN-END:variables
}
