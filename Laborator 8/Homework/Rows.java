public abstract class Rows {
    int id;
    String name;
    static InfoTable infoTable;

    public Rows() {
    }

    public Rows(int id, String name, InfoTable infoTable) {
        this.id = id;
        this.name = name;
        this.infoTable = infoTable;
    }

    public static InfoTable getTablename() {
        return infoTable;
    }

    public void setTablename(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
