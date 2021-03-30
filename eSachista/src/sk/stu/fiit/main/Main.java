package sk.stu.fiit.main;

import sk.stu.fiit.utils.DataLoader;
import sk.stu.fiit.view.EntryFrame;

/**
 *
 * @author Martin Melisek
 * @author Lucia Rapanova
 */
public class Main {

    public static void main(String[] args) {
        DataLoader.loadData();
        EntryFrame.main();
    }
    
}
