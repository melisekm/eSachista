package sk.stu.fiit.utils;

import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Spravca;

/**
 *
 * @author Martin Melisek
 */
public class DataLoader {

    public static void loadData() {
        Database db = Database.getInstance();
        Spravca organizator = new Spravca("Martin Melisek", "test", "123", "x@x.sk" );
        Organizacia o = new Organizacia("FIIT STUBA VAVA", "sk.stu.fiit.vava", organizator);
        db.getOrganizacie().add(o);
    }
}
