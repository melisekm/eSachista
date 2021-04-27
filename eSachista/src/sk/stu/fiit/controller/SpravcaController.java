package sk.stu.fiit.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 * Hlavny controller pre spravcu, predava info z modelov a databazy pre domovsky
 * panel spravcu
 *
 * @author Martin Melisek
 * @author lucia
 */
public class SpravcaController extends Controller {

    public SpravcaController() {
    }

    /**
     * vrati naformatovany dataset pre chart
     *
     * @return dataset mapujuci den konania a agregovany pocet hracov prihlaseny
     * na turnaje v dany den
     */
    public LinkedHashMap<String, Double> getDniKonaniaDataset() {
        LinkedHashMap<String, Double> hraciTurnajeDataset = new LinkedHashMap<>();
        for (Turnaj t : this.getTurnaje()) {
            if (!t.isFinished()) {
                continue;
            }
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

    /**
     * vrati naformatovany dataset pre chart
     *
     * @return dataset mapujuci pocet hracov prihlasenych na ktory turnaj.
     */
    public LinkedHashMap<String, Double> getHraciDataset() {
        LinkedHashMap<String, Double> hraciTurnajeDataset = new LinkedHashMap<>();
        for (Turnaj t : this.getTurnaje()) {
            if (!t.isFinished()) {
                continue;
            }
            hraciTurnajeDataset.put(t.getNazov(), ((double) t.getHraci().size()));
        }
        return hraciTurnajeDataset;
    }

    /**
     * vrati formatovane statistiky o organizacii<br>
     * 0 - pocet turnajov<br>
     * 1 - pocet naplanovanych turnajov<br>
     * 2 - pocet ukocnenych turnajov<br>
     * 3 - pocet zapasov<br>
     *
     * @param o prihlasena organizacia
     * @return pole retazcov - statistik
     */
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

    /**
     * vypocita priemerne elo registrovanych hracov
     *
     * @return naformatovane priemerne elo, ak nie je ziadny hrac tak "0"
     */
    public String getPriemerneELO() {
        if (this.getHraci().isEmpty()) {
            return "0";
        }
        double sum = 0.0;
        for (Hrac hrac : this.getHraci()) {
            sum += hrac.getELO();
        }
        return String.valueOf(sum / (double) this.getHraci().size());
    }
}
