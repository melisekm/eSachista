package sk.stu.fiit.main;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.io.IOManager;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.utils.DataLoader;
import sk.stu.fiit.view.EntryFrame;

/**
 *
 * @author Martin Melisek
 * @author Lucia Rapanova
 */
public class Main {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

    static {
        Database.createDatabase(); // prazdna DB
    }

    public static void main(String[] args) {
        logger.info("Spustam aplikaciu");
        EntryFrame.main();
    }
}
