package sk.stu.fiit.database;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.platform.Balik;

/**
 *
 * @author Martin Melisek
 */
public class Database {

    private static Database INSTANCE = new Database();
    private ArrayList<Organizacia> organizacie = new ArrayList<>();
    private ArrayList<Balik> baliky = new ArrayList<>();

    private Database() {
        this.baliky.add(new Balik(10, 2, 8));
        this.baliky.add(new Balik(50, 10, 32));
        this.baliky.add(new Balik(100, 20, 64));
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public ArrayList<Balik> getBaliky() {
        return baliky;
    }

    public ArrayList<Organizacia> getOrganizacie() {
        return organizacie;
    }

}
