package sk.stu.fiit.utils;

import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Balik;

/**
 *
 * @author Martin Melisek
 */
public class DataLoader {

    public static void loadData() {
        Database db = Database.getInstance();
        char[] pw = new char[]{'<','=','>'}; // "123"
        Balik b = new Balik(4,2,8);
        Spravca organizator = new Spravca("Martin Melisek", "test", new char[]{'<','=','>'}, "x@x.sk" );
        Organizacia o = new Organizacia("FIIT STUBA VAVA", "sk.stu.fiit.vava", organizator, b);
        db.getOrganizacie().add(o);
    }
}
