package sk.stu.fiit.view;

import java.awt.Color;
import java.awt.FontMetrics;
import javax.swing.JOptionPane;
import sk.stu.fiit.controller.HracController;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.view.dialogs.EditovatHracaDialog;
import sk.stu.fiit.view.panes.IViewRefresh;

/**
 *
 * @author Martin Melisek
 */
public class HracFrame extends javax.swing.JFrame {

    Logger logger = LoggerFactory.getLogger(HracFrame.class);

    private HracController controller;

    private int PANE_COUNT = 3;
    private int LOGOUT_ID = 3;

    private IViewRefresh[] paneSwapContext = new IViewRefresh[PANE_COUNT];
    private int tab = 0;

    public HracFrame() {
        this.controller = new HracController();
        this.controller.loadOrg();
        initComponents();
        this.editInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final String PRE_HTML = "<html><p style=\"text-align: left; width: 80px;\">";
        final String POST_HTML = "</p></html>";
        mainTabPane = new javax.swing.JTabbedPane();
        profilHracaPane = new sk.stu.fiit.view.panes.ProfilHracaPane(this.controller);
        zoznamTurnajovPanel = new sk.stu.fiit.view.panes.ZoznamTurnajovPane(this.controller);
        aktivneTurnajePanel = new sk.stu.fiit.view.panes.AktivneTurnajePane(this.controller);
        logoutPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eSachista - Hr·Ë");

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
        mainTabPane.setBackground(new java.awt.Color(42,111,151));
        mainTabPane.setForeground(new java.awt.Color(0, 0, 0));
        mainTabPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainTabPane.setFont(new java.awt.Font("Segoe UI", 0, 15));
        mainTabPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabPaneStateChanged(evt);
            }
        });
        mainTabPane.addTab("Profil", profilHracaPane);
        mainTabPane.setIconAt(0, new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/user2.png")));
        mainTabPane.setTitleAt(0, PRE_HTML + "Profil" + POST_HTML);
        mainTabPane.addTab("Turnaje", zoznamTurnajovPanel);
        mainTabPane.setIconAt(1, new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/trophy2.png")));
        mainTabPane.setTitleAt(1, PRE_HTML + "Turnaje" + POST_HTML);
        mainTabPane.addTab("AktÌvne turnaje", aktivneTurnajePanel);
        mainTabPane.setIconAt(2, new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/chess2.png")));
        mainTabPane.setTitleAt(2, PRE_HTML + "AktÌvne turnaje" + POST_HTML);

        javax.swing.GroupLayout logoutPaneLayout = new javax.swing.GroupLayout(logoutPane);
        logoutPane.setLayout(logoutPaneLayout);
        logoutPaneLayout.setHorizontalGroup(
            logoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        logoutPaneLayout.setVerticalGroup(
            logoutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        mainTabPane.addTab("Odhl·senie", logoutPane);
        mainTabPane.setIconAt(3, new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/logout.png")));
        mainTabPane.setTitleAt(3, PRE_HTML + "Odhl·siù sa" + POST_HTML);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerPanes() {
        this.paneSwapContext[0] = profilHracaPane;
        this.paneSwapContext[1] = zoznamTurnajovPanel;
        this.paneSwapContext[2] = aktivneTurnajePanel;
    }

    private void mainTabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabPaneStateChanged
        // tu sa budu aktualizovat zale≈æitosti z panelov ak je to treba.
        int selectedPane = mainTabPane.getSelectedIndex();
        if (selectedPane == LOGOUT_ID) {
            mainTabPane.setSelectedIndex(this.tab);
            int res = JOptionPane.showConfirmDialog(this, "Chcete sa odhl·siù?", "LOGOUT", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                this.logOut();
            }
        } else {
            this.tab = selectedPane;
            paneSwapContext[selectedPane].refresh();
        }
    }//GEN-LAST:event_mainTabPaneStateChanged

    private void logOut() {
        logger.info("Hrac " + this.controller.getPrihlasenyHrac().getLogin() + " sa odhlasil.");
        this.setVisible(false);
        this.dispose();
        EntryFrame.main();
    }

    private void editInfo() {
        this.controller.loadOrg();
        if (this.controller.getPrihlasenyHrac().isFirstLogin()) {
            EditovatHracaDialog dialog = new EditovatHracaDialog(this, true, this.controller.getPrihlasenyHrac());
            dialog.showDialog();
            this.controller.saveOrg();
            profilHracaPane.refresh();
        }
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
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HracFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Color c = new Color(1, 73, 124);
        javax.swing.UIManager.put("TabbedPane.selected", c);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HracFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sk.stu.fiit.view.panes.AktivneTurnajePane aktivneTurnajePanel;
    private javax.swing.JPanel logoutPane;
    private javax.swing.JTabbedPane mainTabPane;
    private sk.stu.fiit.view.panes.ProfilHracaPane profilHracaPane;
    private sk.stu.fiit.view.panes.ZoznamTurnajovPane zoznamTurnajovPanel;
    // End of variables declaration//GEN-END:variables
}
