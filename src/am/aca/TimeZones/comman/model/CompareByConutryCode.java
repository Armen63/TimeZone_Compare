package am.aca.TimeZones.comman.model;

import java.util.Comparator;

/**
 * Created by Armen on 4/12/2017.
 */
public class CompareByConutryCode implements Comparator<Zone> {
    @Override
    public int compare(Zone o1, Zone o2) {
        return o1.getCountryCode().compareTo(o2.getCountryCode());
    }
}
