class Countries extends Rows {
    int code;
    String continent;

    public Countries(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "[id = " + id +
                ", name = '" + name + '\'' +
                ", code = " + code +
                ", continent = '" + continent + '\'' +
                ']' + "\n";
    }
}
