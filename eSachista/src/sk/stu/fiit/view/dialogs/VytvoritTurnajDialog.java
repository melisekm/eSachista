package sk.stu.fiit.view.dialogs;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.TurnajController;
import sk.stu.fiit.exceptions.InvalidDateException;
import sk.stu.fiit.exceptions.MaxPocetTurnajovException;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajFormat;
import sk.stu.fiit.utils.ViewUtils;

/**
 * Dialog, vytvarania noveho turnaja
 * @author Martin Melisek
 */
public class VytvoritTurnajDialog extends javax.swing.JDialog {

    private static final Logger logger = LoggerFactory.getLogger(VytvoritTurnajDialog.class);

    private TurnajController controller;

    public VytvoritTurnajDialog(java.awt.Frame parent, boolean modal, TurnajController controller, Turnaj povodny) {
        super(parent, modal);
        this.controller = controller;
        this.controller.setNovyTurnaj(null);
        initComponents();
        datePicker.setMinSelectableDate(new Date());
        if (povodny != null) {
            this.setTurnajInfo(povodny);
        }
    }

    public VytvoritTurnajDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JPanel();
        btnUlozit = new javax.swing.JButton();
        labelCasovyLimit = new javax.swing.JLabel();
        spinnerMinutes = new javax.swing.JSpinner();
        labelMin = new javax.swing.JLabel();
        fieldMiestoKonania = new javax.swing.JTextField();
        labelVytvoritTurnaj = new javax.swing.JLabel();
        labelFormat = new javax.swing.JLabel();
        datePicker = new com.toedter.calendar.JDateChooser();
        spinnerLimitMin = new javax.swing.JSpinner();
        fieldNazov = new javax.swing.JTextField();
        spinnerHrs = new javax.swing.JSpinner();
        labelSec = new javax.swing.JLabel();
        labelInc = new javax.swing.JLabel();
        labelDatum = new javax.swing.JLabel();
        labelCas = new javax.swing.JLabel();
        comboboxFormat = new javax.swing.JComboBox<>();
        spinnerLimitSec = new javax.swing.JSpinner();
        labelMiestoKonania = new javax.swing.JLabel();
        labelNazov = new javax.swing.JLabel();
        spinnerLimitInc = new javax.swing.JSpinner();
        labelOddelovac = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOpis = new javax.swing.JTextArea();
        labelPopis = new javax.swing.JLabel();
        labelRating = new javax.swing.JLabel();
        labelVek = new javax.swing.JLabel();
        spinnerMaxRating = new javax.swing.JSpinner();
        labelOddelovac2 = new javax.swing.JLabel();
        spinnerMaxVek = new javax.swing.JSpinner();
        spinnerMinRating = new javax.swing.JSpinner();
        checkBoxMaxVek = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nov? turnaj");
        setResizable(false);

