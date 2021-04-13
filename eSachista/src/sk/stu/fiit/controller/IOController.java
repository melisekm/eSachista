package sk.stu.fiit.controller;

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

/**
 * Umozni ukladanie databazy do suboru a nasledne citanie - serializacia
 *
 * @author Martin Melisek
 * @see Database
 */
public class IOController  extends Controller {
    
    private static final Logger logger = LoggerFactory.getLogger(IOController.class);
    
    public void saveDatabase(File file) throws FileNotFoundException, IOException {
        Database db = Database.getInstance();
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) { // try with resources
            logger.info("Ukladam databazu.");
            out.writeObject(db); // ulozi databazu
            logger.info("Databaza uspesene ulozena.");
        }
    }

    public void loadDatabase(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            logger.info("Nacitavam databazu so suboru " + file.getName());
            Database.createDatabase((Database) in.readObject());
            logger.info("Databaza uspesene nacitana.");
        }
    }
}
