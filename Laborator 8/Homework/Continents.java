public class Continents extends Rows {

    public Continents(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    @Override
    public String toString() {
        return "[id = " + id +
                ", name = '" + name + '\'' +
                ']' + "\n";
    }

}
