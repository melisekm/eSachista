package sk.stu.fiit.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
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
}
