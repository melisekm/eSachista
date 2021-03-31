package sk.stu.fiit.view;

import java.awt.Color;
import sk.stu.fiit.controller.HracController;

/**
 *
 * @author Martin Melisek
 */
public class HracFrame extends javax.swing.JFrame {

    private HracController controller;

    public HracFrame() {
        this.controller = new HracController();
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

        mainTabPane = new javax.swing.JTabbedPane();
        profilHracaPane1 = new sk.stu.fiit.view.panes.ProfilHracaPane();
        zoznamTurnajovPanel1 = new sk.stu.fiit.view.panes.ZoznamTurnajovPanel();
        aktivneTurnajePanel1 = new sk.stu.fiit.view.panes.AktivneTurnajePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eSachista - Hr��");

        mainTabPane.setBackground(new java.awt.Color(0, 166, 172));
        mainTabPane.setForeground(new java.awt.Color(255, 255, 255));
        mainTabPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mainTabPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabPaneStateChanged(evt);
            }
        });
        mainTabPane.addTab("Profil", profilHracaPane1);
        mainTabPane.addTab("Turnaje", zoznamTurnajovPanel1);
        mainTabPane.addTab("Akt�vne turnaje", aktivneTurnajePanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mainTabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabPaneStateChanged
        // tu sa budu aktualizovat zaležitosti z panelov ak je to treba.
    }//GEN-LAST:event_mainTabPaneStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf Light".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Color c = new Color(0,118,121);
        javax.swing.UIManager.put("TabbedPane.selected", c);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HracFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sk.stu.fiit.view.panes.AktivneTurnajePanel aktivneTurnajePanel1;
    private javax.swing.JTabbedPane mainTabPane;
    private sk.stu.fiit.view.panes.ProfilHracaPane profilHracaPane1;
    private sk.stu.fiit.view.panes.ZoznamTurnajovPanel zoznamTurnajovPanel1;
    // End of variables declaration//GEN-END:variables
}
