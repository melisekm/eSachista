package sk.stu.fiit.database;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.Organizacia;

/**
 *
 * @author Martin Melisek
 */
public class Database {

    private static Database INSTANCE = new Database();
    private ArrayList<Organizacia> organizacie = new ArrayList<>();

    private Database() {
    }
    
    public static Database getInstance(){
        return INSTANCE;
    }

    public ArrayList<Organizacia> getOrganizacie() {
        return organizacie;
    }
    
    
}
