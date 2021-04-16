package sk.stu.fiit.main;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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

    private static boolean saveDefaultDB = false;

    static {
        if (loadDemoDB) {
            logger.info("DEMO DB je zapnuta");
            try {
//                new IOManager().loadDatabase(new File(testovaciaDB));
                Database.createDatabase(); // prazdna DB
                Database.getInstance().getOrganizacie().add(new IOManager().loadOrg());

                if (saveDefaultDB) {
                    Date now = new Date();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(now);
                    cal.add(Calendar.MINUTE, 10);

                    Database.getInstance().getOrganizacie().get(0).getTurnaje().get(0).setDatumKonania(cal.getTime());
                    Database.getInstance().getOrganizacie().get(0).getTurnaje().get(0).setStage(null);
                    Database.getInstance().getOrganizacie().get(0).getTurnaje().get(0).setFinished(false);
                    new IOManager().saveOrg(Database.getInstance().getOrganizacie().get(0));
                }

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
