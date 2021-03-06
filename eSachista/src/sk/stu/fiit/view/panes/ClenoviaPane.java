package sk.stu.fiit.view.panes;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sk.stu.fiit.controller.SpravcaController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.view.AutoCompleteJComboBoxer;
import sk.stu.fiit.view.dialogs.EditovatHracaDialog;

/**
 * Panel, kde moze spravca zobrazit hracov a editovat ich udaje
 * @author lucia
 * @author Martin Melisek
 */
public class ClenoviaPane extends javax.swing.JPanel implements IViewRefresh {

    private SpravcaController controller;

    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

    public ClenoviaPane(SpravcaController controller) {
        this.controller = controller;
        initComponents();
    }

    public ClenoviaPane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelClenovia = new javax.swing.JLabel();
        labelPocetClenov = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listClenovia = new javax.swing.JList<>();
        btnUpravit = new javax.swing.JButton();
        comboBoxClenovia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 243, 247));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelClenovia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelClenovia.setForeground(new java.awt.Color(67, 106, 179));
        labelClenovia.setText("Po?et ?lenov:");
        add(labelClenovia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        labelPocetClenov.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPocetClenov.setForeground(new java.awt.Color(0, 0, 0));
        labelPocetClenov.setText("po?et ?lenov");
        add(labelPocetClenov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, 20));

        listClenovia.setBackground(new java.awt.Color(255, 255, 255));
        listClenovia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listClenovia.setForeground(new java.awt.Color(68, 68, 68));
        listClenovia.setModel(new DefaultListModel<Pouzivatel>());
        listClenovia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listClenovia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listClenoviaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listClenovia);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 640, 440));

        btnUpravit.setBackground(new java.awt.Color(102, 102, 102));
        btnUpravit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnUpravit.setForeground(new java.awt.Color(255, 255, 255));
        btnUpravit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        btnUpravit.setText("Upravi?");
        btnUpravit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpravitMouseReleased(evt);
            }
        });
        add(btnUpravit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 140, 30));

        comboBoxClenovia.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxClenovia.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboBoxClenovia.setForeground(new java.awt.Color(1, 42, 74));
        comboBoxClenovia.setModel(new DefaultComboBoxModel<Pouzivatel>());
        add(comboBoxClenovia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 220, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Vyh?ad?vanie ?lenov");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Zoznam ?lenov");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void listClenoviaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClenoviaMouseReleased
        this.editHracInfo((Pouzivatel) comboBoxClenovia.getSelectedItem());
    }//GEN-LAST:event_listClenoviaMouseReleased

    private void btnUpravitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpravitMouseReleased
        this.editHracInfo((Pouzivatel) comboBoxClenovia.getSelectedItem());
    }//GEN-LAST:event_btnUpravitMouseReleased

    private void editHracInfo(Pouzivatel p) {
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Prosim vyberte hraca.");
            return;
        }
        EditovatHracaDialog dialog = new EditovatHracaDialog(parent, true, (Hrac) p);
        dialog.showDialog();
        this.controller.saveOrg();
        this.refresh();
    }

    private void naplnComboBoxHracov() {
        labelPocetClenov.setText(String.valueOf(this.controller.getHraci().size()));
        DefaultComboBoxModel<Pouzivatel> model = (DefaultComboBoxModel<Pouzivatel>) comboBoxClenovia.getModel();
        comboBoxClenovia.removeAllItems();
        ArrayList<Pouzivatel> pouzivatelia = this.controller.getOrgLoggedIn().getPouzivatelia();
        for (Pouzivatel pouzivatel : pouzivatelia) {
            if (pouzivatel instanceof Hrac) {
                model.addElement(pouzivatel);
            }
        }
        new AutoCompleteJComboBoxer(comboBoxClenovia);
    }

    private void naplnListHracov() {
        DefaultListModel<Pouzivatel> model = (DefaultListModel<Pouzivatel>) listClenovia.getModel();
        model.setSize(0);
        ArrayList<Pouzivatel> pouzivatelia = this.controller.getOrgLoggedIn().getPouzivatelia();
        for (Pouzivatel pouzivatel : pouzivatelia) {
            if (pouzivatel instanceof Hrac) {
                model.addElement(pouzivatel);
            }
        }
    }

    @Override
    public void refresh() {
        this.controller.loadOrg();
        this.naplnComboBoxHracov();
        this.naplnListHracov();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpravit;
    private javax.swing.JComboBox<Pouzivatel> comboBoxClenovia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelClenovia;
    private javax.swing.JLabel labelPocetClenov;
    private javax.swing.JList<Pouzivatel> listClenovia;
    // End of variables declaration//GEN-END:variables
}
