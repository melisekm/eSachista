package sk.stu.fiit.view;

import sk.stu.fiit.utils.ViewUtils;
import java.util.Arrays;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.EntryController;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.platform.Balik;
import sk.stu.fiit.utils.EntryConstants;
import sk.stu.fiit.view.dialogs.IOManagerDialog;

/**
 * Hlavny frame, pri registracii a prihlasovani pouzivatelov/organizacie,
 * Vstupna obrazovka
 *
 * @author Martin Melisek
 * @author lucia
 */
public class EntryFrame extends javax.swing.JFrame {

    private static final Logger logger = LoggerFactory.getLogger(EntryFrame.class);

    private final EntryController controller;
    private JTextField[] registraciaHracaFields;
    private JTextField[] registraciaOrgFields;
    private int registraciaType;

    public EntryFrame() {
        this.controller = new EntryController();
        initComponents();
        this.groupFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogPripojit = new javax.swing.JDialog();
        panelPripojit = new javax.swing.JPanel();
        labelLogin = new javax.swing.JLabel();
        fieldLogin = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        btnPrihlasitOK = new javax.swing.JButton();
        btnRegistrovatHraca = new javax.swing.JButton();
        labelPrihlasitName = new javax.swing.JLabel();
        labelPrihlasitOrgName = new javax.swing.JLabel();
        dialogRegistrovatOrg = new javax.swing.JDialog();
        panelRegistrovatOrg = new javax.swing.JPanel();
        labelRegistraciaOrg = new javax.swing.JLabel();
        btnVytvoritSpravcu = new javax.swing.JButton();
        labelRegOrgEmail = new javax.swing.JLabel();
        fieldRegOrgEmail = new javax.swing.JTextField();
        labelRegNazovOrg = new javax.swing.JLabel();
        fieldRegNazovOrg = new javax.swing.JTextField();
        labelRegDomenaOrg = new javax.swing.JLabel();
        fieldRegDomenaOrg = new javax.swing.JTextField();
        sliderBalik = new javax.swing.JSlider();
        labelBalik = new javax.swing.JLabel();
        labelBalikKapacita = new javax.swing.JLabel();
        labelBalikKapacitaData = new javax.swing.JLabel();
        labelBalikMaxPrihl = new javax.swing.JLabel();
        labelBalikMaxTurnajov = new javax.swing.JLabel();
        labelBalikMaxPrihlHracovData = new javax.swing.JLabel();
        labelBalikMaxTurnajovData = new javax.swing.JLabel();
        btnVytvoritOrg = new javax.swing.JButton();
        btnZobrazitDetaily = new javax.swing.JButton();
        dialogRegistrovatHraca = new javax.swing.JDialog();
        panelRegistraciaHraca = new javax.swing.JPanel();
        labelRegstraciaHraca = new javax.swing.JLabel();
        labelRegistraciaMeno = new javax.swing.JLabel();
        labelRegistraciaLogin = new javax.swing.JLabel();
        labelRegistraciaHeslo = new javax.swing.JLabel();
        labelRegistraciaHesloZnovu = new javax.swing.JLabel();
        fieldRegistraciaLogin = new javax.swing.JTextField();
        fieldRegistraciaMeno = new javax.swing.JTextField();
        btnRegistraciaHracaOK = new javax.swing.JButton();
        btnRegistraciaHracaZrusit = new javax.swing.JButton();
        fieldRegistraciaHracaPassword = new javax.swing.JPasswordField();
        fieldRegistraciaHracaPasswordZnovu = new javax.swing.JPasswordField();
        dialogDetailyRegistracie = new javax.swing.JDialog();
        panelDetailyRegistracie = new javax.swing.JPanel();
        scrollPaneDetaily = new javax.swing.JScrollPane();
        textAreaDetaily = new javax.swing.JTextArea();
        btnZavrietDetaily = new javax.swing.JButton();
        panelConnection = new javax.swing.JPanel();
        labelIconSK4 = new javax.swing.JLabel();
        labelIconUSA = new javax.swing.JLabel();
        btnIO = new javax.swing.JButton();
        labelAdresa = new javax.swing.JLabel();
        fieldAdresa = new javax.swing.JTextField();
        btnRegistrovatOrg = new javax.swing.JButton();
        btnPripojit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        labelBackGround = new javax.swing.JLabel();
        panelEsachista = new javax.swing.JPanel();

        dialogPripojit.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()); // NOI18N
        dialogPripojit.setTitle(bundle.getString("EntryFrame.dialogPripojit.title")); // NOI18N
        dialogPripojit.setModal(true);
        dialogPripojit.setResizable(false);
        dialogPripojit.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPripojit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelLogin.setText(bundle.getString("EntryFrame.labelLogin.text")); // NOI18N
        panelPripojit.add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        fieldLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fieldLogin.setText(bundle.getString("EntryFrame.fieldLogin.text")); // NOI18N
        panelPripojit.add(fieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 160, -1));

        labelPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPassword.setText(bundle.getString("EntryFrame.labelPassword.text")); // NOI18N
        panelPripojit.add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        fieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fieldPassword.setText(bundle.getString("EntryFrame.fieldPassword.text")); // NOI18N
        panelPripojit.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 160, -1));

        btnPrihlasitOK.setBackground(new java.awt.Color(118, 155, 108));
        btnPrihlasitOK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrihlasitOK.setForeground(new java.awt.Color(255, 255, 255));
        btnPrihlasitOK.setText(bundle.getString("EntryFrame.btnPrihlasitOK.text")); // NOI18N
        btnPrihlasitOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrihlasitOKMouseReleased(evt);
            }
        });
        panelPripojit.add(btnPrihlasitOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 60, -1));

        btnRegistrovatHraca.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrovatHraca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrovatHraca.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrovatHraca.setText(bundle.getString("EntryFrame.btnRegistrovatHraca.text")); // NOI18N
        btnRegistrovatHraca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegistrovatHracaMouseReleased(evt);
            }
        });
        panelPripojit.add(btnRegistrovatHraca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 170, -1));

        labelPrihlasitName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPrihlasitName.setText(bundle.getString("EntryFrame.labelPrihlasitName.text")); // NOI18N
        panelPripojit.add(labelPrihlasitName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        labelPrihlasitOrgName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPrihlasitOrgName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrihlasitOrgName.setText(bundle.getString("EntryFrame.labelPrihlasitOrgName.text")); // NOI18N
        panelPripojit.add(labelPrihlasitOrgName, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 80, 230, -1));

        dialogPripojit.getContentPane().add(panelPripojit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 290));

        dialogRegistrovatOrg.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogRegistrovatOrg.setTitle(bundle.getString("EntryFrame.dialogRegistrovatOrg.title")); // NOI18N
        dialogRegistrovatOrg.setModal(true);
        dialogRegistrovatOrg.setResizable(false);
        dialogRegistrovatOrg.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRegistrovatOrg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRegistraciaOrg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelRegistraciaOrg.setText(bundle.getString("EntryFrame.labelRegistraciaOrg.text")); // NOI18N
        panelRegistrovatOrg.add(labelRegistraciaOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnVytvoritSpravcu.setBackground(new java.awt.Color(102, 102, 102));
        btnVytvoritSpravcu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVytvoritSpravcu.setForeground(new java.awt.Color(255, 255, 255));
        btnVytvoritSpravcu.setText(bundle.getString("EntryFrame.btnVytvoritSpravcu.text")); // NOI18N
        btnVytvoritSpravcu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVytvoritSpravcuMouseReleased(evt);
            }
        });
        panelRegistrovatOrg.add(btnVytvoritSpravcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        labelRegOrgEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRegOrgEmail.setText(bundle.getString("EntryFrame.labelRegOrgEmail.text")); // NOI18N
        panelRegistrovatOrg.add(labelRegOrgEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        fieldRegOrgEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelRegistrovatOrg.add(fieldRegOrgEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 140, -1));

        labelRegNazovOrg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRegNazovOrg.setText(bundle.getString("EntryFrame.labelRegNazovOrg.text")); // NOI18N
        panelRegistrovatOrg.add(labelRegNazovOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        fieldRegNazovOrg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelRegistrovatOrg.add(fieldRegNazovOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 140, -1));

        labelRegDomenaOrg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRegDomenaOrg.setText(bundle.getString("EntryFrame.labelRegDomenaOrg.text")); // NOI18N
        panelRegistrovatOrg.add(labelRegDomenaOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        fieldRegDomenaOrg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelRegistrovatOrg.add(fieldRegDomenaOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 140, -1));

        sliderBalik.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sliderBalik.setMaximum(2);
        sliderBalik.setMinorTickSpacing(1);
        sliderBalik.setPaintTicks(true);
        sliderBalik.setSnapToTicks(true);
        sliderBalik.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBalikStateChanged(evt);
            }
        });
        panelRegistrovatOrg.add(sliderBalik, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 190, 30));

        labelBalik.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBalik.setText(bundle.getString("EntryFrame.labelBalik.text")); // NOI18N
        panelRegistrovatOrg.add(labelBalik, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        labelBalikKapacita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBalikKapacita.setText(bundle.getString("EntryFrame.labelBalikKapacita.text")); // NOI18N
        panelRegistrovatOrg.add(labelBalikKapacita, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        labelBalikKapacitaData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBalikKapacitaData.setText(bundle.getString("EntryFrame.labelBalikKapacitaData.text")); // NOI18N
        panelRegistrovatOrg.add(labelBalikKapacitaData, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        labelBalikMaxPrihl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBalikMaxPrihl.setText(bundle.getString("EntryFrame.labelBalikMaxPrihl.text")); // NOI18N
        panelRegistrovatOrg.add(labelBalikMaxPrihl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        labelBalikMaxTurnajov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBalikMaxTurnajov.setText(bundle.getString("EntryFrame.labelBalikMaxTurnajov.text")); // NOI18N
        panelRegistrovatOrg.add(labelBalikMaxTurnajov, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        labelBalikMaxPrihlHracovData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBalikMaxPrihlHracovData.setText(bundle.getString("EntryFrame.labelBalikMaxPrihlHracovData.text")); // NOI18N
        panelRegistrovatOrg.add(labelBalikMaxPrihlHracovData, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        labelBalikMaxTurnajovData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBalikMaxTurnajovData.setText(bundle.getString("EntryFrame.labelBalikMaxTurnajovData.text")); // NOI18N
        panelRegistrovatOrg.add(labelBalikMaxTurnajovData, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        btnVytvoritOrg.setBackground(new java.awt.Color(118, 155, 108));
        btnVytvoritOrg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVytvoritOrg.setForeground(new java.awt.Color(255, 255, 255));
        btnVytvoritOrg.setText(bundle.getString("EntryFrame.btnVytvoritOrg.text")); // NOI18N
        btnVytvoritOrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVytvoritOrgMouseReleased(evt);
            }
        });
        panelRegistrovatOrg.add(btnVytvoritOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 130, -1));

        btnZobrazitDetaily.setBackground(new java.awt.Color(102, 102, 102));
        btnZobrazitDetaily.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnZobrazitDetaily.setForeground(new java.awt.Color(255, 255, 255));
        btnZobrazitDetaily.setText(bundle.getString("EntryFrame.btnZobrazitDetaily.text")); // NOI18N
        btnZobrazitDetaily.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnZobrazitDetailyMouseReleased(evt);
            }
        });
        panelRegistrovatOrg.add(btnZobrazitDetaily, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        dialogRegistrovatOrg.getContentPane().add(panelRegistrovatOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 460));

        dialogRegistrovatHraca.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogRegistrovatHraca.setTitle(bundle.getString("EntryFrame.dialogRegistrovatHraca.title")); // NOI18N
        dialogRegistrovatHraca.setModal(true);
        dialogRegistrovatHraca.setResizable(false);
        dialogRegistrovatHraca.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                dialogRegistrovatHracaWindowClosed(evt);
            }
        });
        dialogRegistrovatHraca.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRegistraciaHraca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRegstraciaHraca.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelRegstraciaHraca.setText(bundle.getString("EntryFrame.labelRegstraciaHraca.text")); // NOI18N
        panelRegistraciaHraca.add(labelRegstraciaHraca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        labelRegistraciaMeno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRegistraciaMeno.setText(bundle.getString("EntryFrame.labelRegistraciaMeno.text")); // NOI18N
        panelRegistraciaHraca.add(labelRegistraciaMeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        labelRegistraciaLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRegistraciaLogin.setText(bundle.getString("EntryFrame.labelRegistraciaLogin.text")); // NOI18N
        panelRegistraciaHraca.add(labelRegistraciaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        labelRegistraciaHeslo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRegistraciaHeslo.setText(bundle.getString("EntryFrame.labelRegistraciaHeslo.text")); // NOI18N
        panelRegistraciaHraca.add(labelRegistraciaHeslo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        labelRegistraciaHesloZnovu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRegistraciaHesloZnovu.setText(bundle.getString("EntryFrame.labelRegistraciaHesloZnovu.text")); // NOI18N
        panelRegistraciaHraca.add(labelRegistraciaHesloZnovu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        fieldRegistraciaLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelRegistraciaHraca.add(fieldRegistraciaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 150, -1));

        fieldRegistraciaMeno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelRegistraciaHraca.add(fieldRegistraciaMeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, -1));

        btnRegistraciaHracaOK.setBackground(new java.awt.Color(118, 155, 108));
        btnRegistraciaHracaOK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistraciaHracaOK.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistraciaHracaOK.setText(bundle.getString("EntryFrame.btnRegistraciaHracaOK.text")); // NOI18N
        btnRegistraciaHracaOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegistraciaHracaOKMouseReleased(evt);
            }
        });
        panelRegistraciaHraca.add(btnRegistraciaHracaOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 90, -1));

        btnRegistraciaHracaZrusit.setBackground(new java.awt.Color(224, 80, 80));
        btnRegistraciaHracaZrusit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistraciaHracaZrusit.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistraciaHracaZrusit.setText(bundle.getString("EntryFrame.btnRegistraciaHracaZrusit.text")); // NOI18N
        btnRegistraciaHracaZrusit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegistraciaHracaZrusitMouseReleased(evt);
            }
        });
        panelRegistraciaHraca.add(btnRegistraciaHracaZrusit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 90, -1));

        fieldRegistraciaHracaPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelRegistraciaHraca.add(fieldRegistraciaHracaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 150, -1));

        fieldRegistraciaHracaPasswordZnovu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelRegistraciaHraca.add(fieldRegistraciaHracaPasswordZnovu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 150, -1));

        dialogRegistrovatHraca.getContentPane().add(panelRegistraciaHraca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 300));

        dialogDetailyRegistracie.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogDetailyRegistracie.setTitle(bundle.getString("EntryFrame.dialogDetailyRegistracie.title")); // NOI18N
        dialogDetailyRegistracie.setModal(true);
        dialogDetailyRegistracie.setResizable(false);
        dialogDetailyRegistracie.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDetailyRegistracie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textAreaDetaily.setEditable(false);
        textAreaDetaily.setColumns(20);
        textAreaDetaily.setLineWrap(true);
        textAreaDetaily.setRows(5);
        textAreaDetaily.setWrapStyleWord(true);
        scrollPaneDetaily.setViewportView(textAreaDetaily);

        panelDetailyRegistracie.add(scrollPaneDetaily, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 210));

        btnZavrietDetaily.setBackground(new java.awt.Color(102, 102, 102));
        btnZavrietDetaily.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnZavrietDetaily.setForeground(new java.awt.Color(255, 255, 255));
        btnZavrietDetaily.setText(bundle.getString("EntryFrame.btnZavrietDetaily.text")); // NOI18N
        btnZavrietDetaily.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnZavrietDetailyMouseReleased(evt);
            }
        });
        panelDetailyRegistracie.add(btnZavrietDetaily, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        dialogDetailyRegistracie.getContentPane().add(panelDetailyRegistracie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("EntryFrame.title")); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelConnection.setBackground(new java.awt.Color(255, 255, 255));
        panelConnection.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelConnection.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIconSK4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIconSK4.setForeground(new java.awt.Color(0, 0, 0));
        labelIconSK4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/sk.png"))); // NOI18N
        labelIconSK4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                labelIconSK4MouseReleased(evt);
            }
        });
        panelConnection.add(labelIconSK4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, -1, 40));

        labelIconUSA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIconUSA.setForeground(new java.awt.Color(0, 0, 0));
        labelIconUSA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/usa.png"))); // NOI18N
        labelIconUSA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                labelIconUSAMouseReleased(evt);
            }
        });
        panelConnection.add(labelIconUSA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, -1, 40));

        btnIO.setBackground(new java.awt.Color(102, 102, 102));
        btnIO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        btnIO.setForeground(new java.awt.Color(255, 255, 255));
        btnIO.setText(bundle.getString("EntryFrame.btnIO.text")); // NOI18N
        btnIO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIO.setFocusPainted(false);
        btnIO.setRequestFocusEnabled(false);
        btnIO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnIOMouseReleased(evt);
            }
        });
        panelConnection.add(btnIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 475, 240, 30));

        labelAdresa.setBackground(new java.awt.Color(255, 255, 255));
        labelAdresa.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        labelAdresa.setForeground(new java.awt.Color(255, 255, 255));
        labelAdresa.setText(bundle.getString("EntryFrame.labelAdresa.text")); // NOI18N
        panelConnection.add(labelAdresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        fieldAdresa.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        fieldAdresa.setText(bundle.getString("EntryFrame.fieldAdresa.text")); // NOI18N
        panelConnection.add(fieldAdresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 260, 40));

        btnRegistrovatOrg.setBackground(new java.awt.Color(118, 155, 108));
        btnRegistrovatOrg.setFont(new java.awt.Font("Candara", 0, 23)); // NOI18N
        btnRegistrovatOrg.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrovatOrg.setText(bundle.getString("EntryFrame.btnRegistrovatOrg.text")); // NOI18N
        btnRegistrovatOrg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 155, 108), 1, true));
        btnRegistrovatOrg.setFocusPainted(false);
        btnRegistrovatOrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRegistrovatOrgMouseReleased(evt);
            }
        });
        panelConnection.add(btnRegistrovatOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 350, 50));

        btnPripojit.setBackground(new java.awt.Color(102, 102, 102));
        btnPripojit.setFont(new java.awt.Font("Candara", 0, 23)); // NOI18N
        btnPripojit.setForeground(new java.awt.Color(255, 255, 255));
        btnPripojit.setText(bundle.getString("EntryFrame.btnPripojit.text")); // NOI18N
        btnPripojit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        btnPripojit.setFocusPainted(false);
        btnPripojit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPripojitMouseReleased(evt);
            }
        });
        panelConnection.add(btnPripojit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 350, 50));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelConnection.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 360, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelConnection.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 360, 30));

        labelBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/chess.png"))); // NOI18N
        labelBackGround.setText(bundle.getString("EntryFrame.labelBackGround.text")); // NOI18N
        panelConnection.add(labelBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, -10, -1, -1));

        panelEsachista.setBackground(new java.awt.Color(255, 255, 255));
        panelEsachista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelEsachista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelConnection.add(panelEsachista, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 350, 150));

        getContentPane().add(panelConnection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dialogRegistrovatHracaWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogRegistrovatHracaWindowClosed
        ViewUtils.clearFields(this.registraciaHracaFields);
    }//GEN-LAST:event_dialogRegistrovatHracaWindowClosed

    private void sliderBalikStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBalikStateChanged
        DefaultBoundedRangeModel model = (DefaultBoundedRangeModel) sliderBalik.getModel();
        int index = model.getValue();
        this.updateBalikInfo(index);
    }//GEN-LAST:event_sliderBalikStateChanged

    private void btnRegistrovatOrgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrovatOrgMouseReleased
        int DEFAULT_BALIK_OPTION = 2;
        this.controller.clearSpravca();
        ViewUtils.clearFields(this.registraciaOrgFields);
        this.registraciaType = EntryConstants.REGISTRUJ_SPRAVCU;
        this.updateBalikInfo(DEFAULT_BALIK_OPTION);
        ViewUtils.showDialog(dialogRegistrovatOrg);
    }//GEN-LAST:event_btnRegistrovatOrgMouseReleased

    private void btnRegistrovatHracaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrovatHracaMouseReleased
        this.registraciaType = EntryConstants.REGISTRUJ_HRACA;
        ViewUtils.clearFields(fieldLogin, fieldPassword);
        ViewUtils.showDialog(dialogRegistrovatHraca);
    }//GEN-LAST:event_btnRegistrovatHracaMouseReleased

    private void btnPrihlasitOKMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrihlasitOKMouseReleased
        String login = fieldLogin.getText();
        char[] password = fieldPassword.getPassword();
        fieldPassword.setText("");
        if (!this.controller.pripojitHraca(login, password)) {
            JOptionPane.showMessageDialog(dialogPripojit, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("UCET NEEXISTUJE"), "Invalid User", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        logger.info("Prihlasenie prebehlo v poriadku.");
        dialogPripojit.dispose();
        this.setVisible(false);
        this.dispose();
        int loggedInId = this.controller.getPripojenyPouzivatel();
        switch (loggedInId) {
            case EntryConstants.LOGGED_IN_SPRAVCA:
                logger.info("Spravca prihlaseny.");
                SpravcaFrame.main();
                break;
            case EntryConstants.LOGGED_IN_HRAC:
                logger.info("Hrac " + this.controller.getPrihlasenyHrac().getMeno() + " prihlaseny");
                HracFrame.main();
                break;
            default:
                logger.error("NEOCAKAVANA CHYBA PRI PRIHLASOVANI");
                break;
        }
    }//GEN-LAST:event_btnPrihlasitOKMouseReleased

    private void btnVytvoritSpravcuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVytvoritSpravcuMouseReleased
        ViewUtils.showDialog(dialogRegistrovatHraca);
    }//GEN-LAST:event_btnVytvoritSpravcuMouseReleased

    private void btnZobrazitDetailyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZobrazitDetailyMouseReleased
        String nazovOrg = fieldRegNazovOrg.getText();
        String adresaOrg = fieldRegDomenaOrg.getText();
        int balikId = ((DefaultBoundedRangeModel) sliderBalik.getModel()).getValue();
        String detailyRegistracie = this.controller.getDetailyRegistracieOrg(nazovOrg, adresaOrg, balikId);
        textAreaDetaily.setText(detailyRegistracie);
        ViewUtils.showDialog(dialogDetailyRegistracie);
    }//GEN-LAST:event_btnZobrazitDetailyMouseReleased

    private void btnVytvoritOrgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVytvoritOrgMouseReleased
        int balikId = ((DefaultBoundedRangeModel) sliderBalik.getModel()).getValue();
        if (!ViewUtils.validateFieldsNotBlank(dialogRegistrovatOrg, fieldRegOrgEmail, fieldRegNazovOrg, fieldRegDomenaOrg)) {
            return;
        }
        String nazovOrg = fieldRegNazovOrg.getText();
        String adresaOrg = fieldRegDomenaOrg.getText();
        String email = fieldRegOrgEmail.getText();
        int status = this.controller.registerOrg(nazovOrg, adresaOrg, balikId, email);
        if (!this.skontrolujStatusRegistracieOrg(status)) {
            return;
        }
        ViewUtils.clearFields(this.registraciaOrgFields);
        dialogRegistrovatOrg.dispose();
        JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("REGISTRACIA BOLA ?SPE?N?"), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnVytvoritOrgMouseReleased

    private void btnRegistraciaHracaZrusitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistraciaHracaZrusitMouseReleased
        ViewUtils.clearFields(this.registraciaHracaFields);
        dialogRegistrovatHraca.dispose();
    }//GEN-LAST:event_btnRegistraciaHracaZrusitMouseReleased

    private void btnRegistraciaHracaOKMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistraciaHracaOKMouseReleased
        int status = this.vykonajRegistraciu(this.registraciaType); // skontroluj ci je mozne registrovat sa
        if (status == EntryConstants.FORM_ERROR || !this.skontrolujStatusRegistracieHrac(status)) {
            return;
        }
        dialogRegistrovatHraca.dispose();
        JOptionPane.showMessageDialog(dialogPripojit, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("REGISTRACIA USPESNA"));
    }//GEN-LAST:event_btnRegistraciaHracaOKMouseReleased

    private void btnZavrietDetailyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZavrietDetailyMouseReleased
        dialogDetailyRegistracie.dispose();
    }//GEN-LAST:event_btnZavrietDetailyMouseReleased

    private void btnPripojitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPripojitMouseReleased
        String orgAdresa = fieldAdresa.getText();
        if (!this.controller.pripojitOrganizaciu(orgAdresa)) {
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("NEPODARILO SA PRIPOJIT"), "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        labelPrihlasitOrgName.setText(this.controller.getOrgName());
        ViewUtils.showDialog(dialogPripojit);
    }//GEN-LAST:event_btnPripojitMouseReleased

    private void btnIOMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIOMouseReleased
        ViewUtils.showDialog(new IOManagerDialog(this, true));
    }//GEN-LAST:event_btnIOMouseReleased

    private void labelIconSK4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconSK4MouseReleased
        logger.info("Prepinam jazyk na slovencinu.");
        Database.getInstance().setBundle("sk_SK");
        this.reInternationalize();
    }//GEN-LAST:event_labelIconSK4MouseReleased

    private void labelIconUSAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconUSAMouseReleased
        logger.info("Prepinam jazyk na anglicitnu.");
        Database.getInstance().setBundle("en_US");
        this.reInternationalize();
    }//GEN-LAST:event_labelIconUSAMouseReleased

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
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        UIManager.put("Button.select", new java.awt.Color(188, 188, 188));
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntryFrame().setVisible(true);
            }
        });
    }
    //<editor-fold defaultstate="collapsed" desc=" Variables declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIO;
    private javax.swing.JButton btnPrihlasitOK;
    private javax.swing.JButton btnPripojit;
    private javax.swing.JButton btnRegistraciaHracaOK;
    private javax.swing.JButton btnRegistraciaHracaZrusit;
    private javax.swing.JButton btnRegistrovatHraca;
    private javax.swing.JButton btnRegistrovatOrg;
    private javax.swing.JButton btnVytvoritOrg;
    private javax.swing.JButton btnVytvoritSpravcu;
    private javax.swing.JButton btnZavrietDetaily;
    private javax.swing.JButton btnZobrazitDetaily;
    private javax.swing.JDialog dialogDetailyRegistracie;
    private javax.swing.JDialog dialogPripojit;
    private javax.swing.JDialog dialogRegistrovatHraca;
    private javax.swing.JDialog dialogRegistrovatOrg;
    private javax.swing.JTextField fieldAdresa;
    private javax.swing.JTextField fieldLogin;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldRegDomenaOrg;
    private javax.swing.JTextField fieldRegNazovOrg;
    private javax.swing.JTextField fieldRegOrgEmail;
    private javax.swing.JPasswordField fieldRegistraciaHracaPassword;
    private javax.swing.JPasswordField fieldRegistraciaHracaPasswordZnovu;
    private javax.swing.JTextField fieldRegistraciaLogin;
    private javax.swing.JTextField fieldRegistraciaMeno;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelAdresa;
    private javax.swing.JLabel labelBackGround;
    private javax.swing.JLabel labelBalik;
    private javax.swing.JLabel labelBalikKapacita;
    private javax.swing.JLabel labelBalikKapacitaData;
    private javax.swing.JLabel labelBalikMaxPrihl;
    private javax.swing.JLabel labelBalikMaxPrihlHracovData;
    private javax.swing.JLabel labelBalikMaxTurnajov;
    private javax.swing.JLabel labelBalikMaxTurnajovData;
    private javax.swing.JLabel labelIconSK4;
    private javax.swing.JLabel labelIconUSA;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPrihlasitName;
    private javax.swing.JLabel labelPrihlasitOrgName;
    private javax.swing.JLabel labelRegDomenaOrg;
    private javax.swing.JLabel labelRegNazovOrg;
    private javax.swing.JLabel labelRegOrgEmail;
    private javax.swing.JLabel labelRegistraciaHeslo;
    private javax.swing.JLabel labelRegistraciaHesloZnovu;
    private javax.swing.JLabel labelRegistraciaLogin;
    private javax.swing.JLabel labelRegistraciaMeno;
    private javax.swing.JLabel labelRegistraciaOrg;
    private javax.swing.JLabel labelRegstraciaHraca;
    private javax.swing.JPanel panelConnection;
    private javax.swing.JPanel panelDetailyRegistracie;
    private javax.swing.JPanel panelEsachista;
    private javax.swing.JPanel panelPripojit;
    private javax.swing.JPanel panelRegistraciaHraca;
    private javax.swing.JPanel panelRegistrovatOrg;
    private javax.swing.JScrollPane scrollPaneDetaily;
    private javax.swing.JSlider sliderBalik;
    private javax.swing.JTextArea textAreaDetaily;
    // End of variables declaration//GEN-END:variables
 //</editor-fold>
    /**
     * precita udaje z fieldov a zaregistruje pouzivatela
     *
     * @param registraciaType ci sa jenda o spracu alebo pouzivatela
     * @return stav ci sa podarilo zaregistrovat, chyby ak nie, OK ak ano
     */
    private int vykonajRegistraciu(int registraciaType) {
        if (!ViewUtils.validateFieldsNotBlank(dialogRegistrovatHraca, registraciaHracaFields)) {
            return EntryConstants.FORM_ERROR;
        }
        String meno = fieldRegistraciaMeno.getText();
        String login = fieldRegistraciaLogin.getText();
        char[] password = fieldRegistraciaHracaPassword.getPassword();
        char[] passwordZnovu = fieldRegistraciaHracaPasswordZnovu.getPassword();
        fieldRegistraciaHracaPassword.setText("");
        fieldRegistraciaHracaPasswordZnovu.setText("");
        // skontroluj pw
        if (!Arrays.equals(password, passwordZnovu)) {
            JOptionPane.showMessageDialog(dialogRegistrovatHraca, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("HESLA SA NEZHODUJU."), "Invalid password", JOptionPane.ERROR_MESSAGE);
            return EntryConstants.FORM_ERROR;
        }
        return this.controller.registerPouzivatel(meno, login, password, registraciaType);
    }

    /**
     * aktualizuje na zaklade zvoleneho indexu balik info
     *
     * @param index id vybraneho balika, ktory sa sparuje s balikom v Db.
     */
    public void updateBalikInfo(int index) {
        Balik b = this.controller.getBalik(index);
        labelBalikKapacitaData.setText(String.valueOf(b.getKapacitaPouzivatelov()));
        labelBalikMaxTurnajovData.setText(String.valueOf(b.getMaxPocetTurnajov()));
        labelBalikMaxPrihlHracovData.setText(String.valueOf(b.getMaxHracovTurnaja()));
    }

    /**
     * vypise stav registracie
     *
     * @param status stav ktory vznikol z service a controllera
     * @return true ak sa registracia podarila, false inak
     */
    private boolean skontrolujStatusRegistracieOrg(int status) {
        if (status == EntryConstants.INVALID_EMAIL) {
            JOptionPane.showMessageDialog(dialogRegistrovatOrg, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("E-MAIL JE ZLE ZADAN?"), "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (status == EntryConstants.MENO_UZ_EXISTUJE) {
            JOptionPane.showMessageDialog(dialogRegistrovatOrg, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("TATO ORGANIZACIA UZ EXISTUJE"), "Invalid input", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (status == EntryConstants.SPRAVCA_NEBOL_VYTVORENY) {
            JOptionPane.showMessageDialog(dialogRegistrovatOrg, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("SPRAVCA ORGANIZACIE NEBOL VYTVORENY"), "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * skontroluje navyse detaily pri registracii hraca
     *
     * @param status stav, ktory vznikol z service/controllera
     * @return true ak sa registracia podarila, false inak
     */
    private boolean skontrolujStatusRegistracieHrac(int status) {
        if (status == EntryConstants.MENO_UZ_EXISTUJE) {
            JOptionPane.showMessageDialog(dialogRegistrovatHraca, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("TENTO POUZIVATEL UZ EXISTUJE."), "Invalid Username", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (status == EntryConstants.KAPACITA_PREKROCENA) {
            JOptionPane.showMessageDialog(dialogRegistrovatHraca, java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("KAPACITA BOLA PREKROCENA."), java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("PREKROCENA KAPACITA"), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void groupFields() {
        this.registraciaHracaFields = new JTextField[]{
            fieldRegistraciaMeno,
            fieldRegistraciaLogin,
            fieldRegistraciaHracaPassword,
            fieldRegistraciaHracaPasswordZnovu
        };
        this.registraciaOrgFields = new JTextField[]{
            fieldRegOrgEmail,
            fieldRegNazovOrg,
            fieldRegDomenaOrg
        };
    }

    private void reInternationalize() {
        this.dispose();
        this.setVisible(false);
        this.main();
    }
}
