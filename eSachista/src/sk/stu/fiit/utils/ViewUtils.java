package sk.stu.fiit.utils;

/**
 *
 * @author Martin Melisek
 */
public class ViewUtils {
    private ViewUtils(){
    }
    public static void showDialog(javax.swing.JDialog dialog){
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
