package sk.stu.fiit.view.panes;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sk.stu.fiit.controller.SpravcaController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.view.AutoCompleteJComboBoxer;
import sk.stu.fiit.view.dialogs.EditovatHracaDialog;

/**
 *
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

        setBackground(new java.awt.Color(240, 243, 247));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelClenovia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelClenovia.setForeground(new java.awt.Color(67, 106, 179));
        labelClenovia.setText("»lenovia");
        add(labelClenovia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        labelPocetClenov.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelPocetClenov.setText("poËet Ëlenov");
        add(labelPocetClenov, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        listClenovia.setBackground(new java.awt.Color(255, 255, 255));
        listClenovia.setForeground(new java.awt.Color(68, 68, 68));
        listClenovia.setModel(new DefaultListModel<Pouzivatel>());
        listClenovia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listClenovia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listClenoviaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listClenovia);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 640, 240));

        btnUpravit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnUpravit.setForeground(new java.awt.Color(0, 0, 0));
        btnUpravit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        btnUpravit.setText("Upraviù");
        btnUpravit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpravitMouseReleased(evt);
            }
        });
        add(btnUpravit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 140, 30));

        comboBoxClenovia.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxClenovia.setForeground(new java.awt.Color(1, 42, 74));
        comboBoxClenovia.setModel(new DefaultComboBoxModel<Pouzivatel>());
        add(comboBoxClenovia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void listClenoviaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClenoviaMouseReleased
        Pouzivatel p = (Pouzivatel) listClenovia.getSelectedValue();
        this.editHracInfo(p);
    }//GEN-LAST:event_listClenoviaMouseReleased

    private void btnUpravitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpravitMouseReleased
        Pouzivatel p = (Pouzivatel) comboBoxClenovia.getSelectedItem();
        this.editHracInfo(p);
    }//GEN-LAST:event_btnUpravitMouseReleased

    private void editHracInfo(Pouzivatel p) {
        EditovatHracaDialog dialog = new EditovatHracaDialog(parent, true, (Hrac) p);
        dialog.showDialog();
        this.controller.saveOrg();
        this.refresh();
    }

    private void naplnComboBoxHracov() {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelClenovia;
    private javax.swing.JLabel labelPocetClenov;
    private javax.swing.JList<Pouzivatel> listClenovia;
    // End of variables declaration//GEN-END:variables
}
