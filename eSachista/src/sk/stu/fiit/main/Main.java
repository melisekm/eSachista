package sk.stu.fiit.main;

import java.io.File;
import java.io.IOException;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.controller.IOController;
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

    private final static String testovaciaDB = "..\\demo\\demo.vava";

    private static boolean loadDemoDB = true;

    static {
        if (loadDemoDB) {
            try {
                new IOController().loadDatabase(new File(testovaciaDB));
            } catch (IOException ex) {
                logger.error("Chyba pri nacitavani DB");
                logger.error(ex.getClass().toString());
            } catch (ClassNotFoundException ex) {
                logger.error("Nacitala sa nekompatibilna trieda");
                logger.error(ex.getClass().toString());
                Database.createDatabase(); // prazdna DB
                DataLoader.loadData();
            }
        } else {
            Database.createDatabase(); // prazdna DB
            DataLoader.loadData();
        }
    }

    public static void main(String[] args) {
        logger.info("Spustam aplikaciu");
        DataLoader.loadData();
        EntryFrame.main();
    }

}
