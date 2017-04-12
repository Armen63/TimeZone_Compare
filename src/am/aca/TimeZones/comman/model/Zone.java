package am.aca.TimeZones.comman.model;

/**
 * Created by Armen on 4/12/2017.
 */
public class Zone {
    private String ID;
    private String countryCode;
    private String timeZone;

    public Zone(String ID, String countryCode, String timeZone) {
        this.ID = ID;
        this.countryCode = countryCode;
        this.timeZone = timeZone;
    }

    public Zone() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "ID=" + ID +
                ", countryCode='" + countryCode + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
