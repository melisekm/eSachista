package sk.stu.fiit.view;

import java.awt.Color;
import java.awt.FontMetrics;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.SpravcaController;
import sk.stu.fiit.view.panes.IViewRefresh;

/**
 *
 * @author Martin Melisek
 */
public class SpravcaFrame extends javax.swing.JFrame {

    Logger logger = LoggerFactory.getLogger(SpravcaFrame.class);

    private SpravcaController controller;

    private int PANE_COUNT = 3;
    private int LOGOUT_ID = 3;

    private IViewRefresh[] paneSwapContext = new IViewRefresh[PANE_COUNT];
    private int tab = 0;

    public SpravcaFrame() {
        this.controller = new SpravcaController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final String PRE_HTML = "<html><p style=\"text-align: left; width: 80px;\">";
        final String POST_HTML = "</p></html>";
        mainTabPane = new javax.swing.JTabbedPane();
        spravcaPrehladPane = new sk.stu.fiit.view.panes.SpravcaPrehladPane(this.controller);
        clenoviaPane = new sk.stu.fiit.view.panes.ClenoviaPane(this.controller);
        turnajePane = new sk.stu.fiit.view.panes.TurnajePane();
        logoutPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eSachista - Spr�vca");
        setMinimumSize(new java.awt.Dimension(935, 655));
        setPreferredSize(new java.awt.Dimension(935, 655));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainTabPane.setUI(new BasicTabbedPaneUI(){
            @Override
            protected int calculateTabWidth(
                int tabPlacement, int tabIndex, FontMetrics metrics) {
                return 150;
            }

            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return 45;
            }
        });
        this.registerPanes();
        mainTabPane.setBackground(new java.awt.Color(0, 166, 172));
        mainTabPane.setForeground(new java.awt.Color(0, 0, 0));
        mainTabPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainTabPane.setFont(new java.awt.Font("Segoe UI", 0, 15));
        mainTabPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabPaneStateChanged(evt);
            }
        });
        mainTabPane.addTab("Profil", spravcaPrehladPane);
        mainTabPane.setIconAt(0, new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/user2.png")));
        mainTabPane.setTitleAt(0, PRE_HTML + "Profil" + POST_HTML);
        mainTabPane.addTab("�lenovia", clenoviaPane);
        mainTabPane.setIconAt(1, new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/group2.png")));
        mainTabPane.setTitleAt(1, PRE_HTML + "�lenovia" + POST_HTML);
        mainTabPane.addTab("Turnaje", turnajePane);
        mainTabPane.setIconAt(2, new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/trophy2.png")));
        mainTabPane.setTitleAt(2, PRE_HTML + "Turnaje" + POST_HTML);
        mainTabPane.addTab("Odhl�si� sa", logoutPane);

        getContentPane().add(mainTabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void registerPanes() {
        this.paneSwapContext[0] = spravcaPrehladPane;
        this.paneSwapContext[1] = clenoviaPane;
        this.paneSwapContext[2] = turnajePane;
    }
    private void mainTabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabPaneStateChanged
        int selectedPane = mainTabPane.getSelectedIndex();
        if (selectedPane == LOGOUT_ID) {
            mainTabPane.setSelectedIndex(this.tab);
            int res = JOptionPane.showConfirmDialog(this, "Chcete sa odhl�si�?", "LOGOUT", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                this.logOut();
            }
        } else {
            this.tab = selectedPane;
            paneSwapContext[selectedPane].refresh();
        }
    }//GEN-LAST:event_mainTabPaneStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.controller.closeServer();
    }//GEN-LAST:event_formWindowClosing
    private void logOut() {
        logger.info("Hrac " + this.controller.getPrihlasenySpravca().getLogin() + " sa odhlasil.");
        this.controller.closeServer();
        this.setVisible(false);
        this.dispose();
        EntryFrame.main();
    }

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
            java.util.logging.Logger.getLogger(SpravcaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpravcaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpravcaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpravcaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        Color c = new Color(0, 118, 121);
        javax.swing.UIManager.put("TabbedPane.selected", c);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpravcaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sk.stu.fiit.view.panes.ClenoviaPane clenoviaPane;
    private javax.swing.JPanel logoutPane;
    private javax.swing.JTabbedPane mainTabPane;
    private sk.stu.fiit.view.panes.SpravcaPrehladPane spravcaPrehladPane;
    private sk.stu.fiit.view.panes.TurnajePane turnajePane;
    // End of variables declaration//GEN-END:variables
}
