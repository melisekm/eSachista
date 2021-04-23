package sk.stu.fiit.view.panes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger logger = LoggerFactory.getLogger(SpravcaPrehladPane.class);
    
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogEditovatSpravcu = new javax.swing.JDialog();
        paneDialogEditovat = new javax.swing.JPanel();
        btnUlozitSpravcaDialog = new javax.swing.JButton();
        labelNazovOrgDialog = new javax.swing.JLabel();
        labelMenoSpravcuDialog = new javax.swing.JLabel();
        fieldNazovOrg = new javax.swing.JTextField();
        fieldMenoSpravcu = new javax.swing.JTextField();
        labelUpravitUdaje = new javax.swing.JLabel();
        btnVybratAvatar = new javax.swing.JButton();
        labelLogoOrgDialog = new javax.swing.JLabel();
        imgChooser = new javax.swing.JFileChooser();
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
        labelEmail = new javax.swing.JLabel();
        labelDataEmail = new javax.swing.JLabel();

        dialogEditovatSpravcu.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneDialogEditovat.setBackground(new java.awt.Color(255, 255, 255));
        paneDialogEditovat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUlozitSpravcaDialog.setBackground(new java.awt.Color(118, 155, 108));
        btnUlozitSpravcaDialog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUlozitSpravcaDialog.setForeground(new java.awt.Color(255, 255, 255));
        btnUlozitSpravcaDialog.setText("Uloûiù");
        btnUlozitSpravcaDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUlozitSpravcaDialogMouseReleased(evt);
            }
        });
        paneDialogEditovat.add(btnUlozitSpravcaDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 140, -1));

        labelNazovOrgDialog.setBackground(new java.awt.Color(0, 0, 0));
        labelNazovOrgDialog.setForeground(new java.awt.Color(0, 0, 0));
        labelNazovOrgDialog.setText("N·zov organiz·cie:");
        paneDialogEditovat.add(labelNazovOrgDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        labelMenoSpravcuDialog.setBackground(new java.awt.Color(0, 0, 0));
        labelMenoSpravcuDialog.setForeground(new java.awt.Color(0, 0, 0));
        labelMenoSpravcuDialog.setText("Meno spr·vcu:");
        paneDialogEditovat.add(labelMenoSpravcuDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 155, -1, -1));
        paneDialogEditovat.add(fieldNazovOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, -1));
        paneDialogEditovat.add(fieldMenoSpravcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, -1));

        labelUpravitUdaje.setBackground(new java.awt.Color(0, 0, 0));
        labelUpravitUdaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelUpravitUdaje.setForeground(new java.awt.Color(0, 0, 0));
        labelUpravitUdaje.setText("Upraviù ˙daje");
        paneDialogEditovat.add(labelUpravitUdaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        btnVybratAvatar.setBackground(new java.awt.Color(102, 102, 102));
        btnVybratAvatar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVybratAvatar.setForeground(new java.awt.Color(255, 255, 255));
        btnVybratAvatar.setText("Vybraù avatar");
        btnVybratAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVybratAvatarMouseReleased(evt);
            }
        });
        paneDialogEditovat.add(btnVybratAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        labelLogoOrgDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        paneDialogEditovat.add(labelLogoOrgDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 160, 140));

        dialogEditovatSpravcu.getContentPane().add(paneDialogEditovat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 310));

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUpravitOrgPrehladMouseReleased(evt);
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
        labelDataMenoSpravcu.setText("Admin");
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

        labelEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelEmail.setText("E-Mail:");
        add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        labelDataEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelDataEmail.setText("admin@org.sk");
        add(labelDataEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVybratAvatarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVybratAvatarMouseReleased
        FileFilter ff = new FileNameExtensionFilter("images", "jpg", "jpeg", "png");
        imgChooser.setFileFilter(ff);
        int open = imgChooser.showOpenDialog(this);
        if (open == JFileChooser.APPROVE_OPTION) {
            File file = imgChooser.getSelectedFile();
            BufferedImage bi;
            try {
                bi = ImageIO.read(file); // path is your file or image path
                labelLogoOrgDialog.setIcon(new ImageIcon(bi));
            } catch (Exception ex) {
                logger.warn("Pouzivatel vybral nepodporany typ obrazku");
                JOptionPane.showMessageDialog(this, "Nepodporovany typ obrazku.", "INVALID IMAGE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnVybratAvatarMouseReleased

    private void btnUlozitSpravcaDialogMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUlozitSpravcaDialogMouseReleased
        if (!ViewUtils.validateFieldsNotBlank(dialogEditovatSpravcu, fieldMenoSpravcu, fieldNazovOrg)) {
            return;
        }
        String menoSpravcu = fieldMenoSpravcu.getText();
        String nazovOrg = fieldNazovOrg.getText();
        this.controller.getOrgLoggedIn().setNazov(nazovOrg);
        this.controller.getPrihlasenySpravca().setMeno(menoSpravcu);
        this.controller.getPrihlasenySpravca().getAvatar().setImage(labelLogoOrgDialog.getIcon());
        this.controller.saveOrg();
        dialogEditovatSpravcu.setVisible(false);
        dialogEditovatSpravcu.dispose();
        this.refresh();
    }//GEN-LAST:event_btnUlozitSpravcaDialogMouseReleased

    private void btnUpravitOrgPrehladMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpravitOrgPrehladMouseReleased
        fieldMenoSpravcu.setText(this.controller.getPrihlasenySpravca().getMeno());
        fieldNazovOrg.setText(this.controller.getOrgLoggedIn().getNazov());
        labelLogoOrgDialog.setIcon(this.controller.getPrihlasenySpravca().getAvatar().getImage());
        ViewUtils.showDialog(dialogEditovatSpravcu);
    }//GEN-LAST:event_btnUpravitOrgPrehladMouseReleased
    
    private void setSpravcaInfo() {
        Spravca s = this.controller.getPrihlasenySpravca();
        Organizacia o = this.controller.getOrgLoggedIn();
        labelDataNazovOrg.setText(o.getNazov());
        labelLogoOrg.setIcon(s.getAvatar().getImage());
        labelDataBalik.setText(o.getBalik().getNazov());
        labelDataMenoSpravcu.setText(s.getMeno());
        labelDataEmail.setText(s.getEmail());
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
    private javax.swing.JButton btnUlozitSpravcaDialog;
    private javax.swing.JButton btnUpravitOrgPrehlad;
    private javax.swing.JButton btnVybratAvatar;
    private javax.swing.JDialog dialogEditovatSpravcu;
    private javax.swing.JTextField fieldMenoSpravcu;
    private javax.swing.JTextField fieldNazovOrg;
    private javax.swing.JFileChooser imgChooser;
    private javax.swing.JLabel labelBalik;
    private javax.swing.JLabel labelDataBalik;
    private javax.swing.JLabel labelDataDatumReg;
    private javax.swing.JLabel labelDataEmail;
    private javax.swing.JLabel labelDataMenoSpravcu;
    private javax.swing.JLabel labelDataNaplanovaneTurnaje;
    private javax.swing.JLabel labelDataNazovOrg;
    private javax.swing.JLabel labelDataPocetClenov;
    private javax.swing.JLabel labelDataPocetTurnajov;
    private javax.swing.JLabel labelDataPocetZapasov;
    private javax.swing.JLabel labelDataPriemerneELO;
    private javax.swing.JLabel labelDataUkonceneTurnaje;
    private javax.swing.JLabel labelDatumRegistracie;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelLogoOrg;
    private javax.swing.JLabel labelLogoOrgDialog;
    private javax.swing.JLabel labelMenoSpravcuDialog;
    private javax.swing.JLabel labelNaplanovaneTurnaje;
    private javax.swing.JLabel labelNazovOrgDialog;
    private javax.swing.JLabel labelPocetClenov;
    private javax.swing.JLabel labelPocetTurnajov;
    private javax.swing.JLabel labelPocetZapasov;
    private javax.swing.JLabel labelPriemerneELO;
    private javax.swing.JLabel labelUkonceneTurnaje;
    private javax.swing.JLabel labelUpravitUdaje;
    private javax.swing.JLabel labelVitajte;
    private javax.swing.JPanel paneDialogEditovat;
    // End of variables declaration//GEN-END:variables
}
