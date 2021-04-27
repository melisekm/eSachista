package sk.stu.fiit.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;

/**
 * Umozni ukladanie databazy do suboru a nasledne citanie - serializacia
 *
 * @author Martin Melisek
 * @see Database
 */
public class IOManager {

    private static final Logger logger = LoggerFactory.getLogger(IOManager.class);

    private String orgPath;
    public IOManager() {
    }

    public IOManager(String nazov) {
        new File("resources\\" + nazov).mkdirs();
        this.orgPath = "resources\\" + nazov + "\\" + nazov + ".vavaORG";
    }
    /**
     * ulozi celu databazu do suboru
     * @param file subor kam sa ma ulozit
     * @throws FileNotFoundException ak sa subor nenajde
     * @throws IOException ak nastane ina chyba
     */
    public void saveDatabase(File file) throws FileNotFoundException, IOException {
        Database db = Database.getInstance();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) { // try with resources
            logger.debug("Ukladam databazu.");
            out.writeObject(db); // ulozi databazu
            logger.debug("Databaza uspesene ulozena.");
        }
    }
    /**
     * nacita celu databazu zo suboru
     * @param file subor z akeho nacitavat
     * @throws FileNotFoundException ak sa nenajde subor
     * @throws IOException ina chyba
     * @throws ClassNotFoundException ak nacitana db je nekompatibilna 
     */
    public void loadDatabase(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            logger.debug("Nacitavam databazu so suboru " + file.getName());
            Database.createDatabase((Database) in.readObject());
            logger.debug("Databaza uspesene nacitana.");
        }
        for (Organizacia organizacia : Database.getInstance().getOrganizacie()) {
            if(!(new File("resources/" + organizacia.getNazov()).exists())){
                logger.warn("Do databazy bola nacitana organizacia, ktorej domovsky subor neexistuje.");
            }
        }
    }
    /**
     * ulozi prave prihlasenu org do suboru
     * @param org organizacia ktora sa ma ulozit
     * @throws FileNotFoundException ak sa subor nenajde
     * @throws IOException ina chyba
     */
    public void saveOrg(Organizacia org) throws FileNotFoundException, IOException {
        File orgFile = new File(this.orgPath);
        if (!orgFile.exists()) {
            orgFile.createNewFile();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.orgPath))) { // try with resources
            logger.debug("Ukladam org do suboru.");
            out.writeObject(org);
            logger.debug("org uspesene ulozene.");
        }
    }
    /**
     * nacita zo suboru organizaciu
     * @return organizacia ak sa to podari inak exception
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Organizacia loadOrg() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.orgPath))) {
            logger.debug("Nacitavam org zo suboru " + this.orgPath);
            return ((Organizacia) in.readObject());
        }
    }
}
