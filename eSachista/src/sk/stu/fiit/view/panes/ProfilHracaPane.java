package sk.stu.fiit.view.panes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sk.stu.fiit.controller.HracController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.utils.ViewUtils;
import sk.stu.fiit.view.dialogs.EditovatHracaDialog;
import sk.stu.fiit.view.dialogs.TurnajInfoDialog;

/**
 *
 * @author lucia
 * @author Martin Melisek
 */
public class ProfilHracaPane extends javax.swing.JPanel implements IViewRefresh {

    private HracController controller;

    private JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

    public ProfilHracaPane(HracController controller) {
        this.controller = controller;
        initComponents();
    }

    public ProfilHracaPane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelOdohrateZapasy = new javax.swing.JLabel();
        labelOdohrateTurnaje = new javax.swing.JLabel();
        labelMeno = new javax.swing.JLabel();
        labelPrezyvka = new javax.swing.JLabel();
        MestoLabel = new javax.swing.JLabel();
        btnUpravitProfil = new javax.swing.JButton();
        iconAvatar = new javax.swing.JLabel();
        labelRating = new javax.swing.JLabel();
        labelRatingData = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listZapasy = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTurnaje = new javax.swing.JList<>();
        labelDatumReg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelZapasy = new javax.swing.JLabel();
        labelTurnaje = new javax.swing.JLabel();
        labelDatumRegData = new javax.swing.JLabel();
        paneStatistiky = new javax.swing.JPanel();
        labelTurnajeStat = new javax.swing.JLabel();
        labelPrehry = new javax.swing.JLabel();
        labelVyhry = new javax.swing.JLabel();
        labelPocetZap = new javax.swing.JLabel();
        labelDataPocetZapasov = new javax.swing.JLabel();
        labelDataVyhry = new javax.swing.JLabel();
        labelDataPrehry = new javax.swing.JLabel();
        labelDataTurnaje = new javax.swing.JLabel();
        labelStatistiky = new javax.swing.JLabel();
        labelMesto = new javax.swing.JLabel();
        labelOrg = new javax.swing.JLabel();
        labelStat = new javax.swing.JLabel();
        labelPohlavie = new javax.swing.JLabel();
        labelDataOrg = new javax.swing.JLabel();
        labelDataMesto = new javax.swing.JLabel();
        labelDataStat = new javax.swing.JLabel();
        labelDataDatumNarodenia = new javax.swing.JLabel();
        labelDataPohlavie = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 243, 247));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOdohrateZapasy.setBackground(new java.awt.Color(0, 0, 0));
        labelOdohrateZapasy.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelOdohrateZapasy.setForeground(new java.awt.Color(0, 0, 0));
        labelOdohrateZapasy.setText("Nem·te odohrat˝ ûiaden z·pas...");
        add(labelOdohrateZapasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        labelOdohrateTurnaje.setBackground(new java.awt.Color(0, 0, 0));
        labelOdohrateTurnaje.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelOdohrateTurnaje.setForeground(new java.awt.Color(0, 0, 0));
        labelOdohrateTurnaje.setText("Nem·te odohrat˝ ûiaden turnaj...");
        add(labelOdohrateTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));

        labelMeno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelMeno.setForeground(new java.awt.Color(54, 107, 172));
        labelMeno.setText("Cpavok");
        add(labelMeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 220, 20));

        labelPrezyvka.setForeground(new java.awt.Color(86, 88, 92));
        labelPrezyvka.setText("Prezyvka");
        add(labelPrezyvka, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        MestoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MestoLabel.setForeground(new java.awt.Color(0, 0, 0));
        MestoLabel.setText("D·tum narodenia:");
        add(MestoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        btnUpravitProfil.setBackground(new java.awt.Color(204, 204, 204));
        btnUpravitProfil.setForeground(new java.awt.Color(0, 0, 0));
        btnUpravitProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/edit.png"))); // NOI18N
        btnUpravitProfil.setText("Upraviù");
        btnUpravitProfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpravitProfilMouseReleased(evt);
            }
        });
        add(btnUpravitProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 150, 40));

        iconAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        add(iconAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 170));

        labelRating.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelRating.setForeground(new java.awt.Color(0, 0, 0));
        labelRating.setText("Rating:");
        add(labelRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        labelRatingData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRatingData.setForeground(new java.awt.Color(0, 0, 0));
        labelRatingData.setText("2641");
        add(labelRatingData, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 70, -1));

        listZapasy.setBackground(new java.awt.Color(255, 255, 255));
        listZapasy.setForeground(new java.awt.Color(51, 51, 51));
        listZapasy.setModel(new DefaultListModel<Zapas>());
        listZapasy.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listZapasy);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 360, 270));

        listTurnaje.setBackground(new java.awt.Color(255, 255, 255));
        listTurnaje.setForeground(new java.awt.Color(51, 51, 51));
        listTurnaje.setModel(new DefaultListModel<Turnaj>());
        listTurnaje.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTurnaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listTurnajeMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(listTurnaje);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 360, 270));

        labelDatumReg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDatumReg.setForeground(new java.awt.Color(0, 0, 0));
        labelDatumReg.setText("D·tum registr·cie:");
        add(labelDatumReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 880, 20));

        labelZapasy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelZapasy.setForeground(new java.awt.Color(238, 176, 18));
        labelZapasy.setText("Z¡PASY");
        add(labelZapasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        labelTurnaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTurnaje.setForeground(new java.awt.Color(238, 176, 18));
        labelTurnaje.setText("TURNAJE");
        add(labelTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, -1));

        labelDatumRegData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDatumRegData.setForeground(new java.awt.Color(0, 0, 0));
        labelDatumRegData.setText("12-3-2021");
        add(labelDatumRegData, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        paneStatistiky.setBackground(new java.awt.Color(255, 255, 255));
        paneStatistiky.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTurnajeStat.setForeground(new java.awt.Color(0, 0, 0));
        labelTurnajeStat.setText("Turnaje:");
        paneStatistiky.add(labelTurnajeStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        labelPrehry.setForeground(new java.awt.Color(0, 0, 0));
        labelPrehry.setText("Prehry:");
        paneStatistiky.add(labelPrehry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        labelVyhry.setForeground(new java.awt.Color(0, 0, 0));
        labelVyhry.setText("V˝hry:");
        paneStatistiky.add(labelVyhry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        labelPocetZap.setForeground(new java.awt.Color(0, 0, 0));
        labelPocetZap.setText("PoËet odohrat˝ch z·pasov:");
        paneStatistiky.add(labelPocetZap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        labelDataPocetZapasov.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelDataPocetZapasov.setForeground(new java.awt.Color(0, 153, 255));
        labelDataPocetZapasov.setText("2");
        paneStatistiky.add(labelDataPocetZapasov, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        labelDataVyhry.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelDataVyhry.setForeground(new java.awt.Color(107, 179, 107));
        labelDataVyhry.setText("2");
        paneStatistiky.add(labelDataVyhry, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        labelDataPrehry.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelDataPrehry.setForeground(new java.awt.Color(238, 79, 79));
        labelDataPrehry.setText("0");
        paneStatistiky.add(labelDataPrehry, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        labelDataTurnaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelDataTurnaje.setForeground(new java.awt.Color(0, 153, 255));
        labelDataTurnaje.setText("1");
        paneStatistiky.add(labelDataTurnaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        labelStatistiky.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelStatistiky.setForeground(new java.awt.Color(238, 176, 18));
        labelStatistiky.setText("äTATISTIKY");
        paneStatistiky.add(labelStatistiky, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        add(paneStatistiky, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 230, 170));

        labelMesto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelMesto.setForeground(new java.awt.Color(0, 0, 0));
        labelMesto.setText("Mesto:");
        add(labelMesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        labelOrg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelOrg.setForeground(new java.awt.Color(0, 0, 0));
        labelOrg.setText("Organizacia:");
        add(labelOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        labelStat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelStat.setForeground(new java.awt.Color(0, 0, 0));
        labelStat.setText("ät·t:");
        add(labelStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        labelPohlavie.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelPohlavie.setForeground(new java.awt.Color(0, 0, 0));
        labelPohlavie.setText("Pohlavie:");
        add(labelPohlavie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        labelDataOrg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDataOrg.setForeground(new java.awt.Color(0, 0, 0));
        labelDataOrg.setText("Orga");
        add(labelDataOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, -1, -1));

        labelDataMesto.setForeground(new java.awt.Color(0, 0, 0));
        labelDataMesto.setText("DolnÈ »pavkovce");
        add(labelDataMesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        labelDataStat.setForeground(new java.awt.Color(0, 0, 0));
        labelDataStat.setText("EurÛpa");
        add(labelDataStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        labelDataDatumNarodenia.setForeground(new java.awt.Color(0, 0, 0));
        labelDataDatumNarodenia.setText("01.04.2021");
        add(labelDataDatumNarodenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        labelDataPohlavie.setForeground(new java.awt.Color(0, 0, 0));
        labelDataPohlavie.setText("Dog");
        add(labelDataPohlavie, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpravitProfilMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpravitProfilMouseReleased
        this.controller.loadOrg();
        EditovatHracaDialog dialog = new EditovatHracaDialog(this.parent, true, this.controller.getPrihlasenyHrac());
        dialog.showDialog();
        this.controller.saveOrg();
        this.refresh();
    }//GEN-LAST:event_btnUpravitProfilMouseReleased

    private void listTurnajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTurnajeMouseReleased
        Turnaj t = (Turnaj) listTurnaje.getSelectedValue();
        if (t == null) {
            return;
        }
        ViewUtils.showDialog(new TurnajInfoDialog(parent, true, t));
    }//GEN-LAST:event_listTurnajeMouseReleased
    private void setHracInfo() {
        Hrac h = this.controller.getPrihlasenyHrac();
        if (h.isFirstLogin()) {
            return;
        }
        labelMeno.setText(h.getMeno());
        labelPrezyvka.setText(h.getLogin());
        labelDataMesto.setText(h.getMesto());
        labelDataStat.setText(h.getStat());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        labelDatumRegData.setText(sdf.format(h.getDatumRegistracie()));
        labelDataDatumNarodenia.setText(sdf.format(h.getDatumNarodenia()));

        labelDataPohlavie.setText(h.getPohlavie().toString());
        labelDataOrg.setText(h.getOrg().getNazov());
        labelRatingData.setText(String.valueOf(h.getELO()));

        iconAvatar.setIcon(h.getAvatar().getImage());

        String[] statistiky = this.controller.getStatistiky(h);
        labelDataPocetZapasov.setText(statistiky[0]);
        labelDataVyhry.setText(statistiky[1]);
        labelDataPrehry.setText(statistiky[2]);
        labelDataTurnaje.setText(statistiky[3]);
    }

    public void naplnListTurnajov() {
        DefaultListModel<Turnaj> model = (DefaultListModel) listTurnaje.getModel();
        model.setSize(0);
        ArrayList<Turnaj> turnaje = this.controller.getPrihlasenyHrac().getTurnaje();
        for (Turnaj t : turnaje) {
            if (t.isFinished()) {
                model.addElement(t);
            }
        }
        if (model.getSize() == 0) {
            labelOdohrateTurnaje.setVisible(true);
        } else {
            labelOdohrateTurnaje.setVisible(false);
        }
    }

    private void naplnListZapasov() {
        DefaultListModel<Zapas> model = (DefaultListModel) listZapasy.getModel();
        model.setSize(0);
        ArrayList<Zapas> zapasy = this.controller.getPrihlasenyHrac().getZapasy();
        for (Zapas z : zapasy) {
            model.addElement(z);
        }
        if (model.getSize() == 0) {
            labelOdohrateZapasy.setVisible(true);
        } else {
            labelOdohrateZapasy.setVisible(false);
        }
    }

    public void refresh() {
        this.controller.loadOrg();
        this.setHracInfo();
        this.naplnListTurnajov();
        this.naplnListZapasov();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MestoLabel;
    private javax.swing.JButton btnUpravitProfil;
    private javax.swing.JLabel iconAvatar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDataDatumNarodenia;
    private javax.swing.JLabel labelDataMesto;
    private javax.swing.JLabel labelDataOrg;
    private javax.swing.JLabel labelDataPocetZapasov;
    private javax.swing.JLabel labelDataPohlavie;
    private javax.swing.JLabel labelDataPrehry;
    private javax.swing.JLabel labelDataStat;
    private javax.swing.JLabel labelDataTurnaje;
    private javax.swing.JLabel labelDataVyhry;
    private javax.swing.JLabel labelDatumReg;
    private javax.swing.JLabel labelDatumRegData;
    private javax.swing.JLabel labelMeno;
    private javax.swing.JLabel labelMesto;
    private javax.swing.JLabel labelOdohrateTurnaje;
    private javax.swing.JLabel labelOdohrateZapasy;
    private javax.swing.JLabel labelOrg;
    private javax.swing.JLabel labelPocetZap;
    private javax.swing.JLabel labelPohlavie;
    private javax.swing.JLabel labelPrehry;
    private javax.swing.JLabel labelPrezyvka;
    private javax.swing.JLabel labelRating;
    private javax.swing.JLabel labelRatingData;
    private javax.swing.JLabel labelStat;
    private javax.swing.JLabel labelStatistiky;
    private javax.swing.JLabel labelTurnaje;
    private javax.swing.JLabel labelTurnajeStat;
    private javax.swing.JLabel labelVyhry;
    private javax.swing.JLabel labelZapasy;
    private javax.swing.JList<Turnaj> listTurnaje;
    private javax.swing.JList<Zapas> listZapasy;
    private javax.swing.JPanel paneStatistiky;
    // End of variables declaration//GEN-END:variables
}
