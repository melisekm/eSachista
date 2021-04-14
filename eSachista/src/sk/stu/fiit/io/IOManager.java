package sk.stu.fiit.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 * Umozni ukladanie databazy do suboru a nasledne citanie - serializacia
 *
 * @author Martin Melisek
 * @see Database
 */
public class IOManager {

    private static final Logger logger = LoggerFactory.getLogger(IOManager.class);

    private String turnajePath = "C:\\Users\\melis\\Documents\\!VAVA\\esachista\\turnaje.vava";

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

    public void saveTurnaje(ArrayList<Turnaj> turnaje) throws FileNotFoundException, IOException {
        File file = new File(this.turnajePath);
        if(!file.exists()){
            file.createNewFile();
        }
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.turnajePath))) { // try with resources
            logger.info("Ukladam turnaje do suboru.");
            out.writeObject(turnaje); // ulozi databazu
            logger.info("turnaje uspesene ulozene.");
        }
    }

    public ArrayList<Turnaj> loadTurnaje() throws FileNotFoundException, IOException, ClassNotFoundException {
        try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.turnajePath))) {
            logger.info("Nacitavam turnaje zo suboru " + turnajePath);
            return ((ArrayList<Turnaj>) in.readObject());
        }
    }
}
