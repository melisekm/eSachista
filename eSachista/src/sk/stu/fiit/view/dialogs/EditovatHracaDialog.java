package sk.stu.fiit.view.dialogs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.HracEditorController;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pohlavie;
import sk.stu.fiit.model.organisation.platform.Avatar;
import sk.stu.fiit.utils.PlatformConstants;
import sk.stu.fiit.utils.ViewUtils;

/**
 * Dialog, ktorym sa edituju data pouzivatela
 * @author lucia
 * @author Martin Melisek
 */
public class EditovatHracaDialog extends javax.swing.JDialog {

    private static final Logger logger = LoggerFactory.getLogger(EditovatHracaDialog.class);

    private HracEditorController controller;

    public EditovatHracaDialog(java.awt.Frame parent, boolean modal, Hrac editovanyHrac) {
        super(parent, modal);
        this.controller = new HracEditorController(editovanyHrac);
        initComponents();
        fieldMeno.setText(editovanyHrac.getMeno());
        if (editovanyHrac.isFirstLogin()) {
            this.prepareFirstEdit();
        } else {
            this.setHracInfo(editovanyHrac);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dialogSkillSelect = new javax.swing.JDialog();
        skillSelectPane = new javax.swing.JPanel();
        comboBoxSkillSelect = new javax.swing.JComboBox<>();
        labelPrvotnePrihlasenie = new javax.swing.JLabel();
        labelSkill = new javax.swing.JLabel();
        labelUlozitSkill = new javax.swing.JButton();
        imgChooser = new javax.swing.JFileChooser();
        mainPane = new javax.swing.JPanel();
        labelUpravitUdaje = new javax.swing.JLabel();
        labelMeno = new javax.swing.JLabel();
        fieldMeno = new javax.swing.JTextField();
        labelMesto = new javax.swing.JLabel();
        fieldMesto = new javax.swing.JTextField();
        labelStat = new javax.swing.JLabel();
        fieldStat = new javax.swing.JTextField();
        labelDatumNarodenia = new javax.swing.JLabel();
        datePickerDatumNarodenia = new com.toedter.calendar.JDateChooser();
        labelPohlavie = new javax.swing.JLabel();
        comboBoxPohlavie = new javax.swing.JComboBox<>();
        btnVybratAvatar = new javax.swing.JButton();
        imageAvatar = new javax.swing.JLabel();
        btnUlozitUdaje = new javax.swing.JButton();

        dialogSkillSelect.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dialogSkillSelect.setTitle("Prvotn? prihl?senie");
        dialogSkillSelect.setModal(true);
        dialogSkillSelect.setResizable(false);
        dialogSkillSelect.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialogSkillSelectWindowClosing(evt);
            }
        });

        skillSelectPane.setLayout(new java.awt.GridBagLayout());

        comboBoxSkillSelect.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboBoxSkillSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Za?iato?n?k", "Stredne pokro?il?", "Pokro?il?" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        skillSelectPane.add(comboBoxSkillSelect, gridBagConstraints);

        labelPrvotnePrihlasenie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPrvotnePrihlasenie.setText("Prvotn? prihl?senie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 0);
        skillSelectPane.add(labelPrvotnePrihlasenie, gridBagConstraints);

        labelSkill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelSkill.setText("V ?achu som:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        skillSelectPane.add(labelSkill, gridBagConstraints);

        labelUlozitSkill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelUlozitSkill.setText("Ulo?i?");
        labelUlozitSkill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                labelUlozitSkillMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(13, 0, 13, 0);
        skillSelectPane.add(labelUlozitSkill, gridBagConstraints);

        javax.swing.GroupLayout dialogSkillSelectLayout = new javax.swing.GroupLayout(dialogSkillSelect.getContentPane());
        dialogSkillSelect.getContentPane().setLayout(dialogSkillSelectLayout);
        dialogSkillSelectLayout.setHorizontalGroup(
            dialogSkillSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(skillSelectPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogSkillSelectLayout.setVerticalGroup(
            dialogSkillSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(skillSelectPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUpravitUdaje.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelUpravitUdaje.setForeground(new java.awt.Color(0, 0, 0));
        labelUpravitUdaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUpravitUdaje.setText("Upravi? ?daje");
        mainPane.add(labelUpravitUdaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 170, -1));

        labelMeno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMeno.setForeground(new java.awt.Color(0, 0, 0));
        labelMeno.setText("Meno:");
        mainPane.add(labelMeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        fieldMeno.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        mainPane.add(fieldMeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, -1));

        labelMesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMesto.setForeground(new java.awt.Color(0, 0, 0));
        labelMesto.setText("Mesto:");
        mainPane.add(labelMesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        fieldMesto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        mainPane.add(fieldMesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 130, -1));

        labelStat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelStat.setForeground(new java.awt.Color(0, 0, 0));
        labelStat.setText("?t?t:");
        mainPane.add(labelStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        fieldStat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        mainPane.add(fieldStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 130, -1));

        labelDatumNarodenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDatumNarodenia.setForeground(new java.awt.Color(0, 0, 0));
        labelDatumNarodenia.setText("D?tum narodenia:");
        mainPane.add(labelDatumNarodenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        datePickerDatumNarodenia.setDateFormatString("d.M.yyyy");
        datePickerDatumNarodenia.setMaxSelectableDate(new Date());
        datePickerDatumNarodenia.setMinSelectableDate(new java.util.Date(-2208992400000L));
        mainPane.add(datePickerDatumNarodenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 130, -1));

        labelPohlavie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPohlavie.setForeground(new java.awt.Color(0, 0, 0));
        labelPohlavie.setText("Pohlavie:");
        mainPane.add(labelPohlavie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        comboBoxPohlavie.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboBoxPohlavie.setModel(new DefaultComboBoxModel<>(Pohlavie.values()));
        mainPane.add(comboBoxPohlavie, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 130, -1));

        btnVybratAvatar.setBackground(new java.awt.Color(102, 102, 102));
        btnVybratAvatar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVybratAvatar.setForeground(new java.awt.Color(255, 255, 255));
        btnVybratAvatar.setText("Vybra? avatar");
        btnVybratAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVybratAvatarMouseReleased(evt);
            }
        });
        mainPane.add(btnVybratAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 130, -1));

        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sk/stu/fiit/obrazky/default-avatar.png"))); // NOI18N
        mainPane.add(imageAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, 150));

        btnUlozitUdaje.setBackground(new java.awt.Color(118, 155, 108));
        btnUlozitUdaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUlozitUdaje.setForeground(new java.awt.Color(255, 255, 255));
        btnUlozitUdaje.setText("Ulo?i?");
        btnUlozitUdaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUlozitUdajeMouseReleased(evt);
            }
        });
        mainPane.add(btnUlozitUdaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * po pociatocnom prihlaseni ulozi skill hraca
     */
    private void labelUlozitSkillMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelUlozitSkillMouseReleased
        int index = comboBoxSkillSelect.getSelectedIndex();
        switch (index) {
            case 0:
                this.controller.getEditovanyHrac().setELO(PlatformConstants.ZACIATOCNIK_ELO);
                break;
            case 1:
                this.controller.getEditovanyHrac().setELO(PlatformConstants.STREDNE_POKROCILY_ELO);
                break;
            case 2:
                this.controller.getEditovanyHrac().setELO(PlatformConstants.POKROCILY_ELO);
                break;
            default:
                throw new AssertionError();
        }
        dialogSkillSelect.setVisible(false);
        dialogSkillSelect.dispose();
    }//GEN-LAST:event_labelUlozitSkillMouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (this.controller.getEditovanyHrac().isFirstLogin()) {
            JOptionPane.showMessageDialog(this, "Je potrebne vyplnit detaily", "ENTER INFO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing
    /**
     * precita fieldy a ulozi udaje hraca
     */
    private void btnUlozitUdajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUlozitUdajeMouseReleased
        if (!ViewUtils.validateFieldsNotBlank(this, fieldMeno, fieldMesto, fieldStat)) {
            logger.warn("Neboli vyplnene vsetky fieldy");
            return;
        }
        Date datumNarodenia = datePickerDatumNarodenia.getDate();
        if (datumNarodenia == null) {
            logger.error("Pouzivatel zadal NEPLATNY DATUM");
            JOptionPane.showMessageDialog(this, "Neplatny datum", "INVALID DATE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String meno = fieldMeno.getText();
        String mesto = fieldMesto.getText();
        String stat = fieldStat.getText();
        Pohlavie pohlavie = (Pohlavie) comboBoxPohlavie.getSelectedItem();
        Avatar avatar = new Avatar(imageAvatar.getIcon());
        logger.info("Ukladam informacie o hracovi.");
        this.controller.updateHrac(meno, mesto, stat, datumNarodenia, pohlavie, avatar);
        logger.info("Hrac " + this.controller.getEditovanyHrac().getMeno() + " ulozeny");
        this.controller.getEditovanyHrac().setFirstLogin(false);

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnUlozitUdajeMouseReleased

    private void dialogSkillSelectWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogSkillSelectWindowClosing
        JOptionPane.showMessageDialog(this, "Na to aby sme vas mohli prihlasit, je potrebne zadat skill.", "ENTER SKILL", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_dialogSkillSelectWindowClosing
    /**
     * otvori file picker a nacita obrazok pre hraca
     */
    private void btnVybratAvatarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVybratAvatarMouseReleased
        FileFilter ff = new FileNameExtensionFilter("images", "jpg", "jpeg", "png");
        imgChooser.setFileFilter(ff);
        int open = imgChooser.showOpenDialog(this);
        if (open == JFileChooser.APPROVE_OPTION) {
            File file = imgChooser.getSelectedFile();
            BufferedImage bi;
            try {
                bi = ImageIO.read(file); // path is your file or image path
                imageAvatar.setIcon(new ImageIcon(bi));
            } catch (Exception ex) {
                logger.warn("Pouzivatel vybral nepodporany typ obrazku");
                JOptionPane.showMessageDialog(this, "Nepodporovany typ obrazku.", "INVALID IMAGE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnVybratAvatarMouseReleased

    private void prepareFirstEdit() {
        logger.info("Prvotne prihlasenie hraca, je potrebne vyplnit udaje.");
        ViewUtils.showDialog(dialogSkillSelect);
        ViewUtils.clearFields(fieldMesto, fieldStat);
    }

    private void setHracInfo(Hrac h) {
        fieldMesto.setText(h.getMesto());
        fieldStat.setText(h.getStat());
        datePickerDatumNarodenia.setDate(h.getDatumNarodenia());
        comboBoxPohlavie.setSelectedItem(h.getPohlavie());
        imageAvatar.setIcon(h.getAvatar().getImage());
    }

    public void showDialog() {
        ViewUtils.showDialog(this);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUlozitUdaje;
    private javax.swing.JButton btnVybratAvatar;
    private javax.swing.JComboBox<Pohlavie> comboBoxPohlavie;
    private javax.swing.JComboBox<String> comboBoxSkillSelect;
    private com.toedter.calendar.JDateChooser datePickerDatumNarodenia;
    private javax.swing.JDialog dialogSkillSelect;
    private javax.swing.JTextField fieldMeno;
    private javax.swing.JTextField fieldMesto;
    private javax.swing.JTextField fieldStat;
    private javax.swing.JLabel imageAvatar;
    private javax.swing.JFileChooser imgChooser;
    private javax.swing.JLabel labelDatumNarodenia;
    private javax.swing.JLabel labelMeno;
    private javax.swing.JLabel labelMesto;
    private javax.swing.JLabel labelPohlavie;
    private javax.swing.JLabel labelPrvotnePrihlasenie;
    private javax.swing.JLabel labelSkill;
    private javax.swing.JLabel labelStat;
    private javax.swing.JButton labelUlozitSkill;
    private javax.swing.JLabel labelUpravitUdaje;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel skillSelectPane;
    // End of variables declaration//GEN-END:variables
}
