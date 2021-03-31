package sk.stu.fiit.view;

import java.awt.Color;
import java.awt.FontMetrics;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import sk.stu.fiit.controller.SpravcaController;

/**
 *
 * @author Martin Melisek
 */
public class SpravcaFrame extends javax.swing.JFrame {

    private SpravcaController controller;

    public SpravcaFrame() {
        this.controller = new SpravcaController();
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

        final String PRE_HTML = "<html><p style=\"text-align: left; width: 80px;\">";
        final String POST_HTML = "</p></html>";
        mainTabPane = new javax.swing.JTabbedPane();
        spravcaPrehladPane = new sk.stu.fiit.view.panes.SpravcaPrehladPane(this.controller);
        clenoviaPane = new sk.stu.fiit.view.panes.ClenoviaPane();
        turnajePane = new sk.stu.fiit.view.panes.TurnajePane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eSachista - Spr�vca");
        setMinimumSize(new java.awt.Dimension(935, 655));
        setPreferredSize(new java.awt.Dimension(935, 655));
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

        getContentPane().add(mainTabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mainTabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabPaneStateChanged
        if(mainTabPane.getSelectedIndex() == 0) {
            spravcaPrehladPane.refresh();
        }
        else if(mainTabPane.getSelectedIndex() == 2){
            turnajePane.refresh();
        }

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
        Color c = new Color(0,118,121);
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
    private javax.swing.JTabbedPane mainTabPane;
    private sk.stu.fiit.view.panes.SpravcaPrehladPane spravcaPrehladPane;
    private sk.stu.fiit.view.panes.TurnajePane turnajePane;
    // End of variables declaration//GEN-END:variables
}
