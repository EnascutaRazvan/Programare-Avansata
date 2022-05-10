import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Database.createConnection();

            AllClassesDAO allClassesDAO = new AllClassesDAO();
            allClassesDAO.setConnection(Database.getConnection());
            List<Rows> countryList;
            countryList = allClassesDAO.findAll(InfoTable.COUNTRIES);
            countryList.add(allClassesDAO.findByName(InfoTable.COUNTRIES, "Romania"));
            countryList.add(allClassesDAO.findByName(InfoTable.COUNTRIES, "Spain"));
            System.out.println(countryList);

            allClassesDAO.create("Spain", allClassesDAO.findByName(InfoTable.CONTINENTS, "Europe").id, "Europe");
            allClassesDAO.create("Germany", allClassesDAO.findByName(InfoTable.CONTINENTS, "Europe").id, "Europe");
            allClassesDAO.create("Sweden", allClassesDAO.findByName(InfoTable.CONTINENTS, "Europe").id, "Europe");
            allClassesDAO.create("Bucharest", "Romania", Boolean.TRUE, 143, 130);
            allClassesDAO.create("Jassy", "Romania", Boolean.FALSE, 100, 200);
            allClassesDAO.create("South America");
            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.getConnection().rollback();
        }
        Database.closeConnection();
    }

}
