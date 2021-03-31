package sk.stu.fiit.utils;

import java.util.Date;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Balik;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajFormat;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajObmedzenia;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajTempoHry;

/**
 *
 * @author Martin Melisek
 */
public class DataLoader {

    public static void loadData() {
        Database db = Database.getInstance();
        vytvorOrganizaciu(db);
        pridajHraca(db, 0);
        pridajTurnaj(db, 0);
        pridajHracaNaTurnaj(db, 0, 0, 1);
    }

    private static void vytvorOrganizaciu(Database db) {
        char[] pw = new char[]{'<', '=', '>'}; // "123"
        Balik b = new Balik(4, 10, 8);
        Spravca organizator = new Spravca("Martin Melisek", "test", pw, "x@x.sk");
        Organizacia o = new Organizacia("FIIT STUBA VAVA", "sk.stu.fiit.vava", organizator, b);
        organizator.setOrg(o);
        db.getOrganizacie().add(o);
    }

    private static void pridajHraca(Database db, int orgId) {
        Organizacia org = db.getOrganizacie().get(orgId);
        org.getPouzivatelia().add(new Hrac(org, "Adam Novy", "aa", new char[]{'<', '=', '>'}));
    }

    private static void pridajTurnaj(Database db, int orgId) {
        Organizacia org = db.getOrganizacie().get(orgId);
        TurnajObmedzenia turnajObmedzenia = new TurnajObmedzenia(800, 2000, 20);
        TurnajTempoHry turnajTempoHry = new TurnajTempoHry(10, 0, 5);
        Turnaj t = new Turnaj(TurnajFormat.SWISS, 
                "Turnaj Dekana", "Online", new Date(), "Turnaj na skole", turnajTempoHry, turnajObmedzenia);
        org.getTurnaje().add(t);
    }

    private static void pridajHracaNaTurnaj(Database db, int orgId, int turnajId, int hracId) {
        Organizacia org = db.getOrganizacie().get(orgId);
        Turnaj t = org.getTurnaje().get(turnajId);
        Hrac h = (Hrac) org.getPouzivatelia().get(hracId);
        t.getHraci().add(h);
        h.getTurnaje().add(t);
    }
}
