/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import sk.stu.fiit.view.ViewUtils;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class ZoznamTurnajovPanel extends javax.swing.JPanel implements IViewRefresh {

    public ZoznamTurnajovPanel() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TabulkaTurnajov = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        TabulkaTurnajov.setBackground(new java.awt.Color(204, 204, 204));
        TabulkaTurnajov.setForeground(new java.awt.Color(51, 51, 51));
        TabulkaTurnajov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Poh�r dekana", "14.3.2022", "FIIT STU, Bratislava", "Open", "Open", "Kone�ne sa op�t m��eme stretn��...", "Swiss 10+5", "10/100"}
            },
            new String [] {
                "N�zov turnaja", "D�tum a �as", "Miesto konania", "Rating", "Vekov� kateg�ria", "Opis", "Form�t", "Kapacita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabulkaTurnajov.setGridColor(new java.awt.Color(51, 51, 51));
        TabulkaTurnajov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabulkaTurnajovMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabulkaTurnajov);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 770, 450));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Kliknut�m na turnaj zobraz�te mo�nosti a podrobn� inform�cie");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, -1));

        jButton1.setBackground(new java.awt.Color(118, 155, 108));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Prihl�si� sa na turnaj");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 170, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void TabulkaTurnajovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabulkaTurnajovMouseClicked
        int indexRow = TabulkaTurnajov.getSelectedRow();
        ViewUtils.showDialog(dialogTurnaj);
    }//GEN-LAST:event_TabulkaTurnajovMouseClicked

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabulkaTurnajov;
    private javax.swing.JDialog dialogTurnaj;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
