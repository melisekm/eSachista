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

    public void saveDatabase(File file) throws FileNotFoundException, IOException {
        Database db = Database.getInstance();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) { // try with resources
            logger.debug("Ukladam databazu.");
            out.writeObject(db); // ulozi databazu
            logger.debug("Databaza uspesene ulozena.");
        }
    }

    public void loadDatabase(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            logger.debug("Nacitavam databazu so suboru " + file.getName());
            Database.createDatabase((Database) in.readObject());
            logger.debug("Databaza uspesene nacitana.");
        }
    }

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

    public Organizacia loadOrg() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.orgPath))) {
            logger.debug("Nacitavam org zo suboru " + this.orgPath);
            return ((Organizacia) in.readObject());
        }
    }
}
