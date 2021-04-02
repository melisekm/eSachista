package sk.stu.fiit.view;

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

    public static void clearFields(JTextComponent... fields) {
        for (JTextComponent field : fields) {
            field.setText("");
        }
    }

    public static void clearLabels(JLabel... labels) {
        for (JLabel label : labels) {
            label.setText("");
        }
    }
}
