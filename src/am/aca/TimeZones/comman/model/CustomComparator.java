package am.aca.TimeZones.comman.model;

import java.util.Comparator;

public class CustomComparator {

    public static class CompareByCountryCode implements Comparator<Zone> {
        @Override
        public int compare(Zone o1, Zone o2) {
            return o1.getCountryCode().compareTo(o2.getCountryCode());
        }
    }

    public static class CompareByTimeZone implements Comparator<Zone> {
        @Override
        public int compare(Zone o1, Zone o2) {
            return o1.getTimeZone().compareTo(o2.getTimeZone());
        }
    }
}
