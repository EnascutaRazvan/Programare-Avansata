public class Cities extends Rows {
    String country;
    Boolean capital;
    int latitude;
    int logitude;

    public Cities(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLogitude() {
        return logitude;
    }

    public void setLogitude(int lagitude) {
        this.logitude = lagitude;
    }

    @Override
    public String toString() {
        return "[id = " + id +
                ", name = '" + name + '\'' +
                ", country='" + country + '\'' +
                ", capital=" + capital +
                ", latitude = '" + latitude + '\'' +
                ", logitude = '" + logitude + '\'' +
                ']' + "\n";
    }
}
