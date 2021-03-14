package sk.stu.fiit.main;

import sk.stu.fiit.utils.DataLoader;
import sk.stu.fiit.view.LoginFrame;

/**
 *
 * @author Martin Melisek
 * @author Lucia Rapanova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataLoader.loadData();
        LoginFrame.main(args);
    }
    
}
