package sk.stu.fiit.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pohlavie;
import sk.stu.fiit.model.organisation.platform.Avatar;

/**
 *
 * @author Martin Melisek
 */
public class HracEditorController extends Controller {

    private Hrac editovanyHrac;

    public HracEditorController(Hrac editovanyHrac) {
        this.editovanyHrac = editovanyHrac;
    }

    public void updateHrac(String meno, String mesto, String stat, Date datumNarodenia, Pohlavie pohlavie, Avatar avatar) {
        this.editovanyHrac.setMeno(meno);
        this.editovanyHrac.setMesto(mesto);
        this.editovanyHrac.setStat(stat);
        this.editovanyHrac.setDatumNarodenia(datumNarodenia);
        this.editovanyHrac.setPohlavie(pohlavie);
        this.editovanyHrac.setAvatar(avatar);
        this.editovanyHrac.setVek(getVekFromDatum(datumNarodenia));
    }

    private int getVekFromDatum(Date datumNarodenia) {
        LocalDate start = LocalDate.ofInstant(datumNarodenia.toInstant(), ZoneId.systemDefault());
        LocalDate end = LocalDate.now();
        int years = (int) ChronoUnit.YEARS.between(start, end);
        return years;
    }

    public Hrac getEditovanyHrac() {
        return editovanyHrac;
    }

    public void setEditovanyHrac(Hrac editovanyHrac) {
        this.editovanyHrac = editovanyHrac;
    }
}
