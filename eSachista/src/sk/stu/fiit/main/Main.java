package sk.stu.fiit.main;

import java.io.File;
import java.io.IOException;
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

    private final static String testovaciaDB = "..\\demo\\demo.vava";

    private static boolean loadDemoDB = true;

    static {
        if (loadDemoDB) {
            logger.info("DEMO DB je zapnuta");
            try {
//                new IOManager().loadDatabase(new File(testovaciaDB));
//                new IOManager().saveOrg(Database.getInstance().getOrganizacie().get(0));
                Database.createDatabase(); // prazdna DB

                Database.getInstance().getOrganizacie().add(new IOManager().loadOrg());
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
            logger.info("DEMO DB je vypnuta.");
            Database.createDatabase(); // prazdna DB
            DataLoader.loadData();
        }
    }

    public static void main(String[] args) {
        logger.info("Spustam aplikaciu");
        EntryFrame.main();
    }

}
