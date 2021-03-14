package sk.stu.fiit.utils;

/**
 *
 * @author Martin Melisek
 */
public class ViewUtils {
    private ViewUtils(){
    }
    public static void showDialog(javax.swing.JDialog dialog){
        dialog.setLocationRelativeTo(null);
        dialog.pack();
        dialog.setVisible(true);
    }
}
