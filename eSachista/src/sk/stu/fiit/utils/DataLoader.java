package sk.stu.fiit.utils;

import java.util.Calendar;
import java.util.Date;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pohlavie;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Avatar;
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
//        vytvorOrganizaciu(db);
//        pridajHracov(db, 0);
//        pridajTurnaj(db, 0, "Turnaj dekana", "Online", "Turnaj online");
        pridajTurnaj(db, 0, "FIITkarsky turnaj", "FIIT", "Turnaj na skole");
//        pridajHracovNaTurnaj(db, 0, 0);
        pridajHracovNaTurnaj(db, 0, 1);
    }

    private static void vytvorOrganizaciu(Database db) {
        char[] pw = new char[]{'<', '=', '>'}; // "123"
        Balik b = new Balik(20, 10, 10);
        Spravca organizator = new Spravca("Martin Melisek", "test", pw, "x@x.sk");
        Organizacia o = new Organizacia("FIIT STUBA VAVA", "sk.stu.fiit.vava", organizator, b);
        organizator.setOrg(o);
        db.getOrganizacie().add(o);
    }

    private static void pridajHracov(Database db, int orgId) {
        Organizacia org = db.getOrganizacie().get(orgId);
        org.getPouzivatelia().add(createHrac(org, "Adam Novy", "aa", 800, "Nové Zámky", Pohlavie.MUZ));
        org.getPouzivatelia().add(createHrac(org, "Milan Prvy", "milan", 1000, "Kosice", Pohlavie.MUZ));
        org.getPouzivatelia().add(createHrac(org, "Jakub Rychly", "jakub", 650, "Bratislava", Pohlavie.MUZ));
        org.getPouzivatelia().add(createHrac(org, "Jana Fialova", "jana", 1500, "Praha", Pohlavie.ZENA));
    }

    private static Hrac createHrac(Organizacia org, String meno, String login, int ELO, String mesto, Pohlavie p) {
        Hrac tmp = new Hrac(org, meno, login, new char[]{'<', '=', '>'});
        tmp.setAvatar(new Avatar(new javax.swing.ImageIcon(DataLoader.class.getResource("/sk/stu/fiit/obrazky/user2.png"))));
        tmp.setDatumNarodenia(new Date());
        tmp.setDatumRegistracie(new Date());
        tmp.setELO(ELO);
        tmp.setFirstLogin(false);
        tmp.setMesto(mesto);
        tmp.setPohlavie(p);
        tmp.setStat("Slovensko");
        tmp.setVek(20);
        return tmp;
    }

    private static void pridajTurnaj(Database db, int orgId, String nazov, String miesto, String popis) {
        Organizacia org = db.getOrganizacie().get(orgId);
        TurnajObmedzenia turnajObmedzenia = new TurnajObmedzenia(1, 3500, 99);
        TurnajTempoHry turnajTempoHry = new TurnajTempoHry(10, 0, 5);
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, 10);
        Turnaj t = new Turnaj(TurnajFormat.ROUND_ROBIN,
                nazov, miesto, cal.getTime(), popis, turnajTempoHry, turnajObmedzenia);
        org.getTurnaje().add(t);
    }

    private static void pridajHracovNaTurnaj(Database db, int orgId, int turnajId) {
        Organizacia org = db.getOrganizacie().get(orgId);
        Turnaj t = org.getTurnaje().get(turnajId);
        Hrac h1 = (Hrac) org.getPouzivatelia().get(1);
        Hrac h2 = (Hrac) org.getPouzivatelia().get(2);
        Hrac h3 = (Hrac) org.getPouzivatelia().get(3);
        Hrac h4 = (Hrac) org.getPouzivatelia().get(4);
        pridajHracaNaTurnaj(t, h1);
        pridajHracaNaTurnaj(t, h2);
        pridajHracaNaTurnaj(t, h3);
        pridajHracaNaTurnaj(t, h4);
    }

    private static void pridajHracaNaTurnaj(Turnaj t, Hrac h) {
        t.getHraci().add(h);
        h.getTurnaje().add(t);
    }
}
