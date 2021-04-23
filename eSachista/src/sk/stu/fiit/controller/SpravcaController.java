package sk.stu.fiit.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class SpravcaController extends Controller {

    public SpravcaController() {
    }

    public LinkedHashMap<String, Double> getDniKonaniaDataset() {
        LinkedHashMap<String, Double> hraciTurnajeDataset = new LinkedHashMap<>();
        for (Turnaj t : this.getTurnaje()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String datum = sdf.format(t.getDatumKonania());
            if (!hraciTurnajeDataset.containsKey(datum)) {
                hraciTurnajeDataset.put(datum, ((double) t.getHraci().size()));
            } else {
                double prev_hraci = hraciTurnajeDataset.get(datum);
                hraciTurnajeDataset.put(datum, prev_hraci += ((double) t.getHraci().size()));
            }
        }
        return hraciTurnajeDataset;
    }

    public LinkedHashMap<String, Double> getHraciDataset() {
        LinkedHashMap<String, Double> hraciTurnajeDataset = new LinkedHashMap<>();
        for (Turnaj t : this.getTurnaje()) {
            hraciTurnajeDataset.put(t.getNazov(), ((double) t.getHraci().size()));
        }
        return hraciTurnajeDataset;
    }

    public String[] getTurnajeStatistiky(Organizacia o) {
        String[] res = new String[4];
        int ukoncene, naplanovane, pocetZapasov;
        ukoncene = naplanovane = pocetZapasov = 0;
        for (Turnaj t : this.getTurnaje()) {
            pocetZapasov += t.getZapasy().size();
            if (t.isFinished()) {
                ukoncene++;
            } else {
                naplanovane++;
            }
        }
        res[0] = String.valueOf(this.getTurnaje().size());
        res[1] = String.valueOf(naplanovane);
        res[2] = String.valueOf(ukoncene);
        res[3] = String.valueOf(pocetZapasov);
        return res;
    }

    public String getPriemerneELO() {
        double sum = 0.0;
        for (Hrac hrac : this.getHraci()) {
            sum += hrac.getELO();
        }
        return String.valueOf(sum / (double) this.getHraci().size());
    }
}
