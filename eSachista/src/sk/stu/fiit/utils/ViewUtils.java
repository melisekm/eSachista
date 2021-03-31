package sk.stu.fiit.utils;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 * Library pre View
 *
 * @author Martin Melisek
 */
public class ViewUtils {

    private ViewUtils() {
    }

    public static void showDialog(JDialog dialog) {
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static boolean validateFieldsNotBlank(Component parent, JTextComponent... fields) {
        for (JTextComponent field : fields) {
            if (field.getText().isBlank()) {
                JOptionPane.showMessageDialog(parent, "Vsetky polia musia byt vyplnene", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static void clearFields(JTextComponent... fields) {
        for (JTextComponent field : fields) {
            field.setText("");
        }
    }

    public static void clearFields(JLabel... labels) {
        for (JLabel label : labels) {
            label.setText("");
        }
    }
}
