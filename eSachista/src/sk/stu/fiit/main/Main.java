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

    private static boolean loadDemoDB = false;

    private static boolean saveDefaultDB = false;

    static {
        Database.createDatabase(); // prazdna DB

    }

    public static void main(String[] args) {
        logger.info("Spustam aplikaciu");
        int res = JOptionPane.showConfirmDialog(null, "Spravca?", "DEBUG", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            loadDemoDB = false;
            saveDefaultDB = true;
        } else {
            loadDemoDB = true;
            saveDefaultDB = false;

        }
        Database.createDatabase(); // prazdna DB
        if (loadDemoDB) {
            logger.info("DB ZO SUBORA");
            try {
                Database.getInstance().getOrganizacie().add(new IOManager().loadOrg());
            } catch (ClassNotFoundException ex) {
                logger.error("Nacitala sa nekompatibilna trieda");
                logger.error(ex.getClass().toString());
                System.exit(1);
//                DataLoader.loadData();
            } catch (IOException ex) {
                logger.error("Chyba pri nacitavani DB");
                logger.error(ex.getClass().toString());
            }
        } else {
            logger.info("DEFAULTNA DB.");
            DataLoader.loadData();
        }
        if (saveDefaultDB) {
            Date now = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(now);
            cal.add(Calendar.MINUTE, 0);

//            DataLoader.loadData();
            Database.getInstance().getOrganizacie().get(0).getTurnaje().get(0).setDatumKonania(cal.getTime());
            Database.getInstance().getOrganizacie().get(0).getTurnaje().get(0).setStage(null);
            Database.getInstance().getOrganizacie().get(0).getTurnaje().get(0).setFinished(false);
            new File("resources/turnaje/0/harmonogram.xml").delete();
            try {
                new IOManager().saveOrg(Database.getInstance().getOrganizacie().get(0));
            } catch (IOException ex) {
                logger.error("Chyba pri nacitavani DB");
                logger.error(ex.getClass().toString());
            }
        }
        EntryFrame.main();
    }

}
