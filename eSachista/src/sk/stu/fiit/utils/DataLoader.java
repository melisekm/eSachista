package sk.stu.fiit.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pohlavie;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Avatar;
import sk.stu.fiit.model.organisation.platform.Balik;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajFormat;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajObmedzenia;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajTempoHry;

/**
 * Nacita predefinovane demo organizacie
 * @author Martin Melisek
 */
public class DataLoader {

    public static void loadData() {
        Database db = Database.getInstance();
        vytvorOrganizaciu(db);
        pridajHracov(db, 0);
        pridajTurnaj(db, 0, 1, 30, 5, 3500, "FIITkarsky", "FIIT", "Turnaj na skole", TurnajFormat.SINGLE_ELIMINATION, new Date(1619202352000L), true);
        pridajTurnaj(db, 0, 5, 0, 20, 2500, "Dekansky", "Online", "Turnaj online", TurnajFormat.ROUND_ROBIN, new Date(), false);
        pridajTurnaj(db, 0, 10, 0, 0, 2000, "BP", "Online", "Turnaj online", TurnajFormat.SINGLE_ELIMINATION, new Date(1619377252000L), false);
        pridajTurnaj(db, 0, 20, 30, 0, 2500, "Ing", "Online", "Turnaj online", TurnajFormat.ROUND_ROBIN, new Date(1619377252000L), false);
        pridajHracovNaTurnaj(db, 0, 0, 4);
        pridajHracovNaTurnaj(db, 0, 1, 3);
        pridajHracovNaTurnaj(db, 0, 2, 5);
        pridajHracovNaTurnaj(db, 0, 3, 4);
    }

    private static void vytvorOrganizaciu(Database db) {
        char[] pw = new char[]{'<', '=', '>'}; // "123"
        Balik b = new Balik("Stredný", 20, 10, 10);
        Spravca organizator = new Spravca("Martin Melisek", "xmelisek", pw, "xmelisek@stuba.sk");
        Organizacia o = new Organizacia("FIIT STUBA VAVA", "sk.stu.fiit.vava", organizator, b);
        organizator.setOrg(o);
        db.getOrganizacie().add(o);
    }

    private static void pridajHracov(Database db, int orgId) {
        Organizacia org = db.getOrganizacie().get(orgId);
        org.getPouzivatelia().add(createHrac(org, "Adam Novy", "adam", 800, "Nové Zámky", Pohlavie.MUZ));
        org.getPouzivatelia().add(createHrac(org, "Milan Prvy", "milan", 1000, "Kosice", Pohlavie.MUZ));
        org.getPouzivatelia().add(createHrac(org, "Jakub Rychly", "jakub", 650, "Bratislava", Pohlavie.MUZ));
        org.getPouzivatelia().add(createHrac(org, "Jana Fialova", "jana", 1500, "Praha", Pohlavie.ZENA));
        org.getPouzivatelia().add(createHrac(org, "Michal Druhy", "michal", 1900, "Praha", Pohlavie.MUZ));
    }

    private static Hrac createHrac(Organizacia org, String meno, String login, int ELO, String mesto, Pohlavie p) {
        Hrac tmp = new Hrac(org, meno, login, new char[]{'<', '=', '>'});
        tmp.setAvatar(new Avatar(new javax.swing.ImageIcon(DataLoader.class.getResource("/sk/stu/fiit/obrazky/default-avatar.png"))));
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

    private static void pridajTurnaj(Database db, int orgId, int limitMins, int limitSec, int increment, int maxRating, String nazov, String miesto, String popis, TurnajFormat format, Date datum, boolean finished) {
        Organizacia org = db.getOrganizacie().get(orgId);
        TurnajObmedzenia turnajObmedzenia = new TurnajObmedzenia(1, maxRating, Integer.MAX_VALUE);
        TurnajTempoHry turnajTempoHry = new TurnajTempoHry(limitMins, limitSec, increment);
        if (!finished) {
            Date now = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(now);
            cal.add(Calendar.MINUTE, limitMins);
            datum = cal.getTime();
        }
        Turnaj t = new Turnaj(format,
                nazov, miesto, datum, popis, turnajTempoHry, turnajObmedzenia);
        t.setFinished(finished);
        org.getTurnaje().add(t);
    }

    private static void pridajHracovNaTurnaj(Database db, int orgId, int turnajId, int pocet) {
        Organizacia org = db.getOrganizacie().get(orgId);
        Turnaj t = org.getTurnaje().get(turnajId);
        ArrayList<Hrac> hraci = new ArrayList<>();
        for (Pouzivatel pouzivatel : org.getPouzivatelia()) {
            if (pouzivatel instanceof Hrac) {
                hraci.add((Hrac) pouzivatel);
            }
        }
        for (int i = 0; i < pocet; i++) {
            pridajHracaNaTurnaj(t, hraci.get(i));
        }
    }

    private static void pridajHracaNaTurnaj(Turnaj t, Hrac h) {
        t.getHraci().add(h);
        h.getTurnaje().add(t);
    }
}
