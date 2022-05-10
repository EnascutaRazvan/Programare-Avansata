import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "student";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;

    public Database() throws SQLException {

    }

    public static Connection getConnection() throws SQLException {
        return connection;
    }

    public static void createConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
        connection.setAutoCommit(false);
    }

    public static void closeConnection() {
        try{
            connection.close();
        } catch(SQLException e) {
            System.err.println("Cannot close the connection: " + e);
        }
    }


}
