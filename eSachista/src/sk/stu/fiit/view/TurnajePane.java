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
public class TurnajePane extends javax.swing.JPanel {

    /**
     * Creates new form TurnajePanel
     */
    public TurnajePane() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 410));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Zoznam naplánovaných turnajov");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        jButton1.setText("Upraviť turnaj");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 120, 30));

        jLabel2.setText("len poznámka: keď klikne na turnaj, mohli by sa sem do txt polí načítať info");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel3.setText("Názov turnaja");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jLabel4.setText("Formát turnaja");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel5.setText("Kapacita: ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "zoznam prihlásených hráčov..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 290, 260));

        jLabel6.setText("Začiatok");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel7.setText("......");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        jButton2.setText("VYTVORIŤ NOVÝ TURNAJ");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 180, 50));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
