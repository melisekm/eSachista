package sk.stu.fiit.utils;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 * Library pre View
 *
 * @author Martin Melisek
 */
public class ViewUtils {

    private ViewUtils() {
    }

    /**
     * nastavi, zobrazi a premiestni dialog do stredu obrazovky
     *
     * @param dialog Dialogove okno, ktore sa nastavi
     */
    public static void showDialog(JDialog dialog) {
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    /**
     * Overi, ci boli vsetky fieldy vyplnene, vypise err dialog, ak nie
     *
     * @param parent Window - parent pre Dialog s infom
     * @param fields Pole alebo var arg fieldov/text arey
     * @return true, ak boli vsetky fieldy vyplnene, false ak opak
     */
    public static boolean validateFieldsNotBlank(Component parent, JTextComponent... fields) {
        for (JTextComponent field : fields) {
            if (field.getText().isBlank()) {
                JOptionPane.showMessageDialog(parent, "Vsetky polia musia byt vyplnene", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

   /**
     * zvaliduje ci field(y) na vstupe sa daju konvertovat na double, vypise
     * chybu ak sa nedaju
     *
     * @param parent Parentske okno kam sa zobrazi chyba
     * @param fields fieldy, ktore je potrebne zvalidovat
     * @return true ak su validne, false ak invalidne
     */
    public static boolean validateDoubleTextFields(Component parent, JTextComponent... fields) {
        return validateNumber(parent, false, fields);
    }

    /**
     * zvaliduje ci field(y) na vstupe sa daju konvertovat na int, vypise chybu
     * ak sa nedaju
     *
     * @param parent Parentske okno kam sa zobrazi chyba
     * @param fields fieldy, ktore je potrebne zvalidovat
     * @return true ak su validne, false ak invalidne
     */
    public static boolean validateIntegerTextFields(Component parent, JTextComponent... fields) {
        return validateNumber(parent, true, fields);
    }

    /**
     * interna metoda na validovanie cisel vo fieldoch
     *
     * @param parent okno kam sa zobrazi chybova hlaska
     * @param isInteger ci sa ma validovat integer
     * @param fields fieldy ktore treba zvalidovat
     * @return true ak su validne, false ak invalidne
     */
    private static boolean validateNumber(Component parent, boolean isInteger, JTextComponent... fields) {
        try {
            for (JTextComponent field : fields) {
                boolean isFieldMimoRozsah = false;
                if (isInteger) {
                    int convertedField = Integer.parseInt(field.getText());
                    isFieldMimoRozsah = Boolean.logicalOr(convertedField < 0, convertedField > Integer.MAX_VALUE);
                } else {
                    double convertedField = Double.parseDouble(field.getText());
                    isFieldMimoRozsah = Boolean.logicalOr(convertedField < 0, convertedField > Long.MAX_VALUE);
                }
                if (isFieldMimoRozsah) {
                    throw new ArithmeticException();
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Neplatna hodnota v ciselnom poli.", "Invalid input.", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(parent, "Hodnota je mimo rozsah.", "Invalid input.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * nastavi prazdnu hodnotu do fieldov zadanych ako parameter
     *
     * @param fields pole alebo vymenovane fieldy
     */
    public static void clearFields(JTextComponent... fields) {
        for (JTextComponent field : fields) {
            field.setText("");
        }
    }

    /**
     * nastavi prazdnu hodnotu do labelov zadanych ako parameter
     *
     * @param labels pole alebo vymenovane labely
     */
    public static void clearLabels(JLabel... labels) {
        clearLabels("", labels);
    }

    /**
     * nastavi zadanu hodnotu do labelov zadanych ako parameter
     *
     * @param defaultValue hodnota ktora sa zada
     * @param labels pole alebo vymenovane labely
     */
    public static void clearLabels(String defaultValue, JLabel... labels) {
        for (JLabel label : labels) {
            label.setText(defaultValue);
        }
    }
}
