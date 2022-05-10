import java.sql.*;
import java.util.ArrayList;


public class AllClassesDAO {
    private static Connection connection = null;

    public void setConnection(Connection connection) {
        AllClassesDAO.connection = connection;
    }

    public void create(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO continents (name) VALUES (?)")) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Continent insert complete!");

        }catch(SQLException e){
            System.err.println("Inseration fail: " + e);
        }
    }

    public void create(String name, String country, Boolean capital, int latitude, int logitude) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO cities (name, country, capital, latitude, logitude) VALUES (?,?,?,?,?)")) {

            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.setObject(3, capital);
            pstmt.setInt(4, latitude);
            pstmt.setInt(5, logitude);
            pstmt.executeUpdate();

        }catch(SQLException e){
            System.err.println("Inseration fail: " + e);
        }
    }

    public void create(String name, int code, String continent) throws SQLException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(
                "INSERT INTO countries (name, code, continent) VALUES (?,?,?)")) {

            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, code);
            prepareStatement.setString(3, continent);
            prepareStatement.executeUpdate();

        }catch(SQLException e){
            System.err.println("Inseration fail: " + e);
        }
    }

    public ArrayList<Rows> findAll(InfoTable infoTable) throws SQLException {
        var rows = new ArrayList<Rows>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM " + infoTable.toString())) {
            while (rs.next()) {
                if (infoTable == InfoTable.CITIES) {
                    var tempTable = new Cities(InfoTable.CITIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCapital(rs.getBoolean("capital"));
                    tempTable.setLogitude(rs.getInt("logitude"));
                    tempTable.setLatitude(rs.getInt("latitude"));
                    rows.add(tempTable);
                }
                if (infoTable == InfoTable.COUNTRIES) {
                    var tempTable = new Countries(InfoTable.COUNTRIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCode(rs.getInt("code"));
                    tempTable.setContinent(rs.getString("continent"));
                    rows.add(tempTable);
                }
                if (infoTable == InfoTable.CONTINENTS) {
                    var tempTable = new Continents(InfoTable.CONTINENTS);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    rows.add(tempTable);
                }
            }
            return rows;
        }
    }

    public Rows findByName(InfoTable infoTable, String name) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM " + infoTable.toString() + " WHERE name='" + name + "'")) {
            if (rs.next()) {
                if (infoTable == InfoTable.CITIES) {
                    var tempTable = new Cities(InfoTable.CITIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCapital(rs.getBoolean("capital"));
                    tempTable.setLogitude(rs.getInt("logitude"));
                    tempTable.setLatitude(rs.getInt("latitude"));
                    tempTable.setCountry(rs.getString("country"));
                    return tempTable;
                }
                if (infoTable == InfoTable.COUNTRIES) {
                    var tempTable = new Countries(InfoTable.COUNTRIES);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    tempTable.setCode(rs.getInt("code"));
                    tempTable.setContinent(rs.getString("continent"));
                    return tempTable;
                }
                if (infoTable == InfoTable.CONTINENTS) {
                    var tempTable = new Continents(InfoTable.CONTINENTS);
                    tempTable.setId(rs.getInt("id"));
                    tempTable.setName(rs.getString("name"));
                    return tempTable;
                }
            }
            return null;
        }
    }

    public Rows findById(Rows rows, int id) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM " + rows.infoTable.toString() + " WHERE id=" + id)) {
            rs.next();
            if (rows.infoTable == InfoTable.CITIES) {
                var tempTable = new Cities(InfoTable.CITIES);
                tempTable.setId(rs.getInt("id"));
                tempTable.setName(rs.getString("name"));
                tempTable.setCapital(rs.getBoolean("capital"));
                tempTable.setLogitude(rs.getInt("logitude"));
                tempTable.setLatitude(rs.getInt("latitude"));
                tempTable.setCountry(rs.getString("country"));
                return tempTable;
            }
            if (rows.infoTable == InfoTable.COUNTRIES) {
                var tempTable = new Countries(InfoTable.COUNTRIES);
                tempTable.setId(rs.getInt("id"));
                tempTable.setName(rs.getString("name"));
                tempTable.setCode(rs.getInt("code"));
                tempTable.setContinent(rs.getString("continent"));
                return tempTable;
            }
            if (rows.infoTable == InfoTable.CONTINENTS) {
                var tempTable = new Continents(InfoTable.CONTINENTS);
                tempTable.setId(rs.getInt("id"));
                tempTable.setName(rs.getString("name"));
                return tempTable;
            }
            return null;
        }
    }
}
