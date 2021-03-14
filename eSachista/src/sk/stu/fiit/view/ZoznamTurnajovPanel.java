/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view;

/**
 *
 * @author lucia
 */
public class ZoznamTurnajovPanel extends javax.swing.JPanel {

    /**
     * Creates new form ZoznamTurnajovPanel
     */
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

        TurnajDialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabulkaTurnajov = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout TurnajDialogLayout = new javax.swing.GroupLayout(TurnajDialog.getContentPane());
        TurnajDialog.getContentPane().setLayout(TurnajDialogLayout);
        TurnajDialogLayout.setHorizontalGroup(
            TurnajDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        TurnajDialogLayout.setVerticalGroup(
            TurnajDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabulkaTurnajov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pohár dekana", "14.3.2022", "FIIT STU, Bratislava", "Open", "Open", "Konečne sa opät môžeme stretnúť...", "Swiss 10+5", "10/100"},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Názov turnaja", "Dátum a čas", "Miesto konania", "Rating", "Veková kategória", "Opis", "Formát", "Kapacita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabulkaTurnajov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabulkaTurnajovMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabulkaTurnajov);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 770, 440));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Kliknutím na turnaj zobrazíte možnosti a podrobné informácie");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void TabulkaTurnajovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabulkaTurnajovMouseClicked
        // TODO add your handling code here:
        int indexRow = TabulkaTurnajov.getSelectedRow();
        TurnajDialog.pack();
        TurnajDialog.setVisible(true);
    }//GEN-LAST:event_TabulkaTurnajovMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabulkaTurnajov;
    private javax.swing.JDialog TurnajDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
