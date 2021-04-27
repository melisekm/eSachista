package sk.stu.fiit.database;

import java.io.Serializable;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.platform.Balik;

/**
 *
 * @author Martin Melisek
 */
public class Database implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    private static Database INSTANCE;
    private ArrayList<Organizacia> organizacie = new ArrayList<>();
    private ArrayList<Balik> baliky = new ArrayList<>();

    private String bundle = "Bundle_sk_SK";

    private Database() {
        this.baliky.add(new Balik("Mal�", 10, 2, 8));
        this.baliky.add(new Balik("Stredn�", 50, 10, 32));
        this.baliky.add(new Balik("Ve�k�", 100, 20, 64));
    }

    public static void createDatabase(Database db) {
        logger.info("Inicializujem existujucu databazu");
        INSTANCE = db;
    }

    public static void createDatabase() {
        logger.info("Inicializujem novu databazu");
        INSTANCE = new Database();
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public ArrayList<Balik> getBaliky() {
        return baliky;
    }

    public ArrayList<Organizacia> getOrganizacie() {
        return organizacie;
    }

    public String getBundle() {
        return bundle;
    }

    public void setBundle(String loc) {
        this.bundle = "Bundle_" + loc;
    }

}