        mainPane.setPreferredSize(new java.awt.Dimension(710, 480));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUlozit.setBackground(new java.awt.Color(118, 155, 108));
        btnUlozit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUlozit.setForeground(new java.awt.Color(255, 255, 255));
        btnUlozit.setText("Ulo?i?");
        btnUlozit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUlozitMouseReleased(evt);
            }
        });
        mainPane.add(btnUlozit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 220, -1));

        labelCasovyLimit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCasovyLimit.setText("?asov? limit:");
        mainPane.add(labelCasovyLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        spinnerMinutes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        mainPane.add(spinnerMinutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 80, -1));

        labelMin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMin.setText("min");
        mainPane.add(labelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        fieldMiestoKonania.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mainPane.add(fieldMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 180, -1));

        labelVytvoritTurnaj.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelVytvoritTurnaj.setText("Vytvori? turnaj");
        mainPane.add(labelVytvoritTurnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        labelFormat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFormat.setText("Form?t:");
        mainPane.add(labelFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        datePicker.setDateFormatString("dd.MM.yyyy");
        datePicker.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mainPane.add(datePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 180, 30));

        spinnerLimitMin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerLimitMin.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));
        mainPane.add(spinnerLimitMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 80, -1));

        fieldNazov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mainPane.add(fieldNazov, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 180, -1));

        spinnerHrs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerHrs.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        mainPane.add(spinnerHrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 80, -1));

        labelSec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelSec.setText("sec");
        mainPane.add(labelSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        labelInc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelInc.setText("inkrement");
        mainPane.add(labelInc, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        labelDatum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDatum.setText("D?tum konania:");
        mainPane.add(labelDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        labelCas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCas.setText("?as za?iatku:");
        mainPane.add(labelCas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 30));

        comboboxFormat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboboxFormat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Round Robin", "Single Elimination" }));
        mainPane.add(comboboxFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 180, -1));

        spinnerLimitSec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerLimitSec.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        mainPane.add(spinnerLimitSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 80, -1));

        labelMiestoKonania.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMiestoKonania.setText("Miesto konania:");
        mainPane.add(labelMiestoKonania, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        labelNazov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNazov.setText("N?zov turnaja:");
        mainPane.add(labelNazov, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        spinnerLimitInc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerLimitInc.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        mainPane.add(spinnerLimitInc, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 80, -1));

        labelOddelovac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOddelovac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOddelovac.setText(":");
        mainPane.add(labelOddelovac, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 20, 30));

        textAreaOpis.setColumns(20);
        textAreaOpis.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textAreaOpis.setLineWrap(true);
        textAreaOpis.setRows(5);
        textAreaOpis.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textAreaOpis);

        mainPane.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 290, 110));

        labelPopis.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPopis.setText("Popis:");
        mainPane.add(labelPopis, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, 30));

        labelRating.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRating.setText("Rating:");
        mainPane.add(labelRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, 30));

        labelVek.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelVek.setText("Max vek:");
        mainPane.add(labelVek, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, 30));

        spinnerMaxRating.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerMaxRating.setModel(new javax.swing.SpinnerNumberModel(4000, 0, 5000, 1));
        mainPane.add(spinnerMaxRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 80, -1));

        labelOddelovac2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOddelovac2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOddelovac2.setText("-");
        mainPane.add(labelOddelovac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 20, -1));

        spinnerMaxVek.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerMaxVek.setModel(new javax.swing.SpinnerNumberModel(99, 0, 99, 1));
        spinnerMaxVek.setEnabled(false);
        mainPane.add(spinnerMaxVek, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 80, -1));

        spinnerMinRating.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnerMinRating.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5000, 1));
        mainPane.add(spinnerMinRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 80, -1));

        checkBoxMaxVek.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkBoxMaxVek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                checkBoxMaxVekMouseReleased(evt);
            }
        });
        mainPane.add(checkBoxMaxVek, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 129, -1, 20));

        getContentPane().add(mainPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUlozitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUlozitMouseReleased
        if (!ViewUtils.validateFieldsNotBlank(this, fieldNazov, fieldMiestoKonania, textAreaOpis)) {
            logger.warn("Neboli vyplnene vsetky fieldy");
            return;
        }
        String nazov = fieldNazov.getText();
        String miesto = fieldMiestoKonania.getText();
        try {
            spinnerHrs.commitEdit();
            spinnerMinutes.commitEdit();
        } catch (java.text.ParseException e) {
            logger.warn("Hodnota v poli cas zacatia bola mimo rozsahu");
        }
        int zaciatokHrs = (Integer) spinnerHrs.getValue();
        int zaciatokMin = (Integer) spinnerMinutes.getValue();

        int formatIndex = comboboxFormat.getSelectedIndex();
        TurnajFormat format = TurnajFormat.values()[formatIndex];
        int limitMin = (Integer) spinnerLimitMin.getValue();
        int limitSec = (Integer) spinnerLimitSec.getValue();
        int increment = (Integer) spinnerLimitInc.getValue();

        int minRating = (Integer) spinnerMinRating.getValue();
        int maxRating = (Integer) spinnerMaxRating.getValue();
        if (minRating > maxRating) {
            logger.warn("Minimalny rating na turnaji bol nastaveny vyssi nez maximalny");
            JOptionPane.showMessageDialog(this, "Minimalny rating musi byt nizsi nez maximalny");
            return;
        }
        int maxVek;
        if (checkBoxMaxVek.isSelected()) {
            maxVek = (Integer) spinnerMaxVek.getValue();
        } else {
            maxVek = Integer.MAX_VALUE;
        }
        String popis = textAreaOpis.getText();

        try {
            logger.info("Ukladam turnaj");
            this.controller.vytvorTurnaj(format, nazov, miesto, datePicker.getDate(),
                    zaciatokHrs, zaciatokMin, limitMin, limitSec, increment, popis, minRating, maxRating, maxVek);
            logger.info("Turnaj " + nazov + " ulozeny");
        } catch (NullPointerException ex) {
            logger.error("NEPLATNY DATUM");
            JOptionPane.showMessageDialog(this, "Neplatny datum");
            return;
        } catch (MaxPocetTurnajovException e) {
            JOptionPane.showMessageDialog(this, "Bol prekroceny maximalny pocet turnajov");
            return;
        } catch (InvalidDateException e) {
            JOptionPane.showMessageDialog(this, "Datum turnaja nemoze byt v minulosti");
            return;
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnUlozitMouseReleased

    private void checkBoxMaxVekMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxMaxVekMouseReleased
        if (checkBoxMaxVek.isSelected()) {
            spinnerMaxVek.setEnabled(true);
        } else {
            spinnerMaxVek.setEnabled(false);
        }
    }//GEN-LAST:event_checkBoxMaxVekMouseReleased

    private void setTurnajInfo(Turnaj povodny) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Bratislava"));
        cal.setTime(povodny.getDatumKonania());
        fieldNazov.setText(povodny.getNazov());
        fieldMiestoKonania.setText(povodny.getMiestoKonania());
        textAreaOpis.setText(povodny.getPopis());
        datePicker.setDate(cal.getTime());
        spinnerMinutes.setValue(cal.get(Calendar.MINUTE));
        spinnerHrs.setValue(cal.get(Calendar.HOUR_OF_DAY));
        spinnerLimitInc.setValue(povodny.getTempoHry().getIncrement());
        spinnerLimitMin.setValue(povodny.getTempoHry().getLimitMins());
        spinnerLimitSec.setValue(povodny.getTempoHry().getLimitSec());
        spinnerMinRating.setValue(povodny.getObmedzenia().getMinRating());
        spinnerMaxRating.setValue(povodny.getObmedzenia().getMaxRating());
        if (povodny.getObmedzenia().getMaxVek() == Integer.MAX_VALUE) {
            checkBoxMaxVek.setSelected(false);
            spinnerMaxVek.setValue(99);
            spinnerMaxVek.setEnabled(false);
        } else {
            checkBoxMaxVek.setSelected(true);
            spinnerMaxVek.setValue(povodny.getObmedzenia().getMaxVek());
            spinnerMaxVek.setEnabled(true);
        }
        comboboxFormat.setSelectedIndex(povodny.getFormat().ordinal());
    }

    public Turnaj showDialog() {
        ViewUtils.showDialog(this);
        return this.controller.getNovyTurnaj();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUlozit;
    private javax.swing.JCheckBox checkBoxMaxVek;
    private javax.swing.JComboBox<String> comboboxFormat;
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JTextField fieldMiestoKonania;
    private javax.swing.JTextField fieldNazov;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCas;
    private javax.swing.JLabel labelCasovyLimit;
    private javax.swing.JLabel labelDatum;
    private javax.swing.JLabel labelFormat;
    private javax.swing.JLabel labelInc;
    private javax.swing.JLabel labelMiestoKonania;
    private javax.swing.JLabel labelMin;
    private javax.swing.JLabel labelNazov;
    private javax.swing.JLabel labelOddelovac;
    private javax.swing.JLabel labelOddelovac2;
    private javax.swing.JLabel labelPopis;
    private javax.swing.JLabel labelRating;
    private javax.swing.JLabel labelSec;
    private javax.swing.JLabel labelVek;
    private javax.swing.JLabel labelVytvoritTurnaj;
    private javax.swing.JPanel mainPane;
    private javax.swing.JSpinner spinnerHrs;
    private javax.swing.JSpinner spinnerLimitInc;
    private javax.swing.JSpinner spinnerLimitMin;
    private javax.swing.JSpinner spinnerLimitSec;
    private javax.swing.JSpinner spinnerMaxRating;
    private javax.swing.JSpinner spinnerMaxVek;
    private javax.swing.JSpinner spinnerMinRating;
    private javax.swing.JSpinner spinnerMinutes;
    private javax.swing.JTextArea textAreaOpis;
    // End of variables declaration//GEN-END:variables
}
