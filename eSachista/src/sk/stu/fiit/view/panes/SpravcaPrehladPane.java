/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.view.panes;

import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import sk.stu.fiit.controller.SpravcaController;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.utils.ViewUtils;
import sk.stu.fiit.view.charts.BarPieChartFactory;

/**
 *
 * @author lucia
 */
public class SpravcaPrehladPane extends javax.swing.JPanel implements IViewRefresh {

    private JPanel SpravcaPanel;
    private JPanel SpravcaDatumyPanel;
    private SpravcaController controller;

    public SpravcaPrehladPane(SpravcaController controller) {
        this.controller = controller;
        initComponents();
        this.setPoctyHracovTurnajeChart();
        this.setPoctyHracovDniChart();
    }

    public SpravcaPrehladPane() {
        initComponents();
        this.setPoctyHracovTurnajeChart();
        this.setPoctyHracovDniChart();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EditovatSpravcuDialog = new javax.swing.JDialog();
        paneDialogEditovat = new javax.swing.JPanel();
        btnUlozitSpravcaDialog = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        labelLogoOrg = new javax.swing.JLabel();
        labelDataNazovOrg = new javax.swing.JLabel();
        labelDatumRegistracie = new javax.swing.JLabel();
        labelPocetClenov = new javax.swing.JLabel();
        btnUpravitOrgPrehlad = new javax.swing.JButton();
        labelDataDatumReg = new javax.swing.JLabel();
        labelDataPocetClenov = new javax.swing.JLabel();
        labelVitajte = new javax.swing.JLabel();
        labelDataMenoSpravcu = new javax.swing.JLabel();
        labelPocetTurnajov = new javax.swing.JLabel();
        labelDataPocetTurnajov = new javax.swing.JLabel();
        labelDataBalik = new javax.swing.JLabel();
        labelPocetZapasov = new javax.swing.JLabel();
        labelDataPocetZapasov = new javax.swing.JLabel();
        labelPriemerneELO = new javax.swing.JLabel();
        labelDataPriemerneELO = new javax.swing.JLabel();
        labelUkonceneTurnaje = new javax.swing.JLabel();
        labelDataUkonceneTurnaje = new javax.swing.JLabel();
        labelNaplanovaneTurnaje = new javax.swing.JLabel();
        labelDataNaplanovaneTurnaje = new javax.swing.JLabel();
        labelBalik = new javax.swing.JLabel();

        EditovatSpravcuDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneDialogEditovat.setBackground(new java.awt.Color(255, 255, 255));
        paneDialogEditovat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUlozitSpravcaDialog.setBackground(new java.awt.Color(118, 155, 108));
        btnUlozitSpravcaDialog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUlozitSpravcaDialog.setForeground(new java.awt.Color(255, 255, 255));
        btnUlozitSpravcaDialog.setText("Uloûiù");
        btnUlozitSpravcaDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUlozitSpravcaDialogMouseClicked(evt);
            }
        });
        paneDialogEditovat.add(btnUlozitSpravcaDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 140, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("N·zov organiz·cie:");
        paneDialogEditovat.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Meno spr·vcu:");
        paneDialogEditovat.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 155, -1, -1));
        paneDialogEditovat.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, -1));
        paneDialogEditovat.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Upraviù ˙daje");
        paneDialogEditovat.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Vybraù avatar");
        paneDialogEditovat.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        paneDialogEditovat.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 160, 140));

        EditovatSpravcuDialog.getContentPane().add(paneDialogEditovat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 310));

        setBackground(new java.awt.Color(240, 243, 247));
        setMinimumSize(new java.awt.Dimension(900, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogoOrg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        add(labelLogoOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 160));

        labelDataNazovOrg.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelDataNazovOrg.setForeground(new java.awt.Color(67, 106, 179));
        labelDataNazovOrg.setText("N·zov organiz·cie");
        add(labelDataNazovOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        labelDatumRegistracie.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDatumRegistracie.setText("D·tum registr·cie:");
        add(labelDatumRegistracie, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        labelPocetClenov.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelPocetClenov.setText("PoËet Ëlenov: ");
        add(labelPocetClenov, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));

        btnUpravitOrgPrehlad.setBackground(new java.awt.Color(204, 204, 204));
        btnUpravitOrgPrehlad.setForeground(new java.awt.Color(0, 0, 0));
        btnUpravitOrgPrehlad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        btnUpravitOrgPrehlad.setText("Upraviù");
        btnUpravitOrgPrehlad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpravitOrgPrehladMouseClicked(evt);
            }
        });
        add(btnUpravitOrgPrehlad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 166, 150, 40));

        labelDataDatumReg.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataDatumReg.setText("jLabel5");
        add(labelDataDatumReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        labelDataPocetClenov.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataPocetClenov.setText("8");
        add(labelDataPocetClenov, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, -1, -1));

        labelVitajte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelVitajte.setText("Vitajte ");
        add(labelVitajte, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        labelDataMenoSpravcu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataMenoSpravcu.setText("jLabel5");
        add(labelDataMenoSpravcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        labelPocetTurnajov.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelPocetTurnajov.setText("PoËet turnajov:");
        add(labelPocetTurnajov, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        labelDataPocetTurnajov.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataPocetTurnajov.setText("8");
        add(labelDataPocetTurnajov, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        labelDataBalik.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataBalik.setText("Mal˝");
        add(labelDataBalik, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        labelPocetZapasov.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelPocetZapasov.setText("PoËet z·pasov:");
        add(labelPocetZapasov, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        labelDataPocetZapasov.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataPocetZapasov.setText("24");
        add(labelDataPocetZapasov, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        labelPriemerneELO.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelPriemerneELO.setText("PriemernÈ ELO:");
        add(labelPriemerneELO, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        labelDataPriemerneELO.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataPriemerneELO.setText("1010");
        add(labelDataPriemerneELO, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, -1));

        labelUkonceneTurnaje.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelUkonceneTurnaje.setText("UkonËenÈ:");
        add(labelUkonceneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        labelDataUkonceneTurnaje.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataUkonceneTurnaje.setText("4");
        add(labelDataUkonceneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        labelNaplanovaneTurnaje.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelNaplanovaneTurnaje.setText("Napl·novanÈ:");
        add(labelNaplanovaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        labelDataNaplanovaneTurnaje.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataNaplanovaneTurnaje.setText("4");
        add(labelDataNaplanovaneTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, -1));

        labelBalik.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelBalik.setText("BalÌk:");
        add(labelBalik, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpravitOrgPrehladMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpravitOrgPrehladMouseClicked
        ViewUtils.showDialog(EditovatSpravcuDialog);
    }//GEN-LAST:event_btnUpravitOrgPrehladMouseClicked

    private void btnUlozitSpravcaDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUlozitSpravcaDialogMouseClicked
        Spravca s = this.controller.getPrihlasenySpravca();
        Organizacia o = this.controller.getOrgLoggedIn();
    }//GEN-LAST:event_btnUlozitSpravcaDialogMouseClicked
    private void setSpravcaInfo() {
        Spravca s = this.controller.getPrihlasenySpravca();
        Organizacia o = this.controller.getOrgLoggedIn();
        labelDataNazovOrg.setText(o.getNazov());
        labelDataBalik.setText(o.getBalik().getNazov());
        labelDataMenoSpravcu.setText(s.getMeno());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        labelDataDatumReg.setText(sdf.format(s.getDatumRegistracie()));

        String[] turnajeStatistiky = this.controller.getTurnajeStatistiky(o);
        labelDataPocetTurnajov.setText(turnajeStatistiky[0]);
        labelDataNaplanovaneTurnaje.setText(turnajeStatistiky[1]);
        labelDataUkonceneTurnaje.setText(turnajeStatistiky[2]);
        labelDataPocetZapasov.setText(turnajeStatistiky[3]);
        labelDataPocetClenov.setText(String.valueOf(this.controller.getHraci().size()));
        labelDataPriemerneELO.setText(this.controller.getPriemerneELO());

    }

    private void setPoctyHracovTurnajeChart() {
        BarPieChartFactory factory = new BarPieChartFactory();
        SpravcaPanel = factory.createChart("BAR", "PoËet hr·Ëov v jednotliv˝ch turnajoch", this.controller.getHraciDataset());
        SpravcaPanel.setPreferredSize(new java.awt.Dimension(330, 300));
        add(SpravcaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 330, 300));
    }

    private void setPoctyHracovDniChart() {
        BarPieChartFactory factory = new BarPieChartFactory();
        SpravcaDatumyPanel = factory.createChart("BAR", "PoËet hr·Ëov podæa dnÌ konania turnajov", this.controller.getDniKonaniaDataset());
        SpravcaDatumyPanel.setPreferredSize(new java.awt.Dimension(330, 300));
        add(SpravcaDatumyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 330, 300));
    }

    public void refresh() {
        this.remove(SpravcaPanel);
        this.remove(SpravcaDatumyPanel);
        this.revalidate();
        this.setSpravcaInfo();
        this.setPoctyHracovTurnajeChart();
        this.setPoctyHracovDniChart();
        this.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog EditovatSpravcuDialog;
    private javax.swing.JButton btnUlozitSpravcaDialog;
    private javax.swing.JButton btnUpravitOrgPrehlad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelBalik;
    private javax.swing.JLabel labelDataBalik;
    private javax.swing.JLabel labelDataDatumReg;
    private javax.swing.JLabel labelDataMenoSpravcu;
    private javax.swing.JLabel labelDataNaplanovaneTurnaje;
    private javax.swing.JLabel labelDataNazovOrg;
    private javax.swing.JLabel labelDataPocetClenov;
    private javax.swing.JLabel labelDataPocetTurnajov;
    private javax.swing.JLabel labelDataPocetZapasov;
    private javax.swing.JLabel labelDataPriemerneELO;
    private javax.swing.JLabel labelDataUkonceneTurnaje;
    private javax.swing.JLabel labelDatumRegistracie;
    private javax.swing.JLabel labelLogoOrg;
    private javax.swing.JLabel labelNaplanovaneTurnaje;
    private javax.swing.JLabel labelPocetClenov;
    private javax.swing.JLabel labelPocetTurnajov;
    private javax.swing.JLabel labelPocetZapasov;
    private javax.swing.JLabel labelPriemerneELO;
    private javax.swing.JLabel labelUkonceneTurnaje;
    private javax.swing.JLabel labelVitajte;
    private javax.swing.JPanel paneDialogEditovat;
    // End of variables declaration//GEN-END:variables
}
